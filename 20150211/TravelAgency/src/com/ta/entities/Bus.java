package com.ta.entities;

import java.util.List;

public class Bus {
	protected int busNo;
	protected String regNo;
	protected String make;
	protected String model;
	protected int capacity;
	protected TravelAgency travelAgency;
	protected List<Journey> journeys;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getRegNo() {
		return regNo;
	}

	public void setRegNo(String regNo) {
		this.regNo = regNo;
	}

	public String getMake() {
		return make;
	}

	public void setMake(String make) {
		this.make = make;
	}

	public String getModel() {
		return model;
	}

	public void setModel(String model) {
		this.model = model;
	}

	public int getCapacity() {
		return capacity;
	}

	public void setCapacity(int capacity) {
		this.capacity = capacity;
	}

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

	public List<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}

}
