package com.smi.tms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.TaskDAO;
import com.smi.tms.model.Task;
import com.smi.tms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskDAO taskDAO;

	public void insertTask(Task task) {
		taskDAO.insertTask(task);
	}

}
