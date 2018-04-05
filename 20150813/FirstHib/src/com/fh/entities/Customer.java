package com.fh.entities;

import java.util.Date;

public class Customer {
	private int customerID;
	private String firstName;
	private String lastName;
	private Date dob;
	private String gender;

	public Customer() {
	}

	public Customer(int customerID, String firstName, Date dob) {
		this.customerID = customerID;
		this.firstName = firstName;
		this.dob = dob;
	}

	public int getCustomerID() {
		return customerID;
	}

	public void setCustomerID(int customerID) {
		this.customerID = customerID;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

}
