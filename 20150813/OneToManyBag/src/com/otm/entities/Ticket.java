package com.otm.entities;

import java.util.Date;

public class Ticket {
	private int ticketNo;
	private Date journeyDate;
	private String type;
	private int seatNo;
	private float amount;

	public final int getTicketNo() {
		return ticketNo;
	}

	public final void setTicketNo(int ticketNo) {
		this.ticketNo = ticketNo;
	}

	public final Date getJourneyDate() {
		return journeyDate;
	}

	public final void setJourneyDate(Date journeyDate) {
		this.journeyDate = journeyDate;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final int getSeatNo() {
		return seatNo;
	}

	public final void setSeatNo(int seatNo) {
		this.seatNo = seatNo;
	}

	public final float getAmount() {
		return amount;
	}

	public final void setAmount(float amount) {
		this.amount = amount;
	}

}
