package com.mtms.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mtms.entities.Journey;
import com.mtms.entities.Passenger;

public class MTMSTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/mtms/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		/*
		 * session.beginTransaction();
		 * 
		 * Passenger passenger = new Passenger(); passenger.setFirstNm("John");
		 * passenger.setLastNm("M"); passenger.setGender("Male");
		 * passenger.setAge(22); session.save(passenger);
		 * 
		 * Journey journey = new Journey(); journey.setSource("Hyderabad");
		 * journey.setDestination("Delhi"); journey.setDateOfJourney(new
		 * Date()); journey.getPassengers().add(passenger);
		 * session.save(journey); session.getTransaction().commit();
		 */
		Journey journey = (Journey) session.get(Journey.class, 1);
		System.out.println("Source : " + journey.getSource());
		for (Passenger passenger : journey.getPassengers()) {
			System.out.println("passenger name : " + passenger.getFirstNm());
		}
		sfactory.close();
	}
}
