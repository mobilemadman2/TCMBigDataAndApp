package org.iscas.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.validator.constraints.Length;
import org.iscas.web.dao.AcupointClassificationDao;
import org.iscas.web.dao.AcupointDao;
import org.iscas.web.dao.AcupointPicDao;
import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.MaterialDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Acupoint;
import org.iscas.web.entity.AcupointClassification;
import org.iscas.web.entity.AcupointPic;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Expert;
import org.neo4j.cypher.internal.compiler.v2_3.spi.IdempotentResult;
import org.neo4j.cypher.internal.frontend.v2_3.perty.recipe.Pretty.nest;
import org.neo4j.register.Register.Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.carrotsearch.hppc.IntIndexedContainer;

@Controller
public class AcupointController extends BaseController{
	
	@Autowired
	AcupointDao acupoint_dao;
	@Autowired
	AcupointPicDao acupoint_pic_dao;
	@Autowired
	AcupointClassificationDao acupoint_classification_dao;
	@Autowired
	MaterialDao temp;
	
	//get all type of classification
	//左边栏的详细的名称的数据(未包含具体穴位数量信息)
	@SuppressWarnings("unchecked")
	@ResponseBody
	@RequestMapping(value = "/acupoint/show_classes", method = RequestMethod.GET)
	public Map<String,List<String>> getAcupointClassication() {
		//use handle data, next use data from database
		Map<String,List<String>> acupoint_type = new HashMap<String,List<String>>();
		List<AcupointClassification> acupoint_classification = acupoint_classification_dao.findAll();
		List<String> classification = acupoint_classification_dao.findDistinctAcupointClassification();
		System.out.println("find slide content");
		System.out.println(acupoint_classification);
		System.out.println(classification);
		for(int index =0; index<acupoint_classification.size();index++) {
			String jingluomingchengfenlei = acupoint_classification.get(index).getJingluomingchengfenlei();
			String jingluo = acupoint_classification.get(index).getJingluomingcheng();
			if(acupoint_type.containsKey(jingluomingchengfenlei)){
				// map contain key
				List<String>jinluomingcheng = acupoint_type.remove(jingluomingchengfenlei);
				jinluomingcheng.add(jingluo);
				acupoint_type.put(jingluomingchengfenlei,jinluomingcheng);
			}
			else {
				//map don't contain key
				List<String> jinluomingcheng = new ArrayList<String>();
				jinluomingcheng.add(jingluo);
				acupoint_type.put(jingluomingchengfenlei,jinluomingcheng);
			}
		}
		
		System.out.println(acupoint_type);
		System.out.println("slide ending");
//		String[] fourteen = {"手厥阴心包经","手阳明大肠经"};
//		String[] six_acupoint = {"头部经外穴","胸腹部经外穴"};
//		acupoint_type.put("经外奇穴图",six_acupoint);
//		acupoint_type.put("十四经经穴图",fourteen);
		return acupoint_type;
	}
	
	
	//显示左边栏中的穴位点的数量
	@ResponseBody
	@RequestMapping(value = "/acupoint/show_classes_numbers", method = RequestMethod.GET)
	public Map<String,Integer> getAcupointClassicationNumber() {
		//use handle data, next use data from database
		Map<String,Integer> acupoint_type = new HashMap<String,Integer>();
		List<AcupointClassification> acupoint_classification = acupoint_classification_dao.findAll();
//		List<String> classification = acupoint_classification_dao.findDistinctAcupointClassification();
		System.out.println("find slide content");
		System.out.println(acupoint_classification);
//		System.out.println(classification);
		for(int index =0; index<acupoint_classification.size();index++) {
			String jingluo = acupoint_classification.get(index).getJingluomingcheng();
			String temp_jingluo = jingluo +".jpg";
			int number_acupoint = acupoint_pic_dao.findCountByPicName(temp_jingluo);
			//map don't contain key
			acupoint_type.put(jingluo,number_acupoint);
		}
		
		System.out.println(acupoint_type);
		System.out.println("get count process end");
//		String[] fourteen = {"手厥阴心包经","手阳明大肠经"};
//		String[] six_acupoint = {"头部经外穴","胸腹部经外穴"};
//		acupoint_type.put("经外奇穴图",six_acupoint);
//		acupoint_type.put("十四经经穴图",fourteen);
		return acupoint_type;
	}
	
	
	//具体穴位点的详细信息
	//get the picture position information
	@ResponseBody
	@RequestMapping(value = "/acupoint/info_detail", method = RequestMethod.GET)
	public List<Acupoint>  getAcupointInfoDetail(@RequestParam String acupoint_name) {
		System.out.println("getAcupointInfoDetail");
		System.out.print(acupoint_name);
		String query_name = acupoint_name.replace("穴","");
		//set by myself
//		query_name = "上迎香";
		List<Acupoint> acupoint = acupoint_dao.findByXueweimingcheng(query_name);
		System.out.println(acupoint);
		return acupoint;
	}
	
	//获取小分类的详细信息,例如"任脉"的详情信息
	//get the picture detail information
	@ResponseBody
	@RequestMapping(value = "/acupoint/pic_path", method = RequestMethod.GET)
	public List<AcupointClassification> getAcupointPicPath(@RequestParam String acupoint_name) {
		System.out.println("picture path");
		System.out.println(acupoint_name);
		List<AcupointClassification> acupoint_path_list = new ArrayList<AcupointClassification>();
//		String acupoint_path = acupoint_classification_dao.findRentishiyituByJingluomingcheng(acupoint_name);
		acupoint_path_list = acupoint_classification_dao.findByJingluomingcheng(acupoint_name);
//		acupoint_path_list.add(acupoint_path);
//		System.out.println(acupoint_path);
		System.out.println(acupoint_path_list);
		System.out.println("get acupoint picture success");
		return acupoint_path_list;
	}
	
	//返回图像中穴位点的位置信息
	//get the picture path
	@ResponseBody
	@RequestMapping(value = "/acupoint/pic_postion", method = RequestMethod.GET)
	public List<AcupointPic>  getAcupointPositions(@RequestParam String acupoint_name) {
		System.out.println("picture position");
		acupoint_name = acupoint_name + ".jpg";
		System.out.println(acupoint_name);
		List<AcupointPic> acupointPic = acupoint_pic_dao.findAllByPicName(acupoint_name);
		System.out.println(acupointPic);
		System.out.println("get acupoint position success");
		return acupointPic;
	}
	
	
	//返回详细的图像页面
	@RequestMapping(value = "/acupoint/detail_picture", method = RequestMethod.GET)
	public String showDetailAcupointPic(
			@RequestParam String acupoint_name,
			ModelMap model) {
		//use handle data, next use data from database
//		System.out.print("/acupoint/detail_picture");
		model.addAttribute("acupointName",acupoint_name);
		acupoint_name +=".jpg";
		System.out.print(acupoint_name);
		List<AcupointPic> acupointPic = acupoint_pic_dao.findAllByPicName(acupoint_name);
		System.out.print("ddddd");
		System.out.print(acupointPic);
		model.addAttribute("acupointPic",acupointPic);
		model.addAttribute("detail_acupoint_name","");
		model.addAttribute("acupontPic_test","你好");
//		return acupoint_name;
		System.out.print(acupointPic);
		return "/acupoint/detail_picture";
	}
	
	//穴位查找，返回详细具体数据信息
	@ResponseBody
	@RequestMapping(value = "/acupoint/acupoint_search", method = RequestMethod.POST)
	public PageDto<Acupoint> showSearchData(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) throws URISyntaxException, IOException,
	InterruptedException, InstantiationException, IllegalAccessException{
		List<Acupoint> acupoint_list =acupoint_dao.findByXueweimingchengContainingOrPeiwuContainingOrZhuzhiContaining(keywords,keywords,keywords);
		for(int i=0;i<acupoint_list.size();i++) {
			String acupoint_name = acupoint_list.get(i).getSuoshujingluofenleimingcheng();
			String big_class = acupoint_classification_dao.findJingluomingchengfenleiByJingluomingcheng(acupoint_name);
			acupoint_list.get(i).setSuoshujingluofenleimingcheng(big_class+"-->"+acupoint_name);
		}
		System.out.print(acupoint_list.size());
		System.out.print("acupoint_search!!");
		return PageDto.ofPagedList(acupoint_list, acupoint_list.size(), pageNumber, pageSize);
	}
	
	
	//从查询结果点击显示详细信息
	@RequestMapping(value = "/acupoint/acupoint_search_detail", method = RequestMethod.GET)
	public String showDetaiInformation(
			@RequestParam String acupoint_name,@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,@RequestParam String from,
			@RequestParam String small_class,
			ModelMap model) {
		System.out.println("显示详细信息的哈");
		System.out.println(small_class);
		model.addAttribute("acupointName",small_class);
		model.addAttribute("detail_acupoint_name", acupoint_name);
		return "/acupoint/detail_picture";
	}
	
	
	
}
