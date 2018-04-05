package com.cs.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;

import com.cs.entities.Member;
import com.cs.helper.HibernateSessionFactory;

public class MemberDao {

	public void saveMember(Member member) {
		SessionFactory sessionFactory = null;
		Session session = null;

		// session = SessionFactory.getSession();
		sessionFactory = HibernateSessionFactory.getSessionFactory();
		session = sessionFactory.getCurrentSession();
		session.beginTransaction();
		session.save(member);
		session.getTransaction().commit();
	}

	public Member findMember(int id) {
		// return (Member) SessionFactory.getSession().get(Member.class, id);
		try {
			/*HibernateSessionFactory.getSessionFactory().getCurrentSession()
					.beginTransaction();*/
			((Member) HibernateSessionFactory.getSessionFactory()
					.getCurrentSession().get(Member.class, id)).getFirstNm();
			return (Member) HibernateSessionFactory.getSessionFactory()
					.getCurrentSession().get(Member.class, id);
		} finally {
			/*HibernateSessionFactory.getSessionFactory().getCurrentSession()
					.getTransaction().commit();*/
		}
	}

}
