package com.revature.model;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Component
@Entity
@Table(name="META")
public class Meta implements Comparable<Meta>, Serializable {
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 5738513520110945597L;

	@Column
	long ownerID;
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column
	long gameID;
	
	@Column
	long superID;
	
	@Column
	String name;
	
	@Column
	int intelligence;

	@Column
	int strength;

	@Column
	int speed;

	@Column
	int durability;

	@Column
	int power;

	@Column
	int combat;
	
	@Column
	String url;
	
	public Meta() {
		super();
	}

	public Meta(long ownerID, long gameID, long superID, String name, int intelligence, int strength, int speed,
			int durability, int power, int combat, String url) {
		super();
		this.ownerID = ownerID;
		this.gameID = gameID;
		this.superID = superID;
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.url = url;
	}

	public Meta(long ownerID, long superID, String name, int intelligence, int strength, int speed,
			int durability, int power, int combat, String url) {
		super();
		this.ownerID = ownerID;
		this.superID = superID;
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.url = url;
	}

	public Meta(int combat, int durability, long gameID, int intelligence, String name,
			long ownerID, int power, int speed, int strength, long superID, String url) {
		super();
		this.ownerID = ownerID;
		this.superID = superID;
		this.name = name;
		this.intelligence = intelligence;
		this.strength = strength;
		this.speed = speed;
		this.durability = durability;
		this.power = power;
		this.combat = combat;
		this.url = url;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public long getGameID() {
		return gameID;
	}

	public void setGameID(long gameID) {
		this.gameID = gameID;
	}

	public long getSuperID() {
		return superID;
	}

	public void setSuperID(long superID) {
		this.superID = superID;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getCombat() {
		return combat;
	}

	public void setCombat(int combat) {
		this.combat = combat;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
	}

	@Override
	public int compareTo(Meta other) {
		if (this.getGameID() < other.getGameID() ) {
			return -1;
		} else if (this.getGameID() > other.getGameID() ) {
			return 1;
		} else {
			return 0;
		}
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + combat;
		result = prime * result + durability;
		result = prime * result + (int) (gameID ^ (gameID >>> 32));
		result = prime * result + intelligence;
		result = prime * result + ((name == null) ? 0 : name.hashCode());
		result = prime * result + (int) (ownerID ^ (ownerID >>> 32));
		result = prime * result + power;
		result = prime * result + speed;
		result = prime * result + strength;
		result = prime * result + (int) (superID ^ (superID >>> 32));
		result = prime * result + ((url == null) ? 0 : url.hashCode());
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
		Meta other = (Meta) obj;
		if (combat != other.combat)
			return false;
		if (durability != other.durability)
			return false;
		if (gameID != other.gameID)
			return false;
		if (intelligence != other.intelligence)
			return false;
		if (name == null) {
			if (other.name != null)
				return false;
		} else if (!name.equals(other.name))
			return false;
		if (ownerID != other.ownerID)
			return false;
		if (power != other.power)
			return false;
		if (speed != other.speed)
			return false;
		if (strength != other.strength)
			return false;
		if (superID != other.superID)
			return false;
		if (url == null) {
			if (other.url != null)
				return false;
		} else if (!url.equals(other.url))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Meta [ownerID=" + ownerID + ", gameID=" + gameID + ", superID=" + superID 
			+ ", name=" + name + ", intelligence=" + intelligence + ", strength=" + strength 
			+ ", speed=" + speed + ", durability=" + durability + ", power=" + power 
			+ ", combat=" + combat + ", url=" + url + "]";
	}

}
