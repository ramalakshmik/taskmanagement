package com.smi.tms.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpSession;

import com.smi.tms.model.Role;
import com.smi.tms.model.User;

public class TMSCommonUtil {

	public static boolean isEmailValid(String email) {
		String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\." + "[a-zA-Z0-9_+&*-]+)*@"
				+ "(?:[a-zA-Z0-9-]+\\.)+[a-z" + "A-Z]{2,7}$";

		Pattern pat = Pattern.compile(emailRegex);
		if (email == null)
			return false;
		return pat.matcher(email).matches();
	}
	
	public static final String EMPLOYEE = "EMPLOYEE";
	public static final String PROJECT = "PROJECT";
	public static final String MODULE= "MODULE";
	public static final String ROLE = "ROLE";
	
	public static final String EMPLOYEE_ACTIONS = "/employeelist";
	public static final String PROJECT_ACTIONS = "/project/list";
	public static final String MODULE_ACTIONS = "/module/list";
	public static final String ROLE_ACTIONS = "/authorization/list";
	
	public static final Integer EMPLOYEE_ORDER = 1;
	public static final Integer PROJECT_ORDER = 2;
	public static final Integer MODULE_ORDER = 3;
	public static final Integer ROLE_ORDER = 4;
	public static final String DEFAULT_PASSWORD = "smi@123";
	
	

	public static boolean isPhoneNumberValid(String number) {
		// The given argument to compile() method
		// is regular expression. With the help of
		// regular expression we can validate mobile
		// number.
		// 1) Begins with 0 or 91
		// 2) Then contains 7 or 8 or 9.
		// 3) Then contains 9 digits
		Pattern p = Pattern.compile("(0/91)?[7-9][0-9]{9}");

		// Pattern class contains matcher() method
		// to find matching between given number
		// and regular expression
		Matcher m = p.matcher(number);
		return m.matches();
	}

	public static HttpSession session;

	public static void setSession(HttpSession session) {
		TMSCommonUtil.session = session;
	}

	public static HttpSession getSession() {
		return TMSCommonUtil.session;
	}
	
	public static Role getRole() {
		User user = TMSCommonUtil.getUser();
		if(user !=null && user.getRole() !=null && user.getRole().size()>0) {
			return user.getRole().get(0);
		}
		return null;
	}
	
	public static String getRoleName() {
		return getRole().getRole();
	}
	
	public static User getUser() {
		User user = (User) session.getAttribute("user");
		return user;
	}
	
	

}
