package com.jsc.dao;

import com.jsc.domain.User;

public interface UserDao {

	void add_User(User newUser);
	void delete_User(int userId);
	void update_User(User user);
	User getUserByUserId(int userId);
	User login_System(User user);
}
