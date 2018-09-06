package com.smi.tms.service.impl;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.RoleDAO;
import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;
import com.smi.tms.service.RoleService;

@Service
public class RoleServiceImpl implements RoleService{

	
	@Autowired
	RoleDAO roleDao;
	
	@Override
	@Transactional(readOnly=true)
	public Map<Role,List<Authorization>> getRole() {
		
		//Sorting based on sort order
		Map<Role,List<Authorization>> roleAuthMap = new TreeMap<Role,List<Authorization>>((Comparator<Role>) (o1, o2) -> o1.getSortOrder() - o2.getSortOrder());
		
		List<Role> roleList = roleDao.getRole();
		if(roleList!= null && roleList.size()>0) {
			for(Role role:roleList) {
				roleAuthMap.put(role, role.getAuthorizationList());
			}
		}
		System.out.println(roleAuthMap);

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

	@Override
	public Role getRoleByEmpId(Integer empId) {
		return roleDao.getRoleByEmployee(empId);
	}

}
