package com.mtmwx.entities;

import java.util.Date;

public class CustomerStock {
	private CustomerStockId id;
	private int quantity;
	private Date purchaseDate;

	public CustomerStockId getId() {
		return id;
	}

	public void setId(CustomerStockId id) {
		this.id = id;
	}

	public int getQuantity() {
		return quantity;
	}

	public void setQuantity(int quantity) {
		this.quantity = quantity;
	}

	public Date getPurchaseDate() {
		return purchaseDate;
	}

	public void setPurchaseDate(Date purchaseDate) {
		this.purchaseDate = purchaseDate;
	}

}
