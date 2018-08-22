package com.smi.tms.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Task;
import com.smi.tms.service.EmployeeService;
import com.smi.tms.service.TaskService;

@Controller
@RequestMapping(value="/task")
public class TaskController {
	
	@Autowired
	TaskService taskService;
	
	@Autowired
	EmployeeService employeeService;
	
	@RequestMapping(value="/{id}", method = RequestMethod.GET)
	public ModelAndView getTask(HttpServletRequest request,
			HttpServletResponse response,@PathVariable("id") Integer taskId) {
			Task task = taskService.getTaskById(taskId);
			ModelAndView modelView = new ModelAndView("userView"); //change this 
			modelView.addObject("task",task);
				return modelView;
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public ModelAndView getTaskByEmpId(HttpServletRequest request,
			HttpServletResponse response,@RequestParam(value="empId",required=true) Integer empId) {
		List<Task> taskList = employeeService.getTaskListByEmpId(empId);
		ModelAndView modelView = new ModelAndView("userView");
		modelView.addObject("taskList",taskList);
		return modelView;
	}

}
