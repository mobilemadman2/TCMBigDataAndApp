package org.iscas.elastic.query;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import org.elasticsearch.action.search.SearchRequestBuilder;
import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.rest.RestStatus;

import java.io.IOException;


public class QueryEngine {

  private Client es;

  public QueryEngine(Client es) {
    this.es = es;
  }

  public ESResult execute(IndexQuery query) throws IOException {
    SearchRequestBuilder req = es.prepareSearch();
    String[] indices = new String[query.indices.size()];
    indices = query.indices.toArray(indices);
    req.setIndices(indices);

    if(query.fields != null) {
      for(String f : query.fields) req.addStoredField(f);
    }

    if(query.limit != null) {
      query.start = query.start == null? 0 : query.start;
      req.setFrom(query.start);
      req.setSize(query.limit);
    }

    query.accept(req);

    SearchResponse resp = req.get();
    if(!resp.status().equals(RestStatus.OK) || resp.isTimedOut())
      throw new IOException("failed to fetch from elasticsearch");

    return parse(resp);
  }

  private ESResult parse(SearchResponse resp) {
    ESResult res = new ESResult();
    res.totalHits = resp.getHits().totalHits;
    res.pageSize = resp.getHits().getHits().length;
    JSONObject json = JSON.parseObject(resp.toString());

    JSONArray hits = json.getJSONObject("hits").getJSONArray("hits");
    for(int i = 0; i < hits.size(); ++i) {
      res.rows.add(new ESRow(hits.getJSONObject(i).getJSONObject("_source")));
    }

    return res;
  }
}
