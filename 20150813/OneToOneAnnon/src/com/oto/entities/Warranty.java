package com.oto.entities;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.persistence.PrimaryKeyJoinColumn;
import javax.persistence.Table;
import javax.persistence.Entity;

import org.hibernate.annotations.GenericGenerator;
import org.hibernate.annotations.Parameter;

@Entity
@Table(name = "WARRANTY")
public class Warranty {
	private int productCode;
	private String description;
	private String warrantyTerms;
	private String warrantyVoidTerms;
	private int warrantyInMonths;
	private Product product;

	@Id
	@Column(name = "PRODUCT_CODE")
	@GeneratedValue(generator = "hforeign")
	@GenericGenerator(name = "hforeign", strategy = "foreign", parameters = { @Parameter(name = "property", value = "product") })
	public int getProductCode() {
		return productCode;
	}

	public void setProductCode(int productCode) {
		this.productCode = productCode;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Column(name = "WARRANTY_TERMS")
	public String getWarrantyTerms() {
		return warrantyTerms;
	}

	public void setWarrantyTerms(String warrantyTerms) {
		this.warrantyTerms = warrantyTerms;
	}

	@Column(name = "WARRANTY_VOID_TERMS")
	public String getWarrantyVoidTerms() {
		return warrantyVoidTerms;
	}

	public void setWarrantyVoidTerms(String warrantyVoidTerms) {
		this.warrantyVoidTerms = warrantyVoidTerms;
	}

	@Column(name = "WARRANTY_IN_MONTHS")
	public int getWarrantyInMonths() {
		return warrantyInMonths;
	}

	public void setWarrantyInMonths(int warrantyInMonths) {
		this.warrantyInMonths = warrantyInMonths;
	}

	@OneToOne(cascade = CascadeType.ALL)
	@PrimaryKeyJoinColumn
	public Product getProduct() {
		return product;
	}

	public void setProduct(Product product) {
		this.product = product;
	}

}
