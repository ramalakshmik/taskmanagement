package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smi.tms.dao.UserDAO;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.util.HibernateUtil;

@Component
public class UserDAOImpl implements UserDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersById(int empId) {

		return (List<User>) HibernateUtil.getHibernateTemplate().find(
				"FROM User WHERE reporting_to=?", empId);

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Task> getTasksById(int empId) {
		return (List<Task>) HibernateUtil.getHibernateTemplate().find(
				"FROM Task WHERE assigned_to = ?", empId);
	}

}
