package com.smi.tms.service;

import com.smi.tms.model.User;

public interface LoginService {
	User getActiveUser(String userName);
	User getUser(String userName, String password);
}
