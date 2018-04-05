package com.ta.entities;

import java.util.Date;
import java.util.List;

public class Journey {
	protected int journeyId;
	protected String source;
	protected String destination;
	protected Date journeyDate;
	protected Bus bus;
	protected List<Ticket> tickets;
	protected TravelAgency travelAgency;

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

	public Date getJourneyDate() {
		return journeyDate;
	}

	public void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public Bus getBus() {
		return bus;
	}

	public void setBus(Bus bus) {
		this.bus = bus;
	}

	public List<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(List<Ticket> tickets) {
		this.tickets = tickets;
	}

	public TravelAgency getTravelAgency() {
		return travelAgency;
	}

	public void setTravelAgency(TravelAgency travelAgency) {
		this.travelAgency = travelAgency;
	}

}
