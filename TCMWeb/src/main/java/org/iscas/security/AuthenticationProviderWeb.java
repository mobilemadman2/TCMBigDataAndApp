/*package org.iscas.security;

import java.util.Collection;

import org.iscas.web.service.CustomUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationProvider;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.AuthenticationException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Component;
 
*//**
 * 自己的认证提供者
 * Title: AuthenticationProviderWeb
 * Description: 
 * @author yzh
 * @date 2018年4月26日下午5:19:57
 *//*
@Component
public class AuthenticationProviderWeb implements AuthenticationProvider {
 
	@Autowired
	CustomUserService customUserService;
	
	@Override
	public Authentication authenticate(Authentication authentication)throws AuthenticationException {
		String name = (String) authentication.getPrincipal();
		String password = (String) authentication.getCredentials();
		UserDetails userDetails = customUserService.loadUserByUsername(name);
		if(userDetails == null){
			throw new UsernameNotFoundException("用户名不存在");
		}
		if(!userDetails.getPassword().equals(password)){
			throw new BadCredentialsException("密码不正确");
		}
		System.out.println("认证");
		Collection<? extends GrantedAuthority> authorities = userDetails.getAuthorities();
		//构建返回用户登录成功的token
		UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(userDetails, password, authorities);
                return token;
	}
 
	@Override
	public boolean supports(Class<?> authentication) {
		// TODO Auto-generated method stub
                //表示支持
		return true;
	}
 
}
*/