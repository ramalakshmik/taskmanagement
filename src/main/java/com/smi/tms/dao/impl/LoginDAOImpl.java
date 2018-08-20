package com.smi.tms.dao.impl;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.List;

import com.smi.tms.dao.LoginDAO;
import com.smi.tms.model.User;
import com.smi.tms.util.HibernateUtil;

public class LoginDAOImpl implements LoginDAO {

	public User getActiveUser(String userName) {
		User user = new User();

		short enabled = 1;
		List<?> list = HibernateUtil.getHibernateTemplate().find("FROM User WHERE userName=? and isActive=?", userName,
				enabled);
		if (!list.isEmpty()) {
			user = (User) list.get(0);
		}
		return user;

	}

	public User getUser(String userName, String password) {

		User user = new User();

		List<?> list = HibernateUtil.getHibernateTemplate().find("FROM User WHERE userName=? and password=?", userName,
				password);
		if (!list.isEmpty()) {
			user = (User) list.get(0);
		}
		return user;

	}

	public String encodePassword(String passwordToHash) {
		String generatedPassword = null;
		try {
			MessageDigest md = MessageDigest.getInstance("MD5");
			md.update(passwordToHash.getBytes());
			byte[] bytes = md.digest();
			StringBuilder sb = new StringBuilder();
			for (int i = 0; i < bytes.length; i++)
				sb.append(Integer.toString((bytes[i] & 0xff) + 0x100, 16).substring(1));
			generatedPassword = sb.toString();
		} catch (NoSuchAlgorithmException e) {
			e.printStackTrace();
		}
		return generatedPassword;
	}
}
