package com.fh.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.cfg.Configuration;

import com.fh.entities.Product;

public class ProductTest {
	public static void main(String[] args) {
		Product product = null;
		Session session = null;
		Transaction transaction = null;
		Configuration configuration = null;
		SessionFactory sessionFactory = null;

		configuration = new Configuration().configure();
		sessionFactory = configuration.buildSessionFactory();
		session = sessionFactory.openSession();

		transaction = session.beginTransaction();
		product = new Product();
		product.setProductId(1);
		product.setName("Aircooler");
		product.setDescription("Cools air");
		product.setAmount(10233.34f);

		session.save(product);
		transaction.commit();
		session.close();
		sessionFactory.close();
	}
}
