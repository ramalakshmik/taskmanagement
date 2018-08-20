package com.smi.tms.dao;

import com.smi.tms.model.Task;

public interface TaskDAO {

	boolean insertTask(Task task);
	void changeStatus(Integer id);
}
