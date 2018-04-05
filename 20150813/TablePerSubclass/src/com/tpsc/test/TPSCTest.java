package com.tpsc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpsc.entities.CardPayment;
import com.tpsc.entities.ChequePayment;
import com.tpsc.entities.Payment;
import com.tpsc.util.HibernateUtil;

public class TPSCTest {
	public static void main(String[] args) {
		Session session = null;
		Payment payment = null;
		CardPayment cardPayment = null;
		SessionFactory sfactory = null;
		ChequePayment chequePayment = null;

		/*
		 * payment = new Payment(); payment.setMerchant("Central");
		 * payment.setAmount(3000);
		 * 
		 * cardPayment = new CardPayment();
		 * cardPayment.setMerchant("Pataloons"); cardPayment.setAmount(5000);
		 * cardPayment.setCardNumber("3843-2425-2242-3343");
		 * cardPayment.setCardType("Visa"); cardPayment.setCvv(242);
		 * cardPayment.setExpiry("01/2016");
		 * 
		 * chequePayment = new ChequePayment();
		 * chequePayment.setMerchant("Shoppers Stop");
		 * chequePayment.setAmount(9333); chequePayment.setChequeNo("25252");
		 * chequePayment.setBank("ICICI BANK"); chequePayment.setIssuedDate(new
		 * Date());
		 */

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * session.save(payment); session.save(cardPayment);
		 * session.save(chequePayment);
		 */
		cardPayment = (CardPayment) session.get(Payment.class, 2);
		System.out.println("Card Number : " + cardPayment.getCardNumber());

		session.getTransaction().commit();

		HibernateUtil.closeSessionFactory();
	}
}
