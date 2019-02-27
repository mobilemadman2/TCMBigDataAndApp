/*package org.iscas.security;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationFailureHandler;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
import com.fasterxml.jackson.databind.ObjectMapper;
 
*//**
 * 我的认证失败后的处理
 * Title: MyAuthenticationSuccessHandler
 * Description: 
 * @author yzh
 * @date 2018年4月27日上午11:03:54
 *//*
@Component(value="myAuthenticationFailureHandler")
public class MyAuthenticationFailureHandler extends SimpleUrlAuthenticationFailureHandler {
 
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationFailure(HttpServletRequest request,
			HttpServletResponse response, AuthenticationException exception)
			throws IOException, ServletException {
		// TODO Auto-generated method stub
//		super.onAuthenticationFailure(request, response, exception);
		System.out.println("登陆失败");
		response.setContentType("application/json;charset=utf-8");
		response.getWriter().write(objectMapper.writeValueAsString(exception.getMessage()));
	}
}*/