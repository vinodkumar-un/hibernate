package com.ci.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embeddable;

@Embeddable
public class StudentID implements Serializable {
	@Column(name = "STUDENT_NO")
	private int no;
	@Column(name = "BRANCH_CODE")
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
