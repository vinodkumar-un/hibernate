package com.ci.test;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.ci.entities.Region;
import com.ci.entities.RegionID;

public class CITest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/ci/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = null;

		try {
			session = sfactory.openSession();
			session.beginTransaction();

			Region region = new Region();
			RegionID id = new RegionID();
			id.setSurveyNo("s2");
			id.setPlotNo(2);
			region.setId(id);
			region.setArea("1 acre");
			region.setType("Commercial");

			session.save(region);

			session.getTransaction().commit();

			RegionID id1 = new RegionID();
			id1.setSurveyNo("s2");
			id1.setPlotNo(2);
			Region s1Region = (Region) session.get(Region.class, id1);
			System.out.println("area : " + s1Region.getArea());
		} catch (HibernateException he) {
			he.printStackTrace();
			session.getTransaction().rollback();
		} finally {
			if (session != null) {
				session.close();
			}
			if (sfactory != null) {
				sfactory.close();
			}
		}
	}
}
