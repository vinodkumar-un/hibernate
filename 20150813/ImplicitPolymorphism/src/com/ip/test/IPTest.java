package com.ip.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ip.entities.CardPayment;
import com.ip.entities.Payment;
import com.ip.util.HibernateUtil;

public class IPTest {
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
		/*
		 * session.save(payment); session.save(cardPayment);
		 */

		payment = (Payment) session.get(Payment.class, 1);
		System.out.println("Object : " + payment.getClass().getCanonicalName());
		System.out.println("Merchant : " + payment.getMerchant());

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
