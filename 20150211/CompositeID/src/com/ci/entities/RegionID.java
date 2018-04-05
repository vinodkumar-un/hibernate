package com.ci.entities;

import java.io.Serializable;

public class RegionID implements Serializable {
	private String surveyNo;
	private int plotNo;

	public String getSurveyNo() {
		return surveyNo;
	}

	public void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public int getPlotNo() {
		return plotNo;
	}

	public void setPlotNo(int plotNo) {
		this.plotNo = plotNo;
	}

}
