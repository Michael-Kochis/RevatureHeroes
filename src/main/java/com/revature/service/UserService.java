package com.revature.service;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.interfaces.IHeroDAO;
import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.LoginForm;
import com.revature.model.User;

@Controller
@CrossOrigin
public class UserService {
	@Autowired
	IUserDAO dao;
	
	@Autowired
	IHeroDAO hDao;

	@RequestMapping(value="/register", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT})
	public ResponseEntity<LoginForm> register(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody LoginForm register) {
		User user = new User();
		if (register == null) {
			return null;
		} else {
			user = loginFormtoUser(register);
			user.encryptPassword();
			System.out.println(dao);
			if (dao.findUserByName(user.getUsername()) == null) {
				dao.insert(user);
			} else {
				return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
			}
		}

			LoginForm returnThis = new LoginForm(user.getUsername(), user.getPassword() );
			res.setContentType("application/json");
			return ResponseEntity.status(HttpStatus.OK).body(returnThis);

	}

	private User loginFormtoUser(LoginForm form) {
		User returnThis = new User();
		returnThis.setUsername(form.getUserName());
		returnThis.setPassword(form.getPassword());
		
		return returnThis;
	}
	
	@RequestMapping(value="/getUser/{id}", method= {RequestMethod.GET})
	public ResponseEntity<User> getUser(HttpServletRequest req,
    		HttpServletResponse res, @PathVariable("id") long id) {
		User user = dao.findUserByID(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);		
	}

	@RequestMapping(value="/login", method= {RequestMethod.POST, 
			RequestMethod.PUT})
    public ResponseEntity<User> login(HttpServletRequest req,
    		HttpServletResponse res, @RequestBody LoginForm login) {
		if (login == null) {
			return null;
		}
		User user = dao.findUserByName(login.getUserName() );
		if (user == null) {
			return null;
		} else if (!user.checkPassword(login.getPassword()) ) {
			return null;
		}

		return ResponseEntity.status(HttpStatus.OK).body(user);		
	}
	
	@RequestMapping(value="/logout", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT})
	public ResponseEntity<LoginForm> logout(HttpServletRequest req,
			HttpServletResponse res) {
		LoginForm returnThis = new LoginForm("Logout", "Logout");

		return ResponseEntity.status(HttpStatus.OK).body(returnThis);		
	}
	
	@RequestMapping(value="/updateUser", method= {RequestMethod.POST, RequestMethod.PUT}) 
	public ResponseEntity<User> updateUser(HttpServletRequest req,
			HttpServletResponse res, @RequestBody User user) {
		dao.update(user);
		
		return ResponseEntity.status(HttpStatus.OK).body(user);
	}
}
