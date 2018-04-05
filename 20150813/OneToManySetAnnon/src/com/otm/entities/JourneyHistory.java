package com.otm.entities;

import java.util.Date;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Entity;

@Entity
@Table(name = "JOURNEY_HISTORY")
public class JourneyHistory {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;

	public JourneyHistory(int journeyId, String source, String destination,
			Date dateOfJourney) {
		this.journeyId = journeyId;
		this.source = source;
		this.destination = destination;
		this.dateOfJourney = dateOfJourney;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
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

}
