package com.smi.tms.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.User;
import com.smi.tms.service.LoginService;
import com.smi.tms.service.UserService;

@Controller
public class UserController {

	@Autowired
	UserService userService;
	
	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/change-password", method = RequestMethod.GET)
	public ModelAndView getPasswordChange(HttpServletRequest request,
			HttpServletResponse response) {
			ModelAndView modelView  = new ModelAndView("changePassword");
				return modelView;
	}
	
	@RequestMapping(value = "/change-password", method = RequestMethod.POST)
	public ModelAndView changePassword(HttpServletRequest request, HttpServletResponse response,@ModelAttribute("user") User user) {
			ModelAndView modelView  = new ModelAndView("changePassword");
			User existUser = loginService.getUser(user.getUserName(), user.getOldPassword());
			if (existUser!= null) {
				existUser.setPassword(user.getPassword());
				loginService.updatePassword(existUser);
				modelView.addObject("successMsg", "Successfully Changed Password");
				
			}
			else { // User name or password not match
				modelView.addObject("errorMsg", "Invalid Username and Password. Try Again!");
			}
			return modelView;
	}
	
	

}
