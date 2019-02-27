package org.iscas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.alibaba.fastjson.JSON;
import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;

import ch.qos.logback.core.rolling.SizeAndTimeBasedRollingPolicy;
import io.netty.handler.codec.http.HttpRequest;

import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.BingZheng;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.DiseaseClassify;

import java.io.IOException;
import java.lang.reflect.Field;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.elasticsearch.action.search.SearchResponse;
import org.elasticsearch.client.Client;
import org.elasticsearch.index.query.QueryBuilders;
import org.iscas.elastic.ESClientFactory;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.query.ESRow;
import org.iscas.web.dao.BingzhengDao;
import org.iscas.web.dao.DiseaseClassifyDao;
import org.iscas.web.dao.DiseaseDao;

@Controller
public class DiseaseClassifyController extends BaseController {

	@Autowired
	DiseaseClassifyDao diseaseClassifyDao;


	@ResponseBody
	@RequestMapping(value = "/disease/disease-classify", method = RequestMethod.GET)
	public List<DiseaseClassify> diseaseClassifySearch(){ 
		return diseaseClassifyDao.findAll();
	}

}
