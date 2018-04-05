package com.mtml.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mtml.entities.Journey;
import com.mtml.entities.Passenger;

public class MTMLTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/mtml/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		
		/*Passenger passenger = new Passenger();
		passenger.setFirstNm("John");
		passenger.setLastNm("K");
		passenger.setGender("Male");
		passenger.setAge(42);
		
		session.save(passenger);
		Journey journey = new Journey();
		journey.setSource("Hyderabad");
		journey.setDestination("Banglore");
		journey.setDateOfJourney(new Date());
		journey.getPassengers().add(passenger);
		
		session.save(journey);*/
		
		Passenger passenger = (Passenger) session.get(Passenger.class, 2);
		Journey journey = (Journey) session.get(Journey.class, 3);
		/*journey.getPassengers().add(passenger);
		session.update(journey);*/
		passenger.getJourneys().add(journey);
		session.update(passenger);
		
		session.getTransaction().commit();
		sfactory.close();
		
	}
}





