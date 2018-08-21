package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.util.HibernateUtil;

@Component
public class EmployeeDAOImpl implements EmployeeDAO{

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		return (List<Employee>) HibernateUtil.getHibernateTemplate().find(
				"FROM Employee WHERE reporting_to=?", reportingToId);

	}

	public List<Task> getTaskListByEmpId(Integer id) {
		/*
		 * HibernateTemplate template = HibernateUtil.getHibernateTemplate();
		 * Employee employee = template.get(Employee.class, id); if(employee!=
		 * null && employee.getTaskList() != null &&
		 * employee.getTaskList().size()!=0) { return employee.getTaskList(); }
		 * return null;
		 */
		return (List<Task>) HibernateUtil.getHibernateTemplate().find(
				"FROM Task WHERE assigned_to=?", id);
	}


}
