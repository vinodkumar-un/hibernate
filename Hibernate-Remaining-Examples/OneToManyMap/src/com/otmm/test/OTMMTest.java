package com.otmm.test;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import com.otmm.entities.Staff;
import com.otmm.entities.TravelAgency;

public class OTMMTest {
	public static void main(String[] args) {
		Configuration configuration = new Configuration()
				.configure("com/otmm/common/hibernate.cfg.xml");
		SessionFactory sfactory = configuration.buildSessionFactory();
		Session session = sfactory.openSession();

		/*
		 * session.beginTransaction(); Staff staff = new Staff();
		 * staff.setStaffName("John"); staff.setDesignation("Programmer");
		 * staff.setGender("Male"); staff.setAge(22); session.save(staff);
		 * 
		 * TravelAgency ta = new TravelAgency();
		 * ta.setTravelAgencyName("Kaleswara"); ta.setEstablishedDate(new
		 * Date()); ta.setMobile("2322323");
		 * 
		 * Integer id = staff.getStaffId(); Map<Integer, Staff> staffMap = new
		 * HashMap<Integer, Staff>(); staffMap.put(id, staff);
		 * 
		 * ta.setStaff(staffMap); session.save(ta);
		 * 
		 * session.getTransaction().commit();
		 */

		TravelAgency ta = (TravelAgency) session.get(TravelAgency.class, 1);
		System.out.println("TravelAgency name : " + ta.getTravelAgencyName());
		Map<Integer, Staff> staff = ta.getStaff();
		for (Integer key : staff.keySet()) {
			System.out.println("Staff Name : " + staff.get(key).getStaffName());
		}
		sfactory.close();

	}
}
