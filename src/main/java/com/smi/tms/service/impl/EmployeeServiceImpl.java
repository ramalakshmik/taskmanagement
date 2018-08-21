package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		return employeeDAO.getEmployeeListByReportingToId(reportingToId);
	}

	public List<Task> getTaskListByEmpId(Integer empId) {
		return employeeDAO.getTaskListByEmpId(empId);
	}

}
