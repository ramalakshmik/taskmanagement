package com.smi.tms.formatter;

import java.text.ParseException;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.converter.Converter;
import org.springframework.format.Formatter;
import org.springframework.stereotype.Component;

import com.smi.tms.model.Project;
import com.smi.tms.service.ProjectService;

@Component
public class ProjectConverter implements Converter<String, Project> {
	
	@Autowired
	ProjectService projectService;

	/*@Override
	public void setAsText(String id) {
		// Project project =
		// this.projectService.getProjectBy(Integer.parseInt(id));
		// this.setValue(project);

		HttpSession session = TMSCommonUtil.getSession();
		session.setAttribute("projectId", id);
	}*/

	@Override
	public Project convert(String projectName) {
		return null;
	}
}
