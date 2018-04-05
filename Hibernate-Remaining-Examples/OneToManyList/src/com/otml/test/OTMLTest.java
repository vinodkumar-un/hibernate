package com.otml.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otml.entities.Bus;
import com.otml.entities.TravelAgency;

public class OTMLTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/otml/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * Bus bus1 = new Bus(); bus1.setCapacity(24); bus1.setType("Mini Bus");
		 * bus1.setMake("Tata"); bus1.setModel("Mini"); session.save(bus1);
		 * 
		 * Bus bus2 = new Bus(); bus2.setCapacity(54);
		 * bus2.setType("Volvo Bus"); bus2.setMake("Benz");
		 * bus2.setModel("Volvo"); session.save(bus2);
		 * 
		 * TravelAgency ta1 = new TravelAgency();
		 * ta1.setTravelAgencyName("Kaleswara Travels");
		 * ta1.setEstablishedDate(new Date()); ta1.setMobile("0000000000");
		 * List<Bus> buses1 = new ArrayList<Bus>(); buses1.add(bus2);
		 * buses1.add(bus1); ta1.setBuses(buses1); session.save(ta1);
		 * 
		 * Bus bus3 = new Bus(); bus3.setCapacity(24); bus3.setType("City Bus");
		 * bus3.setMake("Tata"); bus3.setModel("Local"); session.save(bus3);
		 * 
		 * Bus bus4 = new Bus(); bus4.setCapacity(54);
		 * bus4.setType("Sleeper Bus"); bus4.setMake("Benz");
		 * bus4.setModel("Sleeper AC"); session.save(bus4);
		 * 
		 * TravelAgency ta2 = new TravelAgency();
		 * ta2.setTravelAgencyName("Kesineni Travels");
		 * ta2.setEstablishedDate(new Date()); ta2.setMobile("0000000001");
		 * List<Bus> buses2 = new ArrayList<Bus>(); buses2.add(bus3);
		 * buses2.add(bus4); ta2.setBuses(buses2); session.save(ta2);
		 */

		TravelAgency ta = (TravelAgency) session.get(TravelAgency.class, 1);
		System.out.println("TravelAgencyName : " + ta.getTravelAgencyName());
		List<Bus> busses = ta.getBuses();
		for (Bus b : busses) {
			System.out.println(b.getType());
		}
		session.getTransaction().commit();
		sfactory.close();
	}
}
