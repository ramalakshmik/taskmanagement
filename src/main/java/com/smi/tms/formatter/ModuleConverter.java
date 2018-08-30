package com.smi.tms.formatter;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.smi.tms.service.ModuleService;
import com.smi.tms.util.TMSCommonUtil;

@Component
public class ModuleConverter extends PropertyEditorSupport {
	
	@Autowired
	ModuleService moduleService;
	
	@Override
	public void setAsText(String id) {
		// Project project = this.projectService.getProjectBy(Integer.parseInt(id));
		// this.setValue(project);

		HttpSession session = TMSCommonUtil.getSession();
		session.setAttribute("moduleId", id);
	}

}
