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

	@RequestMapping(value = "/list", method = RequestMethod.GET)
	public ModelAndView moduleList() {
		ModelAndView modelAndView = new ModelAndView("module");
		List<Module> modules = moduleService.listAll();
		List<Project> projects = projectService.listAll();
		modelAndView.addObject("projects", projects);
		modelAndView.addObject("moduleList", modules);
		return modelAndView;
	}

	@RequestMapping(value = "/{id}", method = RequestMethod.GET)
	public ModelAndView moduleById(@PathVariable("id") Integer moduleId) {
		Module module = moduleService.getModuleBy(moduleId);
		ModelAndView modelAndView = new ModelAndView("moduleEdit");
		modelAndView.addObject("module", module);
		return modelAndView;
	}

	@RequestMapping(value = "/addModule", method = RequestMethod.GET)
	public ModelAndView addModule() {
		Module module = new Module();
		ModelAndView modelAndView = new ModelAndView("moduleEdit", "module",
				module);
		return modelAndView;
	}

	@RequestMapping(value = "/addModule", method = RequestMethod.POST)
	public ModelAndView updateModuleById(
			@ModelAttribute("module") Module module, BindingResult bindingResult) {
		module.setIsActive(1);
		boolean saved = moduleService.saveOrUpdateModule(module);
		if (saved) {
			return new ModelAndView("redirect:/module/list");
		} else {
			ModelAndView modelAndView = new ModelAndView("moduleEdit");
			modelAndView.addObject("module", module);
			return modelAndView;
		}
	}

}
