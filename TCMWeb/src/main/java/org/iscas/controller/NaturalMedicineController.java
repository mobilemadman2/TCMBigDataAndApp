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
import org.iscas.web.entity.NaturalMedicine;


import java.io.IOException;
import java.net.URISyntaxException;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.NaturalMedicineDao;
import org.iscas.web.dao.NaturalMedicineDao;

@Controller
public class NaturalMedicineController extends BaseController {

	@Autowired
	NaturalMedicineDao naturalmedicineDao;

	@ResponseBody
	@RequestMapping(value = "/naturalmedicine/get", method = RequestMethod.POST)
	public PageDto<NaturalMedicine> naturalmedicine_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//System.out.println("hahahahhahah,start");
		List<NaturalMedicine> list = naturalmedicineDao.findAll();
		//System.out.println("hahahahhahah,end");
		// for(NaturalMedicine d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//NaturalMedicineDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/naturalmedicine/get_return.html", method = RequestMethod.GET)
	public String naturalmedicine_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<NaturalMedicine> list = naturalmedicineDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "naturalmedicine/naturalmedicine";
	}
	
	@RequestMapping(value = "/naturalmedicine/info.html", method = RequestMethod.GET)
	public String naturalmedicine_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "naturalmedicineId", required = false) Long naturalmedicineId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<NaturalMedicine> naturalmedicine = naturalmedicineDao.findById(naturalmedicineId);
		System.out.println(naturalmedicine.get().getNameCn());
		
		map.addAttribute("naturalmedicine", naturalmedicine.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "naturalmedicine/info";
	}

}
