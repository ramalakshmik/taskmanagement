package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;

public interface EmployeeDAO {

	List<Employee> getEmployeeListByReportingToId(Integer reportingToId);

	List<Task> getTaskListByEmpId(Integer id);

	boolean addEmployee(Employee employee);

	Task getLastAssignedTaskBy(Integer empId);
}
