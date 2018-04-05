package com.otm.entities;

import java.util.Date;

public class Approval {
	private int approvalId;
	private String certificateName;
	private Date approvedDate;
	private Property property;

	public final int getApprovalId() {
		return approvalId;
	}

	public final void setApprovalId(int approvalId) {
		this.approvalId = approvalId;
	}

	public final String getCertificateName() {
		return certificateName;
	}

	public final void setCertificateName(String certificateName) {
		this.certificateName = certificateName;
	}

	public final Date getApprovedDate() {
		return approvedDate;
	}

	public final void setApprovedDate(Date approvedDate) {
		this.approvedDate = approvedDate;
	}

	public final Property getProperty() {
		return property;
	}

	public final void setProperty(Property property) {
		this.property = property;
	}

}
