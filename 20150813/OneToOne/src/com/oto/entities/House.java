package com.oto.entities;

public class House {
	private int houseNo;
	private String description;
	private String type;
	private String location;
	private float price;

	public final int getHouseNo() {
		return houseNo;
	}

	public final void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public final String getDescription() {
		return description;
	}

	public final void setDescription(String description) {
		this.description = description;
	}

	public final String getType() {
		return type;
	}

	public final void setType(String type) {
		this.type = type;
	}

	public final String getLocation() {
		return location;
	}

	public final void setLocation(String location) {
		this.location = location;
	}

	public final float getPrice() {
		return price;
	}

	public final void setPrice(float price) {
		this.price = price;
	}

}
