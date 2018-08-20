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

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value="/login",method=RequestMethod.POST)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response,@ModelAttribute("user")User user) {
		String userName = "srilekha.vasanth@gmail.com"; //request.getParameter("userName");
		String password = "analyst@123"; //request.getParameter("password");
		user = loginService.getUser(user.getUserName(), user.getPassword());
		request.getSession().setAttribute("user", user);
		// if (user.getRole().get(0).getRole().equalsIgnoreCase("admin")) {
		return new ModelAndView("redirect:employeelist");
		// }

	}

}
