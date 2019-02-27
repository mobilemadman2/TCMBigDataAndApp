package org.iscas.web.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import java.util.ArrayList;
import java.util.List;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.engine.Engine.Get;
import org.elasticsearch.index.query.QueryBuilders;
import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.query.ESRow;
import org.iscas.web.dao.DiseaseDao;
import org.iscas.web.dao.UserDao;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.User;

/**
 * Created by suemi on 17-7-2.
 */
@Service
@Transactional
public class DiseaseService {

  @Autowired
  private DiseaseDao diseaseDao;
  
  public List<Disease>  getDiseaseByNameCn(String keywords) {
	  //List<Material> material = materialDao.findByNameCn(keywords);
	  List<Disease> disease = diseaseDao.findByNameOrOverviewContaining(keywords,keywords);
/*	  List<Disease> disease1= diseaseDao.findAllByNameCnAttri1(keywords);
	  List<Disease> disease2 = diseaseDao.findAllByNameCnAttri2(keywords);
	  disease1.addAll(disease2);*/
	  return disease;
  }
  
  public List<Disease>  getDisease(String keywords) {

		Client client = ESClientFactory.getClient();
//		Map<String,Object> infoMap = new HashMap<String, Object>();
//      infoMap.put("name", "气血两虚");
      
      SearchResponse response = client.prepareSearch("disease")
              .setTypes("disease")
//              .setSearchType(SearchType.DFS_QUERY_THEN_FETCH)
              .setQuery(QueryBuilders.termQuery("name.keyword", keywords))                 // Query
//              .setPostFilter(QueryBuilders.rangeQuery("age").from(12).to(18))     // Filter
//              .setFrom(0).setSize(60).setExplain(true)
              .get();
      

      ESResult res = new ESResult();
      res.totalHits = response.getHits().totalHits;
      res.pageSize = response.getHits().getHits().length;
      JSONObject json = JSON.parseObject(response.toString());

      JSONArray hits = json.getJSONObject("hits").getJSONArray("hits");
      List<Disease> list = new ArrayList<>(); 
      for(int i = 0; i < hits.size(); ++i) {
        res.rows.add(new ESRow(hits.getJSONObject(i).getJSONObject("_source")));
        JSONObject object = hits.getJSONObject(i).getJSONObject("_source");
        Disease disease = new Disease();
        disease.setOverview(object.getString("overview"));
        disease.setName(object.getString("name"));
        disease.setUpdateAt(object.getDate("update_at"));
        disease.setId(object.getLong("id"));
        
        list.add(disease);
//        Disease disease;
//        Class disClass = Disease.class;
//        for(Field f : disClass.getFields()) {
//      	  System.out.println(f.getName());
//        }
//        for(String key : object.keySet()) {
//      	  
//        }
        System.out.println(object);
      }
//      response = client.prepareSearch("bing_zheng").setTypes("fuck").get();
      System.out.println(response.getHits().getTotalHits());
      
      return list;
  }
}
