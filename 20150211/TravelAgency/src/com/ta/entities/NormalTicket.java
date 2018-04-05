package com.ta.entities;

public class NormalTicket extends Ticket {
	protected int seatNo;
	protected boolean isWindow;

	public int getSeatNo() {
		return seatNo;
	}

	public void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public boolean isWindow() {
		return isWindow;
	}

	public void setWindow(boolean isWindow) {
		this.isWindow = isWindow;
	}

}
