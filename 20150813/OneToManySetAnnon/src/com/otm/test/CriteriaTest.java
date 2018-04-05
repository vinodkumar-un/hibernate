package com.otm.test;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.otm.entities.Journey;
import com.otm.util.HibernateUtil;
import com.sun.corba.se.spi.legacy.connection.GetEndPointInfoAgainException;

public class CriteriaTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.getCurrentSession();
			session.beginTransaction();
			// getAllJourneys(session);
			// getAllJourneysBySource(session, "Hyderabad");
			// getJourneysBetweenSourceAndDest(session, "Hyderabad",
			// "Banglore");
			// getDestinationsBySource(session, "Hyderabad");
			// getNoOfJourneys(session);
			// getDestAndDateBySource(session, "Hyderabad");
			// getNoOfJourneysForEachSource(session);
			// getJourneyAndTicketsSold(session);
			// getAllJourneysWithTickets(session, "Hyderabad");
			// getDetachedJourneys(session, "Hyderabad");
			getJourneysByExample(session, "Hyderabad");
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			HibernateUtil.closeSessionFactory();
		}
	}

	private static void getAllJourneys(Session session) {
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		List<Journey> journeys = criteria.list();
		System.out.println(journeys);
	}

	private static void getAllJourneysBySource(Session session, String source) {
		Criteria getAllJourneysBySource = null;

		getAllJourneysBySource = session.createCriteria(Journey.class).add(
				Restrictions.eq("source", source));
		List<Journey> journeys = getAllJourneysBySource.list();
		System.out.println(journeys);
	}

	private static void getJourneysBetweenSourceAndDest(Session session,
			String source, String dest) {
		Criteria getJourneysBetweenSourceAndDest = session
				.createCriteria(Journey.class)
				.add(Restrictions.eq("source", source))
				.add(Restrictions.eq("destination", dest))
				.addOrder(Order.desc("dateOfJourney"));
		List<Journey> journeys = getJourneysBetweenSourceAndDest.list();
		System.out.println(journeys);
	}

	private static void getDestinationsBySource(Session session, String source) {
		Criteria getDestinationsBySource = session
				.createCriteria(Journey.class)
				.add(Restrictions.eq("source", source))
				.setProjection(
						Projections.distinct(Projections
								.property("destination")));
		List<String> destinations = getDestinationsBySource.list();
		System.out.println(destinations);
	}

	private static void getNoOfJourneys(Session session) {
		Criteria getNoOfJourneys = session.createCriteria(Journey.class)
				.setProjection(Projections.count("journeyId"));
		long count = (Long) getNoOfJourneys.list().get(0);
		System.out.println("No of journeys : " + count);
	}

	private static void getDestAndDateBySource(Session session, String source) {
		Criteria getDestAndDateBySource = session
				.createCriteria(Journey.class)
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("destination"))
								.add(Projections.property("dateOfJourney")))
				.add(Restrictions.eq("source", source));

		List<Object[]> rows = getDestAndDateBySource.list();
		for (Object[] row : rows) {
			System.out.println("dest : " + row[0] + " date : " + row[1]);
		}
	}

	private static void getNoOfJourneysForEachSource(Session session) {
		Criteria getNoOfJourneysForEachSource = session.createCriteria(
				Journey.class).setProjection(
				Projections.projectionList()
						.add(Projections.groupProperty("source"))
						.add(Projections.count("journeyId")));
		List<Object[]> rows = getNoOfJourneysForEachSource.list();
		for (Object[] row : rows) {
			System.out.println("source : " + row[0] + " count : " + row[1]);
		}
	}

	private static void getJourneyAndTicketsSold(Session session) {
		Criteria criteria = session
				.createCriteria(Journey.class)
				.createAlias("tickets", "t")
				.setProjection(
						Projections.projectionList()
								.add(Projections.groupProperty("journeyId"))
								.add(Projections.count("t.ticketNo")));
		List<Object[]> rows = criteria.list();
		for (Object[] row : rows) {
			System.out.println("Journey id : " + row[0] + " No of tickets : "
					+ row[1]);
		}
	}

	private static void getAllJourneysWithTickets(Session session, String source) {
		Criteria criteria = session
				.createCriteria(Journey.class)
				.createAlias("tickets", "t", JoinType.LEFT_OUTER_JOIN)
				.setProjection(
						Projections.projectionList()
								.add(Projections.property("source"))
								.add(Projections.property("destination"))
								.add(Projections.property("t.ticketNo"))
								.add(Projections.property("t.price")))
				.add(Restrictions.like("source", "%" + source + "%"));
		List<Object[]> rows = criteria.list();
		for (Object[] row : rows) {
			System.out.println("Source : " + row[0] + " Destination : "
					+ row[1] + " ticket No : " + row[2] + " price : " + row[3]);
		}
	}

	private static void getDetachedJourneys(Session session, String source) {
		DetachedCriteria criteria = DetachedCriteria.forClass(Journey.class)
				.add(Restrictions.eq("source", source));
		Criteria execCriteria = criteria.getExecutableCriteria(session);
		List<Journey> journeys = execCriteria.list();
		System.out.println(journeys);
	}

	private static void getJourneysByExample(Session session, String source) {
		Journey journey = new Journey();
		journey.setSource(source);

		Example example = Example.create(journey);
		Criteria criteria=  session.createCriteria(Journey.class);
		criteria.add(example);
		
		List<Journey> journeys = criteria.list();
		System.out.println(journeys);
	}
}









