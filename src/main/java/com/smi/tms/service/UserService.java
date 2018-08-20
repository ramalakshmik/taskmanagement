package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Task;
import com.smi.tms.model.User;

public interface UserService {

	List<User> getUsersById(int empId);

	List<Task> getTasksById(int empId);

}
