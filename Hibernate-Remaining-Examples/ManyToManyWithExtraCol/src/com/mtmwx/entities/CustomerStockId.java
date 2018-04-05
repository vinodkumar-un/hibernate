package com.mtmwx.entities;

import java.io.Serializable;

public class CustomerStockId implements Serializable {
	private Customer pCustomer;
	private Stock pStock;

	public Customer getpCustomer() {
		return pCustomer;
	}

	public void setpCustomer(Customer pCustomer) {
		this.pCustomer = pCustomer;
	}

	public Stock getpStock() {
		return pStock;
	}

	public void setpStock(Stock pStock) {
		this.pStock = pStock;
	}

}
