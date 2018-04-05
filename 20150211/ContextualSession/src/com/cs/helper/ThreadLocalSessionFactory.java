package com.cs.helper;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

@Deprecated
public class ThreadLocalSessionFactory {
	private static SessionFactory sessionFactory;
	private static ThreadLocal<Session> threadLocal = new ThreadLocal<Session>();

	static {
		Configuration configuration = new Configuration()
				.configure("com/cs/common/hibernate.cfg.xml");
		sessionFactory = configuration.buildSessionFactory();
		configuration = null;
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static Session getSession() {
		Session session = null;

		session = threadLocal.get();
		if (session == null || session.isOpen() == false) {
			session = getSessionFactory().openSession();
			threadLocal.set(session);
		}
		return session;
	}

	public static void closeSessionFactory() {
		sessionFactory.close();
	}

	public static void closeSession() {
		Session session = null;

		session = threadLocal.get();
		if (session != null && session.isOpen() == true) {
			session.close();
			threadLocal.set(null);
		}
	}
}
