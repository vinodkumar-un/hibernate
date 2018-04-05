package com.bs.test;

import java.util.Date;

import com.bs.dao.EventDao;
import com.bs.util.HibernateUtil;

public class BSTest {
	public static void main(String[] args) {
		EventDao eventDao = new EventDao();
		eventDao.saveEvent(1, new Date(), "Hibernate Bootstrapping Discussion",
				2, 450);
		HibernateUtil.closeSessionFactory();
	}
}
