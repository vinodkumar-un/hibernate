package com.mtm.test;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.mtm.entities.Agent;
import com.mtm.entities.Property;
import com.mtm.util.HibernateUtil;

public class MTMListTest {
	public static void main(String[] args) {
		SessionFactory sfactory = null;
		Session session = null;
		Property property = null;
		Agent agent = null;

		sfactory = HibernateUtil.getSessionFactory();
		session = sfactory.openSession();
		session.beginTransaction();

		/*
		 * agent = new Agent(); agent.setFirstName("Rohan");
		 * agent.setLastName("X"); agent.setDesignation("Sales Manager");
		 * agent.setMobile("373937373"); agent.setEmail("rohan@gmail.com");
		 * 
		 * property = createProperty("Duplex", "Building", "Kondapur",
		 * 34793733f);
		 * 
		 * List<Property> properties = new ArrayList<Property>();
		 * properties.add(property); agent.setProperties(properties);
		 * 
		 * List<Agent> agents = new ArrayList<Agent>(); agents.add(agent);
		 * property.setAgents(agents);
		 */

		/*
		 * agent = (Agent) session.get(Agent.class, 3); List<Property>
		 * properties = agent.getProperties(); for (Property prop : properties)
		 * { System.out.println(prop.getPropertyId()); }
		 */
		System.out.println("****************");
		property = (Property) session.get(Property.class, 1);
		List<Agent> agents = property.getAgents();
		for (Agent ag : agents) {
			if (ag != null) {
				System.out.println(ag.getAgentId());
			}
		}

		session.getTransaction().commit();
		HibernateUtil.closeSessionFactory();
	}

	private static Property createProperty(String descr, String type,
			String location, float price) {
		Property property = null;

		property = new Property();
		property.setDescription(descr);
		property.setType(type);
		property.setLocation(location);
		property.setPrice(price);

		return property;
	}

}
