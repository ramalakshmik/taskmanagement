package com.smi.tms.dao;

import java.util.List;

import com.smi.tms.model.Module;

public interface ModuleDAO {

	List<Module> listAll();

	Module getModuleBy(int moduleId);

	boolean saveOrUpdateModule(Module module);

}
