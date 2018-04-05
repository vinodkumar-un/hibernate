package com.gvl.test;

import org.hibernate.cfg.Configuration;
import org.hibernate.tool.hbm2ddl.SchemaExport;

public class SchemaExportTest {
	public static void main(String[] args) {
		Configuration configuration = null;

		configuration = new Configuration()
				.configure("com/gvl/common/hibernate.cfg.xml");
		SchemaExport export = new SchemaExport(configuration);
		export.create(true, true);
	}
}
