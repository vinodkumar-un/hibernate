package com.hsf.test;

import com.hsf.dao.UserDao;

public class HSFTest {
	public static void main(String[] args) {
		UserDao userDao = null;

		userDao = new UserDao();
		userDao.saveUser(1, "David", "Keys", "+91983872", "david@gmail.com",
				"S.R Nagar", "Opp Signals", "hyderabad", "ts", 3535, "India");
	}
}
