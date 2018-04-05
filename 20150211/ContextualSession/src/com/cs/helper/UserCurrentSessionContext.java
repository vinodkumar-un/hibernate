package com.cs.helper;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.context.spi.CurrentSessionContext;
import org.hibernate.engine.spi.SessionFactoryImplementor;

/**
 * User defined CurrentSessionContext Maintains Session as singleton
 */
public class UserCurrentSessionContext implements CurrentSessionContext {
	private Session session;
	private SessionFactoryImplementor sessionFactoryImplementor;

	public UserCurrentSessionContext(
			SessionFactoryImplementor sessionFactoryImplementor) {
		this.sessionFactoryImplementor = sessionFactoryImplementor;
	}

	@Override
	public Session currentSession() throws HibernateException {
		if (session == null || session.isOpen() == false) {
			session = sessionFactoryImplementor.openSession();
		}
		return session;
	}

}
