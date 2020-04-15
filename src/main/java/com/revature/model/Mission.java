package com.revature.model;

import java.time.LocalDateTime;
import java.util.Dictionary;
import java.util.Map;
import java.util.TreeMap;
import java.util.TreeSet;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import org.springframework.stereotype.Component;

@Component
@Entity
@Table(name="MISSION")
public class Mission implements Comparable<Mission> {
	@Column 
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long missionID;
	
	@Column
	private long templateID;
	
	@Column
	private long ownerID;
	
	@Column
	private String title;
	
	@Column
	private String description;
	
	@Column
	private TreeMap<String, Object> requirements;
	
	@Column
	private TreeSet<Long> heroes;
	
	@Column
	private Double missionSuccess;
	
	@Column
	private Long missionStart;
	
	@Column 
	private Long missionFinish;
	
	@Column
	private String missionStatus;  // Available, In Progress, Completed

	public Mission() {
		super();
	}

	public Mission(long missionID, long templateID, long ownerID, String title, String description,
			TreeMap<String, Object> requirements, TreeSet<Long> heroes, Double missionSuccess, Long missionStart,
			Long missionFinish, String missionStatus) {
		super();
		this.missionID = missionID;
		this.templateID = templateID;
		this.ownerID = ownerID;
		this.title = title;
		this.description = description;
		this.requirements = requirements;
		this.heroes = heroes;
		this.missionSuccess = missionSuccess;
		this.missionStart = missionStart;
		this.missionFinish = missionFinish;
		this.missionStatus = missionStatus;
	}

	public Mission(Mission other) {
		this(other.getMissionID(), other.getTemplateID(), other.getOwnerID(), other.getTitle(),
				other.getDescription(), other.getRequirements(), other.getHeroes(), other.getMissionSuccess(),
				other.getMissionStart(), other.getMissionFinish(), other.getMissionStatus() );
	}

	public long getMissionStart() {
		return missionStart;
	}

	public void setMissionStart(long missionStart) {
		this.missionStart = missionStart;
	}

	public long getMissionFinish() {
		return missionFinish;
	}

	public void setMissionFinish(long missionFinish) {
		this.missionFinish = missionFinish;
	}

	public String getMissionStatus() {
		return missionStatus;
	}

	public void setMissionStatus(String missionStatus) {
		this.missionStatus = missionStatus;
	}

	public void setMissionID(long missionID) {
		this.missionID = missionID;
	}

	public long getMissionID() {
		return missionID;
	}

	public void setGameID(long gameID) {
		this.missionID = gameID;
	}

	public long getTemplateID() {
		return templateID;
	}

	public void setTemplateID(long templateID) {
		this.templateID = templateID;
	}

	public long getOwnerID() {
		return ownerID;
	}

	public void setOwnerID(long ownerID) {
		this.ownerID = ownerID;
	}

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public TreeMap<String, Object> getRequirements() {
		return requirements;
	}

	public void setRequirements(TreeMap<String, Object> requirements) {
		this.requirements = requirements;
	}

	public TreeSet<Long> getHeroes() {
		return heroes;
	}
	
	public Double getMissionSuccess() {
		return missionSuccess;
	}

	public void setMissionSuccess(Double missionSuccess) {
		this.missionSuccess = missionSuccess;
	}

	public void setMissionStart(Long missionStart) {
		this.missionStart = missionStart;
	}

	public void setMissionFinish(Long missionFinish) {
		this.missionFinish = missionFinish;
	}

	public void addReq(String s, Object o) {
		if (this.requirements == null) {
			this.requirements = new TreeMap<String, Object>();
		}
		this.requirements.put(s, o);
	}

	public void setHeroes(TreeSet<Long> heroes) {
		this.heroes = heroes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((description == null) ? 0 : description.hashCode());
		result = prime * result + ((heroes == null) ? 0 : heroes.hashCode());
		result = prime * result + ((missionFinish == null) ? 0 : missionFinish.hashCode());
		result = prime * result + (int) (missionID ^ (missionID >>> 32));
		result = prime * result + ((missionStart == null) ? 0 : missionStart.hashCode());
		result = prime * result + ((missionStatus == null) ? 0 : missionStatus.hashCode());
		long temp;
		temp = Double.doubleToLongBits(missionSuccess);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		result = prime * result + (int) (ownerID ^ (ownerID >>> 32));
		result = prime * result + ((requirements == null) ? 0 : requirements.hashCode());
		result = prime * result + (int) (templateID ^ (templateID >>> 32));
		result = prime * result + ((title == null) ? 0 : title.hashCode());
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
		Mission other = (Mission) obj;
		if (description == null) {
			if (other.description != null)
				return false;
		} else if (!description.equals(other.description))
			return false;
		if (heroes == null) {
			if (other.heroes != null)
				return false;
		} else if (!heroes.equals(other.heroes))
			return false;
		if (missionFinish == null) {
			if (other.missionFinish != null)
				return false;
		} else if (!missionFinish.equals(other.missionFinish))
			return false;
		if (missionID != other.missionID)
			return false;
		if (missionStart == null) {
			if (other.missionStart != null)
				return false;
		} else if (!missionStart.equals(other.missionStart))
			return false;
		if (missionStatus == null) {
			if (other.missionStatus != null)
				return false;
		} else if (!missionStatus.equals(other.missionStatus))
			return false;
		if (Double.doubleToLongBits(missionSuccess) != Double.doubleToLongBits(other.missionSuccess))
			return false;
		if (ownerID != other.ownerID)
			return false;
		if (requirements == null) {
			if (other.requirements != null)
				return false;
		} else if (!requirements.equals(other.requirements))
			return false;
		if (templateID != other.templateID)
			return false;
		if (title == null) {
			if (other.title != null)
				return false;
		} else if (!title.equals(other.title))
			return false;
		return true;
	}
	
	@Override
	public int compareTo(Mission other) {
		long compareTo = missionID - other.missionID;
		if (compareTo > 0) {
			return 1;
		} else if (compareTo < 0) {
			return -1;
		} else {
			return 0;
		}
	}

	@Override
	public String toString() {
		return "Mission [missionID=" + missionID + ", templateID=" + templateID + ", ownerID=" + ownerID + ", title="
				+ title + ", description=" + description + ", requirements=" + requirements + ", heroes=" + heroes
				+ ", missionSuccess=" + missionSuccess + ", missionStart=" + missionStart + ", missionFinish="
				+ missionFinish + ", missionStatus=" + missionStatus + "]";
	}
	
}
