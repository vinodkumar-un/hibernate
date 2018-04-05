package com.oto.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oto.entities.Address;
import com.oto.entities.Person;

public class OTOTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/oto/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		try {
			Address address = new Address();
			address.setAddressLine1("Mithrivanam");
			address.setAddressLine2("Ameerpet");
			address.setCity("Hyderabad");
			address.setState("TS");
			address.setZip(3522);
			address.setCountry("India");

			Person person = new Person();
			person.setFirstNm("John");
			person.setLastNm("D");
			person.setGender("M");
			person.setAge(24);
			person.setAddress(address);

			// savePerson(session, person, address);
			person = (Person) session.get(Person.class, 1);
			System.out.println("FirstNm : " + person.getFirstNm());
			System.out.println("addressLine1 : "
					+ person.getAddress().getAddressLine1());
		} finally {
			if (sfactory != null) {
				sfactory.close();
			}			
		}
	}

	private static void savePerson(Session session, Person person,
			Address address) {
		session.beginTransaction();
		session.save(address);
		session.save(person);
		session.getTransaction().commit();
	}
}
