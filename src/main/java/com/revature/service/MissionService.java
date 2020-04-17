package com.revature.service;

import java.util.TreeMap;
import java.util.TreeSet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.interfaces.IMissionDAO;
import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.Mission;
import com.revature.model.User;

@Controller
@CrossOrigin
public class MissionService {
	static long maxTemplate = 24;
	
	@Autowired
	public IMissionDAO dao;
	
	@Autowired
	public IUserDAO udao;
	
	@RequestMapping(value="/completeMission", method= {RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<TreeMap<String, Integer>> completeMission(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody Mission mission) {
		if (!mission.getMissionStatus().equalsIgnoreCase("In Progress")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		mission.setMissionStatus("Completed");
		dao.update(mission);
		TreeMap<String, Integer> rewardList = new TreeMap<String, Integer>();
		
		int rewards = (int) mission.getRequirements().floorEntry("missionLevel").getValue();
		rewards /= 10;  if (rewards < 1) rewards = 1;
		User user = udao.findUserByID(mission.getOwnerID() );


		user.addTreasury("powerUp", rewards);
		rewardList.put("powerUp", rewards);
		
		user.addTreasury("heroEssence", rewards*10);
		rewardList.put("heroEssence", rewards*10);
		
		user.addTreasury("heroDollars", rewards*rewards*10);
		rewardList.put("heroDollars", rewards*rewards*10);
		
		return ResponseEntity.status(HttpStatus.OK).body(rewardList);
	}
	
	@RequestMapping(value="/getMissions", method= {RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<TreeSet<Mission>> getMissions(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody Long id) {
		if (id == null) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		TreeSet<Mission> list = dao.findMissionByOwnerID(id);
		int availableCount = 0;
		for (Mission m : list) {
			if (m.getMissionStatus().equalsIgnoreCase("Available") ) {
				availableCount++;
			}
		}
		
		while (availableCount < 3) {		
			long x = (long)(Math.random()*maxTemplate ) + 1;
			System.out.println(x);
			Mission m = dao.generateMission(x);
			m.setOwnerID(id);
			dao.update(m);
			availableCount++;
			list.add(m);
		}
		
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@RequestMapping(value="/startMission", method= {RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<Mission> startMission(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody Mission mission) {
		if (!mission.getMissionStatus().equalsIgnoreCase("Available")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		mission.setMissionStatus("In Progress.");
		dao.update(mission);
		
		return ResponseEntity.status(HttpStatus.OK).body(mission);
	}

}
