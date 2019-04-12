package com.jsc.service;

import com.jsc.dao.UserDao;
import com.jsc.dao.UserDaoImpl;
import com.jsc.domain.User;

public class UserServiceImpl implements UserService{

	private UserDao ud;
	
	public UserServiceImpl(){
		ud = new UserDaoImpl();
	}
	
	@Override
	public void add_User(User newUser) {
		ud.add_User(newUser);
	}

	@Override
	public void delete_User(int userId) {
		ud.delete_User(userId);
	}

	@Override
	public void update_User(User user) {
		ud.update_User(user);
	}

	@Override
	public User login_System(User user) {
		return ud.login_System(user);
	}

	@Override
	public User getUserByUserId(int userId) {
		return ud.getUserByUserId(userId);
	}
}
