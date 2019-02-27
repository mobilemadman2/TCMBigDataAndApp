package org.iscas.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;

import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Standard;
import org.iscas.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by *** on 17-7-2.
 */
@Controller
public class RouteSearchController extends BaseController {
  @RequestMapping(value = "/disease-search.html", method = RequestMethod.GET)
  public String diseaseSearch(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "disease/disease-search";
  }
  
  @RequestMapping(value = "/syndrome-search.html", method = RequestMethod.GET)
  public String diseaseSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  System.out.println(keywords);
	  return "syndrome/syndrome-search";
  }
  
  @RequestMapping(value = "/material-search.html", method = RequestMethod.POST)
  public String materialSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "material/material-search";
  }
  
  @RequestMapping(value = "/prescription-search.html", method = RequestMethod.POST)
  public String PrescriptionSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "prescription/prescription-search";
  }
  
  @RequestMapping(value = "/expert-search.html", method = RequestMethod.POST)
  public String EcpertSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "expert/expert-search";
  }



  @RequestMapping(value = "/paper-search.html", method = RequestMethod.POST)
  public String PaperSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "paper/paper-search";
  }
  @RequestMapping(value = "/search_info_doctor.html", method = RequestMethod.POST)
  public String SearchInfoDoctorPost(@RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords); 
	  map.addAttribute("keyword",keywords);
	  return "paper/search_info_doctor";
  }

  //添加搜索相关转条
  @RequestMapping(value = "/acupoint_search.html", method = RequestMethod.POST)
  public String acupointSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "acupoint/acupoint_search";
  }
  
//添加搜索相关转条
  @RequestMapping(value = "/materialcase_search.html", method = RequestMethod.POST)
  public String materialCaseSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value="keywords", required=false) String keywords,
		  ModelMap map) {
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword",keywords);
	  
	  return "medicalcase/materialcase_search";
  }
  
  


 
  
  @RequestMapping(value="/standard-search.html", method = RequestMethod.POST)
  public String standardSearch(
		@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		@RequestParam(value = "sortType", defaultValue = "") String sortType,
		@RequestParam(value="keywords", required=false) String keywords, 
		ModelMap map){
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("sortType", sortType);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword", keywords);		
	  return "standard/standard_search";
	}
  
  @RequestMapping(value="/patent_search.html", method = RequestMethod.POST)
  public String patentSearch(
		@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		@RequestParam(value = "sortType", defaultValue = "") String sortType,
		@RequestParam(value="keywords", required=false) String keywords, 
		ModelMap map){
	  System.out.println("keywords: "+keywords);
	  map.addAttribute("sortType", sortType);
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("keyword", keywords);		
	  return "patent/patent_search";
	}
  

}
