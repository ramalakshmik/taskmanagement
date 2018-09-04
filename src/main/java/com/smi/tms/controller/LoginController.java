package com.smi.tms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.smi.tms.model.User;
import com.smi.tms.service.LoginService;
import com.smi.tms.util.TMSCommonUtil;

@Controller
public class LoginController {

	@Autowired
	LoginService loginService;

	@RequestMapping(value = "/login", method = RequestMethod.GET)
	public void showLogin(HttpServletRequest request,
			HttpServletResponse response) {
		request.setAttribute("errorMsg",
				"Invalid Username and Password. Try Again!");
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/login", method = RequestMethod.POST)
	public ModelAndView showForm(HttpServletRequest request,
			HttpServletResponse response) {
		try {
			String userName = request.getParameter("username");
			String password = request.getParameter("password");
			User user = loginService.getUser(userName, password);
			if (user == null)
				throw new Exception();
			HttpSession session = request.getSession();
			TMSCommonUtil.setSession(session);
			session.setAttribute("user", user);
			return new ModelAndView("redirect:employeelist");
		} catch (Exception e) {

			return new ModelAndView("redirect:login");
		}
	}

}
