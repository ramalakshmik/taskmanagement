package com.smi.tms.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.google.gson.Gson;
import com.smi.tms.dto.RoleDto;
import com.smi.tms.model.Authorization;
import com.smi.tms.model.Role;
import com.smi.tms.service.AuthorizationService;
import com.smi.tms.service.RoleService;
import com.smi.tms.util.MenuEnum;

@Controller
@RequestMapping(value="/authorization")
public class AuthorizationController {
	
	@Autowired 
	RoleService roleService;
	
	@Autowired
	AuthorizationService authService;
	
	@RequestMapping(value="/list")
	@Transactional(readOnly=true)
	public ModelAndView showAuthorization() {
		Map<Role, List<Authorization>> roleAuthMap = roleService.getRole();
		ModelAndView modelView =new ModelAndView("roleMenu");
		modelView.addObject("roleAuthMap", roleAuthMap);
				/*// Menu load from Enum
				Map<String, String> menuMap = Arrays.stream(MenuEnum.values())
						.collect(Collectors.toMap(stat -> stat.name(), stat -> stat.getMenu()));*/
				
				/*List<Role> allRole = roleService.getAllRole();*/
				
				/*RoleDto roleDto = new RoleDto();
				roleDto.setRoleList(allRole);
		modelView.addObject("roleDto",roleDto );*/
		/*modelView.addObject("menuMap", menuMap);*/
		return modelView;
	}
	
	@RequestMapping(value="/edit",method=RequestMethod.POST)
	public ModelAndView saveAllAuth(@ModelAttribute("roleDto") RoleDto roleDto) {
		
		System.out.println(">>> "+ new Gson().toJson(roleDto));
		
		for(Role role :roleDto.getRoleList()){
			
			
			
			/*for(String menu:role.getMenuList()){
				
			}*/
		}
		
		/*Role role = roleService.getRoleById(roleId);*/
		
		// Menu load from Enum
		/*Map<String, String> menuMap = Arrays.stream(MenuEnum.values())
				.collect(Collectors.toMap(stat -> stat.name(), stat -> stat.getMenu()));*/
				
		ModelAndView modelView =new ModelAndView("employeelist");
		return modelView;
	}
	
	@RequestMapping(value="/edit/{id}",method=RequestMethod.GET)
	@Transactional(readOnly=true)
	public ModelAndView editAuthById(@PathVariable("id")Integer roleId) {
		
		Role role = roleService.getRoleById(roleId);
		
		// Menu load from Enum
		Map<String, String> menuMap = Arrays.stream(MenuEnum.values())
				.collect(Collectors.toMap(stat -> stat.name(), stat -> stat.getMenu()));
				
		ModelAndView modelView =new ModelAndView("roleMenuEdit");
		modelView.addObject("role", role);
		modelView.addObject("menuMap", menuMap);
		return modelView;
	}
	
	@RequestMapping(value="/save",method=RequestMethod.POST)
	public ModelAndView saveRole(@ModelAttribute("role")Role role) {
		
		/*Role existingRole = roleService.getRoleById(role.getId());*/
		
		/*List<Authorization> authList = authService.getAuthorizationByRoleId(role.getId());*/
		
		authService.deleteAuthByRoleId(role.getId());
		authService.updateAuthList(role.getId(),role.getMenuList());
		
		
		
		ModelAndView modelView =new ModelAndView("redirect:list");
		return modelView;
		
	}
}