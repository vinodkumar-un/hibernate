package com.otm.test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Set;

import com.otm.entities.Bill;
import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

public class OTMTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Property property = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();

		session.beginTransaction();
		// session.save(createProperty("Duplex House", "Ameerpet", 24224252f));
		// session.save(createProperty("3BHK Flat", "Jubliee Hills", 3837444f));

		property = (Property) session.get(Property.class, 1);
		for (Bill bill : property.getBills()) {
			System.out.println("Descr : " + bill.getRemarks());
		}

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

	private static Property createProperty(String descr, String location,
			float price) {
		Property property = null;
		Bill instBill1 = null;
		Bill instBill2 = null;

		property = new Property();
		property.setDescription(descr);
		property.setLocation(location);
		property.setType("House");
		property.setPrice(price);

		instBill1 = new Bill();
		instBill1.setBillDate(new Date());
		instBill1.setRemarks("1st Installment");
		instBill1.setAmount(372738f);

		instBill2 = new Bill();
		instBill2.setBillDate(new Date());
		instBill2.setRemarks("2st Installment");
		instBill2.setAmount(57352738f);

		List<Bill> bills = new ArrayList<Bill>();
		bills.add(instBill1);
		bills.add(instBill2);

		property.setBills(bills);

		return property;
	}
}
