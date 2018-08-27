package com.smi.tms.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
@Controller
public class LogoutController {

	@RequestMapping(value="/logout",method=RequestMethod.GET)
	public void logout(HttpServletRequest request, HttpServletResponse response)
	{
		HttpSession httpSession=request.getSession();
		httpSession.invalidate();
		RequestDispatcher rd = request.getRequestDispatcher("index.jsp");
		try {
			rd.forward(request, response);
		} catch (ServletException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		//return "redirect:/tms";
		
		/*HttpSession httpSession = request.getSession();
        httpSession.invalidate();
        return "redirect:/tms";*/
	}
}
