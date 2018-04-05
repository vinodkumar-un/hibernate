package com.jp.entities;

public class SavingsAccount implements Account {
	private float balance;

	@Override
	public float getBalance() {
		return balance;
	}

	@Override
	public void setBalance(float balance) {
		this.balance = balance;
	}

}
