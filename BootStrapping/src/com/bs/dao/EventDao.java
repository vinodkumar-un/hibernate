package com.bs.dao;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.bs.entities.Event;
import com.bs.util.HibernateUtil;

public class EventDao {
	public void saveEvent(int eventId, Date eventDate, String description,
			int hours, int noOfParticipants) {
		Event event=null;
		SessionFactory sfactory=null;
		Session session=null;
		
		event=new Event();
		event.setEventId(eventId);
		event.setEventDate(eventDate);
		event.setDescription(description);
		event.setHours(hours);
		event.setNoOfParticipants(noOfParticipants);
		
		sfactory=HibernateUtil.getSessionFactory();
		session=sfactory.openSession();
		session.beginTransaction();
		
		session.save(event);
		
		session.getTransaction().commit();
	}
}
