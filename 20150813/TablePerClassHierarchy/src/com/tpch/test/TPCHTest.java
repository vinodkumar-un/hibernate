package com.tpch.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpch.entities.CardPayment;
import com.tpch.entities.Payment;
import com.tpch.util.HibernateUtil;

public class TPCHTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Payment payment = null;
		CardPayment cardPayment = null;

		payment = new Payment();
		payment.setMerchant("Central");
		payment.setAmount(3593);

		cardPayment = new CardPayment();
		cardPayment.setMerchant("Shopper Stop");
		cardPayment.setAmount(5522);
		cardPayment.setCardNumber("2933-4243-4646-5757");
		cardPayment.setCardType("Visa");
		cardPayment.setCvv(525);
		cardPayment.setExpiry("01/16");

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();

		session.beginTransaction();
		session.save(payment);
		session.save(cardPayment);

		/*
		 * payment = (Payment) session.get(Payment.class, 2);
		 * System.out.println("Object : " +
		 * payment.getClass().getCanonicalName());
		 * System.out.println("Merchant : " + payment.getMerchant());
		 */

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
