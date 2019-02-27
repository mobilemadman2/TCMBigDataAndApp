package org.iscas.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

import org.iscas.web.dao.StandardDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Image;
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Standard;
import org.iscas.web.view.CountStandard;
import org.iscas.web.view.IndexCollection;
import org.neo4j.register.Register.Int;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
public class StandardController extends BaseController{
	
	@Autowired
	StandardDao standardDao;
	
	@ResponseBody
	@RequestMapping(value="/standard/show_index", method = RequestMethod.GET)
	public List<IndexCollection> show_index(){
		Map<String, Integer> map = new HashMap<String, Integer>();
		map.put("C00/09 医药、卫生、劳动保护综合", 1);
		map.put("C10/29 医药", 2);
		map.put("C30/49 医疗器械", 3);
		map.put("C50/64 卫生", 4);
		map.put("其他", 5);
		int i = 0;
		int j = 0;
		
		List<String> firstIndexCollection = standardDao.findDistinctFirstIndex();
		List<IndexCollection> indexCollections = new ArrayList<>();
		
		for(String firstIndex:firstIndexCollection) {
			IndexCollection indexCollection = new IndexCollection();
			indexCollection.setFirstIndex(firstIndex);
			indexCollection.setStandardCount(standardDao.countByFirstIndex(firstIndex));
			
			List<String> secondIndexStringCollection = standardDao.findDistinctSecondIndex(firstIndex);
			List<CountStandard> secondIndexCollection = new ArrayList<>();
			for (i=0;i<secondIndexStringCollection.size(); i++) {
				CountStandard countStandard = new CountStandard();
				String secondIndex = secondIndexStringCollection.get(i);
				countStandard.setSecond_index(secondIndex);
				List<String> ccs = standardDao.findDistinctCCS(secondIndex);
				Integer index = Integer.valueOf((ccs.get(0).substring(1)));
				countStandard.setStandardCount(standardDao.countBySecondIndex(secondIndex));
				countStandard.setIndex(index);
				countStandard.setCcs(ccs.get(0));

				for (j=0; j<secondIndexCollection.size();j++) {
					if (index <= secondIndexCollection.get(j).getIndex()) {
						break;
					}
				}
				secondIndexCollection.add(j, countStandard);
			}
			indexCollection.setSecondIndexCollection(secondIndexCollection);
			
			for (i=0; i<indexCollections.size();i++) {
				if (map.get(firstIndex)<= map.get(indexCollections.get(i).getFirstIndex())) {
					break;
				}
			}
			indexCollections.add(i, indexCollection);
		}
		return indexCollections;	
	}
	
	//转向标准列表
	@RequestMapping(value="/getStantardList", method =  RequestMethod.GET)
	public String getStantardList(
			@RequestParam String first_index,
			@RequestParam String second_index,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType,
			ModelMap model){
		
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("sortType", sortType);
		model.addAttribute("first_index", first_index);
		model.addAttribute("second_index", second_index);
		System.out.println("转向");
		return "standard/standard_list";		
	}
	
	//获取标准列表
	@ResponseBody
	@RequestMapping(value = "/standard/get_list", method = RequestMethod.POST)
	public PageDto<Standard> image_list_page(@RequestParam String first_index,
			@RequestParam String second_index,
			@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
			) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException 
	{
		System.out.println("转向成功");
		List<Standard> list = standardDao.findByFirstIndexAndSecondIndex(first_index, second_index);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	//标准详情界面
	@RequestMapping(value = "/standard/info.html", method = RequestMethod.GET)
	public String standard_info(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "standardId", required = false) Long standardId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {	
		Optional<Standard> standard = standardDao.findById(standardId);
		System.out.println(standard.get().getFilePath());
		
		map.addAttribute("standard", standard.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		return "standard/info";
	}
	//PDF界面
	@RequestMapping(value = "/standard_pdf.html", method = RequestMethod.GET)
	public String prescription(
			@RequestParam String file_path,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		map.addAttribute("file_path", file_path);	
		return "standard/standard_pdf";
	}
	
	@ResponseBody
	@RequestMapping(value = "/standard/standard_search", method = RequestMethod.POST)
	public PageDto<Standard> prescription_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println("11111111111111111111111111111");
		System.out.println("abc"+keywords);	
		List<Standard> list = standardDao.findByName(keywords);		
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}


}
