package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Module;

public interface ModuleService {

	List<Module> listAll();

	Module getModuleBy(int moduleId);

	boolean saveOrUpdateModule(Module module);
	
	Module getById(int moduleId);

}
