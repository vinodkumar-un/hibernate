package com.ta.dao;

import java.util.Date;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ta.entities.Journey;
import com.ta.entities.Passenger;
import com.ta.entities.Ticket;

public class JourneyDao {
	private final String SQL_GET_JOURNEYS_BTW_DATES = "sql_get_journeys_btw_dates";

	public int saveJourney(final Session session, final Journey journey) {
		return (Integer) session.save(journey);
	}

	public List<Journey> getJourneys(final Session session,
			final Date startDate, final Date endDate) {
		Query query = null;

		query = session.getNamedQuery(SQL_GET_JOURNEYS_BTW_DATES);
		query.setParameter("p_start_dt", startDate);
		query.setParameter("p_end_dt", endDate);

		return query.list();
	}

	public Ticket saveTicket(final Session session, final int passengerId,
			final int journeyId) {
		Ticket ticket = null;
		Passenger passenger = null;
		Journey journey = null;

		ticket = new Ticket();
		ticket.setType("AC Sleeper");
		ticket.setSeatNo("L 1");

		passenger = (Passenger) session.get(Passenger.class, passengerId);
		journey = (Journey) session.get(Journey.class, journeyId);

		ticket.setJourney(journey);
		ticket.setPassenger(passenger);

		session.save(ticket);
		return ticket;
	}

	public Ticket saveTicket(final Session session, Ticket ticket,
			Passenger passenger, int journeyId) {
		Journey journey = null;

		session.save(passenger);
		ticket.setPassenger(passenger);
		journey = (Journey) session.get(Journey.class, journeyId);
		ticket.setJourney(journey);
		session.save(ticket);
		return ticket;
	}

}
