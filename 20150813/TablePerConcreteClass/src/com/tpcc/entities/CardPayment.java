package com.tpcc.entities;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CARD_PAYMENT")
@AttributeOverrides({
		@AttributeOverride(name = "paymentId", column = @Column(name = "CARD_PAYMENT_ID")),
		@AttributeOverride(name = "merchant", column = @Column(name = "CMERCHANT")),
		@AttributeOverride(name = "amount", column = @Column(name = "CARD_AMOUNT")) })
public class CardPayment extends Payment {
	@Column(name = "CARD_NO")
	private String cardNumber;
	@Column(name = "CARD_TYPE")
	private String cardType;
	private int cvv;
	private String expiry;

	public final String getCardNumber() {
		return cardNumber;
	}

	public final void setCardNumber(String cardNumber) {
		this.cardNumber = cardNumber;
	}

	public final String getCardType() {
		return cardType;
	}

	public final void setCardType(String cardType) {
		this.cardType = cardType;
	}

	public final int getCvv() {
		return cvv;
	}

	public final void setCvv(int cvv) {
		this.cvv = cvv;
	}

	public final String getExpiry() {
		return expiry;
	}

	public final void setExpiry(String expiry) {
		this.expiry = expiry;
	}

}
