package com.smi.tms.util;

import javax.servlet.http.HttpServletRequest;

import com.smi.tms.model.Role;
import com.smi.tms.model.User;

public class TMSCommonUtil {

	public static String getRole(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		Role role2 = user.getRole().get(0);
		return role2.getRole();
	}
	
	public static User getUser(HttpServletRequest request) {
		User user = (User) request.getSession().getAttribute("user");
		return user;
	}
	
	
}
