package com.smi.tms.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.smi.tms.dao.AuthorizationDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.service.AuthorizationService;
import com.smi.tms.util.TMSCommonUtil;

@Service
public class AuthorizationServiceImpl implements AuthorizationService {

	@Autowired 
	AuthorizationDAO authorizationDAO;
	
	@Override
	public List<Authorization> getAuthorizationByRoleId(Integer roleId) {
		List<Authorization> authorizationList = authorizationDAO.getAuthorizationByRoleId(roleId);
		return authorizationList.stream().sorted((a1,a2) -> a1.getSortOrder()-a2.getSortOrder()).collect(Collectors.toList());
	}

	@Override
	public void saveAuthorization(Authorization auth) {
		// 
		
	}

	@Override
	@Transactional
	public void deleteAuthByRoleId(Integer roleId) {
		List<Authorization> authorizationList = authorizationDAO.getAuthorizationByRoleId(roleId);
		
		//Make all the previous auth list are is_active = 0
		authorizationList.forEach( auth-> auth.setIsActive(0));
		
	}

	@Override
	@Transactional
	public void updateAuthList(Integer roleId,List<String> updatedMenu) {
		
		List<Authorization> updateAuthorizationList=new ArrayList<Authorization>();
		
		for(String menu :updatedMenu) {
			Authorization auth = authorizationDAO.getAuthByMenuName(roleId,menu);
			if(auth!=null) {
				auth.setIsActive(1);
				auth.setUpdatedOn(new Date());
				//auth.setUpdatedBy(TMSCommonUtil.getUser().getUserName());
				updateAuthorizationList.add(auth);
			}
		}
		
		System.out.println("updateAuthorizationList >> "+new Gson().toJson(updateAuthorizationList));
		
		authorizationDAO.addAuthorizationList(updateAuthorizationList);
		
	}


}
