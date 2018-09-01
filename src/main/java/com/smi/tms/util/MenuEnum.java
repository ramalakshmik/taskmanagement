package com.smi.tms.util;

public enum MenuEnum {
	
	EMPLOYEE("Employee"),PROJECT("Project"),MODULE("Module"),ROLE("Role");
	
	 private String menu;
	
	MenuEnum(String menu) {
		this.menu = menu;
	}

	public String getMenu() {
		return menu;
	}

	public void setMenu(String menu) {
		this.menu = menu;
	}
	
	
}
