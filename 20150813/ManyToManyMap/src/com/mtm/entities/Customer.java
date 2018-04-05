package com.mtm.entities;

import java.util.Date;
import java.util.Map;

public class Customer {
	private int customerId;
	private String firstName;
	private String lastName;
	private String gender;
	private Date dob;
	private String mobile;
	private String email;
	private Map<String, OpenedAccount> accounts;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
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

	public Date getDob() {
		return dob;
	}

	public void setDob(Date dob) {
		this.dob = dob;
	}

	public String getMobile() {
		return mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Map<String, OpenedAccount> getAccounts() {
		return accounts;
	}

	public void setAccounts(Map<String, OpenedAccount> accounts) {
		this.accounts = accounts;
	}

}
