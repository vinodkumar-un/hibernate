package com.mtm.entities;

import java.util.Date;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "JOURNEY")
public class Journey {
	private int journeyId;
	private String source;
	private String destination;
	private Date dateOfJourney;
	private Set<Passenger> passengers;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "JOURNEY_ID")
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

	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "JOURNEY_PASSENGER", joinColumns = { @JoinColumn(name = "P_JOURNEY_ID", referencedColumnName = "JOURNEY_ID") }, inverseJoinColumns = { @JoinColumn(name = "P_PASSENGER_ID", referencedColumnName = "PASSENGER_ID") })
	public Set<Passenger> getPassengers() {
		return passengers;
	}

	public void setPassengers(Set<Passenger> passengers) {
		this.passengers = passengers;
	}

}
