package com.smi.tms.dao.impl;

import java.util.List;

import org.hibernate.query.Query;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.smi.tms.dao.EmployeeDAO;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.util.Constants;
import com.smi.tms.util.HibernateUtil;

@Component
public class EmployeeDAOImpl implements EmployeeDAO {

	@SuppressWarnings("unchecked")
	public List<Employee> getEmployeeListByReportingToId(Integer reportingToId) {
		return (List<Employee>) HibernateUtil.getHibernateTemplate().find(
				"FROM Employee WHERE reporting_to=?", reportingToId);

	}

	@SuppressWarnings("unchecked")
	public List<Task> getTaskListByEmpId(Integer id) {
		/*
		 * HibernateTemplate template = HibernateUtil.getHibernateTemplate();
		 * Employee employee = template.get(Employee.class, id); if(employee!=
		 * null && employee.getTaskList() != null &&
		 * employee.getTaskList().size()!=0) { return employee.getTaskList(); }
		 * return null;
		 */

		/*
		 * List<?> taskList =
		 * HibernateUtil.getHibernateTemplate().findByNamedParam
		 * ("FROM Task WHERE assigned_to=:id", "id", id); return (List<Task>)
		 * taskList;
		 */

		return (List<Task>) HibernateUtil.getHibernateTemplate().find(
				"FROM Task WHERE assigned_to= ?", id);
	}

	public boolean addEmployee(Employee employee) {
		try {
			// Session session =
			// HibernateUtil.getHibernateTemplate().getSessionFactory().getCurrentSession();
			// session.setHibernateFlushMode(FlushMode.AUTO);
			HibernateTemplate hibernateTemplate = HibernateUtil
					.getHibernateTemplate();
			hibernateTemplate.setCheckWriteOperations(false);
			hibernateTemplate.saveOrUpdate(employee);
			// hibernateTemplate.setCheckWriteOperations(false);
			// session.saveOrUpdate(employee);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	@Override
	public Task getLastAssignedTaskBy(Integer empId) {
		// TODO Auto-generated method stub
		return null;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Employee> getreportingToList() {
		return (List<Employee>) HibernateUtil
				.getHibernateTemplate()
				.find("select e FROM User u inner join u.employee e inner join"
						+ " u.role r WHERE r.role=?", Constants.PROJECT_MANAGER);
	}

	@Override
	public Employee getEmployeeById(Integer empId) {
		return (Employee) HibernateUtil.getHibernateTemplate().get(
				Employee.class, empId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public boolean emailExists(String emailId, Integer empId) {
		Employee employee = null;
		try {
			Query<Employee> query = null;
			if (empId == null || empId == 0) {
				query = HibernateUtil.getHibernateTemplate().getSessionFactory()
						.getCurrentSession().createQuery(
								"select e FROM Employee e WHERE e.emailAddress=?");
				query.setParameter(0, emailId); 
			} else {
				query = HibernateUtil.getHibernateTemplate().getSessionFactory()
						.getCurrentSession().createQuery(
								"select e FROM Employee e WHERE e.emailAddress=? and e.id <>?");
				query.setParameter(0, emailId);
				query.setParameter(1, empId);
			}
			employee = query.uniqueResult();
			return employee == null ? false : true;
		} catch (Exception e) {
			return false;
		}

	}

}
