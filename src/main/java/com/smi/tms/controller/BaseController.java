package com.smi.tms.controller;

import java.text.SimpleDateFormat;
import java.util.Date;

import org.springframework.beans.propertyeditors.CustomDateEditor;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.InitBinder;

import com.smi.tms.formatter.ModuleConverter;
import com.smi.tms.formatter.ProjectConverter;
import com.smi.tms.model.Module;
import com.smi.tms.model.Project;

public class BaseController {
	
	/*@InitBinder
	public void initBinder(WebDataBinder binder) {
		binder.registerCustomEditor(Project.class, new ProjectConverter());
		binder.registerCustomEditor(Module.class, new ModuleConverter());
		
		SimpleDateFormat dateFormat = new SimpleDateFormat("dd-MMM-yyyy");
	    dateFormat.setLenient(false);
	    binder.registerCustomEditor(Date.class, new CustomDateEditor(dateFormat, true));
	    
	}*/

}
