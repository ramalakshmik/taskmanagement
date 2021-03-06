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

	@Override
	public List<Role> getRoleById(Integer roleId) {
		
		return  (List<Role>) HibernateUtil.getHibernateTemplate().find("FROM Role where id=? and isActive=1",roleId);
	}

	@Override
	public Role getRoleByEmployee(Integer empId) {
		 List<Role> roles = (List<Role>)HibernateUtil.getHibernateTemplate().find("select u.role from User u inner join u.employee e  where e.id=?", empId);
		 return roles.get(0);
	}

}
