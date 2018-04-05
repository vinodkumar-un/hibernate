package com.ci.entities;

import java.io.Serializable;

public class StudentID implements Serializable {
	private int no;
	private String branch;

	public int getNo() {
		return no;
	}

	public void setNo(int no) {
		this.no = no;
	}

	public String getBranch() {
		return branch;
	}

	public void setBranch(String branch) {
		this.branch = branch;
	}

}
