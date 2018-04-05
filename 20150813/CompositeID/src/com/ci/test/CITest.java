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
		StudentID student = null;
		
		student = new StudentID();
		/*student.setNo(1);
		student.setBranch("Madhapur");
		student.setFirstName("John");
		student.setLastName("k");
		student.setMedium("English");
		student.setStandard("LKG");*/
		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();
		student.setNo(1);
		student.setBranch("Madhapur");
		Student s1 = (Student) session.get(Student.class, student);
		System.out.println("First Name : " + s1.getFirstName());
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
