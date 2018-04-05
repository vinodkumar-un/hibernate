package com.otms.entities;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private Set<Ticket> tickets;

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

	public Set<Ticket> getTickets() {
		if(tickets == null) {
			tickets = new HashSet<Ticket>();
		}
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

}
