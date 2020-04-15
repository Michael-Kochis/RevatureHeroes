package com.revature.model;

import java.util.Map.Entry;
import java.util.TreeMap;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="RH_User")
public class User implements Comparable<User> {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	private long id;
	
	@Column
	private String username;
	
	@Column(name="password")
	private String password;
	
	@Column(name="treasury")
	private TreeMap<String, Integer> treasury;

	public User() {
		super();
	}

	public User(String username, String password) {
		super();
		this.username = username;
		this.password = password;
	}

	public User(long id, String username, String password, TreeMap<String, Integer> stuff) {
		super();
		this.id = id;
		this.username = username;
		this.password = password;
		this.treasury = stuff;
	}

	public long getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}


	public String getPassword() {
		return this.password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public TreeMap<String, Integer> getTreasury() {
		return treasury;
	}

	public void setTreasury(TreeMap<String, Integer> treasury) {
		this.treasury = treasury;
	}
	
	public void addTreasury(String key, Integer plus) {
		if (this.treasury.containsKey(key)) {
			Entry<String, Integer> temp = this.treasury.floorEntry(key);
			this.treasury.replace(key, temp.getValue(), temp.getValue() + plus);
		} else {
			this.treasury.put(key, plus);
		}
	}

	/**
	 * Warning: use this only once per each user, ideally between registration and
	 * saving to the database.
	 */
	public void encryptPassword() {
		PHash ph = new PHash();
		ph.setPassword(this.password);
		this.password = ph.getHash();
	}
	
	public boolean checkPassword(String s) {
		PHash ph = new PHash(this.getPassword());
		return ph.checkPassword(s);
	}

	@Override
	public int compareTo(User o) {
		long temp = (this.getId() - o.getId() );
		if (temp < 0) {
			return -1;
		} else if (temp > 0) {
			return 1;
		} else {
			return 0;
		}
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((username == null) ? 0 : username.hashCode());
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
		User other = (User) obj;
		if (id != other.id)
			return false;
		if (username == null) {
			if (other.username != null)
				return false;
		} else if (!username.equals(other.username))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "User [id=" + id + ", username=" + username + "]";
	}

}
