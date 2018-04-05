package com.tpcc.entities;

import java.util.Date;

import javax.persistence.AttributeOverride;
import javax.persistence.AttributeOverrides;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "CHEQUE_PAYMENT")
@AttributeOverrides({
		@AttributeOverride(name = "paymentId", column = @Column(name = "CHQ_PAYMENT_ID")),
		@AttributeOverride(name = "merchant", column = @Column(name = "CHQ_MERCHANT")),
		@AttributeOverride(name = "amount", column = @Column(name = "CHQ_AMOUNT")) })
public class ChequePayment extends Payment {
	@Column(name = "CHEQUE_NO")
	private String chequeNo;
	@Column(name = "BANK_NM")
	private String bank;
	@Column(name = "ISS_DT")
	private Date issuedDate;

	public final String getChequeNo() {
		return chequeNo;
	}

	public final void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public final String getBank() {
		return bank;
	}

	public final void setBank(String bank) {
		this.bank = bank;
	}

	public final Date getIssuedDate() {
		return issuedDate;
	}

	public final void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

}
