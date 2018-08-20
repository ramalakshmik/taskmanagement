package com.smi.tms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		Role role2 = user.getRole().get(0);
		String role = role2.getRole();
		if (role!= null && role.equalsIgnoreCase("admin")) {
			List<User> userList = userService.getUsersById(user.getId());
			request.getSession().setAttribute("userList", userList);
			return new ModelAndView("adminview");
		}else{
			List<Task> taskList = userService.getTasksById(user.getId());
			request.getSession().setAttribute("taskList", taskList);
			return new ModelAndView("employeeview");
		}

	}

}
