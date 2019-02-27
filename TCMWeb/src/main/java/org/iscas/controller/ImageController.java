package org.iscas.controller;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.iscas.web.dao.ImageDao;
import org.iscas.web.dto.PageDto;
import org.iscas.web.entity.Image;
import org.iscas.web.view.CountImage;
import org.iscas.web.view.DiseaseImageClasses;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import freemarker.template.Template;

@Controller
public class ImageController extends BaseController{
	
	@Autowired
	ImageDao imageDao;
	
	//获取图像分类信息
	@ResponseBody
	@RequestMapping(value="/image/show_classes", method = RequestMethod.GET)
	public List<DiseaseImageClasses> show_classes() {
		List<String> dieases = imageDao.findDistinctDieaseClass();		
		List<DiseaseImageClasses> diseaseImageClasses_list = new ArrayList<>();
		for (String disese:dieases) {
			System.out.println(disese);
			
			DiseaseImageClasses diseaseImageClasses = new DiseaseImageClasses();
			List<String> imageClassesString = imageDao.findDistinctImageClasses(disese);
			System.out.println(imageClassesString);
			List<CountImage> imageClasses = new ArrayList<>();
			for(String imageClass:imageClassesString) {
				CountImage countImage = new CountImage();
				countImage.setImage_class(imageClass);
				countImage.setImageCount(imageDao.countByDiseaseClassAndImageClass(disese,imageClass));
				imageClasses.add(countImage);
			}
			
			diseaseImageClasses.setImageCount(imageDao.countByDiseaseClass(disese));
			diseaseImageClasses.setDisease_class(disese);
			diseaseImageClasses.setImage_classes(imageClasses);
			diseaseImageClasses_list.add(diseaseImageClasses);
		}
		
		
		return diseaseImageClasses_list;
	}
	
	//转向图像列表界面
	@RequestMapping(value="/getImageList", method =  RequestMethod.GET)
	public String getImageList(@RequestParam String disease_class,
			@RequestParam String image_class,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "sortType", defaultValue = "") String sortType,
			ModelMap model){
		model.addAttribute("pageNumber", pageNumber);
		model.addAttribute("pageSize",pageSize);
		model.addAttribute("sortType", sortType);
		model.addAttribute("disease_class", disease_class);
		model.addAttribute("image_class", image_class);
		return "image/image_list";		
	}
	
	//获取图像列表
	@ResponseBody
	@RequestMapping(value = "/image_list/get", method = RequestMethod.POST)
	public PageDto<Image> image_list_page(@RequestParam String disease_class,
			@RequestParam String image_class,
			@RequestParam(value = "searchQuery", required = false) String queryString,
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize
			) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException 
	{
		List<Image> list = imageDao.findByDiseaseClassAndImageClass(disease_class, image_class);
		return PageDto.ofList(list, list.size(), pageNumber, pageSize);
	}
	
	//图像详情界面
	@RequestMapping(value = "/image/info.html", method = RequestMethod.GET)
	public String image_info(
			@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
			@RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
			@RequestParam(value = "imageId", required = false) Long imageId,
			Model map) throws URISyntaxException, IOException,
			InterruptedException, InstantiationException, IllegalAccessException {
		
		Optional<Image> image = imageDao.findById(imageId);
		System.out.println(image.get().getImagePath());
		
		map.addAttribute("disease_class", image.get().getDiseaseClass());
		map.addAttribute("image_class", image.get().getImageClass());
		map.addAttribute("image", image.get());
		map.addAttribute("pageNumber", pageNumber);
		map.addAttribute("pageSize", pageSize);
		
		return "image/info";
	}
	
	//返回列表界面
	@RequestMapping(value = "/image_list.html", method = RequestMethod.GET)
	public String prescription(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	      map.addAttribute("pageNumber", pageNumber);
	      map.addAttribute("pageSize",pageSize);
	      map.addAttribute("sortType", sortType);
	      return "image/image_list";
	}
	
	
}
