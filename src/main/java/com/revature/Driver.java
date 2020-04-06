package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.PHash;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	    IUserDAO dao = ac.getBean(IUserDAO.class);
//	    dao.insert(new User(1L, "Superior", "IamSuperior"));
//	    dao.insert(new User(2L, "Neo", "IKnowKungFu"));
	    User u = dao.findUserByID(1L);
	    User u2 = dao.findUserByID(2L);
	    	    
//	    dao.update(u);
//	    dao.update(u2);
	    
	    System.out.println(u + " | " + u2);
	    System.out.println(u.checkPassword("IamSuperior") + " " + u2.checkPassword("IKnowKungFu"));
	}

}
