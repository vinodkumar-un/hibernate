package com.gvl.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaValidator;

public class SchemaValidatorTest {
	public static void main(String[] args) {
		Configuration configuration = null;

		configuration = new Configuration()
				.configure("com/gvl/common/hibernate.cfg.xml");
		SchemaValidator validator = new SchemaValidator(configuration);
		validator.validate();
	}
}
