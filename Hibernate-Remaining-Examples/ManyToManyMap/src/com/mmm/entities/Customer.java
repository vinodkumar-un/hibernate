package com.mmm.entities;

import java.util.HashMap;
import java.util.Map;

public class Customer {
	private Integer customerId;
	private String firstNm;
	private String lastNm;
	private String gender;
	private int age;
	private Map<Integer, Account> accounts;

	public Integer getCustomerId() {
		return customerId;
	}

	public void setCustomerId(Integer customerId) {
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

	public Map<Integer, Account> getAccounts() {
		if(accounts == null) {
			accounts = new HashMap<Integer, Account>();
		}
		return accounts;
	}

	public void setAccounts(Map<Integer, Account> accounts) {
		this.accounts = accounts;
	}

}
