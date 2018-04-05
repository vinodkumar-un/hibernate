package com.bs.test;

import java.util.Properties;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.bs.entities.Doctor;

public class BootstrapProgTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration();
		/*configuration.setProperty("hibernate.connection.driver_class",
				"oracle.jdbc.driver.OracleDriver");
		configuration.setProperty("hibernate.connection.url",
				"jdbc:oracle:thin:@localhost:1521:xe");
		configuration.setProperty("hibernate.connection.username", "hib20150211_user");
		configuration.setProperty("hibernate.connection.password", "welcome1");*/
		Properties props = new Properties();
		props.put("hibernate.connection.driver_class", "oracle.jdbc.driver.OracleDriver");
		props.put("hibernate.connection.url", "jdbc:oracle:thin:@localhost:1521:xe");
		props.put("hibernate.connection.username", "hib20150211_user");
		props.put("hibernate.connection.password", "welcome1");
		configuration.setProperties(props);
		

		configuration.addClass(Doctor.class);
		SessionFactory sessionFactory = configuration.buildSessionFactory();
	}
}
