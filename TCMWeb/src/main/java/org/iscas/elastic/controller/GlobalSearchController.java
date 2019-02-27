package org.iscas.elastic.controller;

import org.dom4j.DocumentException;
import org.iscas.controller.BaseController;
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
public class GlobalSearchController extends BaseController {
  
  @RequestMapping(value = "/search.html", method = RequestMethod.GET)
  public String search() {
    return "search/home";
  }
  
  @RequestMapping(value = "/es-search/{classify}.html")
  public String disease_search_result(
		  @PathVariable String classify,
			@RequestParam(value = "keywords") String keywords,
			ModelMap model) {
	  System.out.println(keywords);
	  
	  model.addAttribute("content", keywords);
	  
    return classify+"/es-"+ classify +"-result";
  }
  
  @RequestMapping(value = "/search/result.html")
  public String search_result(
			@RequestParam(value = "content") String content,
			ModelMap model) {
	  System.out.println(content);
	  
	  model.addAttribute("content", content);
	  
    return "search/result";
  }

  @ResponseBody
  @RequestMapping(value="/search/global")
  public ESResult global_search(String content) throws DocumentException {
	  return FastQuery.queryIndexes(content, "disease", "material");
  }

  @ResponseBody
  @RequestMapping(value="/search/index")
  public ESResult index_search(String content,
		String index,
		@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		@RequestParam(value = "pageSize", defaultValue = "10") Integer pageSize
		) throws DocumentException {
//	  System.out.println(pageNumber+"\t"+pageSize);
	  if("all".equals(index)) {
		  ESResult esResult = FastQuery.queryIndexes(content, "disease", "material", "prescription","expert_medical_case","bing_zheng_tab1","expert");
		  esResult.rows = esResult.rows.subList((pageNumber-1)*pageSize, esResult.rows.size()<pageNumber*pageSize?esResult.rows.size():pageNumber*pageSize);
		  return esResult;
	  }
	  
	  return FastQuery.query(content, index, (pageNumber-1)*pageSize, pageSize);
  }
}
