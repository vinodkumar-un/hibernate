package com.ta.valueobjects;

public class StaffVO {
	private String staffId;
	private String staffNm;

	public StaffVO(String staffId, String staffNm) {
		this.staffId = staffId;
		this.staffNm = staffNm;
	}

	public String getStaffId() {
		return staffId;
	}

	public void setStaffId(String staffId) {
		this.staffId = staffId;
	}

	public String getStaffNm() {
		return staffNm;
	}

	public void setStaffNm(String staffNm) {
		this.staffNm = staffNm;
	}

}
