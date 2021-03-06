package com.smi.tms.model;

import java.util.Date;


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.Table;
import javax.persistence.Transient;

import org.hibernate.annotations.Cascade;
import org.hibernate.annotations.CascadeType;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
@Table(name = "task")
public class Task extends BaseModel {


	@Column(name = "title")
	private String title;

	@OneToOne(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.MERGE})
	@JoinColumn (name = "module_id")
	private Module module;

	@OneToOne(fetch = FetchType.EAGER)
//	@Cascade({CascadeType.MERGE})
	@JoinColumn (name = "project_id")
	private Project project;

	@Column(name = "task_description")
	private String taskDescription;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "actual_start_date")
	private Date actualStartDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "actual_end_date")
	private Date actualEndDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "expected_start_date")
	private Date expectedStartDate;

	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "expected_end_date")
	private Date expectedEndDate;
	
	@DateTimeFormat(pattern = "dd/MM/yyyy")
	@Column(name = "postponded_end_date")
	private Date postponedEndDate;
	
	@Column(name = "status")
	private Integer status;

	@Column(name = "reason")
	private String reason;

	@ManyToOne(fetch=FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private Employee employee;
	
	@Transient
	private String statusColor;

	public Employee getEmployee() {
		return employee;
	}

	public void setEmployee(Employee employee) {
		this.employee = employee;
	}

	@ManyToOne(fetch=FetchType.EAGER)
	@JoinColumn(name = "assigned_by")
	private Employee assignBy;

	public String getTitle() {
		return title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public Module getModule() {
		return module;
	}

	public void setModule(Module module) {
		this.module = module;
	}

	public Project getProject() {
		return project;
	}

	public void setProject(Project project) {
		this.project = project;
	}

	public String getTaskDescription() {
		return taskDescription;
	}

	public void setTaskDescription(String taskDescription) {
		this.taskDescription = taskDescription;
	}


	public Integer getStatus() {
		return status;
	}

	public void setStatus(Integer status) {
		this.status = status;
	}

	public String getReason() {
		return reason;
	}

	public void setReason(String reason) {
		this.reason = reason;
	}

	public Employee getAssignBy() {
		return assignBy;
	}

	public void setAssignBy(Employee assignBy) {
		this.assignBy = assignBy;
	}

	public Date getActualStartDate() {
		return actualStartDate;
	}

	public void setActualStartDate(Date actualStartDate) {
		this.actualStartDate = actualStartDate;
	}

	public Date getActualEndDate() {
		return actualEndDate;
	}

	public void setActualEndDate(Date actualEndDate) {
		this.actualEndDate = actualEndDate;
	}

	public Date getExpectedStartDate() {
		return expectedStartDate;
	}

	public void setExpectedStartDate(Date expectedStartDate) {
		this.expectedStartDate = expectedStartDate;
	}

	public Date getExpectedEndDate() {
		return expectedEndDate;
	}

	public void setExpectedEndDate(Date expectedEndDate) {
		this.expectedEndDate = expectedEndDate;
	}

	public Date getPostponedEndDate() {
		return postponedEndDate;
	}

	public void setPostponedEndDate(Date postponedEndDate) {
		this.postponedEndDate = postponedEndDate;
	}

	public String getStatusColor() {
		return statusColor;
	}

	public void setStatusColor(String statusColor) {
		this.statusColor = statusColor;
	}

	

}
