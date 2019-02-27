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
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.entity.Material;


@Service
@Transactional
public class MaterialService {

  @Autowired
  private MaterialDao materialDao;
  
  public List<Material>  getMaterialByNameCn(String keywords) {
	  //List<Material> material = materialDao.findByNameCn(keywords);
	  List<Material> material = materialDao.findByNameCnOrAttributionContaining(keywords,keywords);
	  /*List<Material> material1 = materialDao.findAllByNameCnAttri1(keywords);
	  List<Material> material2 = materialDao.findAllByNameCnAttri2(keywords);
	  material1.addAll(material2);*/
	  return material;
  }
  
  public List<Material>  getMaterial(String keywords) {

		Client client = ESClientFactory.getClient();

        SearchResponse response = client.prepareSearch("material")
                .setTypes("material")
                .setQuery(QueryBuilders.termQuery("name_cn.keyword", keywords))                 // Query
                .get();
      
      ESResult res = new ESResult();
      res.totalHits = response.getHits().totalHits;
      res.pageSize = response.getHits().getHits().length;
      JSONObject json = JSON.parseObject(response.toString());

      JSONArray hits = json.getJSONObject("hits").getJSONArray("hits");
      List<Material> list = new ArrayList<>(); 
      for(int i = 0; i < hits.size(); ++i) {
        res.rows.add(new ESRow(hits.getJSONObject(i).getJSONObject("_source")));
        JSONObject object = hits.getJSONObject(i).getJSONObject("_source");
        Material disease = new Material();
        disease.setNameCn(object.getString("name_cn"));
        disease.setEffect(object.getString("effect"));
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
