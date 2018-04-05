package com.otm.entities;

import java.util.Date;

public class Bill {
	private int billNo;
	private String remarks;
	private Date billDate;
	private float amount;

	public final int getBillNo() {
		return billNo;
	}

	public final void setBillNo(int billNo) {
		this.billNo = billNo;
	}

	public final String getRemarks() {
		return remarks;
	}

	public final void setRemarks(String remarks) {
		this.remarks = remarks;
	}

	public final Date getBillDate() {
		return billDate;
	}

	public final void setBillDate(Date billDate) {
		this.billDate = billDate;
	}

	public final float getAmount() {
		return amount;
	}

	public final void setAmount(float amount) {
		this.amount = amount;
	}

}
