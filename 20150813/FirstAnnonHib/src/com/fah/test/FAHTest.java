package com.fah.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.fah.entities.Product;
import com.fah.util.HibernateUtil;

public class FAHTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Product product = null;

		product = new Product();
		product.setProductId(1);
		product.setProductName("Television");
		product.setDescription("LED Full HD 40 inch");
		product.setPrice(222242);
		product.setManufacturedDate(new Date());
		product.setTaxableAmount(552);
		
		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		session.save(product);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
