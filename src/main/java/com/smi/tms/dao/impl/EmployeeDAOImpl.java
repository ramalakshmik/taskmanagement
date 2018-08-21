package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.util.HibernateUtil;

public class EmployeeDAOImpl implements EmployeeDAO{

	@Override
	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<Task> getTaskListByEmpId(Integer id) {
		HibernateTemplate template = HibernateUtil.getHibernateTemplate();
		Employee employee = template.get(Employee.class, id);
		if(employee!= null && employee.getTaskList() != null && employee.getTaskList().size()!=0) {
			return employee.getTaskList();
		}
		return null;
	}


}
