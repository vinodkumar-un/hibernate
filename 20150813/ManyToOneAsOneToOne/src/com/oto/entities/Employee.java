package com.oto.entities;

public class Employee {
	private int employeeId;
	private String firstName;
	private String lastName;
	private String designation;
	private float salary;
	private PFAccount pfAccount;

	public final int getEmployeeId() {
		return employeeId;
	}

	public final void setEmployeeId(int employeeId) {
		this.employeeId = employeeId;
	}

	public final String getFirstName() {
		return firstName;
	}

	public final void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public final String getLastName() {
		return lastName;
	}

	public final void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public final String getDesignation() {
		return designation;
	}

	public final void setDesignation(String designation) {
		this.designation = designation;
	}

	public final float getSalary() {
		return salary;
	}

	public final void setSalary(float salary) {
		this.salary = salary;
	}

	public final PFAccount getPfAccount() {
		return pfAccount;
	}

	public final void setPfAccount(PFAccount pfAccount) {
		this.pfAccount = pfAccount;
	}

}
