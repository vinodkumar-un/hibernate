package com.cm.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cm.entities.Address;
import com.cm.entities.Employee;
import com.cm.util.HibernateUtil;

public class CMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Employee employee = null;
		Address address = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		employee = new Employee();
		employee.setFirstName("Mathew");
		employee.setLastName("D");
		employee.setGender("Male");
		employee.setDob(new Date());

		address = new Address();
		address.setAddressLine1("505, 5th floor");
		address.setAddressLine2("Ameerpet");
		address.setCity("Hyderabad");
		address.setState("TS");
		address.setZip(2252);
		address.setCountry("India");

		employee.setAddress(address);

		session.save(employee);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
