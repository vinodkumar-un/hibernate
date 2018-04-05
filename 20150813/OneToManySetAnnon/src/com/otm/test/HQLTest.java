package com.otm.test;

import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.otm.entities.Journey;
import com.otm.entities.Ticket;
import com.otm.util.HibernateUtil;

public class HQLTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Journey journey = null;
		Ticket ticket = null;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			session.beginTransaction();
			// getJourneys(session, "Hyderabad", "Goa");
			/*
			 * getJourneysByTicketTypeAndSource(session, "Hyderabad",
			 * "Semi Sleeper", 01, 2016);
			 */
			/*
			 * getScheduledJourneys(session, "Hyderabad", "Banglore",
			 * "Semi Sleeper");
			 */
			// getMaxTicketPrice(session, "Hyderabad", "Banglore");
			// getPoorSellingJourneys(session);
			// getAllJourneys(session);
			// updateJourney(session, 81, "Banglore", "Goa");
			// cancelJourney(session, 81);
			// insertIntoJourneyHistory(session);
			getNativeAllJourneys(session);
		} catch (HibernateException e) {
			e.printStackTrace();
		} finally {
			session.getTransaction().commit();
			HibernateUtil.closeSessionFactory();
		}
	}

	private static void getAllJourneys(Session session) {
		Query query = null;

		query = session.getNamedQuery("getAllJourneys");
		List<Journey> journeys = query.list();
		System.out.println(journeys);
	}

	private static void getJourneys(Session session, String source,
			String destination) {
		Query query = null;

		query = session
				.createQuery("from Journey j where j.source = ? and j.destination = ?");
		query.setParameter(0, source);
		query.setParameter(1, destination);
		List<Journey> journeys = query.list();
		System.out.println(journeys);
	}

	private static void getJourneysByTicketTypeAndSource(Session session,
			String source, String ticketType, int month, int year) {
		Query query = null;

		query = session
				.createQuery("select j from Journey j inner join j.tickets t where j.source = :source and month(j.dateOfJourney) = :month and year(j.dateOfJourney) = :year and t.type=:type");
		query.setParameter("source", source);
		query.setParameter("year", year);
		query.setParameter("month", month);
		query.setParameter("type", ticketType);
		List<Journey> journeys = query.list();
		System.out.println(journeys);
	}

	private static void getScheduledJourneys(Session session, String source,
			String destination, String ticketType) {
		Query query = null;

		query = session
				.createQuery("select j.source, j.destination, j.dateOfJourney, t.price from Journey j left outer join j.tickets t where j.source = :source and j.destination = :destination and (t.type=:type or t.type is NULL)");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		query.setParameter("type", ticketType);

		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			System.out.println("Source : " + row[0] + "  destination : "
					+ row[1] + " journeyDate : " + row[2] + " price : "
					+ row[3]);
		}
	}

	private static void getMaxTicketPrice(Session session, String source,
			String destination) {
		Query query = null;

		query = session
				.createQuery("select j.source, j.destination, j.dateOfJourney, max(t.price) from Journey j left outer join j.tickets t where j.source = :source and j.destination = :destination group by (j.source, j.destination, j.dateOfJourney)");
		query.setParameter("source", source);
		query.setParameter("destination", destination);
		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			System.out.println("Source : " + row[0] + "  destination : "
					+ row[1] + " journeyDate : " + row[2] + " price : "
					+ row[3]);
		}
	}

	private static void getPoorSellingJourneys(Session session) {
		Query query = null;
		String sql = null;

		sql = "select j.source, j.destination, j.dateOfJourney from Journey j left outer join j.tickets t where 1 >= (select count(it) from Ticket it where it.journey.journeyId = j.journeyId)";
		query = session.createQuery(sql);
		List<Object[]> rows = query.list();
		for (Object[] row : rows) {
			System.out.println("Source : " + row[0] + "  destination : "
					+ row[1] + " journeyDate : " + row[2]);
		}
	}

	public static void updateJourney(Session session, int journeyId,
			String source, String dest) {
		Query query = null;

		query = session
				.createQuery("update Journey j set j.source = :source, j.destination = :dest where j.journeyId = :jid");
		query.setParameter("source", source);
		query.setParameter("dest", dest);
		query.setParameter("jid", journeyId);
		int rowsAffected = query.executeUpdate();
		System.out.println("Rows updated : " + rowsAffected);
	}

	public static void cancelJourney(Session session, int journeyId) {
		Query query = null;

		query = session
				.createQuery("delete from Ticket t where t.journey.journeyId = ?");
		query.setParameter(0, journeyId);
		int rowsDeleted = query.executeUpdate();
		System.out.println("deleted : " + rowsDeleted);
	}

	public static void insertIntoJourneyHistory(Session session) {
		Query query = null;

		query = session
				.createQuery("insert into JourneyHistory(journeyId, source, destination, dateOfJourney) select j.journeyId, j.source, j.destination, j.dateOfJourney from Journey j where month(j.dateOfJourney) = month(sysdate)-1");
		int rows = query.executeUpdate();
		System.out.println("rows inserted : " + rows);
	}

	private static void getNativeAllJourneys(Session session) {
		SQLQuery query = null;

		query = session.createSQLQuery("select * from journey");
		query.addEntity(Journey.class);
		List<Journey> journeys = query.list();
		System.out.println(journeys);
	}
}








