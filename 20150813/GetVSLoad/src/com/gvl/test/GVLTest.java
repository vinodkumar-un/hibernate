package com.gvl.test;

import com.gvl.dao.EventDao;
import com.gvl.util.HibernateUtil;

public class GVLTest {

	public static void main(String[] args) {
		EventDao dao = null;

		dao = new EventDao();
		dao.showEvent(1);
	}

}
