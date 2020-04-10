package com.revature.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.revature.dao.interfaces.IHeroDAO;

@Controller
@CrossOrigin
public class HeroService {
	@Autowired
	private SessionFactory sf;

	/*
	 * @Autowired IHeroDAO dao;
	 * 
	 */
	
	@RequestMapping(value="/initGame", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<List<Integer>> initGame() {
		List<Integer> list = new ArrayList<Integer>();
		Random dice = new Random();
		
		dice.setSeed(System.currentTimeMillis());
		
		for (int i=0; i<3; i++) {
			list.add(dice.nextInt(732)+1);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
}
