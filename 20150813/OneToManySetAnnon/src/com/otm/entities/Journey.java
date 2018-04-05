package com.otm.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import org.hibernate.annotations.NamedQueries;
import org.hibernate.annotations.NamedQuery;

@Entity
@Table(name = "JOURNEY")
@NamedQueries({ @NamedQuery(name = "getAllJourneys", query = "from Journey j") })
public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private Set<Ticket> tickets;

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

	@OneToMany(mappedBy = "journey")
	public Set<Ticket> getTickets() {
		return tickets;
	}

	public void setTickets(Set<Ticket> tickets) {
		this.tickets = tickets;
	}

	@Override
	public String toString() {
		return "Journey [journeyId=" + journeyId + ", source=" + source
				+ ", destination=" + destination + ", dateOfJourney="
				+ dateOfJourney + "]";
	}

}
