package com.jsc.dao;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import com.jsc.domain.User;
import com.jsc.utils.JdbcConnectionUtils;

public class UserDaoImpl implements UserDao {
	
	private static PreparedStatement ps;
	
	@Override
	public void add_User(User newUser) {
		try {
			int index = 1;
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" INSERT INTO user(username,password,type) VALUES(?,?,?) ");
			ps.setString(index++, newUser.getUsername());
			ps.setString(index++, newUser.getPassword());
			ps.setString(index++, newUser.getType());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void delete_User(int id) {
		try {
			int index = 1;
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" DELETE FROM user WHERE id = ? ");
			ps.setInt(index,id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void update_User(User user) {
		try {
			int index = 1;
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" UPDATE user SET username = ? , password = ? WHERE id = ? ");
			ps.setString(index++, user.getUsername());
			ps.setString(index++, user.getPassword());
			ps.setInt(index++, user.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public User login_System(User user) {
		try {
			int index= 1;
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" SELECT * FROM user WHERE username = ? AND password = ? ");
			ps.setString(index++, user.getUsername());
			ps.setString(index++, user.getPassword());
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int line = 1;
				user = new User(rs.getInt(line++), rs.getString(line++), rs.getString(line++), rs.getString(line++));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return user;
	}

	@Override
	public User getUserByUserId(int userId) {
		try {
			ps = JdbcConnectionUtils.getConnection().prepareStatement(" SELECT * FROM user WHERE id = ? ");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int line = 1;
				return new User(rs.getInt(line++), rs.getString(line++), rs.getString(line++), rs.getString(line++));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}
}
