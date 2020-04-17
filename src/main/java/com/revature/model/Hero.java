package com.revature.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="META")
public class Hero extends Meta implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 660115881911642052L;

	public Hero() {
		super();
	}

	public Hero(long ownerID, long gameID, long superID, String name, int intelligence, int strength, int speed,
			int durability, int power, int combat, String url, String status) {
		super(ownerID, gameID, superID, name, intelligence, strength, speed, durability, power, combat, url, status);
	}

	public Hero(long ownerID, long superID, String name, int intelligence, int strength, int speed, int durability,
			int power, int combat, String url, String status) {
		super(ownerID, superID, name, intelligence, strength, speed, durability, power, combat, url, status);
	}


	
}
