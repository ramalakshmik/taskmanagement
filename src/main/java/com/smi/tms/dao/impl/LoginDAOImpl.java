package com.smi.tms.dao.impl;

import java.util.List;

import com.smi.tms.dao.LoginDAO;
import com.smi.tms.model.User;
import com.smi.tms.util.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {

	public User getActiveUser(String userName) {
		User user = new User();

		short enabled = 1;
		List<?> list = HibernateUtil.getHibernateTemplate().find(
				"FROM User WHERE userName=? and isActive=?", userName, enabled);
		if (!list.isEmpty()) {
			user = (User) list.get(0);
		}
		return user;

	}

	public User getUser(String userName, String password) {

		User user = new User();

		List<?> list = HibernateUtil.getHibernateTemplate()
				.find("FROM User WHERE userName=? and password=?", userName,
						password);
		if (!list.isEmpty()) {
			user = (User) list.get(0);
		}
		return user;

		
		 /*String queryS = "SELECT u FROM User u where u.userName='" + userName
		 + "' and u.password='" + password + "'"; User user = (User)
		 HibernateUtil.getHibernateTemplate().execute( new
		 HibernateCallback<Object>() {
		 
		 @Override public Object doInHibernate(Session session) throws
		 HibernateException, SQLException { Query query =
		 session.createQuery(queryS); return query.uniqueResult(); } });
		 return user;*/
		 
	}
}
