package com.ta.entities;

import java.util.HashSet;
import java.util.Set;

public class Bus {
	private int busNo;
	private String registrationNo;
	private String make;
	private String model;
	private int capacity;
	private Set<Journey> journeys;

	public int getBusNo() {
		return busNo;
	}

	public void setBusNo(int busNo) {
		this.busNo = busNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
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

	public void setJourneys(Set<Journey> journeys) {
		this.journeys = journeys;
	}

	public Set<Journey> getJourneys() {
		if (journeys == null) {
			journeys = new HashSet<Journey>();
		}
		return journeys;
	}

}
