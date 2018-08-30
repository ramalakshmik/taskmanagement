package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Authorization;

public interface AuthorizationService {
	
	List<Authorization> getAuthorizationByRoleId(Integer roleId);

}
