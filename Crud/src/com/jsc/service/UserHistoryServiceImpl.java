package com.jsc.service;

import com.jsc.dao.UserHistoryDao;
import com.jsc.dao.UserHistoryDaoImpl;
import com.jsc.domain.UserHistory;

public class UserHistoryServiceImpl implements UserHistoryService {

	private static UserHistoryDao uhd;
	
	public UserHistoryServiceImpl() {
		uhd = new UserHistoryDaoImpl();
	}
	
	@Override
	public void add_UserHistory(UserHistory history) {
		uhd.add_UserHistory(history);
	}

}
