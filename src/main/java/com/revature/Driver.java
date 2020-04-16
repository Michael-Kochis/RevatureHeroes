package com.revature;

import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.interfaces.IMissionDAO;
import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.Mission;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO udao = ac.getBean(IUserDAO.class);
		IMissionDAO dao = ac.getBean(IMissionDAO.class);
//	    IUserDAO dao = ac.getBean(IUserDAO.class);
//	    IHeroDAO hdao = ac.getBean(IHeroDAO.class);
//	    dao.insert(new User(1L, "Superior", "IamSuperior"));
//	    dao.insert(new User(2L, "Neo", "IKnowKungFu"));
	    User u = udao.findUserByID(130L);
//	    User u2 = dao.findUserByID(2L);
	    
		/*
		 * Mission m = new Mission(); m.setMissionStatus("Available"); m.setHeroes(new
		 * TreeSet<Long>() ); m.setOwnerID(0); m.setRequirements(new TreeMap<String,
		 * Object>() );
		 * 
		 * m.setTemplateID(24); m.setTitle("Alien Invasion");
		 * m.setDescription("Convince aliens that Earth is not an easy conquest.");
		 * m.addReq("heroesRequired", 3); m.addReq("statRequired", "power");
		 * m.addReq("missionLevel", 180); m.addReq("missionDuration", 300);
		 * 
		 */		
//		System.out.println(m.toString());
		
//		dao.update(m);

	    u.addTreasury("power-up-327", 7);
	    u.addTreasury("hero essence", 70);
	    u.addTreasury("hero dollars", 700);
	    udao.update(u);
//	    dao.update(u2);
//	    Hero h2 = hdao.findMyHeroByName(4L, "Rhishisikk");
	    
//	    System.out.println(h);
//	    System.out.println(h2);
//	    System.out.println(u + " | " + u2);
//	    System.out.println(u.checkPassword("IamSuperior") + " " + u2.checkPassword("IKnowKungFu"));
	}

}
