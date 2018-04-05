package com.ta.delegate;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.hibernate.HibernateError;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.ta.dao.JourneyDao;
import com.ta.dao.TravelAgencyDao;
import com.ta.entities.Bus;
import com.ta.entities.Journey;
import com.ta.entities.Passenger;
import com.ta.entities.Staff;
import com.ta.entities.Ticket;
import com.ta.util.HibernateSessionFactory;
import com.ta.valueobjects.BusVO;
import com.ta.valueobjects.JourneyVO;
import com.ta.valueobjects.StaffVO;
import com.ta.valueobjects.TicketVO;

public class JourneyDelegate {

	public List<BusVO> getAllBuses() {
		List<Bus> buses = null;
		List<BusVO> busVOs = null;
		SessionFactory sfactory = null;
		TravelAgencyDao dao = null;
		Session session = null;

		sfactory = HibernateSessionFactory.getSessionFactory();
		session = sfactory.openSession();
		dao = new TravelAgencyDao();
		buses = dao.getBuses(session);
		busVOs = new ArrayList<BusVO>();
		for (Bus b : buses) {
			busVOs.add(new BusVO(String.valueOf(b.getBusNo()), b
					.getRegistrationNo()));
		}
		return busVOs;
	}

	public List<StaffVO> getAllStaff() {
		List<Staff> staffList = null;
		List<StaffVO> staffVOList = null;
		SessionFactory sfactory = null;
		TravelAgencyDao dao = null;
		Session session = null;

		sfactory = HibernateSessionFactory.getSessionFactory();
		session = sfactory.openSession();
		dao = new TravelAgencyDao();

		staffList = dao.getStaff(session);
		staffVOList = new ArrayList<StaffVO>();
		for (Staff staff : staffList) {
			staffVOList.add(new StaffVO(String.valueOf(staff.getStaffId()),
					(staff.getFirstNm() + "," + staff.getLastNm())));
		}
		return staffVOList;
	}

	public void saveJourney(JourneyVO journeyVO) throws ParseException {
		SimpleDateFormat sdf = null;
		SessionFactory sfactory = null;
		TravelAgencyDao travelAgencyDao = null;
		JourneyDao journeyDao = null;
		Journey journey = null;
		Session session = null;
		int journeyId = 0;
		int[] staffIds = null;
		boolean flag = false;

		journey = new Journey();
		journey.setSource(journeyVO.getSource());
		journey.setDestination(journeyVO.getDestination());
		sdf = new SimpleDateFormat("dd/mm/yyyy");
		journey.setDateOfJourney(sdf.parse(journeyVO.getDateOfJourney()));

		staffIds = new int[journeyVO.getStaff().length];
		for (int i = 0; i < journeyVO.getStaff().length; i++) {
			staffIds[i] = Integer.parseInt(journeyVO.getStaff()[i]);
		}
		try {
			sfactory = HibernateSessionFactory.getSessionFactory();
			session = sfactory.openSession();
			session.beginTransaction();

			journeyDao = new JourneyDao();
			journeyId = journeyDao.saveJourney(session, journey);
			travelAgencyDao = new TravelAgencyDao();
			travelAgencyDao.addStaffAndBusToJourney(session, journeyId,
					Integer.parseInt(journeyVO.getBusNo()), staffIds);
			flag = true;
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				session.getTransaction().commit();
			} else {
				session.getTransaction().rollback();
			}
		}
	}

	public List<JourneyVO> getAllJourneys(final Date startDate,
			final Date endDate) {
		List<JourneyVO> journeyVOList = null;
		List<Journey> journeyList = null;
		SessionFactory sfactory = null;
		JourneyDao journeyDao = null;
		Session session = null;

		sfactory = HibernateSessionFactory.getSessionFactory();
		session = sfactory.openSession();
		journeyDao = new JourneyDao();
		journeyList = journeyDao.getJourneys(session, startDate, endDate);

		journeyVOList = new ArrayList<JourneyVO>();
		for (Journey journey : journeyList) {
			JourneyVO vo = new JourneyVO();
			vo.setJourneyId(String.valueOf(journey.getJourneyId()));
			vo.setSource(journey.getSource());
			vo.setDestination(journey.getDestination());
			vo.setDateOfJourney(new SimpleDateFormat("dd/MM/yyyy")
					.format(journey.getDateOfJourney()));
			journeyVOList.add(vo);
		}
		return journeyVOList;
	}

	public int newTicket(String passengerId, String journeyId) {
		JourneyDao journeyDao = null;
		SessionFactory sfactory = null;
		Session session = null;
		Ticket ticket = null;
		boolean flag = false;

		try {
			sfactory = HibernateSessionFactory.getSessionFactory();
			session = sfactory.openSession();
			session.beginTransaction();

			journeyDao = new JourneyDao();
			ticket = journeyDao.saveTicket(session,
					Integer.parseInt(passengerId), Integer.parseInt(journeyId));
			flag = true;
			return ticket.getTicketNo();
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				session.getTransaction().commit();
			} else {
				session.getTransaction().rollback();
			}
		}
		return 0;
	}

	public int newTicket(TicketVO ticketVO) {
		JourneyDao journeyDao = null;
		SessionFactory sfactory = null;
		Session session = null;
		Ticket ticket = null;
		Passenger passenger = null;
		boolean flag = false;

		try {
			sfactory = HibernateSessionFactory.getSessionFactory();
			session = sfactory.openSession();
			session.beginTransaction();

			passenger = new Passenger();
			passenger.setFirstNm(ticketVO.getFirstNm());
			passenger.setLastNm(ticketVO.getLastNm());
			passenger.setAge(Integer.parseInt(ticketVO.getAge()));
			passenger.setGender(ticketVO.getGender());

			ticket = new Ticket();
			ticket.setType("Sleeper");
			ticket.setSeatNo("R1");
			journeyDao = new JourneyDao();
			ticket = journeyDao.saveTicket(session, ticket, passenger,
					Integer.parseInt(ticketVO.getJourneyId()));
			flag = true;
			return ticket.getTicketNo();
		} catch (HibernateException he) {
			he.printStackTrace();
			flag = false;
		} finally {
			if (flag) {
				session.getTransaction().commit();
			} else {
				session.getTransaction().rollback();
			}
		}
		return 0;
	}

}
