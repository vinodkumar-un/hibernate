package com.otms.test;

import java.util.Date;
import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import org.hibernate.criterion.DetachedCriteria;
import org.hibernate.criterion.Example;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.hibernate.sql.JoinType;

import com.otms.entities.Journey;
import com.otms.entities.Ticket;

public class CriteriaTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/otms/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		/*
		 * Calendar c = Calendar.getInstance(); c.set(2015, 04, 01, 0, 0, 0);
		 * Date fromDate = c.getTime(); c.set(2015, 04, 20, 0, 0, 0); Date
		 * toDate = c.getTime(); showAllJourneys(session, fromDate, toDate);
		 */
		showAllJourneysBySourceUsingExample(session);
		sfactory.close();
	}

	public static void showAllJourneys(Session session) {
		List<Journey> journeys = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		journeys = criteria.list();
		for (Journey j : journeys) {
			System.out.println(j.getSource());
		}
	}

	public static void showAllJourneys(Session session, final String source) {
		List<Journey> journeys = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		criteria.add(Restrictions.like("source", source));
		journeys = criteria.list();
		for (Journey j : journeys) {
			System.out.println(j.getSource());
		}
	}

	private static void showAllJourneys(Session session, final Date fromDate,
			final Date toDate) {
		List<Journey> journeys = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		criteria.add(Restrictions.between("dateOfJourney", fromDate, toDate));
		journeys = criteria.list();
		for (Journey j : journeys) {
			System.out.println(j.getJourneyId());
		}
	}

	private static void showAllJourneysByTicket(Session session, String type) {
		List<Journey> journeys = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		/*
		 * criteria.createAlias("tickets", "t");
		 * criteria.add(Restrictions.like("t.type", type));
		 */
		criteria = criteria.createCriteria("tickets");
		criteria.add(Restrictions.like("type", type));
		journeys = criteria.list();

		for (Journey j : journeys) {
			System.out.println(j.getJourneyId());
		}
	}

	private static void showSourceForAllJourneys(Session session) {
		List<String> sources = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		criteria.setProjection(Projections.property("source"));
		sources = criteria.list();
		for (String s : sources) {
			System.out.println(s);
		}

	}

	private static void showSourceAndDestination(Session session) {
		List<Object[]> data = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		ProjectionList list = Projections.projectionList()
				.add(Projections.property("source"))
				.add(Projections.property("destination"));
		criteria.setProjection(list);
		data = criteria.list();
		for (Object[] d : data) {
			System.out.println("source : " + d[0] + " - destination : " + d[1]);
		}
	}

	private static void showTotalAmount(Session session) {
		List<Double> amount = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Ticket.class);
		criteria.setProjection(Projections.sum("amount"));
		amount = criteria.list();
		System.out.println(amount.get(0));
	}

	private static void showNoOfTicketsByJourney(Session session) {
		List<Object[]> data = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		criteria.createAlias("tickets", "t");
		ProjectionList list = Projections.projectionList();
		list.add(Projections.property("journeyId"));
		list.add(Projections.count("journeyId"));
		list.add(Projections.groupProperty("t.journey"));

		criteria.setProjection(list);
		data = criteria.list();
		for (Object[] d : data) {
			System.out.println("Journey Id : " + d[0] + " -  count :" + d[1]);
		}

	}

	private static void showAllJourneysByTicketType(Session session,
			String ticketType) {
		List<Journey> journeys = null;
		Criteria criteria = null;

		criteria = session.createCriteria(Journey.class);
		criteria.createAlias("tickets", "t", JoinType.LEFT_OUTER_JOIN);
		criteria.add(Restrictions.or(Restrictions.like("t.type", ticketType),
				Restrictions.isNull("t.type")));
		journeys = criteria.list();

		for (Journey j : journeys) {
			System.out.println(j.getJourneyId());
		}
	}

	private static void showAllJourneysUsingDetachedCriteria(Session session) {
		List<Journey> journeys = null;
		DetachedCriteria dc = null;

		dc = DetachedCriteria.forClass(Journey.class);
		dc.add(Restrictions.like("source", "Hyderabad"));

		Criteria c = dc.getExecutableCriteria(session);
		journeys = c.list();
		for (Journey j : journeys) {
			System.out.println(j.getJourneyId());
		}
	}

	private static void showAllJourneysBySourceUsingExample(Session session) {
		List<Journey> journeys = null;
		Criteria criteria = null;
		Journey j = null;
		
		j = new Journey();
		j.setSource("Hyderabad");
		criteria = session.createCriteria(Journey.class);
		criteria.add(Example.create(j).ignoreCase());
		journeys = criteria.list();
		for (Journey journey : journeys) {
			System.out.println(journey.getJourneyId());
		}
	}
}








