package com.bs.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bs.entities.Event;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	/*
	 * static { Configuration configuration = new Configuration()
	 * .configure("com/bs/common/bootstrapping.cfg.xml"); sessionFactory =
	 * configuration.buildSessionFactory(); }
	 */

	/*
	 * static { Configuration configuration = new Configuration(); //
	 * configuration.addResource("com/bs/entities/Event.hbm.xml");
	 * configuration.addClass(Event.class); sessionFactory =
	 * configuration.buildSessionFactory(); }
	 */

	static {
		Properties props = null;
		Configuration configuration = null;

		props = new Properties();
		try {
			props.load(HibernateUtil.class.getClassLoader()
					.getResourceAsStream("db.properties"));
			configuration = new Configuration();
			configuration.setProperty("hibernate.connection.driver_class",
					props.getProperty("con.driverClass"));
			configuration.setProperty("hibernate.connection.url",
					props.getProperty("con.url"));
			configuration.setProperty("hibernate.connection.username",
					props.getProperty("con.username"));
			configuration.setProperty("hibernate.connection.password",
					props.getProperty("con.password"));

			configuration.addResource("com/bs/entities/Event.hbm.xml");
			sessionFactory = configuration.buildSessionFactory();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	public static SessionFactory getSessionFactory() {
		return sessionFactory;
	}

	public static void closeSessionFactory() {
		if (sessionFactory != null) {
			sessionFactory.close();
		}
	}
}
