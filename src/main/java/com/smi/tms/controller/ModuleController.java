package com.smi.tms.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.Module;
import com.smi.tms.model.Project;
import com.smi.tms.service.ModuleService;
import com.smi.tms.service.ProjectService;

@Controller
@RequestMapping(value = "/module")
public class ModuleController {

	@Autowired
	ModuleService moduleService;

	@Autowired
	ProjectService projectService;

	private Map<Integer, Project> projectMap;

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView moduleList() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			modelAndView.setViewName("module");
			List<Module> modules = moduleService.listAll();
			List<Project> projects = projectService.listAll();
			modelAndView.addObject("projects", projects);
			modelAndView.addObject("moduleList", modules);
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView moduleById(@PathVariable("id") Integer moduleId) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Module module = moduleService.getById(moduleId);
			modelAndView.setViewName("moduleEdit");
			modelAndView.addObject("module", module);
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addModule", method = RequestMethod.GET)
	public ModelAndView addModule() {
		ModelAndView modelAndView = new ModelAndView();
		try {
			Module module = new Module();
			modelAndView.setViewName("moduleEdit");
			modelAndView.addObject("module", module);
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public ModelAndView updateModuleById(
			@ModelAttribute("module") Module module, BindingResult bindingResult) {
		ModelAndView modelAndView = new ModelAndView();
		try {
			module.setIsActive(1);
			Project project = module.getProject();
			if (project != null && project.getId() > 0) {
				project = this.projectMap.get(project.getId());
			}
			List<Module> modules = project.getModules();
			if (modules == null || modules.size() == 0) {
				modules.add(module);
			}
			modules.add(module);
			project.setModules(modules);
			boolean saved = projectService.saveOrUpdateProject(project);
			if (saved) {
				modelAndView.setViewName("redirect:/module/list");
			} else {
				modelAndView.setViewName("moduleEdit");
				modelAndView.addObject("module", module);

			}
		} catch (Exception e) {
			modelAndView.setViewName("error");
		}
		return modelAndView;
	}

	@ModelAttribute(name = "projects")
	public Map<Integer, String> populateProject() {
		List<Project> projs = new ArrayList<Project>();
		projs = projectService.listAll();
		Map<Integer, String> projects = projs.stream().collect(
				Collectors.toMap(proj -> proj.getId(),
						proj -> proj.getProjectName()));
		this.projectMap = projs.stream().collect(
				Collectors.toMap(proj -> proj.getId(), proj -> proj));
		return projects;
	}

}
