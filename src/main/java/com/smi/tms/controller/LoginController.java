package com.smi.tms.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.User;
import com.smi.tms.service.LoginService;
import com.smi.tms.util.HibernateUtil;

@Controller
public class LoginController {
	
	@Autowired
	LoginService loginService;
	
	@RequestMapping("/login")
	public ModelAndView showForm() {
		HibernateUtil.hibernateTemplate.save(new User());
		return new ModelAndView("employeelist");
	}

}
