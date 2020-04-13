package com.revature.dao;

import java.util.List;
import java.util.TreeSet;

import javax.persistence.criteria.CriteriaQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.revature.dao.interfaces.IMissionDAO;
import com.revature.model.Hero;
import com.revature.model.Mission;

@Repository
@Transactional
public class MissionDAO implements IMissionDAO {
	@Autowired
	SessionFactory sf;

	@Override
	public TreeSet<Mission> findAllMission() {
		Session s = sf.getCurrentSession();
		CriteriaQuery<Mission> cq = s.getCriteriaBuilder().createQuery(Mission.class);
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		
		cq.from(Mission.class);
		List<Mission> tempList = s.createQuery(cq).getResultList();
		for (Mission mission: tempList) {
			returnThis.add(mission);
		}
		
		return returnThis;
	}

	@Override
	public TreeSet<Mission> findMissionByOwnerID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Mission> findMyOpenMissions(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Mission> findMyPastMissions(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Mission findMissionByMissionID(long id) {
		Session s = sf.getCurrentSession();
		return s.get(Mission.class, id);
	}

	@Override
	public TreeSet<Mission> findMissionByTemplateID(long id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Mission> findMissionByTitle(String title) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public TreeSet<Mission> findMyMissionByTitle(long id, String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteMission(Mission mission) {
		Session s = sf.getCurrentSession();
		s.delete(mission);
	}

	@Override
	public void deleteMissionByID(long id) {
		deleteMission(findMissionByMissionID(id) );
	}

	@Override
	public void insert(Mission mission) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(mission);
	}

	@Override
	public void save(Mission mission) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(mission);
	}

	@Override
	public void update(Mission mission) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(mission);
	}

}
