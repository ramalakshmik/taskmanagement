package com.smi.tms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Project;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.ProjectService;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;
	
	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		Role role2 = user.getRole().get(0);
		String role = role2.getRole();
		int empId = user.getEmployee().getId();
		if (role != null && role.equalsIgnoreCase("Project Manager")) {
			List<Employee> employeeList = employeeService.getEmployeeListByReportingToId(empId);
			/*request.getSession().setAttribute("employeeList", employeeList);*/
			List<Project> projects = projectService.listAll();
			Task task = new Task();
			ModelAndView modelAndView = new ModelAndView("adminView", "command", task);
			modelAndView.addObject("employeeList", employeeList);
			modelAndView.addObject("projects", projects);
			return modelAndView;
		} else {
			List<Task> taskList = employeeService.getTaskListByEmpId(empId);
			Task task = new Task();
			ModelAndView modelAndView = new ModelAndView("userView", "command", task);
			modelAndView.addObject("taskList", taskList);
			return modelAndView;
		}

	}

}
