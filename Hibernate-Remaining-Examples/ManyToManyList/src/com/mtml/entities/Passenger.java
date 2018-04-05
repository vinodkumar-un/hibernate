package com.mtml.entities;

import java.util.ArrayList;
import java.util.List;

public class Passenger {
	private int passengerId;
	private String firstNm;
	private String lastNm;
	private String gender;
	private int age;
	private List<Journey> journeys;

	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
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

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public List<Journey> getJourneys() {
		if(journeys == null) {
			journeys = new ArrayList<Journey>();
		}
		return journeys;
	}

	public void setJourneys(List<Journey> journeys) {
		this.journeys = journeys;
	}

}
