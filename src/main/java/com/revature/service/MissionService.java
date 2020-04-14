package com.revature.service;

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
	@Autowired
	public IMissionDAO dao;
	
	@RequestMapping(value="/getMissions", method= {RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<TreeSet<Mission>> getMissions(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody long id) {
		TreeSet<Mission> list = dao.findMissionByOwnerID(id);
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	


}
