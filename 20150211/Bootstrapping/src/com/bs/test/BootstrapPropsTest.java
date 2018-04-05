package com.bs.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bs.entities.Doctor;

public class BootstrapPropsTest {

	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		//configuration.addResource("com/bs/entities/Doctor.hbm.xml");
		configuration.addClass(Doctor.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		
		Doctor doctor = new Doctor();
		doctor.setDoctorId(2);
		doctor.setFirstNm("Ravi");
		doctor.setLastNm("P");
		doctor.setExperience(1);
		doctor.setHighestDegree("MBBS");
		doctor.setSpecialization("Brain");
		
		Session session = sessionFactory.openSession();
		session.beginTransaction();
		session.save(doctor);
		
		session.getTransaction().commit();
		session.close();
		sessionFactory.close();
	}

}
