package com.cs.dao;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cs.entities.Property;
import com.cs.entities.User;
import com.cs.util.HibernateUtil;

public class PropertyDao {
	public void saveProperty(Property property, int userId) {
		User user = null;
		Session session = null;
		SessionFactory sfactory = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.getCurrentSession();

		user = (User) session.load(User.class, userId);
		Set<User> users = new HashSet<User>();
		users.add(user);
		property.setUsers(users);
		session.save(property);
	}
}
