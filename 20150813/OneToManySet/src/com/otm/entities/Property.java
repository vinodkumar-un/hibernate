package com.otm.entities;

import java.util.Set;

public class Property {
	private int propertyId;
	private String description;
	private String type;
	private String location;
	private float price;
	private Set<Approval> approvals;

	public Property() {
	}

	public Property(String description, float price) {
		super();
		this.description = description;
		this.price = price;
	}

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

	public final Set<Approval> getApprovals() {
		return approvals;
	}

	public final void setApprovals(Set<Approval> approvals) {
		this.approvals = approvals;
	}

}
