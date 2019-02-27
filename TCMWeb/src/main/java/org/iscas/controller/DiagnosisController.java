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
import org.iscas.web.entity.Diagnosis;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.DiagnosisDao;

@Controller
public class DiagnosisController extends BaseController {

	@Autowired
	DiagnosisDao diagnosisDao;

	@ResponseBody
	@RequestMapping(value = "/diagnosis/get", method = RequestMethod.POST)
	public PageDto<Diagnosis> diagnosis_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Diagnosis> list = diagnosisDao.findAll();
		// for(Diagnosis d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//PatentDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/diagnosis/get_return.html", method = RequestMethod.GET)
	public String diagnosis_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Diagnosis> list = diagnosisDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "diagnosis/diagnosis";
	}
	
	@RequestMapping(value = "/diagnosis/info.html", method = RequestMethod.GET)
	public String diagnosis_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "diagnosisId", required = false) Long diagnosisId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Diagnosis> diagnosis = diagnosisDao.findById(diagnosisId);
		System.out.println(diagnosis.get().getId());
		
		map.addAttribute("diagnosis", diagnosis.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "diagnosis/info";
	}

}
