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
import org.iscas.web.entity.BingZheng;
import org.iscas.web.entity.Disease;
import org.iscas.web.entity.Material;
import org.iscas.web.service.DiseaseService;
import org.iscas.web.view.SortDiseases;
import org.iscas.web.view.SortDiseases;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.iscas.web.dao.BingzhengDao;
import org.iscas.web.dao.DiseaseDao;

@Controller
public class DiseaseController extends BaseController {
	private static final Log Log = LogFactory.getLog(DiseaseController.class);
	@Autowired
	DiseaseDao diseaseDao;
	@Autowired
	BingzhengDao bingzhengDao;
	
	@Autowired
	DiseaseService diseaseService;

	@ResponseBody
	@RequestMapping(value = "/disease/get", method = RequestMethod.POST)
	public PageDto<Disease> disease_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType) throws URISyntaxException,
			IOException, InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println(pageNumber + "\t" + pageSize + "\t" +sortType);
		System.out.println("/disease/get");
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

			Page<Disease> list = diseaseDao.findAll(pageable);
/*			for(Disease disease : list.getContent()) {
				System.out.println(disease.getOverview());
			}*/
			return PageDto.ofPagedList(list.getContent(), list.getNumber(), pageNumber, pageSize);
		} else {
			List<Disease> list = diseaseDao.findAll();
			return PageDto.ofList(list, list.size(), pageNumber, pageSize);
		}
	}

	@RequestMapping(value = "/disease/get_return.html", method = RequestMethod.GET)
	public String disease_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Disease> list = diseaseDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("sortType", sortType);
		
		return "disease/disease";
	}
	
	@RequestMapping(value = "/disease/info.html", method = RequestMethod.GET)
	public String disease_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType,
			@RequestParam(value = "diseaseId", required = false) Long diseaseId,
			@RequestParam(value = "from", required = false) String from,
			HttpRequest request,
			HttpSession session,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		System.out.println(from);
		Optional<Disease> disease = diseaseDao.findById(diseaseId);
		
		//		System.out.println(disease.get().getName());
		List<BingZheng>ls = bingzhengDao.findByDisease(disease.get());
		
//		for(BingZheng bz:ls) {
//			System.out.println(bz.getName());
//		}
		
		map.addAttribute("disease", disease.get());
		map.addAttribute("bingzheng",ls);
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		map.addAttribute("sortType", sortType);
		
		return "disease/info";
	}
	
	
	//homepage idsease info
	@RequestMapping(value = "/disease/info-home.html", method = RequestMethod.GET)
	public String disease_info_home(@RequestParam(value = "diseaseId", required = false) Long diseaseId,
			HttpRequest request,
			Model map)  {
		Optional<Disease> disease = diseaseDao.findById(diseaseId);
		
		//		System.out.println(disease.get().getName());
		List<BingZheng> ls = bingzhengDao.findByDisease(disease.get());
		
//		for(BingZheng bz:ls) {
//			System.out.println(bz.getName());
//		}
		
		map.addAttribute("disease", disease.get());
		map.addAttribute("bingzheng",ls);
		
		return "disease/info-home";
	}
	
	@ResponseBody
	@RequestMapping(value = "/disease/disease-searchbackup", method = RequestMethod.POST)
	public PageDto<Disease> disease_search_backup(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println(keywords);
		
		List<Disease> list = diseaseService.getDisease(keywords);
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value = "/disease/disease-search", method = RequestMethod.POST)
	public PageDto<Disease> disease_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords,
			ModelMap model) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println(keywords);
		
		List<Disease> list = diseaseService.getDiseaseByNameCn(keywords);
		//System.out.println("搜索输出："+list.size()+";"+pageNumber+";"+pageSize);
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/disease/infoUpdateData.html", method = RequestMethod.GET)
	public String disease_infoUpdate(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "diseaseId", required = false) Long diseaseId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Disease> disease = diseaseDao.findById(diseaseId);
		System.out.println(disease.get().getName());
		//diseaseDao.save(disease);
		map.addAttribute("disease", disease.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "disease/infoUpdateData";
	}
	
	@RequestMapping("/disease/infoUpdateData")
    public void disease_infoUpdate(@ModelAttribute("disease") Disease disease) throws Exception {
        System.out.println(disease.getId());
        System.out.println(disease.getName());
        Optional<Disease> newdisease=diseaseDao.findById(disease.getId());
        newdisease.get().setAlias(disease.getAlias());
        newdisease.get().setClma(disease.getClma());
        newdisease.get().setDidi(disease.getDidi());
        newdisease.get().setEsdi(disease.getEsdi());
        newdisease.get().setEtPa(disease.getEtPa());
        newdisease.get().setExamination(disease.getExamination());
        newdisease.get().setName(disease.getName());
        newdisease.get().setNameChn(disease.getNameChn());
        newdisease.get().setOverview(disease.getOverview());
        System.out.println(newdisease.get().getCreateAt().toString());
        if(!disease.getName().isEmpty() && !disease.getNameChn().isEmpty() ) {
        	//diseaseDao.save(disease);
        	/*diseaseDao.updateById(disease.getId(), disease.getName(), disease.getAlias(), disease.getComposition(),
        			disease.getProcessed(), disease.getProcess(), disease.getPharmacologicaleffects(),
        			disease.getFunction(), disease.getDosage(), disease.getRemarks(), disease.getVariousDescription(), 
        			disease.getApplication(), disease.getAttention(), disease.getSource());*/
        	diseaseDao.save(newdisease.get());
        }
        
    }
	
	@RequestMapping(value = "/disease/delete", method = RequestMethod.GET)
	public String disease_id_delete(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "diseaseId", required = false) Long diseaseId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Disease> disease = diseaseDao.findById(diseaseId);
		//System.out.println(diseaseId+",name:"+disease.get().getName());
		diseaseDao.deleteById(diseaseId);
		
		//map.addAttribute("disease", disease.get());
		//map.addAttribute("pageNumber", pageNumber);
		//map.addAttribute("pageSize", pageSize);
		
		return "disease/delete";
	}
	
	@RequestMapping("/disease/infoAddData")
    public void runLogin(@ModelAttribute("disease") Disease disease) throws Exception {
        System.out.println(disease.getAlias());
        System.out.println(disease.getName());
        if(!disease.getName().isEmpty() && !disease.getNameChn().isEmpty() ) {
        	diseaseDao.save(disease);
        }
        
    }

	
	@ResponseBody
	@RequestMapping(value = "/diseases/alphabet-order")
	public List<SortDiseases> getAlphabets() {
		List<SortDiseases> alphabetDisease = new ArrayList<>();
		char curr_char = 'A';
		List<Disease> diseaselist = diseaseDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<diseaselist.size()&&curr_char<='Z'){
			if(curr_char==diseaselist.get(index).getNamePinyin().charAt(0)) {
				SortDiseases aDiseases = new SortDiseases();
				List<String> diseaseName = new ArrayList<>(); 
				List<String> diseaseId = new ArrayList<>(); 
				aDiseases.setName(curr_char+"");
				
				while(index<diseaselist.size()&&curr_char==diseaselist.get(index).getNamePinyin().charAt(0)) {
					diseaseName.add(diseaselist.get(index).getName());
					diseaseId.add(diseaselist.get(index).getId().toString());
					index++;
				}
				aDiseases.setDiseases(diseaseName);
				aDiseases.setDiseasesId(diseaseId);
				alphabetDisease.add(aDiseases);
				
			}
			curr_char++;
		}
		return alphabetDisease;
	}
	@ResponseBody
	@RequestMapping(value = "/diseases/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Disease> diseases_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//diseaseDao.findAllByNamePinyinAsc();
		char alphabetC=alphabet.charAt(0);
		List<Disease> list = diseaseDao.findAllByNamePinyinAlphabet(alphabet);
		//char curr_char = 'a';
/*		if(alphabetC=='o')
		System.out.println("yes:"+alphabetC);
		else
			System.out.println("no:"+alphabetC);*/
		
		/*List<Material> diseaselist = diseaseDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<diseaselist.size()&&curr_char<='z'){	
			System.out.println("diseaselist curr_diseaselist:"+diseaselist.get(index).getNamePinyin());
			System.out.println(diseaselist.get(index).getNamePinyin().charAt(0));
			if(curr_char==diseaselist.get(index).getNamePinyin().charAt(0)) {	
				
				while(index<diseaselist.size()&&alphabetC==diseaselist.get(index).getNamePinyin().charAt(0)) {
					
					list.add(diseaselist.get(index));
					index++;
				}
			}
			curr_char++;
		}*/
		
		System.out.println("list size:"+list.size());

		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	

}
