package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.RoleDAO;
import com.smi.tms.model.Role;
import com.smi.tms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleDAO roleDao;
	
	@Override
	public List<Role> getRole() {
		return roleDao.getRole();
	}

}
