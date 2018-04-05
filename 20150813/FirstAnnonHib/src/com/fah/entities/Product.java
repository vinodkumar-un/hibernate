package com.fah.entities;

import java.util.Date;

import javax.persistence.Access;
import javax.persistence.AccessType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Transient;
import javax.persistence.UniqueConstraint;
import javax.transaction.TransactionScoped;

@Entity
@Table(name = "PRODUCT", uniqueConstraints = { @UniqueConstraint(columnNames = { "PRODUCT_NM" }) })
public class Product {
	@Id
	private int productId;
	@Column(name = "PRODUCT_NM")
	private String productName;
	private String description;
	private double price;
	private Date manufacturedDate;
	@Transient
	private int taxableAmount;

	public int getProductId() {
		return productId;
	}

	public void setProductId(int productId) {
		this.productId = productId;
	}

	public String getProductName() {
		return productName;
	}

	public void setProductName(String productName) {
		this.productName = productName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public double getPrice() {
		return price;
	}

	public void setPrice(double price) {
		this.price = price;
	}

	public Date getManufacturedDate() {
		return manufacturedDate;
	}

	public void setManufacturedDate(Date manufacturedDate) {
		this.manufacturedDate = manufacturedDate;
	}

	public int getTaxableAmount() {
		return taxableAmount;
	}

	public void setTaxableAmount(int taxableAmount) {
		this.taxableAmount = taxableAmount;
	}

}
