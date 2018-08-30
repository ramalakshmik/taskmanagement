package com.smi.tms.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

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
		
		List<Role> roleList = roleService.getRole();
		
		ModelAndView modelView =new ModelAndView("roleMenu");
		
		/*autherizationService.getAuthorizationByRoleId(roleId );*/
		
		// Status load from Enum
		/*Map<Integer, String> menuMap = Arrays.stream(MenuEnum.values())
				.collect(Collectors.toMap(menu -> menu.ordinal(), menu -> menu.getMenu()));*/
				
		modelView.addObject("roleList", roleList);
		/*modelView.addObject("menuMap", menuMap);*/
		return modelView;
	}

}
