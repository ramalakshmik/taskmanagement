package com.smi.tms.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class LoginController {
	
	@RequestMapping(value="/employeelist",method=RequestMethod.POST)
	public ModelAndView showForm() {
		return new ModelAndView("adminView");
	}

}
