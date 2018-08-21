package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.LoginService;

@Service
public class EmployeeServiceImpl implements EmployeeService{

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Override
	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTaskListByEmpId(Integer empId) {
		return employeeDAO.getTaskListByEmpId(empId);
	}

}
