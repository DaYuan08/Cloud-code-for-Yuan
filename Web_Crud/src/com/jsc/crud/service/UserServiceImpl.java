package com.jsc.crud.service;

import java.util.List;

import com.jsc.crud.dao.UserDao;
import com.jsc.crud.dao.UserDaoImpl;
import com.jsc.crud.domain.User;

public class UserServiceImpl implements UserService {

	private static UserDao ud;
	
	public UserServiceImpl() {
		ud = new UserDaoImpl();
	}
	
	@Override
	public void addUser(User user) {
		ud.addUser(user);
	}

	@Override
	public void deleteSingleUser(int id) {
		ud.deleteSingleUser(id);
	}
	
	@Override
	public void deleteMoreUser(String[] userIds) {
		ud.deleteMoreUser(userIds);
	}

	@Override
	public void updateUser(User user) {
		ud.updateUser(user);
	}

	@Override
	public List<User> userList(String name, String sex, String workTimeStart, String workTimeEnd, String birthDayStart,
			String birthDayEnd, int page, int pageRow) {
		return ud.userList(name, sex, workTimeStart, workTimeEnd, birthDayStart, birthDayEnd, page, pageRow);
	}

	@Override
	public int getMaxPage(String name, String sex, double workTimeStart, double workTimeEnd, String birthDayStart,
			String birthDayEnd) {
		return ud.getMaxPage(name, sex, workTimeStart, workTimeEnd, birthDayStart, birthDayEnd);
	}

	@Override
	public User getUserByUserId(int userId) {
		return ud.getUserByUserId(userId);
	}

}
