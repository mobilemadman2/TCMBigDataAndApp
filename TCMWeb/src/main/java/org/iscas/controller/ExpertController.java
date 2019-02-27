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
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import io.netty.handler.codec.http.HttpRequest;

import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.ExpertPaper;
import org.iscas.web.entity.MedicalCase;
import org.iscas.web.entity.Paper;
import org.iscas.web.service.ExpertService;
import org.iscas.web.service.MaterialService;
import org.iscas.web.view.SortExpert;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.TrueFalseType;
import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.ExpertPaperDao;
import org.iscas.web.dao.MedicalCaseDao;
import org.iscas.web.dao.PaperDao;

@Controller
public class ExpertController extends BaseController {

	@Autowired
	ExpertDao expertDao;

	@Autowired
	ExpertService expertService;
	
	@Autowired
	MedicalCaseDao medicalCaseDao;
	
	@Autowired
	ExpertPaperDao expertPaperDao;
	
	@Autowired
	PaperDao paperDao;

	@ResponseBody
	@RequestMapping(value = "/expert/get", method = RequestMethod.POST)
	public PageDto<Expert> expert_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Expert> list = expertDao.findAll();
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/expert/get_return.html", method = RequestMethod.GET)
	public String expert_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "expert/expert";
	}
	
	@RequestMapping(value = "/expert/info.html", method = RequestMethod.GET)
	public String expert_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "expertId", required = false) Long expertId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Expert> expert = expertDao.findById(expertId);	
		List<MedicalCase> expertMedicalCase = medicalCaseDao.findByDocterName(expert.get().getName()); 
		//List<ExpertPaper> expertPaper = expertPaperDao.findByDoctorName(expert.get().getName());
		List<Paper> expertPaper = paperDao.findBydoctorName(expert.get().getName());

		map.addAttribute("expertMedicalCase", expertMedicalCase);
		map.addAttribute("expertPaper", expertPaper);
		map.addAttribute("expert", expert.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		return "expert/info";
	}
	
	@ResponseBody
	@RequestMapping(value = "/expert/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Expert> expert_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//expertDao.findAllByNamePinyinAsc();
		char alphabetC=alphabet.charAt(0);
		List<Expert> list = expertDao.findAllByNamePinyinAlphabet(alphabet);
		System.out.println("/expert/get_alpahbet"+list.size()+";"+pageNumber+";"+pageSize);
		//char curr_char = 'a';
/*		if(alphabetC=='o')
		System.out.println("yes:"+alphabetC);
		else
			System.out.println("no:"+alphabetC);*/
		
		/*List<Expert> expertlist = expertDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<expertlist.size()&&curr_char<='z'){	
			System.out.println("expertlist curr_expertlist:"+expertlist.get(index).getNamePinyin());
			System.out.println(expertlist.get(index).getNamePinyin().charAt(0));
			if(curr_char==expertlist.get(index).getNamePinyin().charAt(0)) {	
				
				while(index<expertlist.size()&&alphabetC==expertlist.get(index).getNamePinyin().charAt(0)) {
					
					list.add(expertlist.get(index));
					index++;
				}
			}
			curr_char++;
		}*/
		
		//System.out.println("list size:"+list.size());

		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	@ResponseBody
	@RequestMapping(value = "/expert/alphabet-order")
	public List<SortExpert> getAlphabets() {
		List<SortExpert> alphabetExpert = new ArrayList<>();
		char curr_char = 'A';
		List<Expert> expertlist = expertDao.findAllByNamePinyinAsc();
		
		int index = 0;
		while(index<expertlist.size()&&curr_char<='Z'){
			if(curr_char==expertlist.get(index).getNamePinyin().charAt(0)) {
				SortExpert aExperts = new SortExpert();
				List<String> expertName = new ArrayList<>(); 
				List<String> expertId = new ArrayList<>(); 
				aExperts.setName(curr_char+"");
				
				while(index<expertlist.size()&&curr_char==expertlist.get(index).getNamePinyin().charAt(0)) {
					expertName.add(expertlist.get(index).getName());
					expertId.add(expertlist.get(index).getId().toString());
					index++;
				}
				aExperts.setExperts(expertName);
				aExperts.setExpertsId(expertId);
				
				alphabetExpert.add(aExperts);
				
			}
			curr_char++;
		}
		return alphabetExpert;
	}
	
	@ResponseBody
	@RequestMapping(value = "/expert/expert-search", method = RequestMethod.POST)
	public PageDto<Expert> expert_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println("abc"+keywords);
		
		List<Expert> list = expertService.getExpertByNameCn(keywords);
		
		
		
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value = "/expert/get_paper_id", method = RequestMethod.GET)
	public Long getPaperId(@RequestParam String expertPaperId) {
		System.out.println("hahahah"+Long.valueOf(expertPaperId));
		Optional<ExpertPaper> expertPaper= expertPaperDao.findById(Long.valueOf(expertPaperId));
		System.out.println("hahahah"+expertPaper.get().getPaperName());
		String paperName=expertPaper.get().getPaperName();
		//Paper paper= paperDao.findByName(expertPaper.get().getPaperName());
		
		List<Paper> all_paper_name = paperDao.findAll();
		for(int index=0;index<all_paper_name.size();index++) {
			//System.out.println( all_paper_name.get(index).getName());
			if(paperName.equals(all_paper_name.get(index).getPaper_name())) {
				return all_paper_name.get(index).getId();
			}
		}
		return (long) -1;

	}
	
	//从查询结果点击显示详细信息
/*		@RequestMapping(value = "/expert-case/search_info_expert", method = RequestMethod.GET)
		public String materialCaseSearchPost(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
				  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
				  @RequestParam(value="keywords", required=false) String keywords,
				  ModelMap map) {
			  System.out.println("keywords: "+keywords);
			  map.addAttribute("pageNumber", pageNumber);
			  map.addAttribute("pageSize",pageSize);
			  map.addAttribute("keyword",keywords);
			  
			  return "expert/expert-search";
		  }
*/
}
