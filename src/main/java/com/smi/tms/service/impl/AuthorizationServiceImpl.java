package com.smi.tms.service.impl;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.smi.tms.dao.AuthorizationDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.service.AuthorizationService;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired 
	AuthorizationDAO authorizationDAO;
	
	@Override
	public List<Authorization> getAuthorizationByRoleId(Integer roleId) {
		List<Authorization> authorizationList = authorizationDAO.getAuthorizationByRoleId(roleId);
		return authorizationList.stream().sorted((a1,a2) -> a1.getSortOrder()-a2.getSortOrder()).collect(Collectors.toList());
	}

}
