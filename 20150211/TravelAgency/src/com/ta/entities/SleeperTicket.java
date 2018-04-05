package com.ta.entities;

public class SleeperTicket extends Ticket {
	protected int berth;
	protected boolean isUpper;

	public int getBerth() {
		return berth;
	}

	public void setBerth(int berth) {
		this.berth = berth;
	}

	public boolean isUpper() {
		return isUpper;
	}

	public void setUpper(boolean isUpper) {
		this.isUpper = isUpper;
	}

}
