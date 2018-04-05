package com.otml.entities;

import java.util.Date;
import java.util.List;

public class TravelAgency {
	private int travelAgencyId;
	private String travelAgencyName;
	private Date establishedDate;
	private String mobile;
	private List<Bus> buses;

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

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

}
