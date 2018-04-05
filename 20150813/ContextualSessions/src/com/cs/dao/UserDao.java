package com.cs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cs.entities.User;
import com.cs.util.HibernateUtil;

public class UserDao {
	public int saveUser(User user) {
		int userId = 0;
		Session session = null;
		SessionFactory sfactory = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.getCurrentSession();

		userId = (int) session.save(user);
		return userId;
	}
}
