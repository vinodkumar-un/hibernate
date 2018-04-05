package com.kg.test;

import java.util.Date;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.kg.entities.Citizen;

public class KGTest {
	public static void main(String[] args) {
		Session session = null;
		Configuration configuration = new Configuration()
				.configure("com/kg/common/oracle-hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		configuration = null;

		try {

			session = sfactory.getCurrentSession();
			session.beginTransaction();
			Citizen citizen = new Citizen();
			citizen.setFirstNm("Sita1");
			citizen.setLastNm("K");
			citizen.setDob(new Date());
			citizen.setGender("Male");

			int citizenId = (Integer) session.save(citizen);
			System.out.println("Citizen id : " + citizenId);
			session.getTransaction().commit();
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (sfactory != null) {
				sfactory.close();
			}
		}
	}
}
