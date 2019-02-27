/*package org.iscas.security;

import java.io.IOException;
 
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.authentication.SimpleUrlAuthenticationSuccessHandler;
import org.springframework.stereotype.Component;
 
import com.fasterxml.jackson.databind.ObjectMapper;
 
*//**
 * 我的认证成功后的处理
 * Title: MyAuthenticationSuccessHandler
 * Description: 
 * @author yzh
 * @date 2018年4月27日上午11:03:54
 *//*
@Component(value="myAuthenticationSuccessHandler")
public class MyAuthenticationSuccessHandler extends SimpleUrlAuthenticationSuccessHandler {
 
	@Autowired
	ObjectMapper objectMapper;
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request,
			HttpServletResponse response, Authentication authentication)
			throws IOException, ServletException {
		//登陆成功后自己的业务逻辑
		System.out.println("登陆成功");
		//返回json
//		response.setContentType("application/json;charset=UTF-8");
//      response.getWriter().write(objectMapper.writeValueAsString(authentication));
        //如果是要跳转到某个页面
        new DefaultRedirectStrategy().sendRedirect(request, response, "/index");
	}
}*/