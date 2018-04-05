package com.mtm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtm.entities.Customer;
import com.mtm.entities.OpenedAccount;
import com.mtm.util.HibernateUtil;

public class MTMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Customer customer = null;
		OpenedAccount account = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * customer = new Customer(); customer.setFirstName("John");
		 * customer.setLastName("D"); customer.setDob(new Date());
		 * customer.setEmail("john@gmail.com"); customer.setMobile("242242424");
		 * customer.setGender("Male");
		 * 
		 * Map<String, OpenedAccount> accounts = new HashMap<String,
		 * OpenedAccount>(); account = createAccount("Savings", new Date(), 383,
		 * "john@gmail", "8373933", "Active"); accounts.put("1234432111223344",
		 * account); account = createAccount("Current", new Date(), 3831,
		 * "john_d@gmail", "8373923", "Active");
		 * accounts.put("1234432111225544", account);
		 * 
		 * customer.setAccounts(accounts); session.save(customer);
		 */

		customer = (Customer) session.get(Customer.class, 1);
		for (String cardNo : customer.getAccounts().keySet()) {
			System.out.println("Card No : " + cardNo + " - "
					+ customer.getAccounts().get(cardNo).getAccountNo());
		}

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

	private static OpenedAccount createAccount(String type, Date openedDate,
			float balance, String regEmail, String regMobile, String status) {
		OpenedAccount openedAccount = null;

		openedAccount = new OpenedAccount();
		openedAccount.setType(type);
		openedAccount.setOpenedDate(openedDate);
		openedAccount.setBalance(balance);
		openedAccount.setRegEmail(regEmail);
		openedAccount.setRegMobile(regMobile);
		openedAccount.setStatus(status);

		return openedAccount;
	}
}
