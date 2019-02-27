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


import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Book;
import org.iscas.web.entity.Dynasty;
import org.iscas.web.entity.Syndrome;
import org.iscas.web.entity.SyndromeLevel;
import org.iscas.web.entity.SyndromeTreatment;
import org.iscas.web.entity.Dynasty.DynastyType;
import org.iscas.web.service.SyndromeService;
import org.iscas.web.view.SortBooks;
import org.iscas.web.view.SortSyndrome;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.SyndromeDao;
import org.iscas.web.dao.SyndromeTreatmentDao;


@Controller
public class SyndromeController extends BaseController {

	@Autowired
	SyndromeDao syndromeDao;
	
	@Autowired
	SyndromeTreatmentDao syndromeTreatmentDao;

	@Autowired
	SyndromeService syndromeService;

	@ResponseBody
	@RequestMapping(value = "/syndrome/get", method = RequestMethod.POST)
	public PageDto<Syndrome> syndrome_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		if (sortType != null && !sortType.equals("")) {
			Direction direction;
			String tmp [] = sortType.split("-");
			if(tmp[1].equals("asc")) {
				direction = Sort.Direction.ASC;
			}else {
				direction = Sort.Direction.DESC;
			}
			Sort sort = new Sort(direction, tmp[0]); // 创建时间降序排序
//			Pageable pageable = PageRequest.of(pageNumber-1, pageSize, sort);
//			System.out.println(tmp[0]);
			Pageable pageable = PageRequest.of(pageNumber-1, pageSize, direction, tmp[0]);

			Page<Syndrome> list = syndromeDao.findAll(pageable);
/*			for(Disease disease : list.getContent()) {
				System.out.println(disease.getOverview());
			}*/
			return PageDto.ofPagedList(list.getContent(), list.getNumber(), pageNumber, pageSize);
		} else {
			List<Syndrome> list = syndromeDao.findAllNameDesDataInTab1();
			List<SyndromeTreatment> list1 = syndromeTreatmentDao.findRemainingInTab2();
			for(int i=0; i<list.size(); i++){
//				System.out.println(list.get(i).getName()+" 111111111111111111111111 ");
				List<SyndromeTreatment> st = syndromeTreatmentDao.findByData(list.get(i).getName());
				for(int j=0; j<st.size(); j++){
					list.get(i).setData_source(list.get(i).getData_source()+'，'+st.get(j).getData_source());
				}
//				System.out.println(list.get(i).getData_source()+" "+list.size());
			}
			
			for(int j = 0; j < list1.size(); j++){
				Syndrome s = new Syndrome();
				s.setId(list1.get(j).getId());
				s.setName(list1.get(j).getName());
				s.setGeneral_description("");
				s.setData_source(list1.get(j).getData_source());
				list.add(s);
			}
			
//			System.out.println(list.size()+" 0 ");
			return PageDto.ofList(list, list.size(), pageNumber, pageSize);
		}
	}
	
	@RequestMapping(value = "/syndrome/get_return.html", method = RequestMethod.GET)
	public String syndrome_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "syndrome/syndrome";
	}
	
	@RequestMapping(value = "/syndrome/info.html", method = RequestMethod.GET)
	public String syndrome_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "syndromeId", required = false) Long syndromeId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		Optional<Syndrome> syndrome = Optional.ofNullable(null); 
		syndrome = syndromeDao.findById(syndromeId);	
		
		if(syndrome.isPresent() == true){
			List<SyndromeTreatment> st = syndromeTreatmentDao.findByData(syndrome.get().getName());
			List<SyndromeTreatment> sta = syndromeTreatmentDao.findByAllData(syndrome.get().getName());
			for(int j=0; j<st.size(); j++){
				syndrome.get().setData_source(syndrome.get().getData_source()+'，'+st.get(j).getData_source());
			}
	//			System.out.println(list.get(i).getData_source()+" "+list.size());
	//		System.out.println(sta.get(0).getDisease_name()+"000000");
			if(!sta.isEmpty()){
				map.addAttribute("syndromeTreatment", sta);
			}
			map.addAttribute("syndrome", syndrome.get());
		}else{
			Syndrome s = new Syndrome();
			Optional<SyndromeTreatment> syndromeTreatment = syndromeTreatmentDao.findById(syndromeId);
			List<SyndromeTreatment> st = syndromeTreatmentDao.findAllDataById(syndromeId.toString());
			
			s.setId(syndromeId);
			s.setStandard_num("          ");
			s.setName_en("          ");
			s.setLevel1_name("          ");
			s.setLevel2_name("          ");
			s.setGeneral_description("          ");
			s.setName(syndromeTreatment.get().getName());
			s.setData_source(syndromeTreatment.get().getData_source());
			
			Optional<Syndrome> syndrome1 = Optional.of(s);
//			System.out.println(s.getName()+"....3333..."+s.getData_source()+"......"+syndrome1.get().getName());
			if(!st.isEmpty()){
				map.addAttribute("syndromeTreatment", st);
			}
			map.addAttribute("syndrome", syndrome1.get());
		}
		
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		return "syndrome/info";
	}
	
	@ResponseBody
	@RequestMapping(value = "/syndrome/syndrome-order", method = RequestMethod.GET)
	public List<SyndromeLevel> getSyndrome() {
		List<Object[]> list = syndromeDao.findBylevel2();
		List<SyndromeLevel> syndromeLevellist = new ArrayList<>();
		for(Object[] o : list){
			SyndromeLevel syndromeLevel = new SyndromeLevel();
			syndromeLevel.setLevel2_name(o[0].toString());
			syndromeLevel.setNumber(o[1].toString());
			syndromeLevellist.add(syndromeLevel);
		}
		
		List<SyndromeTreatment> list1 = syndromeTreatmentDao.findRemainingInTab2();
		SyndromeLevel sl = new SyndromeLevel();
		sl.setLevel2_name("未分证类");
		sl.setNumber(list1.size()+"");
		syndromeLevellist.add(sl);
		
		return syndromeLevellist;
	}
	
	@ResponseBody
	@RequestMapping(value = "/syndrome/get_level", method = RequestMethod.POST)
	public PageDto<Syndrome> syndrome_page_level(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "六经证类") String level2_name) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//expertDao.findAllByNamePinyinAsc();
		List<Syndrome> list = new ArrayList<>();
		if(level2_name.equals("未分证类")){
			List<SyndromeTreatment> list1 = syndromeTreatmentDao.findRemainingInTab2();
			
			for(int j = 0; j < list1.size(); j++){
				Syndrome s = new Syndrome();
				s.setId(list1.get(j).getId());
				s.setName(list1.get(j).getName());
				s.setGeneral_description("");
				s.setData_source(list1.get(j).getData_source());
				list.add(s);
			}
		}else{
			list = syndromeDao.findBylevel2_name(level2_name);
			for(int i=0; i<list.size(); i++){
	//			System.out.println(list.get(i).getName()+" 111111111111111111111111 ");
				List<SyndromeTreatment> st = syndromeTreatmentDao.findByData(list.get(i).getName());
				for(int j=0; j<st.size(); j++){
					list.get(i).setData_source(list.get(i).getData_source()+'，'+st.get(j).getData_source());
				}
	//			System.out.println(list.get(i).getData_source()+" "+list.size());
			}
		}
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
		
	@ResponseBody
	@RequestMapping(value = "/syndrome/alphabet-order")
	public List<SortSyndrome> getAlphabets() {
		List<SortSyndrome> alphabetSyndrome = new ArrayList<>();
		char curr_char = 'A';
		List<Syndrome> syndromelist = syndromeDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<syndromelist.size()&&curr_char<='Z'){
			if(curr_char==syndromelist.get(index).getNamePinyin().charAt(0)) {
				
//				System.out.println(syndromelist.get(index).getNamePinyin().charAt(0)+" 000");
				
				SortSyndrome aSyndrome = new SortSyndrome();
				List<String> syndromeName = new ArrayList<>(); 
				List<String> syndromeId = new ArrayList<>(); 
				aSyndrome.setName(curr_char+"");
				
				while(index<syndromelist.size()&&curr_char==syndromelist.get(index).getNamePinyin().charAt(0)) {
					syndromeName.add(syndromelist.get(index).getName());
					index++;
				}
				aSyndrome.setSyndrome(syndromeName);
				alphabetSyndrome.add(aSyndrome);
			}
			curr_char++;
		}
		return alphabetSyndrome;
	}
	
	@ResponseBody
	@RequestMapping(value = "/syndrome/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Syndrome> syndrome_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet,
			@RequestParam(value = "sortType", defaultValue = "") String sortType) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
			char alphabetC=alphabet.charAt(0);
			List<Syndrome> list = syndromeDao.findAllByNamePinyinAlphabet(alphabetC);
			for(int i=0; i<list.size(); i++){
//				System.out.println(list.get(i).getName()+" 111111111111111111111111 ");
				List<SyndromeTreatment> st = syndromeTreatmentDao.findByData(list.get(i).getName());
				for(int j=0; j<st.size(); j++){
					list.get(i).setData_source(list.get(i).getData_source()+'，'+st.get(j).getData_source());
				}
//				System.out.println(list.get(i).getData_source()+" "+list.size());
			}
			return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
		
	@ResponseBody
	@RequestMapping(value = "/syndrome/syndrome-search", method = RequestMethod.POST)
	public PageDto<Syndrome> syndrome_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		List<Syndrome> list = new ArrayList<>();
		list = syndromeService.getSyndromeByNameCn(keywords);
		if(list.size()==0){
			Syndrome syndrome = new Syndrome();
			List<SyndromeTreatment> st = syndromeTreatmentDao.findByNameCn(keywords);
			for(int i = 0; i < st.size(); i++){
				syndrome.setId(st.get(i).getId());
				syndrome.setName(st.get(i).getName());
				syndrome.setGeneral_description("");
				syndrome.setUpdateAt(st.get(i).getUpdateAt());
				list.add(syndrome);
			}
		}
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
}
