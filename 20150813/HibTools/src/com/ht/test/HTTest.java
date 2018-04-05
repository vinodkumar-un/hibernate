package com.ht.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ht.entities.Bill;

public class HTTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory factory = configuration.buildSessionFactory();
		Session session = factory.openSession();

		Bill bill = new Bill();
		bill.setBillNo(243);
		bill.setBillDate(new Date());
		bill.setDescription("This is an Banglow with all facilities");
		bill.setAmount(2222);

		session.beginTransaction();
		session.save(bill);
		session.getTransaction().commit();
		factory.close();

	}
}
