package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Role;

public interface RoleDAO {

	public List<Role> getRole();
	
	public List<Role> getRoleById(Integer roleId);
}
