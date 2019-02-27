package org.iscas.interceptor;

import java.util.Enumeration;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

public class GoBackInterceptor extends HandlerInterceptorAdapter{

	public GoBackInterceptor() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler)
			throws Exception {
//		
//		System.out.println("preHandle");
//		System.out.println(request.getRequestURI());
//		System.out.println(request.getParameter("pageNumber"));
//		System.out.println(request.getParameter("pageSize"));
//		System.out.println(request.getParameter("sortType"));

		request.getSession().setAttribute("pageNumber", request.getParameter("pageNumber"));
		request.getSession().setAttribute("pageSize", request.getParameter("pageSize"));
		request.getSession().setAttribute("sortType", request.getParameter("sortType"));
		request.getSession().setAttribute("from", request.getParameter("from"));
		// TODO Auto-generated method stub
		return super.preHandle(request, response, handler);
	}
	
	

}
