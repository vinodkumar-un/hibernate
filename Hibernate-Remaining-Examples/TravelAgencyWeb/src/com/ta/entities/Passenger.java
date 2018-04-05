package com.ta.entities;

import java.util.HashSet;
import java.util.Set;

public class Passenger {
	private int passengerId;
	private String firstNm;
	private String lastNm;
	private int age;
	private String gender;
	private Set<Journey> journeys;
	private Set<Ticket> tickets;

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

	public int getAge() {
		return age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public Set<Journey> getJourneys() {
		if (journeys == null) {
			journeys = new HashSet<Journey>();
		}
		return journeys;
	}

	public Set<Ticket> getTickets() {
		if (tickets == null) {
			tickets = new HashSet<Ticket>();
		}
		return tickets;
	}

	public void setJourneys(Set<Journey> journeys) {
		this.journeys = journeys;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
