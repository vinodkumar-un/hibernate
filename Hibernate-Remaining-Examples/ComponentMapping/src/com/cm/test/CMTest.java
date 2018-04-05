package com.cm.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.cm.entities.Address;
import com.cm.entities.Person;

public class CMTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		session.beginTransaction();
		Person person = new Person();
		person.setFirstNm("John");
		person.setLastNm("k");
		Address address = new Address();
		address.setAddressLine1("Mithrivanam");
		address.setAddressLine2("Ammerpet");
		address.setCity("Hyd");
		address.setState("TS");
		address.setZip(242);
		address.setCountry("India");
		person.setAddress(address);
		session.save(person);

		session.getTransaction().commit();
		sfactory.close();

	}
}
