package com.otms.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otms.entities.Journey;
import com.otms.entities.Ticket;

public class OTMSTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/otms/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		Ticket ticket = new Ticket();
		ticket.setType("AC Sleeper");
		ticket.setSeatNo(2);
		ticket.setBusNo(2422);
		ticket.setAmount(252.2f);
		
		Journey journey = new Journey();
		journey.setSource("Hyderabad");
		journey.setDestination("Banglore");
		journey.setDateOfJourney(new Date());
		journey.getTickets().add(ticket);
		ticket.setJourney(journey);
		
		session.save(ticket);

		session.getTransaction().commit();
		sfactory.close();
	}
}
