package com.oto.test;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.oto.entities.House;
import com.oto.entities.Layout;
import com.oto.util.HibernateUtil;

public class OTOTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		House house = null;
		Layout layout = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*house = new House();
		house.setDescription("Prime location with an 3 stairs building");
		house.setLocation("Ameerpet");
		house.setType("Building");
		house.setPrice(8373621);

		session.save(house);*/

		house = (House) session.load(House.class, 2);

		layout = new Layout();
		layout.setSurveyNo("s19383");
		layout.setPlotNo("p29373");
		layout.setArea(250);
		layout.setUnitsType("yards");
		layout.setFacing("East");
		layout.setHouse(house);

		session.save(layout);

		/*
		 * layout = (Layout) session.get(Layout.class, 2);
		 * System.out.println(layout.getHouse().getDescription());
		 */

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
