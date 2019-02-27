package org.iscas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.netty.handler.codec.http.HttpRequest;
import io.netty.util.internal.shaded.org.jctools.queues.MpscArrayQueue;
import scala.Char;

import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Acupoint;
import org.iscas.web.entity.AcupointClassification;
import org.iscas.web.entity.Diagnosis;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.MedicalCase;
import org.iscas.web.view.SortMaterial;
import org.iscas.web.view.SortMatrialCase;
import org.neo4j.cypher.internal.compiler.v2_3.ast.rewriters.flattenBooleanOperators;
import org.neo4j.cypher.internal.frontend.v2_3.perty.print.printCommandsToString;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.iscas.utils.ChineseToPinyin;
import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.MedicalCaseDao;;

@Controller
public class MedicalCaseController extends BaseController {

	@Autowired
	MedicalCaseDao medicalCaseDao;
	
	@Autowired
	ExpertDao expert_dao;

	@ResponseBody
	@RequestMapping(value = "/medicalcase/get", method = RequestMethod.POST)
	public PageDto<MedicalCase> material_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<MedicalCase> list = medicalCaseDao.findAll();

		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/medicalcase/info.html", method = RequestMethod.GET)
	public String disease_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType,
			@RequestParam(value = "materialcaseId", required = false) Long materialcaseId,
			@RequestParam(value = "from", required = false) String from,
			HttpRequest request,
			HttpSession session,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println("medicalcase/info.html");
		System.out.println(materialcaseId);
		Optional<MedicalCase> medicalcase = medicalCaseDao.findById(materialcaseId);
		map.addAttribute("medicalcase", medicalcase.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		map.addAttribute("sortType", sortType);
		System.out.println(medicalcase);
		return "medicalcase/info";
	}
	
	//获取病历的列表信息
	@ResponseBody
	@RequestMapping(value = "/medical-case/listinfo", method = RequestMethod.POST)
	public PageDto<MedicalCase> showMedicalCase(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<MedicalCase> list = medicalCaseDao.findAll();
		System.out.println("ddddddddddd");
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	//获取侧边栏的信息
	@SuppressWarnings("unlikely-arg-type")
	@ResponseBody
	@RequestMapping(value = "/materialcase/alphabet-order")
	public Map<Character,List<String>> getAlphabets() {
		Map<Character,List<String>> AlphaDoctorName = new HashMap<Character,List<String>>();
		List<String> doctor_name = new ArrayList<String>();
		doctor_name = medicalCaseDao.findDistinctDoctorName();
		System.out.println("输出拼音");
		for (int i = 0; i < doctor_name.size(); i++) {
			String pinyin = ChineseToPinyin.getPinyin(doctor_name.get(i));
			char start_char = pinyin.toUpperCase().charAt(0);
			if(AlphaDoctorName.containsKey(start_char)) {
				List<String> doctor_name_one = AlphaDoctorName.get(start_char);
				doctor_name_one.add(doctor_name.get(i));
				AlphaDoctorName.put(start_char, doctor_name_one);
			}
			else {
				List<String> doctor_name_one = new ArrayList<String>();
				doctor_name_one.add(doctor_name.get(i));
				AlphaDoctorName.put(start_char, doctor_name_one);
			}
		}
//		System.out.println(ChineseToPinyin.getPinyin(doctor_name.get(0)));
		return AlphaDoctorName;
	}
	
	//获取侧边栏的信息
	@ResponseBody
	@RequestMapping(value = "/materialcase/doctor_numbers")
	public Map<String,Integer> getDoctorNumbers() {
		Map<String,Integer> result = new HashMap<String, Integer>();
		List<MedicalCase> doctor_list = medicalCaseDao.findAll();
		
		for (int i = 0; i < doctor_list.size(); i++) {
			String doctor_name = doctor_list.get(i).getDoctor_name();
			if(result.containsKey(doctor_name)) {
				int doctor_numbers = result.get(doctor_name);
				result.put(doctor_name, doctor_numbers+1);
			}
			else {
				result.put(doctor_name, 1);
			}
		}
		return result;
	}
	
	
	//获取小分类的详细信息,例如"任脉"的详情信息
		//get the picture detail information
	@ResponseBody
	@RequestMapping(value = "/matricalcase/doc_info", method = RequestMethod.GET)
	public List<MedicalCase> getDoctorInfo(@RequestParam String doctor_name) {
		System.out.println("doctor name");
		System.out.println(doctor_name);
		List<MedicalCase> acupoint_path_list = new ArrayList<MedicalCase>();
//			String acupoint_path = acupoint_classification_dao.findRentishiyituByJingluomingcheng(acupoint_name);
		acupoint_path_list = medicalCaseDao.findByDocterName(doctor_name);
//			acupoint_path_list.add(acupoint_path);
//			System.out.println(acupoint_path);
		return acupoint_path_list;
	}
	
	
	//修改查找的具体字段，现在设置查找医生字段
	//这边是搜索显示的具体内容的哈
	@ResponseBody
	@RequestMapping(value = "/medical-case/search_info", method = RequestMethod.POST)
	public PageDto<MedicalCase> showSearchData(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) throws URISyntaxException, IOException,
	InterruptedException, InstantiationException, IllegalAccessException{
		List<MedicalCase> acupoint_path_list = new ArrayList<MedicalCase>();
//		String acupoint_path = acupoint_classification_dao.findRentishiyituByJingluomingcheng(acupoint_name);
	acupoint_path_list = medicalCaseDao.findByDocterName(keywords);
		return PageDto.ofPagedList(acupoint_path_list, acupoint_path_list.size(), pageNumber, pageSize);
	}
	
	//从查询结果点击显示详细信息
	@RequestMapping(value = "/medical-case/search_info_doctor", method = RequestMethod.GET)
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
	
	//从专家页面跳转过来的详细界面
	@RequestMapping(value = "/medical-case/info_doctor", method = RequestMethod.GET)
	public String getInfoDoctor(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			  @RequestParam(value="keywords", required=false) String keywords,
			  @RequestParam(value="institution", required=false) String institution,
			  ModelMap map) {
		  System.out.println("keywords: "+keywords+institution);
		  map.addAttribute("institution",institution);
		  map.addAttribute("pageNumber", pageNumber);
		  map.addAttribute("pageSize",pageSize);
		  map.addAttribute("keyword",keywords);
		  
		  return "medicalcase/doctor-info";
	  }

	@ResponseBody
	@RequestMapping(value = "/medicalcase/check_doctor_name", method = RequestMethod.GET)
	public Long checkDoctorName(@RequestParam String doctor_name) {
		List<Expert> all_doctor_name = expert_dao.findAll();
		System.out.println("check doctor name");
		System.out.println(all_doctor_name.size());
		System.out.println(doctor_name);
		for(int index=0;index<all_doctor_name.size();index++) {
			System.out.println( all_doctor_name.get(index).getName());
			if(doctor_name.equals(all_doctor_name.get(index).getName())) {
				return all_doctor_name.get(index).getId();
			}
		}
		return (long) -1;
	}
	
	

}
