package com.revature;

import java.util.TreeMap;
import java.util.TreeSet;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import com.revature.dao.interfaces.IMissionDAO;
import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.Hero;
import com.revature.model.Mission;
import com.revature.model.User;

public class Driver {

	public static void main(String[] args) {
		ApplicationContext ac = new ClassPathXmlApplicationContext("applicationContext.xml");

		IUserDAO udao = ac.getBean(IUserDAO.class);
		IMissionDAO mdao = ac.getBean(IMissionDAO.class);

//	    User u = udao.findUserByID(126L);
	    Mission m = mdao.findMissionByMissionID(321L);
	    Mission m2 = mdao.findMissionByMissionID(261L);
	    Mission m3 = mdao.findMissionByMissionID(262L);

	    TreeSet<Mission> missions = mdao.findAllMission();
	    for (Mission m4 : missions) {
	    	if (m4.getHeroes() == null) {
	    		m4.setHeroes(new TreeSet<Hero>() );
	    		mdao.update(m4);
	    	}
	    }
	    
		/*
		 * u.setTreasury(new TreeMap<String, Integer>() ); u.addTreasury("powerUp", 35);
		 * u.addTreasury("heroEssence", 350); u.addTreasury("heroDollars", 7000);
		 * udao.update(u);
		 * 
		 */		 	    
	    System.out.println(m);
	    System.out.println(m2);
	    System.out.println(m3);
	}

}
