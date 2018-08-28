package com.smi.tms.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.smi.tms.dao.ModuleDAO;
import com.smi.tms.model.Module;
import com.smi.tms.service.ModuleService;

@Service
public class ModuleServiceImpl implements ModuleService {

	@Autowired
	ModuleDAO moduleDAO;

	@Override
	public List<Module> listAll() {
		return this.moduleDAO.listAll();
	}

	@Override
	public Module getModuleBy(int moduleId) {
		return this.moduleDAO.getModuleBy(moduleId);
	}

	@Override
	@Transactional
	public boolean saveOrUpdateModule(Module module) {
		return moduleDAO.saveOrUpdateModule(module);
	}

}
