package com.smi.tms.service.impl;

import java.util.List;

import org.hibernate.type.TrueFalseType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;

	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		return employeeDAO.getEmployeeListByReportingToId(reportingToId);
	}

	public List<Task> getTaskListByEmpId(Integer empId) {
		return employeeDAO.getTaskListByEmpId(empId);
	}

	@Override
	@Transactional
	public boolean addEmployee(Employee employee) {
 		return employeeDAO.addEmployee(employee);
	}

	@Override
	public Task getLastAssignedTaskBy(Integer empId) {
		return employeeDAO.getLastAssignedTaskBy(empId);
	}

	@Override
	public List<Employee> getreportingToList() {
		return employeeDAO.getreportingToList();
	}

	@Override
	@Transactional(readOnly = true)
	public Employee getEmployeeById(Integer empId) {
		// TODO Auto-generated method stub
		return employeeDAO.getEmployeeById(empId);
	}

}
