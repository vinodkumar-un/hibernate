package com.ta.entities;

import java.util.Date;
import java.util.List;

public class TravelAgency {
	protected int travelAgencyId;
	protected String organizationName;
	protected Date estDt;
	protected List<Staff> staff;
	protected List<Bus> buses;
	protected List<Journey> journeys;

	public int getTravelAgencyId() {
		return travelAgencyId;
	}

	public void setTravelAgencyId(int travelAgencyId) {
		this.travelAgencyId = travelAgencyId;
	}

	public String getOrganizationName() {
		return organizationName;
	}

	public void setOrganizationName(String organizationName) {
		this.organizationName = organizationName;
	}

	public Date getEstDt() {
		return estDt;
	}

	public void setEstDt(Date estDt) {
		this.estDt = estDt;
	}

	public List<Staff> getStaff() {
		return staff;
	}

	public void setStaff(List<Staff> staff) {
		this.staff = staff;
	}

	public List<Bus> getBuses() {
		return buses;
	}

	public void setBuses(List<Bus> buses) {
		this.buses = buses;
	}

	public List<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}

}
