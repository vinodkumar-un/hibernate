package com.otm.entities;

import java.util.Map;

public class Property {
	private int propertyId;
	private String description;
	private String type;
	private String location;
	private float price;
	private Map<String, Worker> workers;

	public final int getPropertyId() {
		return propertyId;
	}

	public final void setPropertyId(int propertyId) {
		this.propertyId = propertyId;
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

	public final Map<String, Worker> getWorkers() {
		return workers;
	}

	public final void setWorkers(Map<String, Worker> workers) {
		this.workers = workers;
	}

}
