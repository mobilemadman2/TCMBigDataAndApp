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
import org.elasticsearch.index.query.QueryBuilders;
import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.query.ESRow;
import org.iscas.web.dao.PrescriptionDao;
import org.iscas.web.dao.UserDao;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.User;

/**
 * Created by suemi on 17-7-2.
 */
@Service
@Transactional
public class PrescriptionService {

  @Autowired
  private PrescriptionDao prescriptionDao;
  
  public List<Prescription>  getPrescriptionByNameCn(String keywords) {
	  List<Prescription> prescription = prescriptionDao.findByNameOrSourceContaining(keywords,keywords);
	  return prescription;
  }
  
  public List<Prescription>  getPrescription(String keywords) {

		Client client = ESClientFactory.getClient();

      SearchResponse response = client.prepareSearch("prescription")
              .setTypes("prescription")
              .setQuery(QueryBuilders.termQuery("name.keyword", keywords))                 // Query
              .get();
    
    ESResult res = new ESResult();
    res.totalHits = response.getHits().totalHits;
    res.pageSize = response.getHits().getHits().length;
    JSONObject json = JSON.parseObject(response.toString());

    JSONArray hits = json.getJSONObject("hits").getJSONArray("hits");
    List<Prescription> list = new ArrayList<>(); 
    for(int i = 0; i < hits.size(); ++i) {
      res.rows.add(new ESRow(hits.getJSONObject(i).getJSONObject("_source")));
      JSONObject object = hits.getJSONObject(i).getJSONObject("_source");
      Prescription pre = new Prescription();
    
      pre.setId(object.getLong("id"));
      pre.setName(object.getString("name"));
      pre.setSource(object.getString("source"));
      pre.setUpdateAt(object.getDate("update_at"));
      
      list.add(pre);
      System.out.println(object);
    }
    
    System.out.println(response.getHits().getTotalHits());
    
    return list;
}
}
