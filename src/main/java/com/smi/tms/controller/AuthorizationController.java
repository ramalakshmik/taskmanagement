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

import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;
import com.smi.tms.service.AuthorizationService;
import com.smi.tms.service.RoleService;
import com.smi.tms.util.MenuEnum;

@Controller
@RequestMapping(value = "/authorization")
public class AuthorizationController {

	@Autowired
	RoleService roleService;

	@Autowired
	AuthorizationService authService;

	@RequestMapping(value = "/list")
	public ModelAndView showAuthorization() {
		ModelAndView modelView = new ModelAndView();
		try {
			Map<Role, List<Authorization>> roleAuthMap = roleService.getRole();
			modelView.setViewName("roleMenu");
			modelView.addObject("roleAuthMap", roleAuthMap);
		} catch (Exception e) {
			modelView.setViewName("error");
		}
		return modelView;
	}

	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	@Transactional(readOnly = true)
	public ModelAndView editAuthById(@PathVariable("id") Integer roleId) {
		ModelAndView modelView = new ModelAndView();
		try {
			Role role = roleService.getRoleById(roleId);
			modelView.setViewName("roleMenuEdit");
			// Menu load from Enum
			Map<String, String> menuMap = Arrays.stream(MenuEnum.values())
					.collect(
							Collectors.toMap(stat -> stat.name(),
									stat -> stat.getMenu()));

			modelView.addObject("role", role);
			modelView.addObject("menuMap", menuMap);
		} catch (Exception e) {
			modelView.setViewName("error");
		}
		return modelView;
	}

	@RequestMapping(value = "/save", method = RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute("role") Role role) {
		ModelAndView modelView = new ModelAndView();
		try {
			authService.updateAuthList(role.getId(), role.getMenuList());
			modelView.setViewName("redirect:list");

		} catch (Exception e) {
			modelView.setViewName("error");
		}
		return modelView;
	}
}