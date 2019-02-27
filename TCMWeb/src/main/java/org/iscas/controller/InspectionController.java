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
import org.iscas.web.entity.Inspection;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.InspectionDao;

@Controller
public class InspectionController extends BaseController {

	@Autowired
	InspectionDao inspectionDao;

	@ResponseBody
	@RequestMapping(value = "/inspection/get", method = RequestMethod.POST)
	public PageDto<Inspection> inspection_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Inspection> list = inspectionDao.findAll();
		// for(Inspection d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//PatentDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/inspection/get_return.html", method = RequestMethod.GET)
	public String inspection_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Inspection> list = inspectionDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "inspection/inspection";
	}
	
	@RequestMapping(value = "/inspection/info.html", method = RequestMethod.GET)
	public String inspection_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "inspectionId", required = false) Long inspectionId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Inspection> inspection = inspectionDao.findById(inspectionId);
		System.out.println(inspection.get().getId());
		
		map.addAttribute("inspection", inspection.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "inspection/info";
	}

}
