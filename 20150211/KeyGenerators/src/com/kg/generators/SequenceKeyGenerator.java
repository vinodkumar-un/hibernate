package com.kg.generators;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import org.hibernate.HibernateException;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.IdentifierGenerator;

public class SequenceKeyGenerator implements IdentifierGenerator {

	@Override
	public Serializable generate(SessionImplementor session, Object entity)
			throws HibernateException {
		Connection con = null;
		Statement statement = null;
		ResultSet rs = null;
		Integer key = null;

		try {
			con = session.connection();
			statement = con.createStatement();
			rs = statement
					.executeQuery("SELECT CITIZEN_ID_SEQUENCE.NEXTVAL FROM DUAL");
			if (rs.next()) {
				key =  rs.getInt(1);
			}
		} catch (SQLException sqe) {
			sqe.printStackTrace();
			throw new HibernateException(sqe);
		}
		return key;
	}

}
