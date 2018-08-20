package com.smi.tms.dao.impl;

import org.hibernate.Session;

import com.smi.tms.dao.TaskDAO;
import com.smi.tms.model.Task;
import com.smi.tms.util.HibernateUtil;

public class TaskDAOImpl implements TaskDAO {

	@Override
	public boolean insertTask(Task task) {
		try {
			HibernateUtil.getHibernateTemplate().saveOrUpdate(task);
			return true;
		} catch (Exception e) {
			return false;
		}

	}

	public void changeStatus(Integer id) {
		Session session = HibernateUtil.getHibernateTemplate().getSessionFactory().getCurrentSession();
		String status = (String) session.createQuery("SELECT t.status from Task t WHERE t.id = :id")
				.setParameter("id", id).getSingleResult();
		switch (status) {
		case "new":
			session.createQuery("UPDATE Task t SET t.status = 'InProgress' WHERE t.id = :id")
					.setParameter("id", id).executeUpdate();
			return;
		case "InProgress":
			session.createQuery("UPDATE Task t SET t.status = 'completed' WHERE t.id = :id")
					.setParameter("id", id).executeUpdate();
			return;
		case "Completed":
			session.createQuery("DELETE FROM Task t WHERE t.id = :id").setParameter("id", id)
					.executeUpdate();
		}
	}

}
