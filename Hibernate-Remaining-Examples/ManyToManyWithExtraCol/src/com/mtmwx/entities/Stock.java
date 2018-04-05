package com.mtmwx.entities;

public class Stock {
	private int stockId;
	private String stockNm;
	private String holdingCompany;
	private float price;

	public int getStockId() {
		return stockId;
	}

	public void setStockId(int stockId) {
		this.stockId = stockId;
	}

	public String getStockNm() {
		return stockNm;
	}

	public void setStockNm(String stockNm) {
		this.stockNm = stockNm;
	}

	public String getHoldingCompany() {
		return holdingCompany;
	}

	public void setHoldingCompany(String holdingCompany) {
		this.holdingCompany = holdingCompany;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

}
