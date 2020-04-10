package com.revature.dao;

import java.util.List;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import com.revature.dao.interfaces.IHeroDAO;
import com.revature.model.Hero;

public class HeroDAO implements IHeroDAO {
	@Autowired
	SessionFactory sf;

	@Override
	public TreeSet<Hero> findAllHero() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Hero> cq = s.getCriteriaBuilder().createQuery(Hero.class);
		TreeSet<Hero> returnThis = new TreeSet<Hero>();
		
		cq.from(Hero.class);
		List<Hero> tempList = s.createQuery(cq).getResultList();
		for (Hero h: tempList) {
			returnThis.add(h);
		}
		
		return returnThis;
	}

	@Override
	public TreeSet<Hero> findHeroByOwnerID(long id) {
		TreeSet<Hero> templist = findAllHero();
		TreeSet<Hero> returnThis = new TreeSet<Hero>();
		
		for (Hero hero : templist) {
			if (hero.getOwnerID() == id) {
				returnThis.add(hero);
			}
		}
		
		return returnThis;
	}

	@Override
	public Hero findHeroByGameID(long id) {
		Session s = sf.getCurrentSession();
		return s.get(Hero.class, id);
	}

	@Override
	public TreeSet<Hero> findHeroBySuperID(long id) {
		TreeSet<Hero> templist = findAllHero();
		TreeSet<Hero> returnThis = new TreeSet<Hero>();
		
		for (Hero hero : templist) {
			if (hero.getSuperID() == id) {
				returnThis.add(hero);
			}
		}
		
		return returnThis;
	}

	@Override
	public TreeSet<Hero> findHeroByName(String name) {
		TreeSet<Hero> templist = findAllHero();
		TreeSet<Hero> returnThis = new TreeSet<Hero>();
		
		for (Hero hero : templist) {
			if (hero.getName().equals(name)) {
				returnThis.add(hero);
			}
		}
		
		return returnThis;
	}

	@Override
	public Hero findMyHeroByName(long id, String name) {
		TreeSet<Hero> templist = findHeroByOwnerID(id);
		
		for (Hero hero : templist) {
			if (hero.getName().equals(name)) {
				return hero;
			}
		}
		
		return null;
	}

	@Override
	public void deleteHero(Hero hero) {
		Session s = sf.getCurrentSession();
		s.delete(hero);
	}

	@Override
	public void deleteHeroByID(long id) {
		deleteHero(findHeroByGameID(id) );
	}

	@Override
	public void insert(Hero hero) {
		Session s = sf.getCurrentSession();
		s.save(hero);
	}

	@Override
	public void save(Hero hero) {
		Session s = sf.getCurrentSession();
		s.save(hero);
	}

	@Override
	public void update(Hero hero) {
		Session s = sf.getCurrentSession();
		s.update(hero);
	}

}
