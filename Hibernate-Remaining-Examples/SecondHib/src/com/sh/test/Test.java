package com.sh.test;

import org.hibernate.SessionFactory;

import com.sh.dao.DoctorDao;
import com.sh.entities.Doctor;
import com.sh.helper.HibernateSessionFactory;

public class Test {
	public static void main(String[] args) {
		Doctor doctor = null;
		DoctorDao doctorDao = null;

		try {
			doctorDao = new DoctorDao();
			doctor = new Doctor();
			doctor.setDoctorId(1);
			doctor.setFirstNm("Rahul");
			doctor.setLastNm("Gandhi");
			doctor.setExperience(1);
			doctor.setHighestDegree("MBBS");
			doctor.setSpecialization("heart");
			doctorDao.saveDoctor(doctor);
		} finally {
			HibernateSessionFactory.close();
		}

	}
}
