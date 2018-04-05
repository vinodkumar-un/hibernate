package com.oto.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oto.entities.Address;
import com.oto.entities.Person;
import com.oto.util.HibernateUtil;

public class OTOAnnonTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Person person = null;
		Address address = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		address = new Address();
		address.setAddressLine1("505, 5th Floor");
		address.setAddressLine2("Mithrivanam");
		address.setCity("Hyderabad");
		address.setState("TS");
		address.setZip(29228);
		address.setCountry("India");

		person = new Person();
		person.setFirstName("Susan");
		person.setLastName("X");
		person.setGender("Female");
		person.setDob(new Date());
		
		address.setPerson(person);

		session.save(address);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();

	}
}
