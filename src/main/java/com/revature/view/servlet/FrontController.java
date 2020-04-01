package com.revature.view.servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.concurrent.atomic.AtomicLong;

import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.revature.model.Greeting;

@RestController
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 5469009506125602565L;
	private static Logger log = LogManager.getLogger(FrontController.class);
	private static final String template = "Hello, %s!";
	private final AtomicLong counter = new AtomicLong();

	@GetMapping("/greeting")
	public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
		return new Greeting(counter.incrementAndGet(), String.format(template, name));
	}
	
	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse res) {
		String url = req.getRequestURI().substring(16);
		if (url.contains("greeting")) {
			try {
				PrintWriter out = res.getWriter();
				out.println(greeting("World") );

			} catch (IOException e) {
				log.warn("Error of dumbness: ", e);
			}
		}
		System.out.println(url);
	}
}