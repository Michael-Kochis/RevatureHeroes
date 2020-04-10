package com.revature.model;

import java.util.TreeSet;

public class LoginResponse {
	long id;
    String userName;
    TreeSet<Hero> heroes;
    
    public LoginResponse(long nid, String nName, TreeSet<Hero> list) {
		super();
		this.id = nid;
		this.userName = nName;
		this.heroes = list;
	}

}
