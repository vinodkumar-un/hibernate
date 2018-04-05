package com.slc.entities;

import java.util.Date;

public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;

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

	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", source=" + source
				+ ", destination=" + destination + ", dateOfJourney="
				+ dateOfJourney + "]";
	}

}
