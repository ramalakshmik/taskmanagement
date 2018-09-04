package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Authorization;

public interface AuthorizationService {
	
	List<Authorization> getAuthorizationByRoleId(Integer roleId);
	
	void saveAuthorization(Authorization auth);
	
	void deleteAuthByRoleId(Integer roleId);

	void updateAuthList(Integer roleId,List<String> updatedMenu); 

}
