package com.smi.tms.service.impl;

import java.util.Arrays;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.dao.UserDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.RoleService;
import com.smi.tms.util.TMSCommonUtil;

@Service
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDAO employeeDAO;
	
	@Autowired
	UserDAO userDao;
	
	@Autowired
	RoleService roleService; 

	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		return employeeDAO.getEmployeeListByReportingToId(reportingToId);
	}

	public List<Task> getTaskListByEmpId(Integer empId) {
		return employeeDAO.getTaskListByEmpId(empId);
	}

	@Override
	@Transactional
	public boolean addEmployee(Employee employee) {
		User user = TMSCommonUtil.getUser();
		employee.setReportingTo(user.getEmployee());
		employee.setIsActive(1);
		employee.setCreatedBy(user.getEmployee().getFirstName());
		employee.setCreatedOn(new Date());
		
		/*employee.setFirstName(employee.getFirstName());
		employee.setLastName(employee.getLastName());
		employee.setDesignation(employee.getDesignation());
		employee.setDepartment(employee.getDepartment());
		if(employee.getId() == null || employee.getId() == 0)
		{
		employee.setCreatedBy(user.getEmployee().getFirstName());
		employee.setCreatedOn(new Date());
		}*/
		
		//Save Employee
		//employeeDAO.addEmployee(employee);
		
		User empUser = new User();
		empUser.setUserName(employee.getEmailAddress());
		empUser.setPassword(TMSCommonUtil.DEFAULT_PASSWORD);
		empUser.setIsActive(1);
		empUser.setCreatedOn(new Date());
		empUser.setCreatedBy(user.getEmployee().getFirstName());
		empUser.setEmployee(employee);
		
		if(employee.getRole() != null) {
			Role role = roleService.getRoleById(employee.getRole().getId());
			empUser.setRole(Arrays.asList(role));
		}
		
		userDao.saveUser(empUser);
		return true;
		
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
		Employee employee = employeeDAO.getEmployeeById(empId);
		employee.setRole(roleService.getRoleByEmpId(empId));
		return employee;
	}

}
