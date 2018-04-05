package com.otm.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Journey;
import com.otm.entities.Ticket;
import com.otm.util.HibernateUtil;

public class OTMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Journey journey = null;
		Ticket ticket = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		ticket = new Ticket();
		ticket.setType("Semi Sleeper");
		ticket.setSeatNo(35);
		ticket.setPrice(352f);

		journey = new Journey();
		journey.setSource("Hyderabad");
		journey.setDestination("Banglore");
		journey.setDateOfJourney(new Date());

		Set<Ticket> tickets = new HashSet<Ticket>();
		tickets.add(ticket);
		journey.setTickets(tickets);
		session.save(journey);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
