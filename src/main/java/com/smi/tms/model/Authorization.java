package com.smi.tms.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "authorization")
public class Authorization extends BaseModel{
	
	@Column(name = "role_id")
	private Integer roleId;
	
	@Column(name = "menu")
	private String menu;
	
	@Column(name = "actions")
	private String actions;
	
	@Column(name = "method")
	private String method;
	
	@Column(name = "sort_id")
	private Integer sortOrder;

	public Integer getRoleId() {
		return roleId;
	}

	public void setRoleId(Integer roleId) {
		this.roleId = roleId;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}

	public String getActions() {
		return actions;
	}

	public void setActions(String actions) {
		this.actions = actions;
	}

	public String getMethod() {
		return method;
	}

	public void setMethod(String method) {
		this.method = method;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
