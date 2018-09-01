package com.smi.tms.dto;

import java.util.List;

import com.smi.tms.model.Role;

public class RoleDto {

	private List<Role> roleList;
	
	private List<String> selectedList;

	public List<String> getSelectedList() {
		return selectedList;
	}

	public void setSelectedList(List<String> selectedList) {
		this.selectedList = selectedList;
	}

	public List<Role> getRoleList() {
		return roleList;
	}

	public void setRoleList(List<Role> roleList) {
		this.roleList = roleList;
	}
	
	
}
