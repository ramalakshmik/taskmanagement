package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smi.tms.dao.ProjectDAO;
import com.smi.tms.model.Project;
import com.smi.tms.util.HibernateUtil;

@Component
public class ProjectDAOImpl implements ProjectDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Project> listAll() {
		return (List<Project>) HibernateUtil.getHibernateTemplate().find(
				"FROM Project ");
	}

	@Override
	public Project getProjectBy(int projectId) {
		return (Project) HibernateUtil.getHibernateTemplate().get(
				Project.class, projectId);
	}

}
