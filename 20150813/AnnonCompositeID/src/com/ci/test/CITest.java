package com.ci.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ci.entities.Student;
import com.ci.entities.StudentID;
import com.ci.util.HibernateUtil;


public class CITest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Student student = null;
		StudentID id = null;
		
		id = new StudentID();
		student = new Student();
		id.setNo(1);
		id.setBranch("Madhapur");
		student.setId(id);
		student.setFirstName("John");
		student.setLastName("k");
		student.setMedium("English");
		student.setStandard("LKG");
		
		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();
		session.save(student);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
