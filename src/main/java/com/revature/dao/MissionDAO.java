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
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		TreeSet<Mission> list = findAllMission();
		
		for (Mission mission : list ) {
			if (mission.getOwnerID() == id) {
				returnThis.add(mission);
			}
		}
		
		return returnThis;
	}

	@Override
	public TreeSet<Mission> findMyOpenMissions(long id) {
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		return returnThis;
	}

	@Override
	public TreeSet<Mission> findMyPastMissions(long id) {
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		return returnThis;
	}

	@Override
	public Mission findMissionByMissionID(long id) {
		Session s = sf.getCurrentSession();
		return s.get(Mission.class, id);
	}

	@Override
	public TreeSet<Mission> findMissionByTemplateID(long id) {
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		TreeSet<Mission> list = findAllMission();
		
		for (Mission mission : list ) {
			if (mission.getTemplateID() == id) {
				returnThis.add(mission);
			}
		}
		
		if (list.size() == 0) {
			Mission m = new Mission();
			m.setTemplateID(id);
			m.setTitle("Null database return");
			returnThis.add(new Mission() );
		}
		
		return returnThis;
	}
	
	@Override
	public Mission generateMission(long id) {
		Mission template = new Mission();
		if (id > 24) id = 24;
		TreeSet<Mission> list = findMissionByTemplateID(id);
		if (!list.isEmpty() ) {
			template = list.first();
		}
		Mission mission = new Mission(template);
		
		mission.setGameID(0);
		mission.setHeroes(new TreeSet<Long>() );
		mission.setMissionFinish(0);
		mission.setMissionStart(0);
		mission.setMissionStatus("Available");
		mission.setOwnerID(0);
		
		
		return mission;
	}

	@Override
	public TreeSet<Mission> findMissionByTitle(String title) {
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		TreeSet<Mission> list = findAllMission();
		
		for (Mission mission : list ) {
			if (mission.getTitle().equalsIgnoreCase(title) ) {
				returnThis.add(mission);
			}
		}
		
		return returnThis;
	}

	@Override
	public TreeSet<Mission> findMyMissionByTitle(long id, String name) {
		TreeSet<Mission> returnThis = new TreeSet<Mission>();
		TreeSet<Mission> list = findMissionByOwnerID(id);
		
		for (Mission mission : list ) {
			if (mission.getTitle().equalsIgnoreCase(name) ) {
				returnThis.add(mission);
			}
		}
		
		return returnThis;
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
		insert(mission);
	}

	@Override
	public void update(Mission mission) {
		Session s = sf.getCurrentSession();
		s.saveOrUpdate(mission);
	}

}
