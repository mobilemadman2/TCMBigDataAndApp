package org.iscas.controller;

import org.iscas.web.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;
import org.iscas.web.dao.UserDao;
import org.iscas.web.dto.CarryDto;

/**
 * Created by suemi on 17-7-2.
 */
@Controller
public class UserController extends BaseController {
	@Autowired UserDao userDao;
	
	  @ResponseBody
	  @RequestMapping(value = "/user/login-action", method = RequestMethod.POST)
	  public CarryDto<String> login(@RequestParam(value = "account") String userName,
	                            @RequestParam(value = "password") String password) {
		System.out.println("userName: "+userName);
		System.out.println("Password: "+password);
	    User user = userService.findByAccount(userName);
	    String msg = "";
	    if(user == null){
	      msg="此用户不存在";
	    }else if(user.getPassword().equals(password)) {
	      context().userId = user.getId();
	      session.setAttribute("user", currentUser());
	      msg="用户已登陆";
	    } else {
	    	msg="用户名密码不匹配";
	    }
	    return CarryDto.of(msg);
	  }
	  
	  @RequestMapping(value = "/user/user-info", method = RequestMethod.GET)
	  public String user_center() { 
	    return "user/user-info";
	  }
	  
	  @RequestMapping(value = "/user/update-password", method = RequestMethod.GET)
	  public String user_password() {	    
	    return "/user/update-password";
	  }
	  
/*	  @RequestMapping(value = "/logout", method = RequestMethod.GET)
	  public String logout() {
		  session.removeAttribute("user");
		//System.out.println("userId: "+currentUserId());
	    
	    return "index";
	  }*/
	  
	  @ResponseBody
	  @RequestMapping(value = "/register", method = RequestMethod.POST)
	  public CarryDto<String> register(@RequestParam String username,
			  @RequestParam String password,
			  @RequestParam String passwordConfirm,
			  @RequestParam String email,
			  @RequestParam String mobile,
			  ModelMap model) {
		  String errMsg = "";
		  if(username.isEmpty()||password.isEmpty()||passwordConfirm.isEmpty()
				  ||email.isEmpty()||mobile.isEmpty()) {
			  return CarryDto.of("注册信息未填写完全");
		  }
		  
		  if(!password.equals(passwordConfirm)) {
			  model.addAttribute(errMsg, "密码不匹配");
		  }

		  if(userDao.findByAccountOrMobileOrEmail(username, mobile, email)==null) {
			  User user = new User();
			  user.setAccount(username);
			  user.setPlainPassword(password);
			  BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
				// 加密
			  String encodedPassword = passwordEncoder.encode(password.trim());
			  user.setPassword(encodedPassword);
			  user.setEmail(email);
			  user.setMobile(mobile);
			  
			  userDao.save(user);
			  return CarryDto.of("success");
		  }
		  else {
			  //error message
			  if(userDao.findByAccount(username)!=null) errMsg = "用户名重复";
			  else if(userDao.findByEmail(email)!=null) errMsg= "邮箱被占用！";
			  else if(userDao.findByMobile(mobile)!=null) errMsg = "手机号已被占用";
		  }
		System.out.println("userId: "+username);
	    
	    return CarryDto.of(errMsg);
	  }
	  
	  @ResponseBody
	  @RequestMapping(value = "/user/upt-pass", method = RequestMethod.POST)
	  public CarryDto<String> update_password(@RequestParam String password,
			  @RequestParam String newpassword,
			  @RequestParam String confirmpassword) {
		  System.out.println("whataa);sdkjf;alsdfasdfasdf;asdf");
		  String errMsg = "";
		  User user = currentUser();
		  if(!password.equals(user.getPassword())) {
			  return CarryDto.of("密码错误");
		  }
		  
		  if(!newpassword.equals(confirmpassword)) {
			  return CarryDto.of("两次输入密码不一致");  
		  }else {
			  user.setPassword(newpassword);
			  user.setPlainPassword(newpassword);
			  
			  userDao.save(user);
			  session.setAttribute("user", user);
		  }
		//System.out.println("userId: "+currentUserId());
	    
	    return CarryDto.of("修改成功");
	  }
	  
	  @ResponseBody
	  @RequestMapping(value = "/user/upt-info", method = RequestMethod.POST)
	  public CarryDto<String> register(
			  @RequestParam String email,
			  @RequestParam String mobile) {
		  String errMsg = "";
		  User user = currentUser();
		  
		  if(user==null) {
			  return CarryDto.of("未登陆");
		  }
		  
		  //error message
		  if(userDao.findByEmailAndAccountNot(email, user.getAccount())!=null) {
			  errMsg= "邮箱被占用！";
			  return CarryDto.of(errMsg);
		  }
		  else if(userDao.findByMobileAndAccountNot(mobile, user.getAccount())!=null) {
			  errMsg = "手机号已被占用!";
			  return CarryDto.of(errMsg);
		  }
		 
		  System.out.println(mobile);
		  System.out.println(email);
		  user.setEmail(email);
		  user.setMobile(mobile);
		  
		  userDao.save(user);
		  session.setAttribute("user", user);
		//System.out.println("userId: "+currentUserId());
	    
	    return CarryDto.of("修改成功");
	  }
	  
}
