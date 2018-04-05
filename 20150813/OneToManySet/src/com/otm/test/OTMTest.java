package com.otm.test;

import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Approval;
import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

public class OTMTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Property property = null;
		Approval approval = null;

		sessionFactory = HibernateUtil.getSessionFactory();
		session = sessionFactory.openSession();
		session.beginTransaction();

		approval = new Approval();
		approval.setCertificateName("Electricity Board Permission");
		approval.setApprovedDate(new Date());

		property = new Property();
		property.setDescription("3BHK Flat");
		property.setLocation("Balnagar");
		property.setType("Flat");
		property.setPrice(328373356f);

		Set<Approval> approvals = new HashSet<Approval>();
		approvals.add(approval);
		property.setApprovals(approvals);
		approval.setProperty(property);
		
		session.save(property);
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}
}
