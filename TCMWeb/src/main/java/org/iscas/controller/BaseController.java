package org.iscas.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.iscas.web.service.UserService;
import org.iscas.web.entity.User;
import org.iscas.web.utils.model.Context;

import javax.servlet.http.HttpSession;

public abstract class BaseController {

  @Autowired
  protected HttpSession session;
  
  @Autowired
  protected UserService userService;


  protected Context context() {
    Context ctx =  (Context) session.getAttribute("context");
    if(ctx == null) {
      ctx = new Context();
      session.setAttribute("context", ctx);
    }
    return ctx;
  }
  
  protected User currentUser() {
	    Context ctx = context();
	    return ctx == null? null : ctx.userId == null? null : userService.load("root");
	  }
  
  protected Long currentUserId() {
	    Context ctx = context();
	    return ctx == null? null : ctx.userId;
	  }

}
