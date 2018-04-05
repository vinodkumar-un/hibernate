package com.fh.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fh.entities.Customer;

public class FHTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		configuration.configure();

		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();

		Customer customer = new Customer();
		customer.setCustomerID(1);
		customer.setFirstName("Rama");
		customer.setLastName("K");
		customer.setDob(new Date());
		customer.setGender("Male");

		session.save(customer);
		session.getTransaction().commit();
	}
}
