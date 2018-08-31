package com.smi.tms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;
import com.smi.tms.service.RoleService;
import com.smi.tms.util.MenuEnum;

@Controller
@RequestMapping(value="/authorization")
public class AuthorizationController {
	
	@Autowired 
	RoleService roleService;
	
	@RequestMapping(value="/list")
	@Transactional(readOnly=true)
	public ModelAndView showAuthorization() {
		Map<Role, List<Authorization>> roleAuthMap = roleService.getRole();
		ModelAndView modelView =new ModelAndView("roleMenu");
		modelView.addObject("roleAuthMap", roleAuthMap);
		return modelView;
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.POST)
	public ModelAndView editAuthorization(@ModelAttribute("role") Role role,@PathVariable("id") Integer roleId) {
		ModelAndView modelView =new ModelAndView("roleMenuEdit");
		modelView.addObject("role", role);
		return modelView;
	}

}
