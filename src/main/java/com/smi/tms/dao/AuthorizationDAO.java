package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Authorization;

public interface AuthorizationDAO {

	public List<Authorization> getAuthorizationByRoleId(Integer roleId);
	
	public void addAuthorizationList(List<Authorization> authList);

	public Authorization getAuthByMenuName(Integer roleId,String menu);
}
