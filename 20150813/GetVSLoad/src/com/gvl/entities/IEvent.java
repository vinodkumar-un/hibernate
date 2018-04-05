package com.gvl.entities;

import java.util.Date;

public interface IEvent {
	public int getId();
	public void setId(int id);
	public Date getEventDate();
	public void setEventDate(Date eventDate);
	public String getDescription();
	public void setDescription(String description);
	public int getHours();
	public void setHours(int hours);
	public int getNoOfParticipants();
	public void setNoOfParticipants(int noOfParticipants);
}
