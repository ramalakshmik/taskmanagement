package com.smi.tms.controller;

import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Employee;
import com.smi.tms.model.Role;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.ModuleService;
import com.smi.tms.service.ProjectService;
import com.smi.tms.util.Constants;
import com.smi.tms.util.TMSCommonUtil;

@Controller
public class EmployeeController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;
	
	@Autowired
	ModuleService moduleService;

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response) {
		User user = (User) request.getSession().getAttribute("user");
		Role role2 = user.getRole().get(0);
		String role = role2.getRole();
		int empId = user.getEmployee().getId();
		if (role != null && role.equalsIgnoreCase(Constants.PROJECT_MANAGER)) {
			List<Employee> employeeList = employeeService
					.getEmployeeListByReportingToId(empId);
			/* request.getSession().setAttribute("employeeList", employeeList); */
			ModelAndView modelAndView = new ModelAndView("adminView");
			modelAndView.addObject("employeeList", employeeList);
			return modelAndView;
		} else {
			List<Task> taskList = employeeService.getTaskListByEmpId(empId);
			Task task = new Task();
			ModelAndView modelAndView = new ModelAndView("userView", "command",
					task);
			modelAndView.addObject("taskList", taskList);
			return modelAndView;
		}

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee() {
		Employee employee = new Employee();
		ModelAndView modelAndView = new ModelAndView("addEmployee", "command",
				employee); 	
		return modelAndView;
	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.POST)
	public ModelAndView addEmployee(HttpServletRequest request,
			HttpServletResponse response,
			@ModelAttribute("command") Employee employee, BindingResult result) {
		String emailAddress = employee.getEmailAddress();

		boolean emailValid, phoneValid = true;
		emailValid = TMSCommonUtil.isEmailValid(emailAddress);
		phoneValid = TMSCommonUtil.isPhoneNumberValid(employee.getPhone());
		if (emailValid && phoneValid) {
			User user = (User) request.getSession().getAttribute("user");
			employee.setReportingTo(user.getEmployee());
			employee.setIsActive(1);
			employee.setCreatedBy(user.getEmployee().getFirstName());
			employee.setCreatedOn(new Date());
			employeeService.addEmployee(employee);
			return new ModelAndView("redirect:employeelist");
		} else {
			ModelAndView modelAndView = new ModelAndView("addEmployee",
					"command", employee);
			if (!emailValid)
				modelAndView.addObject("validationMsg",
						"Email Address is not valid");
			if (!phoneValid)
				modelAndView.addObject("validationMsg",
						"Phone Number is not valid");
			return modelAndView;
		}

	}

}
