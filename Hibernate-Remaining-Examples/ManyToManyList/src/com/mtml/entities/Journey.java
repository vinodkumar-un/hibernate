package com.mtml.entities;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private List<Passenger> passengers;

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

	public List<Passenger> getPassengers() {
		if (passengers == null) {
			passengers = new ArrayList<Passenger>();
		}

		return passengers;
	}

	public void setPassengers(List<Passenger> passengers) {
		this.passengers = passengers;
	}

}
