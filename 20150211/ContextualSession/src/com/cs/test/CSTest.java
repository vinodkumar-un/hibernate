package com.cs.test;

import java.util.Date;

import org.hibernate.Session;
import org.hibernate.context.internal.ManagedSessionContext;

import com.cs.dao.MemberDao;
import com.cs.entities.Member;
import com.cs.helper.HibernateSessionFactory;

public class CSTest {
	public static void main(String[] args) {
		Member member = null;
		MemberDao memberDao = null;

		memberDao = new MemberDao();
		/*
		 * member = new Member(); member.setId(2); member.setFirstNm("Rama");
		 * member.setLastNm("D"); member.setDob(new Date());
		 * memberDao.saveMember(member);
		 */
		/*Session session = HibernateSessionFactory.getSessionFactory()
				.openSession();
		ManagedSessionContext.bind(session);*/

		Member member1 = memberDao.findMember(2);
		System.out.println(member1.getFirstNm());
		/*ManagedSessionContext.unbind(HibernateSessionFactory
				.getSessionFactory());
		session.close();*/
		HibernateSessionFactory.getSessionFactory().close();
	}
}
