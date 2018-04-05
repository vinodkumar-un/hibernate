package com.mtm.test;

import java.util.HashSet;
import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtm.entities.User;
import com.mtm.entities.Property;
import com.mtm.util.HibernateUtil;

public class MTMSetTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Set<User> owners = null;
		Property property = null;
		User user = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * owners = new HashSet<User>();
		 * 
		 * user = new User(); user.setFirstName("David"); user.setLastName("A");
		 * user.setMobile("111111111"); user.setEmail("david@gmail.com");
		 * owners.add(user);
		 * 
		 * user = new User(); user.setFirstName("Sam"); user.setLastName("B");
		 * user.setMobile("222222222222"); user.setEmail("sam@gmail.com");
		 * owners.add(user);
		 * 
		 * property = new Property(); property.setDescription("Duplex");
		 * property.setType("Building"); property.setLocation("Ameerpet");
		 * property.setPrice(29382623f); property.setOwners(owners);
		 * 
		 * session.save(property);
		 */
		property = (Property) session.get(Property.class, 1);
		property.setDescription("Premium Duplex");
		session.update(property);
		
		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();

	}
}

