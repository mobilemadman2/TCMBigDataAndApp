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
import org.iscas.web.dao.SyndromeDao;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Syndrome;
import org.iscas.web.entity.SyndromeTreatment;

@Service
@Transactional
public class SyndromeService {

	@Autowired
	private SyndromeDao syndromeDao;
	
	//String keywords
	public List<Syndrome>  getSyndromeByNameCn(String keywords) {
		List<Syndrome> syndrome = syndromeDao.findByNameOrGeneral(keywords,keywords);
		return syndrome;
	}
}
