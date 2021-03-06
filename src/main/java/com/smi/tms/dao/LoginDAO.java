package com.smi.tms.dao;

import com.smi.tms.model.User;

public interface LoginDAO {
	User getActiveUser(String userName);

	User getUser(String userName, String password);
	
	String encodePassword(String passwordToHash);

	void saveUser(User user);
	
	
}
