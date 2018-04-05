package com.oto.entities;

import java.util.Date;

public class PFAccount {
	private int pfAccountNo;
	private Date openedDate;
	private float balance;

	public final int getPfAccountNo() {
		return pfAccountNo;
	}

	public final void setPfAccountNo(int pfAccountNo) {
		this.pfAccountNo = pfAccountNo;
	}

	public final Date getOpenedDate() {
		return openedDate;
	}

	public final void setOpenedDate(Date openedDate) {
		this.openedDate = openedDate;
	}

	public final float getBalance() {
		return balance;
	}

	public final void setBalance(float balance) {
		this.balance = balance;
	}

}
