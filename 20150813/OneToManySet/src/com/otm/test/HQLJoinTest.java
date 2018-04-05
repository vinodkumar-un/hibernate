package com.otm.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Approval;
import com.otm.entities.Property;
import com.otm.util.HibernateUtil;

public class HQLJoinTest {
	public static void main(String[] args) {
		SessionFactory sessionFactory = null;
		Session session = null;
		Property property = null;
		Approval approval = null;

		try {
			sessionFactory = HibernateUtil.getSessionFactory();
			session = sessionFactory.getCurrentSession();
			session.beginTransaction();
			// getAllApprovalsForProperty(session);
			// getAllPropertiesWithAvailableApprovals(session);
			// getNoOfApprovalsForProperty(session);
			// getPropertiesWithMinApprovals(session);
			// getPropertiesByTypeAndApproval(session, "Flat", "Electricity%");
			/*getPropertiesBasedOnLocationAndPrice(session, "Balnagar", 300000,
					8000000);*/
			//getPropertyApprovalYear(session, "Flat");
			getPropertiesByType(session, "Flat");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			HibernateUtil.closeSessionFactory();
		}

	}

	private static void getAllApprovalsForProperty(Session session) {
		Query query = null;
		query = session
				.createQuery("select p.description, a.certificateName from Property p inner join p.approvals a");
		List<Object[]> data = query.list();
		for (Object[] row : data) {
			System.out.println("Property Name : " + row[0]
					+ " Certificate Name : " + row[1]);
		}
	}

	private static void getAllPropertiesWithAvailableApprovals(Session session) {
		Query query = null;

		query = session
				.createQuery("select p.description, a.certificateName from Property p left outer join p.approvals a");
		List<Object[]> data = query.list();
		for (Object[] row : data) {
			System.out.println("Property Name : " + row[0]
					+ " Certificate Name : " + row[1]);
		}
	}

	private static void getNoOfApprovalsForProperty(Session session) {
		Query query = null;

		query = session
				.createQuery("select count(a.certificateName), p.description from Property p inner join p.approvals a group by p.description");
		List<Object[]> data = query.list();
		for (Object[] row : data) {
			System.out.println("Property Name : " + row[1] + " Certificates : "
					+ row[0]);
		}
	}

	private static void getPropertiesWithMinApprovals(Session session) {
		Query query = null;

		query = session
				.createQuery("select p.description, p.price from Property p where 1 < (select count(a.approvalId) from Property ip inner join ip.approvals a where ip.propertyId = p.propertyId)");
		List<Object[]> data = query.list();
		for (Object[] row : data) {
			System.out.println("Property Name : " + row[0] + " Price : "
					+ row[1]);
		}
	}

	private static void getPropertiesByTypeAndApproval(Session session,
			String type, String certificateName) {
		Query query = null;

		query = session
				.createQuery("select new Property(p.description, p.price) from Property p inner join p.approvals a where p.type=? and a.certificateName like ?");
		query.setParameter(0, type);
		query.setParameter(1, certificateName);
		List<Property> props = query.list();
		for (Property p : props) {
			System.out.println("Description : " + p.getDescription()
					+ " price : " + p.getPrice());
		}
	}

	private static void getPropertiesBasedOnLocationAndPrice(Session session,
			String loc, float minPrice, float maxPrice) {
		Query query = null;

		query = session
				.createQuery("select distinct(p.description) from Property p inner join p.approvals where p.location = :loc and p.price between :minPrice and :maxPrice");
		query.setParameter("loc", loc);
		query.setParameter("minPrice", minPrice);
		query.setParameter("maxPrice", maxPrice);

		List<String> propertyDescrs = query.list();
		for (String descr : propertyDescrs) {
			System.out.println(descr);
		}
	}

	private static void getPropertyApprovalYear(Session session, String type) {
		Query query = null;
		query = session
				.createQuery("select p.description, a.certificateName, year(a.approvedDate) from Property p inner join p.approvals a where p.type= ?");
		query.setParameter(0, type);
		List<Object[]> data = query.list();
		for (Object[] row : data) {
			System.out.println("descr : " + row[0] + " certificateName : "
					+ row[1] + " year : " + row[2]);
		}
	}
	
	private static void getPropertiesByType(Session session, String type) {
		Query query = null;
		
		query = session.getNamedQuery("getPropertiesByType");
		query.setParameter(0, type);
		List<Property> props = query.list();
		for(Property p : props) {
			System.out.println(p.getDescription());
		}
	}
}








