package com.slc.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.stat.Statistics;

import com.slc.entities.Bus;

public class Test {
	public static void main(String[] args) {
		Configuration configuration = null;
		SessionFactory sfactory = null;
		Session session = null;

		configuration = new Configuration()
				.configure("com/slc/common/hibernate.cfg.xml");
		sfactory = configuration.buildSessionFactory();
		session = sfactory.getCurrentSession();
		Statistics stat = sfactory.getStatistics();
		// saveBus(session, "TS 09 2922", "Tata", "CRDIS");
		session.beginTransaction();
		/*
		 * Bus bus = (Bus) session.get(Bus.class, 1);
		 * System.out.println("Load Count : " + stat.getEntityLoadCount());
		 * System.out.println("Second Level hit : " +
		 * stat.getSecondLevelCacheHitCount());
		 * 
		 * Bus bus1 = (Bus) session.load(Bus.class, 1);
		 * System.out.println("Load Count : " + stat.getEntityLoadCount());
		 * System.out.println("Second Level hit : " +
		 * stat.getSecondLevelCacheHitCount());
		 * 
		 * session.evict(bus); Bus bus3 = (Bus) session.get(Bus.class, 1);
		 * System.out.println("Load Count : " + stat.getEntityLoadCount());
		 * System.out.println("Second Level hit : " +
		 * stat.getSecondLevelCacheHitCount());
		 */
		
		//query.setCacheable(true);

		getBusses(session);
		session.getTransaction().commit();
		session = sfactory.getCurrentSession();
		session.beginTransaction();
		getBusses(session);
		session.getTransaction().commit();
		
		sfactory.close();
	}

	private static void getBusses(Session session) {
		Query query = session.createQuery("from Bus b where b.make like ?");
		query.setParameter(0, "Tata");
		query.setCacheable(true);
		List<Bus> busses = query.list();
		
		for (Bus bus : busses) {
			System.out.println(bus.hashCode());
			System.out.println(bus.getRegistrationNo());
		}
	}

	private static void saveBus(Session session, String regNo, String make,
			String model) {
		session.beginTransaction();
		Bus bus = new Bus();
		bus.setRegistrationNo(regNo);
		bus.setMake(make);
		bus.setModel(model);
		session.save(bus);
		session.getTransaction().commit();
	}
}
