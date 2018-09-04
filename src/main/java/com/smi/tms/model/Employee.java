package com.smi.tms.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.persistence.Table;

@Entity
@Table(name = "employee")
public class Employee extends BaseModel {

	/*@Column(name = "address_id")
	private long address_id;*/
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;

	@Column(name = "designation")
	private String designation;

	@Column(name = "department")
	private String department;

	@Column(name = "phone")
	private String phone;

	@Column(name = "email_address")
	private String emailAddress;

	@OneToOne(fetch = FetchType.EAGER)
	@JoinColumn(name = "reporting_to")
	private Employee reportingTo;

	@ManyToMany(fetch = FetchType.LAZY)
	@JoinTable(name = "employee_project", joinColumns = { @JoinColumn(name = "emp_id", nullable = false, updatable = false) }, inverseJoinColumns = { @JoinColumn(name = "project_id", nullable = false, updatable = false) })
	private List<Project> projects;
	
	/*@OneToMany(mappedBy="employee", cascade = CascadeType.ALL)
	private List<Address> address;*/
	
	@OneToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
	@JoinColumn(name = "address_id")
	private Address address;

	@OneToMany(fetch = FetchType.LAZY)
	@JoinColumn(name = "assigned_to")
	private List<Task> taskList;

	public List<Project> getProjects() {
		return projects;
	}

	public void setProjects(List<Project> projects) {
		this.projects = projects;
	}

	public Employee getReportingTo() {
		return reportingTo;
	}

	public void setReportingTo(Employee reportingTo) {
		this.reportingTo = reportingTo;
	}


	public List<Task> getTaskList() {
		return taskList;
	}

	public void setTaskList(List<Task> taskList) {
		this.taskList = taskList;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

	public String getEmailAddress() {
		return emailAddress;
	}

	public void setEmailAddress(String emailAddress) {
		this.emailAddress = emailAddress;
	}

	

	public Address getAddress() {
		return address;
	}

	public void setAddress(Address address) {
		this.address = address;
	}

	

}
