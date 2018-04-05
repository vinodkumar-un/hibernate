package com.fh.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.fh.entities.Customer;

public class HqlTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;

		Configuration configuration = new Configuration();
		configuration.configure();

		try {
			sfactory = configuration.buildSessionFactory();
			session = sfactory.openSession();
			// getAllCustomers(session);
			// getCustomersByGender(session, "Male");
			// getNoOfCustomers(session);
			getCustomerBasicInfo(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			if (sfactory != null) {
				sfactory.close();
			}
		}
	}

	private static void getAllCustomers(Session session) {
		Query query = null;

		query = session.createQuery("from Customer");
		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println("First Name : " + customer.getFirstName());
		}
	}

	private static void getCustomersByGender(Session session, String gender) {
		Query query = null;

		query = session.createQuery("from Customer c where c.gender like ?");
		query.setParameter(0, gender);
		List<Customer> customers = query.list();
		for (Customer customer : customers) {
			System.out.println("First Name : " + customer.getFirstName());
		}
	}

	public static void getNoOfCustomers(Session session) {
		Query query = null;

		query = session.createQuery("select count(c) from Customer c");
		List<Integer> customerCountList = query.list();
		System.out.println(customerCountList.get(0));
	}

	private static void getCustomerBasicInfo(Session session) {
		Query query = null;

		query = session
				.createQuery("select new Customer(c.customerID, c.firstName, c.dob) from Customer c");
		List<Customer> partialCustomerList = query.list();

		for (Customer customer : partialCustomerList) {
			System.out.println(customer.getFirstName());
		}
	}
}







