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
import org.iscas.web.entity.Prescription;
import org.iscas.web.entity.Prescription;
import org.iscas.web.service.PrescriptionService;
import org.iscas.web.view.SortPrescription;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.type.TrueFalseType;
import org.iscas.web.dao.PrescriptionDao;

@Controller
public class PrescriptionController extends BaseController {

	@Autowired
	PrescriptionDao prescriptionDao;
	
	@Autowired
	PrescriptionService prescriptionService;

	@ResponseBody
	@RequestMapping(value = "/prescription/get", method = RequestMethod.POST)
	public PageDto<Prescription> prescription_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Prescription> list = prescriptionDao.findAll();
		System.out.println("/prescription/get");
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/prescription/get_return.html", method = RequestMethod.GET)
	public String prescription_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Prescription> list = prescriptionDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		System.out.println("/prescription/get_return.html");
		return "prescription/prescription";
	}
	
	@RequestMapping(value = "/prescription/info.html", method = RequestMethod.GET)
	public String prescription_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "prescriptionId", required = false) Long prescriptionId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Prescription> prescription = prescriptionDao.findById(prescriptionId);
		System.out.println(prescription.get().getName());
		
		map.addAttribute("prescription", prescription.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "prescription/info";
	}
	
	@RequestMapping(value = "/prescription/infoUpdateData.html", method = RequestMethod.GET)
	public String prescription_infoUpdate(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "prescriptionId", required = false) Long prescriptionId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Prescription> prescription = prescriptionDao.findById(prescriptionId);
		System.out.println(prescription.get().getName());
		//prescriptionDao.save(prescription);
		map.addAttribute("prescription", prescription.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "prescription/infoUpdateData";
	}
	
	@RequestMapping("/prescription/infoUpdateData")
    public void prescription_infoUpdate(@ModelAttribute("prescription") Prescription prescription) throws Exception {
        System.out.println(prescription.getId());
        System.out.println(prescription.getName());
        Optional<Prescription> newprescription=prescriptionDao.findById(prescription.getId());
        newprescription.get().setAlias(prescription.getAlias());
        newprescription.get().setApplication(prescription.getApplication());
        newprescription.get().setAttention(prescription.getAttention());
        newprescription.get().setComposition(prescription.getComposition());
        newprescription.get().setDosage(prescription.getDosage());
        newprescription.get().setFunction(prescription.getFunction());
        newprescription.get().setName(prescription.getName());
        newprescription.get().setPharmacologicaleffects(prescription.getPharmacologicaleffects());
        newprescription.get().setProcess(prescription.getProcess());
        newprescription.get().setProcessed(prescription.getProcessed());
        newprescription.get().setRemarks(prescription.getRemarks());
        newprescription.get().setSource(prescription.getSource());
        newprescription.get().setVariousDescription(prescription.getVariousDescription());
        System.out.println(newprescription.get().getCreateAt().toString());
        if(!prescription.getName().isEmpty() && !prescription.getSource().isEmpty() && !prescription.getComposition().isEmpty()) {
        	//prescriptionDao.save(prescription);
        	/*prescriptionDao.updateById(prescription.getId(), prescription.getName(), prescription.getAlias(), prescription.getComposition(),
        			prescription.getProcessed(), prescription.getProcess(), prescription.getPharmacologicaleffects(),
        			prescription.getFunction(), prescription.getDosage(), prescription.getRemarks(), prescription.getVariousDescription(), 
        			prescription.getApplication(), prescription.getAttention(), prescription.getSource());*/
        	prescriptionDao.save(newprescription.get());
        }
        
    }
	
	@RequestMapping(value = "/prescription/delete", method = RequestMethod.GET)
	public String prescription_id_delete(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "prescriptionId", required = false) Long prescriptionId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Prescription> prescription = prescriptionDao.findById(prescriptionId);
		//System.out.println(prescriptionId+",name:"+prescription.get().getName());
		prescriptionDao.deleteById(prescriptionId);
		
		//map.addAttribute("prescription", prescription.get());
		//map.addAttribute("pageNumber", pageNumber);
		//map.addAttribute("pageSize", pageSize);
		
		return "prescription/delete";
	}
	
	@RequestMapping("/prescription/infoAddData")
    public void runLogin(@ModelAttribute("prescription") Prescription prescription) throws Exception {
        System.out.println(prescription.getAlias());
        System.out.println(prescription.getName());
        if(!prescription.getName().isEmpty() && !prescription.getSource().isEmpty() && !prescription.getComposition().isEmpty()) {
        	prescriptionDao.save(prescription);
        }
        
    }
	
	//index link
	@RequestMapping(value = "/prescription/info-home.html", method = RequestMethod.GET)
	public String prescription_info_home(@RequestParam(value = "prescriptionId", required = true) Long prescriptionId,
			Model map) {
		Optional<Prescription> prescription = prescriptionDao.findById(prescriptionId);
		System.out.println(prescription.get().getName());
		
		map.addAttribute("prescription", prescription.get());
		
		return "prescription/info-home";
	}
	
	
	
	@ResponseBody
	@RequestMapping(value = "/prescription/prescription-search", method = RequestMethod.POST)
	public PageDto<Prescription> prescription_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println("abc"+keywords);
		
		List<Prescription> list = prescriptionService.getPrescriptionByNameCn(keywords);
		
		
		
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	@ResponseBody
	@RequestMapping(value = "/prescription/alphabet-order")
	public List<SortPrescription> getAlphabets() {
		List<SortPrescription> alphabetPrescription = new ArrayList<>();
		char curr_char = 'A';
		List<Prescription> prescriptionlist = prescriptionDao.findAllByNamePinyinAsc();
		
		int index = 0;
		while(index<prescriptionlist.size()&&curr_char<='Z'){
			if(curr_char==prescriptionlist.get(index).getNamePinyin().charAt(0)) {
				SortPrescription aPrescriptions = new SortPrescription();
				List<String> prescriptionName = new ArrayList<>(); 
				List<String> prescriptionId = new ArrayList<>(); 
				aPrescriptions.setName(curr_char+"");
				
				while(index<prescriptionlist.size()&&curr_char==prescriptionlist.get(index).getNamePinyin().charAt(0)) {
					prescriptionName.add(prescriptionlist.get(index).getName());
					prescriptionId.add(prescriptionlist.get(index).getId().toString());
					index++;
				}
				aPrescriptions.setPrescriptions(prescriptionName);
				aPrescriptions.setPrescriptionsId(prescriptionId);
				
				alphabetPrescription.add(aPrescriptions);
				
			}
			curr_char++;
		}
		return alphabetPrescription;
	}
	@ResponseBody
	@RequestMapping(value = "/prescription/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Prescription> prescription_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//prescriptionDao.findAllByNamePinyinAsc();
		char alphabetC=alphabet.charAt(0);
		List<Prescription> list = prescriptionDao.findAllByNamePinyinAlphabet(alphabet);
		//char curr_char = 'a';
/*		if(alphabetC=='o')
		System.out.println("yes:"+alphabetC);
		else
			System.out.println("no:"+alphabetC);*/
		
		/*List<Prescription> prescriptionlist = prescriptionDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<prescriptionlist.size()&&curr_char<='z'){	
			System.out.println("prescriptionlist curr_prescriptionlist:"+prescriptionlist.get(index).getNamePinyin());
			System.out.println(prescriptionlist.get(index).getNamePinyin().charAt(0));
			if(curr_char==prescriptionlist.get(index).getNamePinyin().charAt(0)) {	
				
				while(index<prescriptionlist.size()&&alphabetC==prescriptionlist.get(index).getNamePinyin().charAt(0)) {
					
					list.add(prescriptionlist.get(index));
					index++;
				}
			}
			curr_char++;
		}*/
		
		//System.out.println("list size:"+list.size());

		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}

}
