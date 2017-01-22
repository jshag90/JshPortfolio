package com.spring.bootstrap;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class BootStrapController {
	
	@RequestMapping(value = "/boothome", method = RequestMethod.GET)
	public String bootHome(){
		
		return "/bootstrap/index";
	}
	
	@RequestMapping(value = "/bootabout", method = RequestMethod.GET)
	public String bootAbout(){
		
		return "/bootstrap/about";
	}
	
	@RequestMapping(value = "/bootpost", method = RequestMethod.GET)
	public String bootPost(){
		
		return "/bootstrap/post";
	}
	
	@RequestMapping(value = "/bootcontact", method = RequestMethod.GET)
	public String bootContact(){
		
		return "/bootstrap/contact";
	}

}
