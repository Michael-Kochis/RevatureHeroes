package com.revature;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.interfaces.IHeroDAO;
import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.Hero;
import com.revature.model.PHash;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

	    IUserDAO dao = ac.getBean(IUserDAO.class);
//	    IHeroDAO hdao = ac.getBean(IHeroDAO.class);
//	    dao.insert(new User(1L, "Superior", "IamSuperior"));
//	    dao.insert(new User(2L, "Neo", "IKnowKungFu"));
	    User u = dao.findUserByID(1L);
	    User u2 = dao.findUserByID(2L);
	    
		/*
		 * Hero h = new Hero(); h.setOwnerID(4L); h.setCombat(40); h.setDurability(80);
		 * h.setIntelligence(25); h.setName("Rhishisikk"); h.setPower(40);
		 * h.setSpeed(20); h.setStrength(20); h.setSuperID(0L); h.setUrl("Custom Hero");
		 * 
		 * hdao.insert(h);
		 */

//	    dao.update(u);
//	    dao.update(u2);
//	    Hero h2 = hdao.findMyHeroByName(4L, "Rhishisikk");
	    
//	    System.out.println(h);
//	    System.out.println(h2);
	    System.out.println(u + " | " + u2);
	    System.out.println(u.checkPassword("IamSuperior") + " " + u2.checkPassword("IKnowKungFu"));
	}

}
