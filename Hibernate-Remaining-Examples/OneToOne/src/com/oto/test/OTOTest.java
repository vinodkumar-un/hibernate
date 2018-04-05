package com.oto.test;

import java.util.Calendar;
import java.util.Date;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.oto.entities.Bill;
import com.oto.entities.BillDetail;

public class OTOTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/oto/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();

		session.beginTransaction();
		/*
		 * Bill bill = new Bill(); bill.setBillDt(new Date()); Calendar cal =
		 * Calendar.getInstance(); cal.set(cal.get(Calendar.YEAR),
		 * cal.get(Calendar.MONTH), cal.get(Calendar.DATE) + 10);
		 * bill.setDueDt(new Date(cal.getTimeInMillis()));
		 * bill.setAmount(242.22f); session.save(bill);
		 * 
		 * BillDetail billDetail = new BillDetail();
		 * billDetail.setLocalCallCost(100.23f);
		 * billDetail.setStdCallCost(100.4f); billDetail.setIsdCallCost(42.2f);
		 * billDetail.setBill(bill);
		 * 
		 * session.save(billDetail);
		 */

		BillDetail bd = (BillDetail) session.get(BillDetail.class, 1);
		System.out.println("Due date : " + bd.getBill().getDueDt());

		session.getTransaction().commit();
		sfactory.close();
	}
}
