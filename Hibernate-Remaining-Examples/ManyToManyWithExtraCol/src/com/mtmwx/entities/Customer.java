package com.mtmwx.entities;

import java.util.Set;

public class Customer {
	private int customerId;
	private String firstNm;
	private String lastNm;
	private String gender;
	private int age;

	private Set<CustomerStock> stocks;

	public int getCustomerId() {
		return customerId;
	}

	public void setCustomerId(int customerId) {
		this.customerId = customerId;
	}

	public String getFirstNm() {
		return firstNm;
	}

	public void setFirstNm(String firstNm) {
		this.firstNm = firstNm;
	}

	public String getLastNm() {
		return lastNm;
	}

	public void setLastNm(String lastNm) {
		this.lastNm = lastNm;
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

	public Set<CustomerStock> getStocks() {
		return stocks;
	}

	public void setStocks(Set<CustomerStock> stocks) {
		this.stocks = stocks;
	}

}
