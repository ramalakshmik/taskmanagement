package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Task;
import com.smi.tms.model.User;

public interface UserDAO {

	
	List<User> getUsersById(int empId);

	List<Task> getTasksById(int empId);

	void saveUser(User user);
}
