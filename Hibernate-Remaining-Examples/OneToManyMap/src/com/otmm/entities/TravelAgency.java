package com.otmm.entities;

import java.util.Date;
import java.util.Map;

public class TravelAgency {
	private int travelAgencyId;
	private String travelAgencyName;
	private Date establishedDate;
	private String mobile;
	private Map<Integer, Staff> staff;

	public int getTravelAgencyId() {
		return travelAgencyId;
	}

	public void setTravelAgencyId(int travelAgencyId) {
		this.travelAgencyId = travelAgencyId;
	}

	public String getTravelAgencyName() {
		return travelAgencyName;
	}

	public void setTravelAgencyName(String travelAgencyName) {
		this.travelAgencyName = travelAgencyName;
	}

	public Date getEstablishedDate() {
		return establishedDate;
	}

	public void setEstablishedDate(Date establishedDate) {
		this.establishedDate = establishedDate;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public Map<Integer, Staff> getStaff() {
		return staff;
	}

	public void setStaff(Map<Integer, Staff> staff) {
		this.staff = staff;
	}

}
