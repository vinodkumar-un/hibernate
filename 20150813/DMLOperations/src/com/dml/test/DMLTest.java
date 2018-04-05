package com.dml.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.dml.entities.Address;
import com.dml.util.HibernateUtil;

public class DMLTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Address address = null;

		/*
		 * address = new Address(); address.setAddressLine1("Mithrivanam");
		 * address.setCity("Hyderabad"); address.setState("TS");
		 * address.setZip(3252); address.setCountry("India");
		 */

		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();
		address = (Address) session.get(Address.class, 1);
		address.setAddressLine1("Mithrivanam 5th floor");

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();

	}
}
