package com.jsc.crud.service;

import java.util.List;

import com.jsc.crud.domain.User;

public interface UserService {

	void addUser(User user);
	void deleteSingleUser(int id);
	void deleteMoreUser(String[] userIds);
	void updateUser(User user);
	List<User> userList(String name,String sex,String workTimeStart,String workTimeEnd,String birthDayStart,String birthDayEnd,int page,int pageRow);
	int getMaxPage(String name, String sex, double workTimeStart, double workTimeEnd, String birthDayStart,String birthDayEnd);
	User getUserByUserId(int userId);
	
}
