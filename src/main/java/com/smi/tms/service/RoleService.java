package com.smi.tms.service;

import java.util.List;
import java.util.Map;

import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;

public interface RoleService {

	Map<Role,List<Authorization>> getRole();
	
	List<Role> getAllRole();
	
	Role getRoleById(Integer roleId);
	
	Role getRoleByEmpId(Integer empId);
}
