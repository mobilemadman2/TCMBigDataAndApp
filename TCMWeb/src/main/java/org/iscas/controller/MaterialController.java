package org.iscas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Material;
import org.iscas.web.entity.Material;
import org.iscas.web.service.MaterialService;
import org.iscas.web.view.SortMaterial;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.MaterialDao;

@Controller
public class MaterialController extends BaseController {

	@Autowired
	MaterialDao materialDao;
	
	@Autowired
	MaterialService materialService;

	@ResponseBody
	@RequestMapping(value = "/material/get", method = RequestMethod.POST)
	public PageDto<Material> material_page(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Material> list = materialDao.findAll();
		// for(Material d:list) {
		// System.out.println(d.getName());
		// }
		//
		// for(BranchAndEffect l:list){
		// System.out.println(l.getId()+"\n"+l.getAbstraction()+"\n"+l.getBranch()+"\n"+l.getEffect()+"\n");
		// }

		// ArrayList<>();//PatentDto.of(tmpResult);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@RequestMapping(value = "/material/get_return.html", method = RequestMethod.GET)
	public String material_return_page(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			ModelMap model) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		List<Material> list = materialDao.findAll();
		model.addAttribute("pageNumber",pageNumber);
		model.addAttribute("pageSize",pageSize);
		
		return "material/material";
	}
	
	@RequestMapping(value = "/material/info.html", method = RequestMethod.GET)
	public String material_info(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "materialId", required = false) Long materialId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Material> material = materialDao.findById(materialId);
		System.out.println(material.get().getId());
		
		map.addAttribute("material", material.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "material/info";
	}

	@RequestMapping(value = "/material/infoUpdateData.html", method = RequestMethod.GET)
	public String material_infoUpdate(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "materialId", required = false) Long materialId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Material> material = materialDao.findById(materialId);
		System.out.println(material.get().getAlias());
		//materialDao.save(material);
		map.addAttribute("material", material.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "material/infoUpdateData";
	}
	
	@RequestMapping("/material/infoUpdateData")
    public void material_infoUpdate(@ModelAttribute("material") Material material) throws Exception {
        System.out.println(material.getId());
        System.out.println(material.getAlias());
        Optional<Material> newmaterial=materialDao.findById(material.getId());
        /*newmaterial.get().setAction(material.getAction());
        newmaterial.get().setAlias(material.getAlias());
        newmaterial.get().setAttribution(material.getAttribution());
        newmaterial.get().setChannel(material.getChannel());
        newmaterial.get().setClassification(material.getClassification());
        newmaterial.get().setComposition(material.getComposition());
        newmaterial.get().setCultivation(material.getCultivation());
        newmaterial.get().setDescription(material.getDescription());
        newmaterial.get().setDiscuss(material.getDiscuss());*/
        material.setCreateAt(newmaterial.get().getCreateAt());
        material.setDeleteAt(newmaterial.get().getDeleteAt());
        material.setUpdateAt(newmaterial.get().getUpdateAt());
        materialDao.save(material);
/*        newmaterial
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()
        newmaterial.get()*/
        //System.out.println(newmaterial.get().getCreateAt().toString());
/*        if(!material.getName().isEmpty() && !material.getSource().isEmpty() && !material.getComposition().isEmpty()) {
        	//materialDao.save(material);
        	materialDao.updateById(material.getId(), material.getName(), material.getAlias(), material.getComposition(),
        			material.getProcessed(), material.getProcess(), material.getPharmacologicaleffects(),
        			material.getFunction(), material.getDosage(), material.getRemarks(), material.getVariousDescription(), 
        			material.getApplication(), material.getAttention(), material.getSource());
        	materialDao.save(newmaterial.get());
        }*/
        
    }
	
	@RequestMapping(value = "/material/delete", method = RequestMethod.GET)
	public String material_id_delete(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "materialId", required = false) Long materialId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		Optional<Material> material = materialDao.findById(materialId);
		//System.out.println(materialId+",name:"+material.get().getName());
		materialDao.deleteById(materialId);
		
		//map.addAttribute("material", material.get());
		//map.addAttribute("pageNumber", pageNumber);
		//map.addAttribute("pageSize", pageSize);
		
		return "material/delete";
	}
	
	@RequestMapping("/material/infoAddData")
    public void runLogin(@ModelAttribute("material") Material material) throws Exception {
        System.out.println(material.getAlias());
        materialDao.save(material);
       /* System.out.println(material.getName());
        if(!material.getName().isEmpty() && !material.getSource().isEmpty() && !material.getComposition().isEmpty()) {
        	materialDao.save(material);
        }*/
        
    }

	
	@RequestMapping(value = "/material/info-home.html", method = RequestMethod.GET)
	public String material_info(@RequestParam(value = "materialId", required = true) Long materialId,
			Model map) {
		Optional<Material> material = materialDao.findById(materialId);
		
		map.addAttribute("material", material.get());		
		return "material/material-info-home";
	}

	
	@ResponseBody
	@RequestMapping(value = "/material/material-search", method = RequestMethod.POST)
	public PageDto<Material> material_search(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "keywords") String keywords) 
			throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		System.out.println("abc"+keywords);
		
		List<Material> list = materialService.getMaterialByNameCn(keywords);
		
		
		
		return PageDto.ofPagedList(list, list.size(), pageNumber, pageSize);
	}
	@ResponseBody
	@RequestMapping(value = "/material/alphabet-order")
	public List<SortMaterial> getAlphabets() {
		List<SortMaterial> alphabetMaterial = new ArrayList<>();
		char curr_char = 'A';
		List<Material> materiallist = materialDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<materiallist.size()&&curr_char<='Z'){
			if(curr_char==materiallist.get(index).getNamePinyin().charAt(0)) {
				SortMaterial aMaterials = new SortMaterial();
				List<String> materialName = new ArrayList<>(); 
				List<String> materialId = new ArrayList<>(); 
				aMaterials.setName(curr_char+"");
				
				while(index<materiallist.size()&&curr_char==materiallist.get(index).getNamePinyin().charAt(0)) {
					materialName.add(materiallist.get(index).getNameCn());
					materialId.add(materiallist.get(index).getId().toString());
					index++;
				}
				aMaterials.setMaterials(materialName);
				aMaterials.setMaterialsId(materialId);
				alphabetMaterial.add(aMaterials);
				
			}
			curr_char++;
		}
		return alphabetMaterial;
	}
	@ResponseBody
	@RequestMapping(value = "/material/get_alpahbet", method = RequestMethod.POST)
	public PageDto<Material> material_page_alphabet(@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "alphabet", defaultValue = "A") String alphabet) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		//materialDao.findAllByNamePinyinAsc();
		char alphabetC=alphabet.charAt(0);
		List<Material> list = materialDao.findAllByNamePinyinAlphabet(alphabet);
		//char curr_char = 'a';
/*		if(alphabetC=='o')
		System.out.println("yes:"+alphabetC);
		else
			System.out.println("no:"+alphabetC);*/
		
		/*List<Material> materiallist = materialDao.findAllByNamePinyinAsc();
		int index = 0;
		while(index<materiallist.size()&&curr_char<='z'){	
			System.out.println("materiallist curr_materiallist:"+materiallist.get(index).getNamePinyin());
			System.out.println(materiallist.get(index).getNamePinyin().charAt(0));
			if(curr_char==materiallist.get(index).getNamePinyin().charAt(0)) {	
				
				while(index<materiallist.size()&&alphabetC==materiallist.get(index).getNamePinyin().charAt(0)) {
					
					list.add(materiallist.get(index));
					index++;
				}
			}
			curr_char++;
		}*/
		
		//System.out.println("list size:"+list.size());

		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	@ResponseBody
	@RequestMapping(value = "/materil/alphabettest", method = RequestMethod.GET)
	public String material_info_alphaabettest(/*@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "materialId", required = false) Long materialId,
			Model map*/) {
		Optional<Material> material = materialDao.findById((long) 1);
		System.out.println(material.get().getNameCn());
		
/*		map.addAttribute("material", material.get());
		map.addAttribute("pageNumber", 20);
		map.addAttribute("pageSize", 1);*/
		
		return material.get().getNameCn();
	}
}
