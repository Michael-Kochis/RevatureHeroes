package com.revature.model;

import java.util.TreeSet;

public class LoginResponse {
	long id;
    String userName;
    TreeSet<Hero> heroes;
    
    public LoginResponse() {
    	super();
    }
    
    public LoginResponse(long nid, String nName, TreeSet<Hero> list) {
		super();
		this.id = nid;
		this.userName = nName;
		this.heroes = list;
	}

	public long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public TreeSet<Hero> getHeroes() {
		return heroes;
	}

	public void setHeroes(TreeSet<Hero> heroes) {
		this.heroes = heroes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((heroes == null) ? 0 : heroes.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((userName == null) ? 0 : userName.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LoginResponse other = (LoginResponse) obj;
		if (heroes == null) {
			if (other.heroes != null)
				return false;
		} else if (!heroes.equals(other.heroes))
			return false;
		if (id != other.id)
			return false;
		if (userName == null) {
			if (other.userName != null)
				return false;
		} else if (!userName.equals(other.userName))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LoginResponse [id=" + id + ", userName=" + userName + ", heroes=" + heroes + "]";
	}

}
