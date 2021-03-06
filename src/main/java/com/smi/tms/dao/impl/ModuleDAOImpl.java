package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smi.tms.dao.ModuleDAO;
import com.smi.tms.model.Module;
import com.smi.tms.model.Project;
import com.smi.tms.util.HibernateUtil;

@Component
public class ModuleDAOImpl implements ModuleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> listAll() {
		return (List<Module>) HibernateUtil.getHibernateTemplate().find(
				"FROM Module where isActive = 1");
	}

	@Override
	public Module getModuleBy(int moduleId) {
		return (Module) HibernateUtil.getHibernateTemplate().get(Module.class,
				moduleId);
	}

	@Override
	public boolean saveOrUpdateModule(Module module) {
		try {
			HibernateUtil.getHibernateTemplate().saveOrUpdate(module);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}

	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> getModulesByProjectId(int projectId) {
		return (List<Module>) HibernateUtil.getHibernateTemplate().find(
				"FROM Project where isActive = 1 and project_id=?", projectId);
	}

	@SuppressWarnings("unchecked")
	@Override
	public Module getById(int moduleId) {
		List<Object[]> objects = (List<Object[]>) HibernateUtil.getHibernateTemplate().find(
				"SELECT m.id, m.moduleName, m.moduleDesc, p.id from Project p INNER JOIN p.modules m where m.id=?",
				moduleId);
		Module module = null;
		if (objects != null && objects.size() > 0) {
			for (Object[] object : objects) {
				int mId = (int) object[0];
				String mName = (String) object[1];
				String mDesc = (String) object[2];
				int pId = (int) object[3];
				
				module = new Module();
				module.setId(mId);
				module.setModuleName(mName); 
				module.setModuleDesc(mDesc);
				Project project = new Project();
				project.setId(pId);
				module.setProject(project);
			}
		}
		return module;
	}
}
