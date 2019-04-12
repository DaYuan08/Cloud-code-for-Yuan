package com.jsc.dao;

import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.text.SimpleDateFormat;

import com.jsc.domain.UserHistory;
import com.jsc.utils.JdbcConnectionUtils;

public class UserHistoryDaoImpl implements UserHistoryDao {


	private static PreparedStatement ps;
	@Override
	public void add_UserHistory(UserHistory history) {
		try {
			int index = 1;
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" INSERT INTO userHistory(userId,username,password,type,operator_User,last_Modified_Time) VALUES(?,?,?,?,?,?) ");
			ps.setInt(index++, history.getUserId());
			ps.setString(index++, history.getUsername());
			ps.setString(index++, history.getPassword());
			ps.setString(index++, history.getType());
			ps.setString(index++, history.getOperator_User());
			ps.setString(index++, new SimpleDateFormat("yyyy-MM-dd hh:mm:ss").format(history.getLast_Modified_Time()));
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
}
