package com.idg.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.idg.entities.Agent;
import com.idg.util.HibernateUtil;

public class IDGTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Agent agent = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();
		for (int i = 0; i < 10; i++) {
			agent = new Agent();
			agent.setDesignation("Field Officer" + i);
			agent.setFirstName("Mathew" + i);
			agent.setLastName("Mark" + i);
			agent.setEmail("Mathew@hib.org" + i);
			agent.setMobile("93939393" + i);
			session.save(agent);
		}
		System.out.println("Agent : "+ agent.getAgentId() + " Inserted..");

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
