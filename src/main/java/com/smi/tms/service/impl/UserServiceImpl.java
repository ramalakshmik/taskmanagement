package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.UserDAO;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.UserService;

@Service
public class UserServiceImpl implements UserService {

	@Autowired
	UserDAO userDAO;

	public List<User> getUsersById(int empId) {
		return userDAO.getUsersById(empId);
	}

	public List<Task> getTasksById(int empId) {
		return userDAO.getTasksById(empId);
	}

}
