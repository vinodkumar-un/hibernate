package com.fh.bean;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

import com.fh.entities.Product;

public class JdbcProductBean {

	public void addProduct(Product product) throws SQLException {
		Connection con = null;
		Statement stmt = null;

		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			con = DriverManager.getConnection(
					"jdbc:oracle:thin:@localhost:1521:xe", "hib20150211_user",
					"welcome1");
			stmt = con.createStatement();
			String sql = "INSERT INTO PRODUCT(PRODUCT_ID, PRODUCT_NM, DESCR, AMOUNT) VALUES("
					+ product.getProductId()
					+ ",'"
					+ product.getName()
					+ "','"
					+ product.getDescription()
					+ "','"
					+ product.getAmount()
					+ "')";
			System.out.println(sql);
			int affectedRecords = stmt.executeUpdate(sql);
			System.out.println("affected rows : " + affectedRecords);
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} finally {
			if (stmt != null) {
				stmt.close();
			}
			if (con != null) {
				con.close();
			}
		}
	}
}
