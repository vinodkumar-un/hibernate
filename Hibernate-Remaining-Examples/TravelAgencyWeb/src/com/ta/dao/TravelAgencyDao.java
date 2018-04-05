package com.ta.dao;

import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import com.ta.entities.Bus;
import com.ta.entities.Journey;
import com.ta.entities.Staff;

public class TravelAgencyDao {
	private final String SQL_GET_ALL_BUS = "sql_all_busses";
	private final String SQL_GET_ALL_STAFF = "sql_all_staff";

	public List<Bus> getBuses(final Session session) {
		Query query = null;

		query = session.getNamedQuery(SQL_GET_ALL_BUS);
		return query.list();
	}

	public List<Staff> getStaff(final Session session) {
		Query query = null;

		query = session.getNamedQuery(SQL_GET_ALL_STAFF);
		return query.list();
	}

	public void addStaffAndBusToJourney(final Session session,
			final int journeyId, final int busNo, final int[] staffIds) {
		Journey journey = null;
		Bus bus = null;
		Staff staff = null;

		journey = (Journey) session.get(Journey.class, journeyId);
		bus = (Bus) session.get(Bus.class, busNo);
		bus.getJourneys().add(journey);
		session.saveOrUpdate(bus);

		for (int staffId : staffIds) {
			staff = (Staff) session.get(Staff.class, staffId);
			staff.getJourneys().add(journey);
			session.saveOrUpdate(staff);
		}

	}

}
