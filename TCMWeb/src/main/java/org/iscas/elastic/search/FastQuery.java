package org.iscas.elastic.search;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.dom4j.DocumentException;
import org.elasticsearch.action.search.MultiSearchRequestBuilder;
import org.elasticsearch.action.search.MultiSearchResponse;
import org.elasticsearch.action.search.MultiSearchResponse.Item;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.MultiMatchQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.ElasticSearchConfig;
import org.iscas.elastic.query.ESQueryParams;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.query.ESRow;
import org.neo4j.kernel.configuration.ssl.SslSystemSettings;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

public class FastQuery {
	public static ESResult query(String searchContent, String index,int from, int size) throws DocumentException {
		Client client = ESClientFactory.getClient();
		ESQueryParams qp = FieldsMapper.getFieldsMapperFromXml().get(index);
		
		String [] fields = new String[qp.fields.size()];

		Map<String, Float> weights = new HashMap<>();
		for(int i=0;i<qp.fields.size();i++) {
			fields[i]= qp.fields.get(i).field; 
			weights.put(qp.fields.get(i).field, qp.fields.get(i).weigth);
		}

		String [] sources_in = new String[qp.sources.size()]; 
		for(int i=0;i<qp.sources.size(); i++) {
			sources_in[i] = qp.sources.get(i).source;
		}

		
		MultiMatchQueryBuilder qBuilder = QueryBuilders.multiMatchQuery(searchContent, fields).fields(weights);//.analyzer("keyword");
        SearchResponse response = client.prepareSearch(index)
                .setTypes(ElasticSearchConfig.ES_DOC_TYPE)
                .setQuery(qBuilder)
                .setFrom(from)
                .setSize(size)
                .setFetchSource(sources_in, null)
                .get();
 
        ESResult res = new ESResult();
        res.totalHits = response.getHits().totalHits;
        res.pageSize = response.getHits().getHits().length;
        JSONObject json = JSON.parseObject(response.toString());

        JSONArray hits = json.getJSONObject("hits").getJSONArray("hits");
        for(int i = 0; i < hits.size(); ++i) {
          res.rows.add(new ESRow(hits.getJSONObject(i)));
//          System.out.println(hits.getJSONObject(i));
        }
        
        return res;
	}
	
	public static ESResult queryIndexes(String searchContent, String ... indexes) throws DocumentException {
		Client client = ESClientFactory.getClient();
		
		List<SearchRequestBuilder> builders = new ArrayList<>();
		for(String index:indexes) {
			ESQueryParams qp = FieldsMapper.getFieldsMapperFromXml().get(index);
			
			String [] fields = new String[qp.fields.size()];
	
			Map<String, Float> weights = new HashMap<>();
			for(int i=0;i<qp.fields.size();i++) {
				fields[i]= qp.fields.get(i).field; 
				weights.put(qp.fields.get(i).field, qp.fields.get(i).weigth);
			}
	
			String [] sources_in = new String[qp.sources.size()]; 
			for(int i=0;i<qp.sources.size(); i++) {
				sources_in[i] = qp.sources.get(i).source;
			}
	
			
			MultiMatchQueryBuilder qBuilder = QueryBuilders.multiMatchQuery(searchContent, fields).fields(weights);
			SearchRequestBuilder srb = client.prepareSearch(index)
	            .setTypes(ElasticSearchConfig.ES_DOC_TYPE)
	            .setSize(ElasticSearchConfig.DEFAULT_SIZE)
	            .setQuery(qBuilder)
	            .setFetchSource(sources_in, null);
			builders.add(srb);
		}
			
		MultiSearchRequestBuilder msrb = client.prepareMultiSearch();
		for(SearchRequestBuilder srb:builders) {
			msrb = msrb.add(srb);
		}
        MultiSearchResponse response = msrb.get();
        
    	ESResult res = new ESResult();
    	
    	int index_num = response.getResponses().length;
    	long [] lens = new long[index_num];
    	int [] curr = new int[index_num];
    	JSONArray [] arrays = new JSONArray [index_num];
    	
    	Item [] item = response.getResponses();
    	for(int i=0;i<response.getResponses().length;i++) {
    		curr[i] = 0;
    		lens[i] = item[i].getResponse().getHits().totalHits<ElasticSearchConfig.DEFAULT_SIZE
    				?item[i].getResponse().getHits().totalHits:ElasticSearchConfig.DEFAULT_SIZE;
    		res.totalHits += lens[i];
    		
    		JSONObject json = JSON.parseObject(item[i].getResponse().toString());
//    		System.out.println(json.toJSONString());

            if(json.getJSONObject("hits")==null || json.getJSONObject("hits").getJSONArray("hits")==null) continue;
            arrays[i] = json.getJSONObject("hits").getJSONArray("hits");
//    		System.out.println("len: " + lens[i] + "\tarray:"+arrays[i].size());
            
    	}
    	for(int i=0;i<res.totalHits;i++) {
    		double val = 0;
    		int selected = -1;
    		for(int j=0;j<curr.length;j++) {
    			if(curr[j]<lens[j]) {
//    				System.out.println(arrays[j].getJSONObject(curr[j]).getDoubleValue("_score"));
    				double item_val = arrays[j].getJSONObject(curr[j]).getDoubleValue("_score");
    				if(item_val>val) {
    					selected = j;
    					val = item_val;
    				}
    			}
    		}
//    		System.out.println("order "+ (i+1) +"\t" + selected + "\t" + curr[selected] + "\t" + val);

            res.rows.add(new ESRow(arrays[selected].getJSONObject(curr[selected])));
//            System.out.println(arrays[selected].getJSONObject(curr[selected]));

    		curr[selected] ++;
    	}
    	
    	return res;
	}
}
