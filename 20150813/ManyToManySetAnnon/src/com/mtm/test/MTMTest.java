package com.mtm.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtm.util.HibernateUtil;
import com.mtm.entities.Journey;
import com.mtm.entities.Passenger;

public class MTMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Journey journey = null;
		Passenger passenger = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		passenger = new Passenger();
		passenger.setFirstName("Rama");
		passenger.setLastName("A");
		passenger.setGender("Male");
		passenger.setAge(2522);

		journey = new Journey();
		journey.setSource("Hyderabad");
		journey.setDestination("Ayodaya");
		journey.setDateOfJourney(new Date());

		Set<Passenger> passengers = new HashSet<Passenger>();
		passengers.add(passenger);
		journey.setPassengers(passengers);
		session.save(journey);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
