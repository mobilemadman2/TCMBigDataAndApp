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
import org.iscas.web.entity.CompoundRegister;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.CompoundRegisterDao;
import org.iscas.web.dao.CompoundRegisterDao;

@Controller
public class CompoundRegisterController extends BaseController {

	@Autowired
	CompoundRegisterDao compoundregisterDao;

	@ResponseBody
	@RequestMapping(value = "/compoundregister/get", method = RequestMethod.POST)
	public PageDto<CompoundRegister> compoundregister_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//System.out.println("hahahahhahah,start");
		List<CompoundRegister> list = compoundregisterDao.findAll();
		//System.out.println("hahahahhahah,end");
		// for(CompoundRegister d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//CompoundRegisterDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/compoundregister/get_return.html", method = RequestMethod.GET)
	public String compoundregister_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<CompoundRegister> list = compoundregisterDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "compoundregister/compoundregister";
	}
	
	@RequestMapping(value = "/compoundregister/info.html", method = RequestMethod.GET)
	public String compoundregister_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "compoundregisterId", required = false) Long compoundregisterId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<CompoundRegister> compoundregister = compoundregisterDao.findById(compoundregisterId);
		System.out.println(compoundregister.get().getCnn());
		
		map.addAttribute("compoundregister", compoundregister.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "compoundregister/info";
	}

}
