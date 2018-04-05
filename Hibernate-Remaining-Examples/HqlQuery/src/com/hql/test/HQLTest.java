package com.hql.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.hql.entities.Person;

public class HQLTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration().configure();
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();

		List<Person> records = getPersonByName(session, "a");
		for (Person o : records) {
			System.out.println(o.getFirstNm());
		}

		sfactory.close();
	}

	private static List<Person> getAllPersons(Session session) {
		Query query = session.createQuery("select p from Person p");
		List<Person> persons = query.list();
		return persons;
	}

	private static List<String> getAllFirstNames(Session session) {
		Query query = null;

		query = session.createQuery("select p.firstNm from Person p");
		List<String> l = query.list();
		return l;
	}

	private static List<Object[]> getPartialPerson(Session session) {
		Query query = null;

		query = session
				.createQuery("select p.personId, p.firstNm from Person p");
		List<Object[]> records = query.list();
		return records;
	}

	private static long getNoOfPersons(Session session) {
		Query query = null;

		query = session.createQuery("select count(p.personId) from Person p");
		return (Long) query.list().get(0);
	}

	private static List<Person> getPersonByName(Session session, String name) {
		Query query = null;

		query = session.createQuery("from Person p where p.firstNm like '%"
				+ name+"%' order by p.firstNm");
		return query.list();
	}

}
