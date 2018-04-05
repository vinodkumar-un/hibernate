package com.ta.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ta.entities.Bus;
import com.ta.entities.Journey;
import com.ta.entities.Passenger;
import com.ta.entities.Staff;
import com.ta.entities.Ticket;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sfactory = null;
		Session session = null;

		configuration = new Configuration()
				.configure("standalone-hibernate.cfg.xml");
		sfactory = configuration.buildSessionFactory();
		session = sfactory.openSession();

		session.beginTransaction();

		Journey journey = new Journey();
		journey.setSource("Hyderabad");
		journey.setDestination("Banglore");
		journey.setDateOfJourney(new Date());

		session.save(journey);

		Bus bus = new Bus();
		bus.setRegistrationNo("TS 09 2211");
		bus.setMake("Tata");
		bus.setModel("Volvo");
		bus.setCapacity(52);
		bus.getJourneys().add(journey);
		session.save(bus);

		Staff staff = new Staff();
		staff.setFirstNm("John");
		staff.setLastNm("K");
		staff.setDesignation("Driver");
		staff.getJourneys().add(journey);
		session.save(staff);

		Passenger passenger = new Passenger();
		passenger.setFirstNm("Blake");
		passenger.setLastNm("S");
		passenger.setAge(24);
		passenger.setGender("M");
		passenger.getJourneys().add(journey);
		session.save(passenger);

		Ticket ticket = new Ticket();
		ticket.setJourney(journey);
		ticket.setPassenger(passenger);
		ticket.setType("AC Sleeper");
		ticket.setSeatNo("L 1");
		session.save(ticket);

		session.getTransaction().commit();
		sfactory.close();

	}
}
