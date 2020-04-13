package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Mission;

public interface IMissionDAO {
    public TreeSet<Mission> findAllMission();
    public TreeSet<Mission> findMissionByOwnerID(long id);
    public TreeSet<Mission> findMyOpenMissions(long id);
    public TreeSet<Mission> findMyPastMissions(long id);
    public Mission findMissionByMissionID(long id);
    public TreeSet<Mission> findMissionByTemplateID(long id);
    public TreeSet<Mission> findMissionByTitle(String title);
    public TreeSet<Mission> findMyMissionByTitle(long id, String name);
    public void deleteMission(Mission mission);
    public void deleteMissionByID(long id);
    public void insert(Mission mission);
    public void save(Mission mission);
    public void update(Mission mission);
}
