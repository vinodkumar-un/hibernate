package com.ta.valueobjects;

public class JourneyVO {
	private String journeyId;
	private String source;
	private String destination;
	private String dateOfJourney;
	private String busNo;
	private String[] staff;

	public String getJourneyId() {
		return journeyId;
	}

	public void setJourneyId(String journeyId) {
		this.journeyId = journeyId;
	}

	public String getSource() {
		return source;
	}

	public void setSource(String source) {
		this.source = source;
	}

	public String getDestination() {
		return destination;
	}

	public void setDestination(String destination) {
		this.destination = destination;
	}

	public String getDateOfJourney() {
		return dateOfJourney;
	}

	public void setDateOfJourney(String dateOfJourney) {
		this.dateOfJourney = dateOfJourney;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String[] getStaff() {
		return staff;
	}

	public void setStaff(String[] staff) {
		this.staff = staff;
	}

}
