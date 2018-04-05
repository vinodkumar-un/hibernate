package com.sh.dao;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import com.sh.entities.Doctor;
import com.sh.helper.HibernateSessionFactory;

public class DoctorDao {

	public void saveDoctor(Doctor doctor) {
		SessionFactory sessionFactory = null;
		Transaction transaction = null;
		Session session = null;
		boolean flag = true;

		try {
			sessionFactory = HibernateSessionFactory.getSessionFactory();
			session = sessionFactory.openSession();
			transaction = session.beginTransaction();

			session.save(doctor);
			flag = false;
		} catch (HibernateException he) {
			flag = true;
			throw he;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.rollback();
				} else {
					transaction.commit();
				}
				if(session != null) {
					session.close();
				}
			}
		}
	}

	public Doctor findDoctor(Session session, int doctorId) {
		Doctor doctor = null;
		doctor = (Doctor) session.load(Doctor.class, doctorId);

		return doctor;
	}
}
