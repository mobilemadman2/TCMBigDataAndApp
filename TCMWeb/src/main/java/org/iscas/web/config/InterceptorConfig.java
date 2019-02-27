package org.iscas.web.config;

import org.iscas.interceptor.GoBackInterceptor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class InterceptorConfig implements WebMvcConfigurer{

  @Override
  public void addInterceptors(InterceptorRegistry registry) {

    registry.addInterceptor(new GoBackInterceptor()).addPathPatterns("/disease/info.html");
  }
}
