package com.otm.test;

import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Property;
import com.otm.entities.Worker;
import com.otm.util.HibernateUtil;

public class OTMMapTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Property property = null;
		Worker worker = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		worker = new Worker();
		worker.setFirstName("Sam");
		worker.setLastName("D");

		property = new Property();
		property.setDescription("3BHK Premium Flat");
		property.setType("Flat");
		property.setLocation("Ameerpet");
		property.setPrice(2424353f);

		Map<String, Worker> workers = new HashMap<String, Worker>();
		workers.put("9192937374", worker);
		property.setWorkers(workers);

		session.beginTransaction();
		session.save(property);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
