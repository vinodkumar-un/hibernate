package com.ta.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

import com.ta.util.HibernateSessionFactory;

public class AppInitializationListener implements ServletContextListener {

	@Override
	public void contextDestroyed(ServletContextEvent event) {
		HibernateSessionFactory.closeSessionFactory();
	}

	@Override
	public void contextInitialized(ServletContextEvent event) {
		HibernateSessionFactory.getSessionFactory();
	}

}
