package com.smi.tms.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Authorization;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.ModuleService;
import com.smi.tms.service.ProjectService;
import com.smi.tms.service.AuthorizationService;
import com.smi.tms.util.AddressType;
import com.smi.tms.util.Constants;
import com.smi.tms.util.TMSCommonUtil;

@Controller
public class EmployeeController extends BaseController {

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;

	@Autowired
	ModuleService moduleService;

	@Autowired
	AuthorizationService autherizationService;

	@RequestMapping(value = "/employeelist", method = RequestMethod.GET)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response) {
		List<Authorization> menuList = null;
		String role = TMSCommonUtil.getRoleName();
		User user = TMSCommonUtil.getUser();
		int empId = user.getEmployee().getId();

		// Get Authorization by role id
		if (TMSCommonUtil.getRole() != null) {
			Integer roleId = TMSCommonUtil.getRole().getId();
			menuList = autherizationService.getAuthorizationByRoleId(roleId);
			request.getSession().setAttribute("menuList", menuList);
		}

		if (role != null
				&& (role.equalsIgnoreCase(Constants.PROJECT_MANAGER) || role
						.equalsIgnoreCase(Constants.ADMIN))) {
			List<Employee> employeeList = employeeService
					.getEmployeeListByReportingToId(empId);
			ModelAndView modelAndView = new ModelAndView("adminView");
			modelAndView.addObject("employeeList", employeeList);
			modelAndView.addObject("authorizationList", menuList);
			return modelAndView;
		} else {
			List<Task> taskList = employeeService.getTaskListByEmpId(empId);
			Task task = new Task();
			ModelAndView modelAndView = new ModelAndView("userView", "command",
					task);
			modelAndView.addObject("taskList", taskList);
			modelAndView.addObject("authorizationList", menuList);
			return modelAndView;
		}

	}

	@RequestMapping(value = "/addEmployee", method = RequestMethod.GET)
	public ModelAndView addEmployee(@ModelAttribute("employee") Employee employee,BindingResult result) {
		//Employee employee = new Employee();
		ModelAndView modelAndView = new ModelAndView("addEmployee", "command",
				employee);
		List<Employee> reportingtolist = employeeService.getreportingToList();
		Map<Integer, String> reportingMap = reportingtolist.stream().collect(Collectors.toMap(emp->emp.getId(),
				emp->emp.getFirstName().concat(" ").concat(emp.getLastName())));
		
		Map<Integer, String> statusMap = Arrays.stream(AddressType.values())
				.collect(Collectors.toMap(addrType -> addrType.ordinal(), addrType -> addrType.getAddrType()));

		modelAndView.addObject("reportingtolist", reportingMap);
		modelAndView.addObject("addresstypelist", statusMap);
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
