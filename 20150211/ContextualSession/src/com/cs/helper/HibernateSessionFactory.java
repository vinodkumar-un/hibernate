package com.cs.helper;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateSessionFactory {
	private static SessionFactory sessionFactory;

	static {
		Configuration configuration = new Configuration()
				.configure("com/cs/common/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		configuration = null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

}
