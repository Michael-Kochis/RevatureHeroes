package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.Hero;

public interface IHeroDAO {
    public TreeSet<Hero> findAllHero();
    public TreeSet<Hero> findHeroByOwnerID(long id);
    public Hero findHeroByGameID(long id);
    public TreeSet<Hero> findHeroBySuperID(long id);
    public TreeSet<Hero> findHeroByName(String name);
    public Hero findMyHeroByName(long id, String name);
    public void deleteHero(Hero hero);
    public void deleteHeroByID(long id);
    public void insert(Hero hero);
    public void save(Hero hero);
    public void update(Hero hero);
}
