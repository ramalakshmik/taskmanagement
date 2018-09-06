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
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("project");
			List<Project> projects = projectService.listAll();
			modelAndView.addObject("projectList", projects);

		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView projectById(@PathVariable("id") Integer projectId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Project project = projectService.getProjectById(projectId);
			modelAndView.setViewName("projectEdit");
			modelAndView.addObject("project", project);

		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.GET)
	public ModelAndView addProject() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Project project = new Project();
			modelAndView.setViewName("projectEdit");
			modelAndView.addObject("project", project);
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addProject", method = RequestMethod.POST)
	public ModelAndView updateProjectById(
			@ModelAttribute("project") Project project,
			BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			project.setIsActive(1);
			boolean saved = projectService.saveOrUpdateProject(project);
			if (saved) {
				modelAndView.setViewName("redirect:/project/list");
			} else {
				modelAndView.setViewName("projectEdit");
				modelAndView.addObject("project", project);
				modelAndView.addObject("errorMsg", "Please enter valid values");
			}
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/delete/{id}", method = RequestMethod.GET)
	public ModelAndView deleteProjectById(@PathVariable("id") Integer projectId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Project project = projectService.getProjectById(projectId);
			projectService.deleteProjectById(project);
			modelAndView.setViewName("project");
			List<Project> projects = projectService.listAll();
			modelAndView.addObject("projectList", projects);
			modelAndView.addObject("displayMsg", "The record has been deleted");

		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

}
