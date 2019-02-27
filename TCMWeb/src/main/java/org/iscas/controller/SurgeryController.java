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
import org.iscas.web.entity.Surgery;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.SurgeryDao;

@Controller
public class SurgeryController extends BaseController {

	@Autowired
	SurgeryDao surgeryDao;

	@ResponseBody
	@RequestMapping(value = "/surgery/get", method = RequestMethod.POST)
	public PageDto<Surgery> surgery_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Surgery> list = surgeryDao.findAll();
		// for(Surgery d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//PatentDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/surgery/get_return.html", method = RequestMethod.GET)
	public String surgery_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Surgery> list = surgeryDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "surgery/surgery";
	}
	
	@RequestMapping(value = "/surgery/info.html", method = RequestMethod.GET)
	public String surgery_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "surgeryId", required = false) Long surgeryId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Surgery> surgery = surgeryDao.findById(surgeryId);
		System.out.println(surgery.get().getId());
		
		map.addAttribute("surgery", surgery.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "surgery/info";
	}

}
