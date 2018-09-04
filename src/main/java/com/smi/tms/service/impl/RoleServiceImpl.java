package com.smi.tms.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;import java.util.stream.Collector;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.google.gson.Gson;
import com.smi.tms.dao.RoleDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;
import com.smi.tms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleDAO roleDao;
	
	@Override
	public Map<Role,List<Authorization>> getRole() {
		Map<Role,List<Authorization>> roleAuthMap = new HashMap<Role,List<Authorization>>();
		List<Role> roleList = roleDao.getRole();
		if(roleList!= null && roleList.size()>0) {
			for(Role role:roleList) {
				roleAuthMap.put(role, role.getAuthorizationList());
			}
		}
		System.out.println(new Gson().toJson(roleAuthMap));
		return roleAuthMap;
	}

	@Override
	public Role getRoleById(Integer roleId) {
		Role role = roleDao.getRoleById(roleId).get(0);
		setMenuDropdown(role);
		return role;
	}

	@Override
	public List<Role> getAllRole() {
		List<Role> roleList = roleDao.getRole();
		
		for(Role role:roleList)
			setMenuDropdown(role);
		
		return roleList;
	}
	
	/**
	 * Method to set Drop down values 
	 * @param role 
	 * @return role
	 */
	public Role setMenuDropdown(Role role) {
		List<Authorization> authorizationList = role.getAuthorizationList();
		List<String> menuString = authorizationList.stream().map(x -> x.getMenu().toUpperCase()).collect(Collectors.toList());
		role.setMenuList(menuString);
		return role;
	}

}
