package com.bs.test;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class BootstrapXmlTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/bs/common/doctor-db.cfg.xml");
		SessionFactory sessionFactory = configuration.buildSessionFactory();
		configuration = null;
		sessionFactory.close();

	}
}
