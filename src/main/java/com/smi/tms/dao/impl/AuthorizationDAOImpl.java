package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Component;

import com.smi.tms.dao.AuthorizationDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.util.HibernateUtil;

@Component
public class AuthorizationDAOImpl implements AuthorizationDAO{

	@SuppressWarnings("unchecked")
	@Override
	public List<Authorization> getAuthorizationByRoleId(Integer roleId) {
		HibernateTemplate hibernateTemplate = HibernateUtil.getHibernateTemplate();
		return (List<Authorization>) hibernateTemplate.find("FROM Authorization where roleId=? and isActive=1", roleId);
	}

}
