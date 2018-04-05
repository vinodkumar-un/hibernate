package com.oto.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oto.entities.Employee;
import com.oto.entities.PFAccount;
import com.oto.util.HibernateUtil;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory factory = null;
		Session session = null;

		factory = HibernateUtil.getSessionFactory();
		session = factory.openSession();
		session.beginTransaction();
		// saveEmployee(session);
		Employee emp = getEmployee(1, session);
		System.out.println("PF Account Balance : "
				+ emp.getPfAccount().getBalance());
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

	public static void saveEmployee(Session session) {
		Employee employee = null;
		PFAccount pfaccount = null;

		pfaccount = new PFAccount();
		pfaccount.setOpenedDate(new Date());
		pfaccount.setBalance(422);

		session.save(pfaccount);

		employee = new Employee();
		employee.setFirstName("John");
		employee.setLastName("K");
		employee.setDesignation("Software Developer");
		employee.setSalary(2222.23f);
		employee.setPfAccount(pfaccount);
		session.save(employee);
	}

	public static Employee getEmployee(int id, Session session) {
		Employee employee = null;

		employee = (Employee) session.get(Employee.class, id);
		return employee;
	}
}
