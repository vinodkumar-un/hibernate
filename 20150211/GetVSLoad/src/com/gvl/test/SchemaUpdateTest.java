package com.gvl.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaUpdate;

public class SchemaUpdateTest {
	public static void main(String[] args) {
		Configuration configuration = null;

		configuration = new Configuration()
				.configure("com/gvl/common/hibernate.cfg.xml");
		SchemaUpdate update = new SchemaUpdate(configuration);
		update.execute(true, true);
	}
}
