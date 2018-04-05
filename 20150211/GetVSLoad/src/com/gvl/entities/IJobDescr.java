package com.gvl.entities;

import java.util.Date;

public interface IJobDescr {
	public int getJobId();

	public void setJobId(int jobId);

	public String getDescription();

	public void setDescription(String description);

	public int getExperience();

	public void setExperience(int experience);

	public String getSkills();

	public void setSkills(String skills);

	public String getGrade();

	public void setGrade(String grade);

	public String getLocation();

	public void setLocation(String location);

	public float getMaxSalary();

	public void setMaxSalary(float maxSalary);

	public Date getPostedDate();

	public void setPostedDate(Date postedDate);
}
