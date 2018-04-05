package com.mmm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.mmm.entities.Account;
import com.mmm.entities.Customer;

public class MMMTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		/*
		 * session.beginTransaction();
		 * 
		 * Account account = new Account();
		 * account.setAccountHolderName("John"); account.setType("Savings");
		 * account.setBalance(242.2f); session.save(account);
		 * 
		 * Customer customer = new Customer(); customer.setFirstNm("John");
		 * customer.setLastNm("D"); customer.setGender("Male");
		 * customer.setAge(42);
		 * customer.getAccounts().put(account.getAccountNo(), account);
		 * session.save(customer); session.getTransaction().commit();
		 */
		Customer customer = (Customer) session.get(Customer.class, 2);
		System.out.println("FirstNm : " + customer.getFirstNm());
		System.out.println("No of accounts : " + customer.getAccounts().size());
		sfactory.close();

	}
}
