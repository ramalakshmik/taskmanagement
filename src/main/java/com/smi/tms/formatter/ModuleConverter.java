package com.smi.tms.formatter;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpSession;

import com.smi.tms.util.TMSCommonUtil;

public class ModuleConverter extends PropertyEditorSupport {
	
	@Override
	public void setAsText(String id) {
		// Project project = this.projectService.getProjectBy(Integer.parseInt(id));
		// this.setValue(project);

		HttpSession session = TMSCommonUtil.getSession();
		session.setAttribute("moduleId", id);
	}

}
