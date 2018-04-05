package com.ta.valueobjects;

public class BusVO {
	private String busNo;
	private String registrationNo;

	public BusVO(String busNo, String registrationNo) {
		this.busNo = busNo;
		this.registrationNo = registrationNo;
	}

	public String getBusNo() {
		return busNo;
	}

	public void setBusNo(String busNo) {
		this.busNo = busNo;
	}

	public String getRegistrationNo() {
		return registrationNo;
	}

	public void setRegistrationNo(String registrationNo) {
		this.registrationNo = registrationNo;
	}

}
