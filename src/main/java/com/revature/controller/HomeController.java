package com.revature.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@CrossOrigin
public class HomeController {
	
	@RequestMapping(value="/home", method= {RequestMethod.GET, RequestMethod.POST})
	public String home() {
		return "home";
	}

}
