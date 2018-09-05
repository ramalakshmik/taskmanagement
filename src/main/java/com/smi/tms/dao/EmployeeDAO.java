package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;

public interface EmployeeDAO {

	List<Employee> getEmployeeListByReportingToId(Integer reportingToId);

	List<Task> getTaskListByEmpId(Integer id);

	boolean addEmployee(Employee employee);

	Task getLastAssignedTaskBy(Integer empId);
	
	List<Employee> getreportingToList();
	
	Employee getEmployeeById(Integer empId);
}
