package com.revature.dao.interfaces;

import java.util.TreeSet;

import com.revature.model.User;

public interface IUserDAO {
    public TreeSet<User> findAllUser();
    public User findUserByID(long id);
    public User findUserByName(String uName);
    public void deleteUser(User user);
    public void deleteUserByID(long id);
    public void insert(User user);
    public void save(User user);
    public void update(User user);
}
