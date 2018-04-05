package com.oto.entities;

public class BillDetail {
	private int billNo;
	private float localCallCost;
	private float stdCallCost;
	private float isdCallCost;
	private Bill bill;

	public int getBillNo() {
		return billNo;
	}

	public void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public float getLocalCallCost() {
		return localCallCost;
	}

	public void setLocalCallCost(float localCallCost) {
		this.localCallCost = localCallCost;
	}

	public float getStdCallCost() {
		return stdCallCost;
	}

	public void setStdCallCost(float stdCallCost) {
		this.stdCallCost = stdCallCost;
	}

	public float getIsdCallCost() {
		return isdCallCost;
	}

	public void setIsdCallCost(float isdCallCost) {
		this.isdCallCost = isdCallCost;
	}

	public Bill getBill() {
		return bill;
	}

	public void setBill(Bill bill) {
		this.bill = bill;
	}

}
