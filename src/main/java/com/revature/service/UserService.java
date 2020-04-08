package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.revature.model.LoginForm;

@Controller
@CrossOrigin
public class UserService {
	private static Logger log = LogManager.getLogger(UserService.class);
	ObjectMapper om = new ObjectMapper();

	@RequestMapping(value="/register", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT})
	public static ResponseEntity<LoginForm> register(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody LoginForm register) {
		if (register == null) {
			return null;
		}
		log.trace("Attempt to register " + register.getUserName() + ".");

		res.setContentType("application/json");
		return ResponseEntity.status(HttpStatus.OK).body(register);
	}

	@RequestMapping(value="/login", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT})
    public static ResponseEntity<LoginForm> login(HttpServletRequest req,
    		HttpServletResponse res, @RequestBody LoginForm login) {
		if (login == null) {
			return null;
		}
		log.trace("Attempt to login " + login.getUserName() + ".");

		res.setContentType("application/json");
		return ResponseEntity.status(HttpStatus.OK).body(login);
		
	}
}
