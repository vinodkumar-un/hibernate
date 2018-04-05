package com.otm.test;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Passenger;
import com.otm.entities.Ticket;
import com.otm.util.HibernateUtil;

public class OTMBagTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Ticket ticket = null;
		Passenger passenger = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * ticket = new Ticket(); ticket.setJourneyDate(new Date());
		 * ticket.setType("Semi Sleeper"); ticket.setSeatNo(1);
		 * ticket.setAmount(500f);
		 * 
		 * passenger = new Passenger(); passenger.setFirstName("John");
		 * passenger.setLastName("D"); passenger.setGender("Male");
		 * passenger.setAge(25);
		 * 
		 * Collection<Ticket> tickets = new ArrayList<Ticket>();
		 * tickets.add(ticket);
		 * 
		 * ticket = new Ticket(); ticket.setJourneyDate(new Date());
		 * ticket.setType("AC Semi Sleeper"); ticket.setSeatNo(10);
		 * ticket.setAmount(1500f); tickets.add(ticket);
		 * 
		 * passenger.setTickets(tickets);
		 * 
		 * session.save(passenger);
		 */

		passenger = (Passenger) session.get(Passenger.class, 1);
		for (Ticket t : passenger.getTickets()) {
			System.out.println("Seat No : " + t.getSeatNo());
		}

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();

	}
}
