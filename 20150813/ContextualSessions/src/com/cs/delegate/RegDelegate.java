package com.cs.delegate;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.context.internal.ManagedSessionContext;

import com.cs.dao.PropertyDao;
import com.cs.dao.UserDao;
import com.cs.entities.Property;
import com.cs.entities.User;
import com.cs.util.HibernateUtil;

public class RegDelegate {
	public void reg() {
		boolean flag = false;
		User user = null;
		UserDao userDao = null;
		Property property = null;
		PropertyDao propertyDao = null;
		Session session = null;
		SessionFactory sfactory = null;
		Transaction transaction = null;

		try {
			sfactory = HibernateUtil.getSessionFactory();
			session = sfactory.openSession();
			ManagedSessionContext.bind(session);
			transaction = session.beginTransaction();

			user = new User();
			user.setFirstName("John");
			user.setLastName("J");
			user.setGender("Male");
			user.setAge(25);
			userDao = new UserDao();
			int userId = userDao.saveUser(user);
			property = new Property();
			property.setDescription("3 BHK Flat");
			property.setType("Flat");
			property.setPrice(393733.0f);
			// property.setLocation("Ameerpet");
			propertyDao = new PropertyDao();
			propertyDao.saveProperty(property, userId);
			flag = true;
		} finally {
			if (transaction != null) {
				if (flag) {
					transaction.commit();
				} else {
					transaction.rollback();
				}
				ManagedSessionContext.unbind(sfactory);
			}
		}
	}
}
