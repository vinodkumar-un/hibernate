package com.tpsc.entities;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "CHEQUE_PAYMENT")
@PrimaryKeyJoinColumn(name = "CHEQUE_PAYMENT_ID")
public class ChequePayment extends Payment {
	@Column(name = "CHEQUE_NO")
	private String chequeNo;
	@Column(name = "BANK_NM")
	private String bank;
	@Column(name = "ISS_DT")
	private Date issuedDate;

	public String getChequeNo() {
		return chequeNo;
	}

	public void setChequeNo(String chequeNo) {
		this.chequeNo = chequeNo;
	}

	public String getBank() {
		return bank;
	}

	public void setBank(String bank) {
		this.bank = bank;
	}

	public Date getIssuedDate() {
		return issuedDate;
	}

	public void setIssuedDate(Date issuedDate) {
		this.issuedDate = issuedDate;
	}

}
