package com.ta.entities;

import java.util.HashSet;
import java.util.Set;

public class Staff {
	private int staffId;
	private String firstNm;
	private String lastNm;
	private String designation;
	private Set<Journey> journeys;

	public int getStaffId() {
		return staffId;
	}

	public void setStaffId(int staffId) {
		this.staffId = staffId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public Set<Journey> getJourneys() {
		if (journeys == null) {
			journeys = new HashSet<Journey>();
		}
		return journeys;
	}

	public void setJourneys(Set<Journey> journeys) {
		this.journeys = journeys;
	}

}
