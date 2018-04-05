package com.tpcc.entities;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.Table;

@Entity
@Table(name = "PAYMENT")
@Inheritance(strategy = InheritanceType.TABLE_PER_CLASS)
abstract public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	protected int paymentId;
	protected String merchant;
	protected float amount;

	public final int getPaymentId() {
		return paymentId;
	}

	public final void setPaymentId(int paymentId) {
		this.paymentId = paymentId;
	}

	public final String getMerchant() {
		return merchant;
	}

	public final void setMerchant(String merchant) {
		this.merchant = merchant;
	}

	public final float getAmount() {
		return amount;
	}

	public final void setAmount(float amount) {
		this.amount = amount;
	}

}
