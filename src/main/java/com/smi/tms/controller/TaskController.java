package com.smi.tms.controller;

import java.util.Arrays;
import java.util.Date;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.formatter.ModuleConverter;
import com.smi.tms.formatter.ProjectConverter;
import com.smi.tms.model.Employee;
import com.smi.tms.model.Module;
import com.smi.tms.model.Project;
import com.smi.tms.model.Task;
import com.smi.tms.model.User;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.ModuleService;
import com.smi.tms.service.ProjectService;
import com.smi.tms.service.TaskService;
import com.smi.tms.util.Constants;
import com.smi.tms.util.StatusEnum;
import com.smi.tms.util.TMSCommonUtil;

@Controller
@RequestMapping(value = "/task")
public class TaskController {

	@Autowired
	TaskService taskService;

	@Autowired
	EmployeeService employeeService;

	@Autowired
	ProjectService projectService;

	@Autowired
	ModuleService moduleService;

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView getTask(HttpServletRequest request,
			HttpServletResponse response, @PathVariable("id") Integer taskId) {
		String pageName;
		Task task = taskService.getTaskById(taskId);
		
		String role = TMSCommonUtil.getRole(request);
		
		if (role != null && role.equalsIgnoreCase(Constants.PROJECT_MANAGER)) {
			pageName = "taskAddEdit";
		}
		else {
			pageName = "taskView";
		}
		List<Project> projects = projectService.listAll();
		List<Module> modules = moduleService.listAll();
		
		ModelAndView modelView = new ModelAndView(pageName,"command",task); // change this
		modelView.addObject("projects", projects);
		modelView.addObject("moduleList", modules);
		
		//Status load from Enum
		Map<Integer,String> statusMap = Arrays.stream(StatusEnum.values()).collect(Collectors.toMap(stat-> stat.ordinal(), stat -> stat.getStatus()));
		modelView.addObject("statusMap", statusMap);
		return modelView;
	}

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView getTaskByEmpId(HttpServletRequest request,
			HttpServletResponse response,
			@RequestParam(value = "empId", required = true) Integer empId) {
		List<Task> taskList = employeeService.getTaskListByEmpId(empId);
		ModelAndView modelView = new ModelAndView("userView");
		modelView.addObject("taskList", taskList);
		return modelView;
	}

	@RequestMapping(value = "/saveTask", method = RequestMethod.POST)
	public ModelAndView save(@ModelAttribute("task") Task task,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		HttpSession session = TMSCommonUtil.getSession();
		String projId = (String) session.getAttribute("projectId");
		Project project = projectService.getProjectBy(Integer.parseInt(projId));

		String moduleId = (String) session.getAttribute("moduleId");
		Module module = moduleService.getModuleBy(Integer.parseInt(moduleId));

		User user = (User) session.getAttribute("user");
		Employee assigner = user.getEmployee();
		Employee assignee = (Employee) session.getAttribute("assignee");
		task.setProject(project);
		task.setModule(module);
		task.setAssignBy(assigner);
		task.setEmployee(assignee);
		taskService.save(task);
		return new ModelAndView("redirect:/employeelist");
	}
	
	@RequestMapping(value = "/updateTask", method = RequestMethod.POST)
	public ModelAndView taskUpdate(@ModelAttribute("task") Task task,
			BindingResult bindingResult, HttpServletRequest request,
			HttpServletResponse response) {
		Task beforeTask = taskService.getTaskById(task.getId());
		beforeTask.setReason(task.getReason());
		beforeTask.setStatus(task.getStatus());
		beforeTask.setUpdatedOn(new Date());
		taskService.save(beforeTask);
		return new ModelAndView("redirect:/employeelist");
	}

	@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Project.class, new ProjectConverter());
		binder.registerCustomEditor(Module.class, new ModuleConverter());
	}
	
	@RequestMapping(value="assignTask", method=RequestMethod.GET)
	public ModelAndView showAssignForm() {
		Task task = new Task();
		ModelAndView modelAndView = new ModelAndView("assignTask", "command", task);
		List<Project> projects = projectService.listAll();
		List<Module> modules = moduleService.listAll();
		modelAndView.addObject("projects", projects);
		modelAndView.addObject("moduleList", modules);
		return modelAndView;
	}

}
