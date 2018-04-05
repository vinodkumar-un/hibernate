package com.bs.util;

import java.io.IOException;
import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bs.entities.Event;

public class HibernateUtil {
	private static SessionFactory sessionFactory;

	/*
	 * Xml File 
	 * static {
	 *  Configuration configuration = new Configuration();
	 *  configuration.configure("com/bs/common/bootstrapping.cfg.xml");
	 *  sessionFactory = configuration.buildSessionFactory(); 
	 * }
	 */

	/*
	 * Properties File 
	 * static { 
	 *  Configuration configuration = new Configuration();
	 *  //configuration.addResource("com/bs/entities/Event.hbm.xml");
	 *  configuration.addClass(Event.class); 
	 *  sessionFactory =configuration.buildSessionFactory();
	 *  }
	 */

	// Programatic Approach
	static {
		Properties props = null;
		Configuration configuration = null;

		props = new Properties();
		try {
			props.load(HibernateUtil.class.getClassLoader()
					.getResourceAsStream("db.properties"));
		} catch (IOException e) {
			e.printStackTrace();
		}

		configuration = new Configuration();
		configuration.setProperty("hibernate.connection.driver_class",
				props.getProperty("con.driverClass"));
		configuration.setProperty("hibernate.connection.url",
				props.getProperty("con.url"));
		configuration.setProperty("hibernate.connection.username",
				props.getProperty("con.username"));
		String pass = Decode.decode(props.getProperty("con.password"));
		configuration.setProperty("hibernate.connection.password",
				pass);
		configuration.addResource("com/bs/entities/Event.hbm.xml");

		sessionFactory = configuration.buildSessionFactory();

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
