package org.iscas.controller;

import javax.servlet.http.HttpServletRequest;

import org.iscas.web.entity.User;
import org.iscas.web.view.Msg;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by suemi on 17-7-2.
 */
@Controller
public class RouteController extends BaseController {

  @RequestMapping(value = "/")
  //@GetMapping("/")
  public String home() {
	  System.out.println("哈哈哈哈哈+home");
    return "index";
  }
  
  @RequestMapping(value = "/login")
  public String login1() {
	  System.out.println("哈哈哈哈哈+login1");
      return "login";
  }
  
  
  
  @RequestMapping(value = "/index")
  public String index2(Model model) {
	  Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
      model.addAttribute("msg", msg);
      System.out.println("哈哈哈哈哈+index");
    return "index";
  }
  
  /* @RequestMapping(value = "/", method = RequestMethod.GET)
  public ModelAndView home() {
    User user = currentUser();
    if(user == null) {
      user = userService.findByAccount("root");
      context().userId = user.getId();
    }
    ModelAndView view = new ModelAndView("/index");
    if(currentUserId() != null)
      view.addObject("user",user);

    return view;
  }*/
  
  @RequestMapping(value = "/index.html")
  public String index(Model model) {
	  Msg msg = new Msg("测试标题", "测试内容", "额外信息，只对管理员显示");
      model.addAttribute("msg", msg);
    return "index";
  }
/*  
  @RequestMapping(value = "/login.html", method = RequestMethod.GET)
  public String login() {
	  System.out.print("哈哈哈哈哈+login");
    return "login";
  }*/

  @RequestMapping(value = "/register.html", method = RequestMethod.GET)
  public String register() {
    return "global/register";
  }
  
  
  @RequestMapping(value = "/info.html", method = RequestMethod.GET)
  public String info() {
    return "info";
  }
  
  @RequestMapping(value = "/disease.html", method = RequestMethod.GET)
  public String disease(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("sortType", sortType);
	  return "disease/disease";
  }
  
  
  @RequestMapping(value = "/syndrome.html", method = RequestMethod.GET)
  public String syndrome(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("sortType", sortType);
	  return "syndrome/syndrome";
  }
  
  @RequestMapping(value = "/medicalcase.html", method = RequestMethod.GET)
  public String medicalcase(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("sortType", sortType);
	  return "medicalcase/medicalcase";
  }
  
  @RequestMapping(value = "/prescription.html", method = RequestMethod.GET)
  public String prescription(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("sortType", sortType);
	  return "prescription/prescription";
  }
  
  @RequestMapping(value = "/expert.html", method = RequestMethod.GET)
  public String expert(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "expert/expert";
  }

  @RequestMapping(value = "/paper.html", method = RequestMethod.GET)
  public String paper(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "paper/paper";
  }


  
  @RequestMapping(value = "/patent.html", method = RequestMethod.GET)
  public String patent(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "patent/patent";
  }
  
  @RequestMapping(value = "/naturalmedicine.html", method = RequestMethod.GET)
  public String naturalmedicine(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "naturalmedicine/naturalmedicine";
  }
  
  @RequestMapping(value = "/compoundregister.html", method = RequestMethod.GET)
  public String compoundregister(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "compoundregister/compoundregister";
  }
  @RequestMapping(value = "/mainrecord.html", method = RequestMethod.GET)
  public String mainrecord(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "mainrecord/mainrecord";
  }
  @RequestMapping(value = "/inspection.html", method = RequestMethod.GET)
  public String inspection(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "inspection/inspection";
  }
  @RequestMapping(value = "/inspectionresult.html", method = RequestMethod.GET)
  public String inspectionresult(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "inspectionresult/inspectionresult";
  }
  @RequestMapping(value = "/diagnosis.html", method = RequestMethod.GET)
  public String diagnosis(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "diagnosis/diagnosis";
  }
  @RequestMapping(value = "/medicalorders.html", method = RequestMethod.GET)
  public String medicalorders(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "medicalorders/medicalorders";
  }
  @RequestMapping(value = "/surgery.html", method = RequestMethod.GET)
  public String surgery(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "surgery/surgery";
  }
@RequestMapping(value = "/material.html", method = RequestMethod.GET)
  public String material(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  return "material/material";
  }

  @RequestMapping(value = "/image.html", method = RequestMethod.GET)
  public String image(@RequestParam(value = "pageNumber", defaultValue = "1") Integer pageNumber,
		  @RequestParam(value = "pageSize", defaultValue = "20") Integer pageSize,
		  @RequestParam(value = "sortType", defaultValue = "") String sortType,
		  ModelMap map) {
	  map.addAttribute("pageNumber", pageNumber);
	  map.addAttribute("pageSize",pageSize);
	  map.addAttribute("sortType", sortType);
	  return "image/image";
	}

@RequestMapping(value = "/infoAddData.html", method = RequestMethod.GET)
public String infoAddData() {

	  return "prescription/infoAddData";
}
@RequestMapping(value = "/infoAddDataMaterial.html", method = RequestMethod.GET)
public String infoAddDataMaterial() {

	  return "material/infoAddData";
}
@RequestMapping(value = "/infoAddDataDisease.html", method = RequestMethod.GET)
public String infoAddDataDisease() {

	  return "disease/infoAddData";
}
  @RequestMapping(value = "/books.html", method = RequestMethod.GET)
  public String books() {
    return "classic-books/home";
  }
  
  //添加人体穴位的跳转
  @RequestMapping(value = "/acupoint.html", method = RequestMethod.GET)
  public String acupoint() {
    return "acupoint/acupoint_main";
  }
  
  @RequestMapping(value = "/standard_home.html", method = RequestMethod.GET)
  public String standard_home() {
    return "standard/standard_home";
  }

}
