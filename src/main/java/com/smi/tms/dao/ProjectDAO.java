package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Project;

public interface ProjectDAO {

	List<Project> listAll();

	Project getProjectById(int projectId);

	boolean saveOrUpdateProject(Project project);

}
