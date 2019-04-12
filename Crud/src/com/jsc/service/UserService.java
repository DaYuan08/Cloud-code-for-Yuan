package com.jsc.service;

import com.jsc.domain.User;

public interface UserService {

	void add_User(User newUser);
	void delete_User(int userId);
	void update_User(User user);
	User getUserByUserId(int userId);
	User login_System(User user);
}
