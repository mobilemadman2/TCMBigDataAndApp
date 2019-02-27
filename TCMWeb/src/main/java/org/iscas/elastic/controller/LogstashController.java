package org.iscas.elastic.controller;

import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.iscas.controller.BaseController;
import org.iscas.elastic.logstash.LogstashConfig;
import org.iscas.elastic.logstash.LogstashConfigView;
import org.iscas.web.entity.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

/**
 * Created by yinrun on 18-8-15.
 */
@Controller
public class LogstashController extends BaseController {
  
  //logstash config file
  @RequestMapping(value = "/logstash/config.html", method = RequestMethod.GET)
  public String acupoint() {
    return "es/logstash/config";
  }
  
  @ResponseBody
  @RequestMapping(value = "/logstash/config")
  public Set<LogstashConfigView> getConfigViews() throws ClassNotFoundException{
	  return new LogstashConfig().genLogstashConfig();
  }

}
