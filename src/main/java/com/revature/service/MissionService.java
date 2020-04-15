package com.revature.service;

import java.util.Random;
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
import com.revature.model.Mission;

@Controller
@CrossOrigin
public class MissionService {
	static long maxTemplate = 24;
	
	@Autowired
	public IMissionDAO dao;
	
	@RequestMapping(value="/completeMission", method= {RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<Mission> completeMission(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody Mission mission) {
		if (!mission.getMissionStatus().equalsIgnoreCase("In Progress")) {
			return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
		}
		mission.setMissionStatus("Completed");
		dao.update(mission);
		
		// add replacement mission to player
		// add to and return player treasury
		
		return ResponseEntity.status(HttpStatus.OK).body(mission);
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
		
		Random dice = new Random();  dice.setSeed(System.currentTimeMillis() );
		while (availableCount < 3) {		
			long x = (dice.nextLong()*maxTemplate) + 1;
			Mission m = dao.generateMission(x);
			m.setOwnerID(id);
			availableCount++;
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
