package com.jsc.crud.dao;

import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import com.jsc.crud.domain.User;
import com.jsc.crud.utils.JdbcUtils;

public class UserDaoImpl implements UserDao{
	
	private static PreparedStatement ps;
	
	@Override
	public void addUser(User user) {
		int index = 1;
		try {
			ps = JdbcUtils.getConnection().prepareStatement(" INSERT INTO User(name,work_exp,sex,header_img,birthDay) VALUES(?,?,?,?,?) ");
			ps.setString(index++, user.getName());
			ps.setDouble(index++, user.getWorkExperiencesex());
			ps.setInt(index++, user.getSex());
			ps.setString(index++, user.getHeaderImg());
			ps.setString(index++, user.getBirthDay());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteSingleUser(int id) {
		try {
			ps = JdbcUtils.getConnection().prepareStatement(" DELETE FROM User WHERE id = ? ");
			ps.setInt(1, id);
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}
	
	@Override
	public void deleteMoreUser(String[] userIds) {
		try {
			for(String userId:userIds) {
				ps = JdbcUtils.getConnection().prepareStatement(" DELETE FROM User WHERE id = ? ");
				ps.setInt(1, Integer.parseInt(userId));
				ps.executeUpdate();
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public void updateUser(User user) {
		try {
			int index = 1;
			ps = JdbcUtils.getConnection().prepareStatement(" UPDATE User SET name = ?,work_exp = ?,sex = ?,header_img = ?,birthDay = ? WHERE id = ? ");
			ps.setString(index++, user.getName());
			ps.setDouble(index++, user.getWorkExperiencesex());
			ps.setInt(index++, user.getSex());
			ps.setString(index++, user.getHeaderImg());
			ps.setString(index++, user.getBirthDay());
			ps.setInt(index++, user.getId());
			ps.executeUpdate();
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
	}

	@Override
	public List<User> userList(String name, String sex, String workTimeStart, String workTimeEnd, String birthDayStart,
			String birthDayEnd, int page, int pageRow) {
		List<User> userList = new LinkedList<>();
		try {
			int index = 1;
			ps = JdbcUtils.getConnection().prepareStatement(" SELECT * FROM User WHERE name LIKE ? AND sex LIKE ? AND work_exp BETWEEN ? AND ? AND birthDay BETWEEN ? AND ? LIMIT ?,? ");
			ps.setString(index++, name);
			ps.setString(index++, sex);
			ps.setDouble(index++, Double.valueOf(workTimeStart));
			ps.setDouble(index++, Double.valueOf(workTimeEnd));
			ps.setDate(index++, Date.valueOf(birthDayStart));
			ps.setDate(index++, Date.valueOf(birthDayEnd));
			ps.setInt(index++, (page - 1) * pageRow);
			ps.setInt(index++, pageRow);
			ResultSet rs = ps.executeQuery();
			while(rs.next()) {
				int line = 1;
				userList.add(new User(rs.getInt(line++), rs.getString(line++), rs.getDouble(line++), rs.getInt(line++), rs.getString(line++), rs.getString(line++), rs.getDate(line++), rs.getDate(line++)));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return userList;
	}

	@Override
	public int getMaxPage(String name, String sex, double workTimeStart, double workTimeEnd, String birthDayStart, String birthDayEnd) {
		int maxPage = 0;
		try {
			int index = 1;
			ps = JdbcUtils.getConnection().prepareStatement(" SELECT * FROM User WHERE name LIKE ? AND sex LIKE ? AND work_exp BETWEEN ? AND ? AND birthDay BETWEEN ? AND ? ");
			ps.setString(index++, name);
			ps.setString(index++, sex);
			ps.setDouble(index++, workTimeStart);
			ps.setDouble(index++, workTimeEnd);
			ps.setDate(index++, Date.valueOf(birthDayStart));
			ps.setDate(index++, Date.valueOf(birthDayEnd));
			ResultSet rs = ps.executeQuery();
			rs.last();
			maxPage = (int) Math.ceil((double)rs.getRow() / 20);
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return maxPage;
	}

	@Override
	public User getUserByUserId(int userId) {
		try {
			ps = JdbcUtils.getConnection().prepareStatement(" SELECT * FROM User WHERE id = ? ");
			ps.setInt(1, userId);
			ResultSet rs = ps.executeQuery();
			if(rs.next()) {
				int line = 1;
				return new User(rs.getInt(line++), rs.getString(line++), rs.getDouble(line++), rs.getInt(line++), rs.getString(line++), rs.getString(line++), rs.getDate(line++), rs.getDate(line++));
			}
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		return null;
	}

}
