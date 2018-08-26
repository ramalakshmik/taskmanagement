package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.ProjectDAO;
import com.smi.tms.model.Project;
import com.smi.tms.service.ProjectService;

@Service
public class ProjectServiceImpl implements ProjectService {

	@Autowired
	ProjectDAO projectDAO;

	@Override
	public List<Project> listAll() {
		return this.projectDAO.listAll();
	}

	@Override
	@Transactional
	public Project getProjectById(int projectId) {
		return this.projectDAO.getProjectById(projectId);
	}

}
