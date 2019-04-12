package com.jsc.utils;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import javax.sql.rowset.CachedRowSet;
import javax.sql.rowset.RowSetProvider;

import com.jsc.domain.User;

public class PagingUtils {

	private static ResultSet rs;
	private static CachedRowSet crs;
	public static List<?> getUserList(int line) {
		List<User> userList = new LinkedList<>();
		try {
			rs = JdbcConnectionUtils.getConnection().createStatement(ResultSet.TYPE_SCROLL_SENSITIVE,ResultSet.CONCUR_READ_ONLY).executeQuery(" SELECT * FROM user ");
			crs = RowSetProvider.newFactory().createCachedRowSet();
			crs.setPageSize(5);
			crs.populate(rs, line);
			while(crs.next()) {
				int list = 1;
				userList.add(new User(crs.getInt(list++), crs.getString(list++), crs.getString(list++), crs.getString(list++)));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}
}
