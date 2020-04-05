package com.revature.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.Greeting;

public class GreetingController {
	private static Logger log = LogManager.getLogger(GreetingController.class);
	private static final String template = "Hello, %s!";
	private static Long counter = new Long(0L);
	
	public Greeting greeting(HttpServletRequest req, HttpServletResponse res) {
		ObjectMapper om = new ObjectMapper();

		String name = req.getParameter("name");
		if (name == null || name.length() == 0) {
			name = "World";
		}
		Greeting returnThis = new Greeting(++counter, String.format(template, name));

		try {
			res.setContentType("text/html");
			PrintWriter out = res.getWriter();
			String jo = om.writeValueAsString(returnThis );
			res.setContentType("application/json");
			out.println(jo);
		} catch (IOException e) {
			log.warn("Error of dumbness: ", e);
		}
		return returnThis;
	}
	
}
