package com.gvl.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.gvl.dao.JobDescrDao;
import com.gvl.entities.IJobDescr;

public class Test {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Configuration configuration = null;
		JobDescrDao jobDescrDao = null;
		IJobDescr jobDescr = null;
		Session session = null;

		configuration = new Configuration()
				.configure("com/gvl/common/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		sessionFactory.close();
	}
}
