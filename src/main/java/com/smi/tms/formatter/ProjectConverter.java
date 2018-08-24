package com.smi.tms.formatter;

import java.beans.PropertyEditorSupport;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Component;

import com.smi.tms.util.TMSCommonUtil;

@Component
public class ProjectConverter extends PropertyEditorSupport {

	@Override
	public void setAsText(String id) {
		// Project project =
		// this.projectService.getProjectBy(Integer.parseInt(id));
		// this.setValue(project);

		HttpSession session = TMSCommonUtil.getSession();
		session.setAttribute("projectId", id);
	}
}
