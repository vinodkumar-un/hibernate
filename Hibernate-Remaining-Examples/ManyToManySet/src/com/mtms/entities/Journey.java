package com.mtms.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private Set<Passenger> passengers;

	public int getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(int journeyId) {
		this.journeyId = journeyId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public Date getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(Date dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public Set<Passenger> getPassengers() {
		if(passengers == null) {
			passengers = new HashSet<Passenger>();
		}
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

}
