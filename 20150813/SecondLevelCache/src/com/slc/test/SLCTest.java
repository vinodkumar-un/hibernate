package com.slc.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.slc.entities.Journey;
import com.slc.util.HibernateUtil;

public class SLCTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session1 = null;
		Journey journey = null;

		sfactory = HibernateUtil.getSessionFactory();
		// client request 1
		session1 = sfactory.openSession();
		System.out.println("database access...");
		journey = (Journey) session1.get(Journey.class, 1);
		System.out.println(journey);
		System.out.println("First Level Hit : "
				+ sfactory.getStatistics().getEntityLoadCount());
		System.out.println("Second Level Hit : "
				+ sfactory.getStatistics().getSecondLevelCacheHitCount());
		System.out.println("Second access to entity in the same session");
		journey = (Journey) session1.get(Journey.class, 1);
		System.out.println("First Level Hit : "
				+ sfactory.getStatistics().getEntityLoadCount());
		System.out.println("Second Level Hit : "
				+ sfactory.getStatistics().getSecondLevelCacheHitCount());
		
		// client request 2
		Session session2 = sfactory.openSession();
		Journey journey1 = (Journey) session2.get(Journey.class, 1);		
		System.out.println(journey);
		System.out.println("First Level Hit : "
				+ sfactory.getStatistics().getEntityLoadCount());
		System.out.println("Second Level Hit : "
				+ sfactory.getStatistics().getSecondLevelCacheHitCount());
		HibernateUtil.closeSessionFactory();
	}
}
