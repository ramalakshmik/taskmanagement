package com.smi.tms.dao.impl;

import java.util.List;

import org.springframework.stereotype.Component;

import com.smi.tms.dao.ModuleDAO;
import com.smi.tms.model.Module;
import com.smi.tms.util.HibernateUtil;

@Component
public class ModuleDAOImpl implements ModuleDAO {

	@SuppressWarnings("unchecked")
	@Override
	public List<Module> listAll() {
		return (List<Module>) HibernateUtil.getHibernateTemplate().find(
				"FROM Module ");
	}

	@Override
	public Module getModuleBy(int moduleId) {
		return (Module) HibernateUtil.getHibernateTemplate().get(Module.class, moduleId);
	}

}
