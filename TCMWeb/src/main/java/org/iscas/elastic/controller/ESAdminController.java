package org.iscas.elastic.controller;

import java.io.IOException;

import org.dom4j.DocumentException;
import org.iscas.controller.BaseController;
import org.iscas.elastic.admin.ElasticSearchManagement;
import org.iscas.elastic.query.ESResult;
import org.iscas.elastic.search.FastQuery;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * Created by yinrun on 18-8-15.
 */
@Controller
public class ESAdminController extends BaseController {
  @ResponseBody
  @RequestMapping(value="/es/index/delete")
  public String delete_index(String content) throws ClassNotFoundException, IOException {
	  ElasticSearchManagement.deleteElasticSearchIndex("org.iscas.web.entity");
	  return "ok";
  }
  
  @ResponseBody
  @RequestMapping(value="/es/index/create")
  public String create_index(String content) throws ClassNotFoundException, IOException {
	  ElasticSearchManagement.createElasticSearchIndex("org.iscas.web.entity");
	  return "ok";
  }


}
