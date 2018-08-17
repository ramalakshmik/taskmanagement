package com.smi.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping("/employeelist")
	public ModelAndView showForm() {
		return new ModelAndView("employeelist");
	}

}
