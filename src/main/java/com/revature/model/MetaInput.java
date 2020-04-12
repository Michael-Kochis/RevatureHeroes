package com.revature.model;

public class MetaInput implements Comparable<MetaInput> {
	private int combat;
	private int durability;
	private long gameID;
	private int intelligence;
	private String name;
	private long ownerID;
	private int power;
	private int speed;
	private int strength;
	private long superID;
	private String url;

	public MetaInput() {
		super();
	}
	
	public MetaInput(int combat, int durability, long gameID, int intelligence, String name, long ownerID, int power,
			int speed, int strength, long superID, String url) {
		super();
		this.combat = combat;
		this.durability = durability;
		this.gameID = gameID;
		this.intelligence = intelligence;
		this.name = name;
		this.ownerID = ownerID;
		this.power = power;
		this.speed = speed;
		this.strength = strength;
		this.superID = superID;
		this.url = url;
	}

	public int getCombat() {
		return combat;
	}

	public void setCombat(int combat) {
		this.combat = combat;
	}

	public int getDurability() {
		return durability;
	}

	public void setDurability(int durability) {
		this.durability = durability;
	}

	public long getGameID() {
		return gameID;
	}

	public void setGameID(long gameID) {
		this.gameID = gameID;
	}

	public int getIntelligence() {
		return intelligence;
	}

	public void setIntelligence(int intelligence) {
		this.intelligence = intelligence;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public int getPower() {
		return power;
	}

	public void setPower(int power) {
		this.power = power;
	}

	public int getSpeed() {
		return speed;
	}

	public void setSpeed(int speed) {
		this.speed = speed;
	}

	public int getStrength() {
		return strength;
	}

	public void setStrength(int strength) {
		this.strength = strength;
	}

	public long getSuperID() {
		return superID;
	}

	public void setSuperID(long superID) {
		this.superID = superID;
	}

	public String getUrl() {
		return url;
	}

	public void setUrl(String url) {
		this.url = url;
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
		MetaInput other = (MetaInput) obj;
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
		return "MetaInput [combat=" + combat + ", durability=" + durability + ", gameID=" + gameID + ", intelligence="
				+ intelligence + ", name=" + name + ", ownerID=" + ownerID + ", power=" + power + ", speed=" + speed
				+ ", strength=" + strength + ", superID=" + superID + ", url=" + url + "]";
	}

	@Override
	public int compareTo(MetaInput o) {
		long compTo = o.getGameID();
		if (this.getGameID() < compTo) {
			return -1;
		} else if (this.getGameID() > compTo) {
			return 1;
		} else {
			return 0;
		}
	}
	
	
}
