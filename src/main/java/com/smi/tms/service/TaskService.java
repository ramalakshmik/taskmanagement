package com.smi.tms.service;

import com.smi.tms.model.Task;

public interface TaskService {

	boolean insertTask(Task task);
	void changeStatus(Integer id);
}
