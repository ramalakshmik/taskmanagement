package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;

public interface EmployeeService {

	List<Employee> getEmployeeListByReportingToId(Integer reportingToId);
	
	List<Task> getTaskListByEmpId(Integer empId);
	
	boolean addEmployee(Employee employee);
	
	Task getLastAssignedTaskBy(Integer empId);

}
