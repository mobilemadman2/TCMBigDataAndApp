package org.iscas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Patent;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Standard;
import org.iscas.web.view.SortPatent;
import org.iscas.web.view.SortPrescription;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.PatentDao;
import org.iscas.web.dao.PatentDao;

@Controller
public class PatentController extends BaseController {

	@Autowired
	PatentDao patentDao;

	@ResponseBody
	@RequestMapping(value = "/patent/get", method = RequestMethod.POST)
	public PageDto<Patent> patent_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//System.out.println("hahahahhahah,start");
		List<Patent> list = patentDao.findAll();
		//System.out.println("hahahahhahah,end");
		// for(Patent d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//PatentDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/patent/get_return.html", method = RequestMethod.GET)
	public String patent_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Patent> list = patentDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "patent/patent";
	}
	
	@RequestMapping(value = "/patent/info.html", method = RequestMethod.GET)
	public String patent_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "patentId", required = false) Long patentId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Patent> patent = patentDao.findById(patentId);
		System.out.println(patent.get().getPatno());
		
		map.addAttribute("patent", patent.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "patent/info";
	}
	
	@ResponseBody
	@RequestMapping(value = "/patent/patent_search", method = RequestMethod.POST)
	public PageDto<Patent> patent_search(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println("11111111111111111111111111111");
		System.out.println("patent arrived /patent/patent_search");
		List<Patent> list = patentDao.findByIt(keywords);
		List<Patent> list2 = patentDao.findByCpti(keywords);
		list.addAll(list2);
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/patent/alphabet-order")
	public List<SortPatent> getAlphabets() {
		System.out.println("111111111111111111111111111111");
		List<SortPatent> alphabetPrescription = new ArrayList<>();
		char curr_char = 'A';
		List<Patent> patentlist = patentDao.findAllByTiPinyinAsc();
		
		int index = 0;
		while(index<patentlist.size()&&curr_char<='Z'){
			if(curr_char==patentlist.get(index).getTiPinyin().charAt(0)) {
				SortPatent aPrescriptions = new SortPatent();
				List<String> patentName = new ArrayList<>(); 
				List<String> patentId = new ArrayList<>(); 
				aPrescriptions.setName(curr_char+"");
				
				while(index<patentlist.size()&&curr_char==patentlist.get(index).getTiPinyin().charAt(0)) {
					patentName.add(patentlist.get(index).getTi());
					patentId.add(patentlist.get(index).getId().toString());
					index++;
				}
				aPrescriptions.setPatents(patentName);
				aPrescriptions.setPatentesId(patentName);
				
				alphabetPrescription.add(aPrescriptions);
				
			}
			curr_char++;
		}
		System.out.println("222222222222222222222222222222222222");
		return alphabetPrescription;
	}
	@ResponseBody
	@RequestMapping(value = "/patent/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Patent> patent_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		char alphabetC=alphabet.charAt(0);
		List<Patent> list = patentDao.findAllByTiPinyinAlphabet(alphabet);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	

}
