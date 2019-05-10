package com.jsc.crud.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class JdbcUtils {

	private static Connection c;
	public static synchronized Connection getConnection() throws ClassNotFoundException, SQLException {
		if(c == null) {
			Class.forName("com.mysql.jdbc.Driver");
			c = DriverManager.getConnection("jdbc:mysql://localhost:3306/db_web","root","yuan123456");
		}
		return c;
	}
}
