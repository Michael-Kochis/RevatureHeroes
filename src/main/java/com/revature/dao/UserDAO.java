package com.revature.dao;

import java.util.List;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaQuery;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.revature.dao.interfaces.IUserDAO;
import com.revature.model.PHash;
import com.revature.model.User;

@Repository
@Transactional
public class UserDAO implements IUserDAO {
	@Autowired
	private SessionFactory sf;

	@Override
	public TreeSet<User> findAllUser() {
		TreeSet<User> returnThis = new TreeSet<User>();
		Session s = sf.getCurrentSession();
		CriteriaQuery<User> cq = s.getCriteriaBuilder().createQuery(User.class);
		cq.from(User.class);
		List<User> tempList = s.createQuery(cq).getResultList();
		for (User u: tempList) {
			returnThis.add(u);
		}
		
		return returnThis;
	}

	@Override
	public User findUserByID(long id) {
		Session s = sf.getCurrentSession();
		return s.get(User.class, id);
	}

	@Override
	public User findUserByName(String uName) {
		return null;
	}

	@Override
	public void deleteUser(User u) {
		// TODO Auto-generated method stub

	}

	@Override
	public void deleteUserByID(long id) {
		// TODO Auto-generated method stub

	}

	@Override
	public void save(User user) {
		Session s = sf.getCurrentSession();
		s.save(user);
	}

	@Override
	public void update(User user) {
		Session s = sf.getCurrentSession();
		s.update(user);
	}

	@Override
	public void insert(User user) {
		Session s = sf.getCurrentSession();
		s.save(user);
	}

}
