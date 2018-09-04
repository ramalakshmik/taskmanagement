package com.smi.tms.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Where;

@Entity
@Table(name = "role")
public class Role extends BaseModel{
	@Column(name = "role")
	private String role;
	
	@Column(name = "role_description")
	private String roleDescription;
	
	@OneToMany(fetch=FetchType.LAZY)
	@JoinColumn(name="role_id")
	@Where(clause="is_active=1")
	private List<Authorization> authorizationList;
	
	@Column(name = "sort_order")
	private Integer sortOrder;
	
	@Transient
	private List<String> menuList;
	
	
	public List<Authorization> getAuthorizationList() {
		return authorizationList;
	}

	public void setAuthorizationList(List<Authorization> authorizationList) {
		this.authorizationList = authorizationList;
	}

	public String getRoleDescription() {
		return roleDescription;
	}

	public void setRoleDescription(String roleDescription) {
		this.roleDescription = roleDescription;
	}

	public String getRole() {
		return role;
	}

	public void setRole(String role) {
		this.role = role;
	}

	public List<String> getMenuList() {
		return menuList;
	}

	public void setMenuList(List<String> menuList) {
		this.menuList = menuList;
	}

	public Integer getSortOrder() {
		return sortOrder;
	}

	public void setSortOrder(Integer sortOrder) {
		this.sortOrder = sortOrder;
	}

}
