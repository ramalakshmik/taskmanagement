package com.smi.tms.service;

import java.util.List;

import com.smi.tms.model.Project;

public interface ProjectService {

	List<Project> listAll();
	
	Project getProjectBy(int parseInt);

	
}
