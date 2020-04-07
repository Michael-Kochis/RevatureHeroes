package com.revature.service;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import com.fasterxml.jackson.databind.ObjectMapper;


public class UserService {
	private static Logger log = LogManager.getLogger(UserService.class);
	ObjectMapper om = new ObjectMapper();

	public static void register(HttpServletRequest req, HttpServletResponse res) {
		String uName = req.getParameter("username");
		String pass = req.getParameter("password");
		try {
			PrintWriter out = res.getWriter();
			out.println("Registration of user " + uName + " with password " + pass);
			res.setContentType("application/json");
            out.println("{ \"username\": \"" + uName + "\", \"password:\" \"" + pass +"\" }");
		} catch (IOException e) {
			log.warn("Exception in UserService: ", e);
		}
	}

}
