package com.tpcc.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.tpcc.entities.CardPayment;
import com.tpcc.entities.ChequePayment;
import com.tpcc.entities.Payment;
import com.tpcc.util.HibernateUtil;

public class TPCCTest {
	public static void main(String[] args) {
		Session session = null;
		Payment payment = null;
		CardPayment cardPayment = null;
		SessionFactory sfactory = null;
		ChequePayment chequePayment = null;

		/*payment = new Payment();
		payment.setMerchant("Central");
		payment.setAmount(3000);*/

		cardPayment = new CardPayment();
		cardPayment.setMerchant("Pataloons");
		cardPayment.setAmount(5000);
		cardPayment.setCardNumber("3843-2425-2242-3343");
		cardPayment.setCardType("Visa");
		cardPayment.setCvv(242);
		cardPayment.setExpiry("01/2016");

		chequePayment = new ChequePayment();
		chequePayment.setMerchant("Shoppers Stop");
		chequePayment.setAmount(9333);
		chequePayment.setChequeNo("25252");
		chequePayment.setBank("ICICI BANK");
		chequePayment.setIssuedDate(new Date());

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*session.save(payment);*/
		session.save(cardPayment);
		session.save(chequePayment);

		/*
		 * cardPayment = (CardPayment) session.get(CardPayment.class, 2);
		 * System.out.println("Object Type : " +
		 * payment.getClass().getCanonicalName());
		 * System.out.println("Merchant : " + payment.getMerchant());
		 */

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
