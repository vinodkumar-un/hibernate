package com.idg.custom;

import java.io.Serializable;
import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.Properties;

import org.hibernate.HibernateException;
import org.hibernate.MappingException;
import org.hibernate.dialect.Dialect;
import org.hibernate.engine.spi.SessionImplementor;
import org.hibernate.id.Configurable;
import org.hibernate.id.IdentifierGenerator;
import org.hibernate.type.Type;

public class AgentIDGenerator implements IdentifierGenerator, Configurable {
	private Properties params;
	private Dialect dialect;

	@Override
	public Serializable generate(SessionImplementor session, Object object)
			throws HibernateException {
		Connection con = null;
		Statement stmt = null;
		ResultSet rs = null;
		String orgPrefix = null;
		int agentId = 0;

		System.out.println("generate...");
		try {
			con = session.connection();
			stmt = con.createStatement();
			rs = stmt
					.executeQuery("SELECT AGENT_ID_SEQUENCE.NEXTVAL FROM DUAL");
			if (rs.next()) {
				agentId = rs.getInt(1);
			}
		} catch (SQLException e) {

		}
		orgPrefix = params.getProperty("org-code");
		return orgPrefix + agentId;
	}

	@Override
	public void configure(Type paramType, Properties paramProperties,
			Dialect paramDialect) throws MappingException {
		System.out.println("configure...");
		this.params = paramProperties;
		this.dialect = paramDialect;
	}

}
