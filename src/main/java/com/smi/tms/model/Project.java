package com.smi.tms.model;

import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name="Project")
public class Project extends BaseModel{

	@Column(name="project_name")
	private String projectName;
	
	@Column(name="project_desc")
	private String projectDesc;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="start_date")
	private Date startDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name="end_date")
	private Date endDate;
	
	@ManyToMany(fetch = FetchType.EAGER, cascade=CascadeType.ALL)
	@JoinTable(name = "project_module", joinColumns = {
			@JoinColumn(name = "project_id", nullable = false, updatable = false) }, inverseJoinColumns = {
					@JoinColumn(name = "module_id", nullable = false, updatable = false) })
	private List<Module> modules;
	
	public String getProjectName() {
		return projectName;
	}

	public void setProjectName(String projectName) {
		this.projectName = projectName;
	}

	public String getProjectDesc() {
		return projectDesc;
	}

	public void setProjectDesc(String projectDesc) {
		this.projectDesc = projectDesc;
	}

	public Date getStartDate() {
		return startDate;
	}

	public void setStartDate(Date startDate) {
		this.startDate = startDate;
	}

	public Date getEndDate() {
		return endDate;
	}

	public void setEndDate(Date endDate) {
		this.endDate = endDate;
	}

	public List<Module> getModules() {
		return modules;
	}

	public void setModules(List<Module> modules) {
		this.modules = modules;
	}
	
	
}
