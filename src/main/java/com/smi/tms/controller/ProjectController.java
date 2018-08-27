package com.smi.tms.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Project;
import com.smi.tms.service.ProjectService;

@Controller
@RequestMapping(value = "/project")
public class ProjectController {

	@Autowired
	ProjectService projectService;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView projectList() {
		ModelAndView modelAndView = new ModelAndView("project");
		List<Project> projects = projectService.listAll();
		modelAndView.addObject("projectList", projects);
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView projectById(@PathVariable("id") Integer projectId) {
		Project project = projectService.getProjectById(projectId);
		ModelAndView modelAndView = new ModelAndView("projectEdit");
		modelAndView.addObject("project", project);
		return modelAndView;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ModelAndView addProject() {
		Project project = new Project();
		ModelAndView modelAndView = new ModelAndView("projectEdit", "project",
				project);
		return modelAndView;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView updateProjectById(
			@ModelAttribute("project") Project project,
			BindingResult bindingResult) {
		project.setIsActive(1);
		boolean saved = projectService.saveOrUpdateProject(project);
		if (saved) {
			return new ModelAndView("redirect:/project/list");
		} else {
			ModelAndView modelAndView = new ModelAndView("projectEdit");
			modelAndView.addObject("project", project);
			modelAndView.addObject("errorMsg", "Please enter valid values");
			return modelAndView;
		}
	}

}
