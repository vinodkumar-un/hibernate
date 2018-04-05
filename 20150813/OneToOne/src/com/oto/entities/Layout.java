package com.oto.entities;

public class Layout {
	private int houseNo;
	private String surveyNo;
	private String plotNo;
	private int area;
	private String unitsType;
	private String facing;
	private House house;

	public final int getHouseNo() {
		return houseNo;
	}

	public final void setHouseNo(int houseNo) {
		this.houseNo = houseNo;
	}

	public final String getSurveyNo() {
		return surveyNo;
	}

	public final void setSurveyNo(String surveyNo) {
		this.surveyNo = surveyNo;
	}

	public final String getPlotNo() {
		return plotNo;
	}

	public final void setPlotNo(String plotNo) {
		this.plotNo = plotNo;
	}

	public final int getArea() {
		return area;
	}

	public final void setArea(int area) {
		this.area = area;
	}

	public final String getUnitsType() {
		return unitsType;
	}

	public final void setUnitsType(String unitsType) {
		this.unitsType = unitsType;
	}

	public final String getFacing() {
		return facing;
	}

	public final void setFacing(String facing) {
		this.facing = facing;
	}

	public final House getHouse() {
		return house;
	}

	public final void setHouse(House house) {
		this.house = house;
	}

}
