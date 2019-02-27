package org.iscas.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.ExpertDao;
import org.iscas.web.dao.PaperDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Expert;
import org.iscas.web.entity.MedicalCase;
import org.iscas.web.entity.Paper;
import org.iscas.web.service.PaperService;
import org.iscas.web.view.SortPaper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class PaperController extends BaseController{
	
	@Autowired
	PaperDao paperDao;
	
	@Autowired
	ExpertDao expert_dao;
	
	@Autowired
	PaperService paperService;
	
	@ResponseBody
	@RequestMapping(value = "/paper/get", method = RequestMethod.POST)
	public PageDto<Paper> paper_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Paper> list = paperDao.findAll();
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/paper/get_return.html", method = RequestMethod.GET)
	public String paper_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "paper/paper";
	}
	
	@RequestMapping(value = "/paper/info.html", method = RequestMethod.GET)
	public String paper_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "paperId", required = false) Long paperId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Paper> paper = paperDao.findById(paperId);	
		map.addAttribute("paper", paper.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		return "paper/info";
	}
	
	@ResponseBody
	@RequestMapping(value = "/paper/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Paper> paper_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {

		char alphabetC=alphabet.charAt(0);
		List<Paper> list = paperDao.findAllByNamePinyinAlphabet(alphabet);
	    System.out.println(list.size());
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	@ResponseBody
	@RequestMapping(value = "/paper/alphabet-order")
	public List<SortPaper> getAlphabets() {
		List<SortPaper> alphabetPaper = new ArrayList<>();
		char curr_char = 'A';
		List<Paper> paperlist = paperDao.findAllByNamePinyinAsc();
//		System.out.println(paperlist.size());
//		System.out.println(paperlist.get(0));
//		System.out.println(paperlist.get(1));
		int index = 0;
		while(index<paperlist.size()&&(curr_char<='Z')){
			//System.out.println("0");
			if(curr_char==paperlist.get(index).getName_pinyin().charAt(0)) {
				//System.out.println("1");
				SortPaper aPapers = new SortPaper();
				List<String> paperName = new ArrayList<>(); 
				List<String> paperId = new ArrayList<>(); 
				aPapers.setName(curr_char+"");
				while(index<paperlist.size()&&curr_char==paperlist.get(index).getName_pinyin().charAt(0)) {
					paperName.add(paperlist.get(index).getPaper_name());
					paperId.add(paperlist.get(index).getId().toString());
					index++;
					//System.out.println("2");
				}
				aPapers.setPapers(paperName);
				aPapers.setPapersId(paperId);
				
				alphabetPaper.add(aPapers);
				
			}
			curr_char++;
		}
		//System.out.println(alphabetPaper.size());
		return alphabetPaper;
	}
	@ResponseBody
	@RequestMapping(value = "/paper/paper-search", method = RequestMethod.POST)
	public PageDto<Paper> paper_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println("abc"+keywords);
		
		List<Paper> list = paperService.getPaperByNameCn(keywords);

		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	
	
	@ResponseBody
	@RequestMapping(value = "/paper/search_info_doctor", method = RequestMethod.POST)
	public PageDto<Paper> search_info_doctor(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println("abc"+keywords);
		
		List<Paper> list = paperDao.findBydoctorName(keywords);

		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	@RequestMapping(value = "/paper/search_info_doctor", method = RequestMethod.GET)
	public String getSearchInfoDoctor(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			  @RequestParam(value="keywords", required=false) String keywords,
			  @RequestParam(value="institution", required=false) String institution,
			  ModelMap map) {
		  System.out.println("keywords: "+keywords+institution);
		  map.addAttribute("institution",institution);
		  map.addAttribute("pageNumber", pageNumber);
		  map.addAttribute("pageSize",pageSize);
		  map.addAttribute("keyword",keywords);
		  
		  return "paper/search_info_doctor";
	  }
	
	
	

}
