package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smi.tms.dao.RoleDAO;
import com.smi.tms.model.Role;
import com.smi.tms.util.HibernateUtil;

@Component
public class RoleDAOImpl implements RoleDAO{

	@Override
	public List<Role> getRole() {
		return (List<Role>) HibernateUtil.getHibernateTemplate().find("FROM Role where isActive=1");
	}

}
