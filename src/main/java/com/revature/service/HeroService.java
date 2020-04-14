package com.revature.service;

import java.util.ArrayList;
import java.util.List;
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

import com.revature.dao.interfaces.IHeroDAO;
import com.revature.model.Hero;

@Controller
@CrossOrigin
public class HeroService {
	  @Autowired 
	  IHeroDAO dao;
	  	
	@RequestMapping(value="/initGame", method= {RequestMethod.GET, RequestMethod.POST, 
			RequestMethod.PUT}) 
	public ResponseEntity<List<Integer>> initGame() {
		List<Integer> list = new ArrayList<Integer>();
		Random dice = new Random();
		int random = 0;
		
		dice.setSeed(System.currentTimeMillis());
		
		while (list.size() < 3) {
			random = dice.nextInt(732)+1;
			list.add(random);
		}
		
		return ResponseEntity.status(HttpStatus.OK).body(list);
	}
	
	@RequestMapping(value="/addHero", method= {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<TreeSet<Hero>> saveHero(HttpServletRequest req, 
			HttpServletResponse res,@RequestBody Hero hero) {
		dao.save(hero);
		TreeSet<Hero> returnThis = dao.findHeroByOwnerID(hero.getOwnerID());
 		
		res.setContentType("application/json");		
		return ResponseEntity.status(HttpStatus.OK).body(returnThis);
	}
	
	@RequestMapping(value="/deleteHero", method= {RequestMethod.DELETE, RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<TreeSet<Hero>> deleteHero(HttpServletRequest req, 
			HttpServletResponse res,@RequestBody Hero hero) {
		long id = hero.getOwnerID();
		dao.deleteHero(hero);
		TreeSet<Hero> returnThis = dao.findHeroByOwnerID(id);
 		
		res.setContentType("application/json");		
		return ResponseEntity.status(HttpStatus.OK).body(returnThis);
	}
	
	@RequestMapping(value="/saveHeroes", method= {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<TreeSet<Hero>> saveHeroes(HttpServletRequest req, 
			HttpServletResponse res,@RequestBody ArrayList<Hero> list) {
		TreeSet<Hero> returnThis = new TreeSet<Hero>();
		
		  for (Hero hero : list) { 
			  if (dao.findMyHeroByName(hero.getOwnerID(), hero.getName()) != null) {
				  //hero exists, do nothing.
			  } else {
			    dao.save(hero);
			  }
			  returnThis.add(dao.findMyHeroByName(hero.getOwnerID(), hero.getName()) ); 
		  }
		 		
		res.setContentType("application/json");		
		return ResponseEntity.status(HttpStatus.OK).body(returnThis);
	}

	@RequestMapping(value="/updateHero", method= {RequestMethod.POST, RequestMethod.PUT})
	public ResponseEntity<TreeSet<Hero>> updateHero(HttpServletRequest req, 
			HttpServletResponse res, @RequestBody Hero hero) {
		long id = hero.getOwnerID();
		dao.update(hero);
		TreeSet<Hero> returnThis = dao.findHeroByOwnerID(id);
 		
		res.setContentType("application/json");		
		return ResponseEntity.status(HttpStatus.OK).body(returnThis);
	}
	
	
}
