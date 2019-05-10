package com.jsc.crud.utils;


import javax.sql.DataSource;

import org.apache.commons.dbutils.QueryRunner;

import com.mysql.jdbc.jdbc2.optional.MysqlConnectionPoolDataSource;

public class DBUtil {

	private static MysqlConnectionPoolDataSource datasSource;
	private static QueryRunner runner;
	
	static {
		datasSource = new MysqlConnectionPoolDataSource();
		datasSource.setUrl("jdbc:mysql://127.0.0.1/db_web?useUnicode=true&characterEncoding=UTF8&useSSL=false&user=root&password=yuan123456");
		runner = new QueryRunner();
	}
	
	public static DataSource getDS() {
		return datasSource;
	}
	
	public static QueryRunner getQR() {
		return runner;
	}
	
}
