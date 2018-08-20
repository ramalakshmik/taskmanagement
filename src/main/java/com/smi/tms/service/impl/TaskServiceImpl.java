package com.smi.tms.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.TaskDAO;
import com.smi.tms.model.Task;
import com.smi.tms.service.TaskService;

@Service
public class TaskServiceImpl implements TaskService {
	@Autowired
	TaskDAO taskDAO;

	@Transactional
	public boolean insertTask(Task task) {
		return taskDAO.insertTask(task);
	}

	@Transactional
	public void changeStatus(Integer id) {
		taskDAO.changeStatus(id);
	}

}
