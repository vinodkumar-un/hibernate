package com.mtm.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

@Entity
@Table(name = "PASSENGER")
public class Passenger {
	private int passengerId;
	private String firstName;
	private String lastName;
	private String gender;
	private int age;
	private Set<Journey> journeys;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "PASSENGER_ID")
	public int getPassengerId() {
		return passengerId;
	}

	public void setPassengerId(int passengerId) {
		this.passengerId = passengerId;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
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

	@ManyToMany(mappedBy = "passengers")
	public Set<Journey> getJourneys() {
		return journeys;
	}

	public void setJourneys(Set<Journey> journeys) {
		this.journeys = journeys;
	}

}
