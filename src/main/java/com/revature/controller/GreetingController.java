package com.revature.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Greeting;

@Controller
@CrossOrigin
public class GreetingController {
	private static Logger log = LogManager.getLogger(GreetingController.class);
	private static final String template = "Hello, %s!";
	private static Long counter = new Long(0L);
	
	@RequestMapping(value="/greeting", method= {RequestMethod.GET, RequestMethod.POST})
	public ResponseEntity<Greeting> greeting(HttpServletRequest req, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();

		String name = req.getParameter("name");
		if (name == null || name.length() == 0) {
			name = "World";
		}
		Greeting returnThis = new Greeting(++counter, String.format(template, name));

		res.setContentType("application/json");
		return ResponseEntity.status(HttpStatus.OK).body(returnThis);
		// should be interpreted as JSON
	}
	
}
