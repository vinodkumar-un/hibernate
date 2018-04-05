package com.hsf.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.hsf.entities.User;
import com.hsf.util.HibernateSessionFactory;

public class UserDao {
	public void saveUser(int id, String firstName, String lastName,
			String mobile, String email, String addressLine1,
			String addressLine2, String city, String state, int zip,
			String country) {
		User user = null;
		Session session = null;
		SessionFactory sfactory = null;

		user = new User();
		user.setUserId(id);
		user.setFirstName(firstName);
		user.setLastName(lastName);
		user.setMobile(mobile);
		user.setEmail(email);
		user.setAddressLine1(addressLine1);
		user.setAddressLine2(addressLine2);
		user.setCity(city);
		user.setState(state);
		user.setZip(zip);
		user.setCountry(country);

		sfactory = HibernateSessionFactory.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();
		session.save(user);
		session.getTransaction().commit();
	}
}
