package com.revature.view.servlet;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.RestController;

import com.revature.controller.GreetingController;

public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 5469009506125602565L;
	private static Logger log = LogManager.getLogger(FrontController.class);

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String url = req.getRequestURI().substring(16);
		if (url.contains("greeting")) {
			log.trace("Greeting detected");
			GreetingController gc = new GreetingController();
			gc.greeting(req, res);
		}
		System.out.println(url);
	}
}