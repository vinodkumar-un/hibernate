package com.otms.test;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otms.entities.Journey;
import com.otms.entities.Ticket;

public class QueryTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/otms/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();
		showNamedSqlQueryAllJourneys(session);
		sfactory.close();
	}

	private static void showAllJourneyByTicketType(Session session, String type) {
		Query query = session
				.createQuery("select j from Journey j inner join j.tickets t where t.type='"
						+ type + "'");
		List<Journey> journeys = query.list();
		for (Journey j : journeys) {
			System.out.println(j.getSource());
		}
	}

	private static void showAllJourneys(Session session, float ticketPrice) {
		Query query = session
				.createQuery("from Journey j left outer join j.tickets t where (t.amount >= "
						+ ticketPrice + " or t.amount is NULL)");
		List<Object[]> list = query.list();
		for (Object[] o : list) {
			System.out.println("Source : " + ((Journey) o[0]).getSource()
					+ " ticket No : " + ((Ticket) o[1]).getTicketId());
		}
	}

	private static void showAllTicketCountForJourneys(Session session) {
		Query query = null;

		query = session
				.createQuery("select j.journeyId, count(t) from Journey j left outer join j.tickets t group by j.journeyId");
		List<Object[]> journeyCountList = query.list();
		for (Object[] o : journeyCountList) {
			System.out.println("Journey Id : " + o[0] + " count : " + o[1]);
		}
	}

	private static void showAllConsolidatedJourney(Session session) {
		Query query = null;

		query = session
				.createQuery("select j.journeyId, count(t), sum(t.amount) from Journey j inner join j.tickets t group by (j.journeyId, t.type) having t.type='Sleeper'");
		List<Object[]> list = query.list();
		for (Object[] o : list) {
			System.out.println("Journey Id : " + o[0] + " count : " + o[1]
					+ " amount : " + o[2]);
		}
	}

	private static void showAllJourneysWithMinTickets(Session session) {
		Query query = null;

		query = session
				.createQuery("select j from Journey j where 2 <= (select count(t) from Ticket t where t.journey.journeyId = j.journeyId)");
		List<Journey> journeys = query.list();
		for (Journey j : journeys) {
			System.out.println(j.getJourneyId());
		}
	}

	private static void showAllTicketsBetweenSourceandDest(Session session,
			String source, String destination) {
		Query query = null;

		query = session
				.createQuery("select t from Ticket t inner join t.journey j where j.source = ? and j.destination=?");
		query.setParameter(0, source);
		query.setParameter(1, destination);

		List<Ticket> tickets = query.list();
		for (Ticket t : tickets) {
			System.out.println(t.getTicketId());
			System.out.println(t.getType());
		}
	}

	private static void updateTicket(Session session, int journeyId, String type) {
		int records = 0;
		Query query = null;

		session.beginTransaction();
		query = session
				.createQuery("update Ticket t set t.type = :ptype where t.journey.journeyId = :pjourneyid");
		query.setParameter("ptype", type);
		query.setParameter("pjourneyid", journeyId);
		records = query.executeUpdate();
		System.out.println("records : " + records);
		session.getTransaction().commit();
	}

	private static void insertTicket(Session session, String type) {
		int records = 0;
		Query query = null;

		session.beginTransaction();
		query = session
				.createQuery("insert into NewTicket(ticketId,type,seatNo,busNo,amount,journey) select t.ticketId, t.type, t.seatNo,t.busNo,t.amount, t.journey from Ticket t where t.type = :ptype");
		query.setParameter("ptype", type);
		records = query.executeUpdate();
		System.out.println("records inserted : " + records);
		session.getTransaction().commit();
	}

	private static void deleteTicket(Session session, String type) {
		int records = 0;
		Query query = null;

		session.beginTransaction();
		query = session.createQuery("delete from Ticket t where t.type=:ptype");
		query.setParameter("ptype", type);
		records = query.executeUpdate();
		System.out.println(records);
		session.getTransaction().commit();
	}

	private static void executeNativeSql(Session session, String type) {
		SQLQuery sQuery = null;

		sQuery = session.createSQLQuery("select * from TICKET where type = ?");
		sQuery.addEntity(Ticket.class);
		sQuery.setParameter(0, type);
		List<Ticket> tickets = sQuery.list();
		for (Ticket t : tickets) {
			System.out.println(t.getTicketId());
		}
	}

	private static void showNamedQueryAllJourneys(Session session) {
		List<Journey> journeys = null;
		Query query = null;
		
		query = session.getNamedQuery("sql_getAllJourneys");
		journeys = query.list();
		for(Journey j : journeys) {
			System.out.println("Source : "+ j.getSource());
		}
	}

	private static void showNamedSqlQueryAllJourneys(Session session) {
		List<Journey> journeys = null;
		SQLQuery query = null;
		
		query = (SQLQuery) session.getNamedQuery("getAllJourneys");
		query.addEntity(Journey.class);
		journeys = query.list();
		for(Journey j : journeys) {
			System.out.println("Source : "+ j.getSource());
		}
	}

}








