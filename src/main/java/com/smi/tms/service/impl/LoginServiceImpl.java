package com.smi.tms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.LoginDAO;
import com.smi.tms.model.User;
import com.smi.tms.service.LoginService;

@Service
public class LoginServiceImpl implements LoginService {

	@Autowired
	LoginDAO loginDAO;

	@Override
	public User getActiveUser(String userName) {
		return loginDAO.getActiveUser(userName);
	}

	@Override
	@Transactional
	public User getUser(String userName, String password) {
		return loginDAO.getUser(userName, password);
	}

	@Override
	public String encodePassword(String passwordToHash) {
		return loginDAO.encodePassword(passwordToHash);
	}

}
