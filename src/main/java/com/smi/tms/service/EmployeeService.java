package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;

public interface EmployeeService {

	List<Employee> getEmployeeListByReportingToId(Integer reportingToId);
	
	List<Task> getTaskListByEmpId(Integer empId);
	
	boolean addEmployee(Employee employee);
	
	Task getLastAssignedTaskBy(Integer empId);
	
	List<Employee> getreportingToList();

	Employee getEmployeeById(Integer empId);
	
	boolean emailExists(String emailId, Integer empId);

}
