package com.gvl.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.gvl.entities.Event;
import com.gvl.entities.IEvent;
import com.gvl.util.HibernateUtil;

public class EventDao {
	public void showEvent(int id) {
		SessionFactory sessionFactory = null;
		Session session = null;
		IEvent event = null;

		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		event = (IEvent) session.load(Event.class, id);
		HibernateUtil.closeSessionFactory();
		if (event != null) {
			System.out.println("Class : " + event.getClass());
			System.out.println("Id : " + event.getId());
			System.out.println("Descr : " + event.getDescription());
		} else {
			System.out.println("Oops! Not found");
		}
	}
}
