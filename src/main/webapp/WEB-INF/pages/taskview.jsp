<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
	.readOnly{
		background-color:rgb(235, 235, 228);
	}
</style>
<c:url var="employeeList" value="/employeelist"/>
<c:url var="saveTask" value="/task/updateTask"/>
<div class="container">
	<h3>Task Details</h3>
	<form:form method="POST" action="${saveTask}" id="taskForm">
		<form:input type="hidden" path="id"></form:input>
		<table style="width: 80%" align="center">
			<tr>
				<td>Title :</td>
				<td><form:input type="text" path="title"  class="readOnly"  readonly="true"/></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input type="text" path="taskDescription" class="readOnly"  readonly="true"/></td>
			</tr>
			<tr>
				<td>Assigner  :</td>
				<td><form:input type="text" path="assignBy.firstName" class="readOnly"  readonly="true"/></td>
			</tr>
			<tr>
				<td>Actual Start Date :</td>
				<td><form:input type="text" path="actualStartDate" class="readOnly"  readonly="true"/></td>
			</tr>
			<tr>
				<td>ExpectedStart Date :</td>
				<td><form:input type="text" path="expectedStartDate" class="readOnly"  readonly="true"/></td>
			</tr>
			<tr>
				<td>Expected End Date :</td>
				<td><form:input type="text" path="expectedEndDate" class="readOnly"  readonly="true"/></td>
			</tr>
				
				<tr>
						<td>Project :</td>
						<td>
						 	<form:input type="text" path="project.projectName" class="readOnly"  readonly="true"/>
						 	<%-- <form:select path="project">
								<form:options name="proj" items="${projects}" itemValue="id"
									itemLabel="projectName" />
							</form:select> --%>
						</td>
					</tr> 
				<tr>
						<td>Module :</td>
						<td>
							<form:input type="text" path="module.moduleName" class="readOnly"  readonly="true"/>
							<%-- <form:select path="module"> 
	  							<form:options items="${module}" itemValue="id" itemLabel="projectName" />
	 						</form:select> --%>
						</td>
					</tr>
					<tr>
						<td>Status :</td>
						<td><form:input id="stat" type="text" path="status" /></td>
					</tr>
					<tr>
						<td>Reason :</td>
						<td><form:input type="text" path="reason" /></td>
					</tr>
					<tr>
					<td colspan="2">
						<input type="submit" class="btn-save" value="Save" /> 
						<!-- <input type="submit" value="Cancel" class="btn-cancel"></td> -->
						<div class="btn-cancel"><a style="color:#fff" href="${employeeList}">back</a></div>
						
				</tr>
			</table>
			
				
		
	</form:form>
</div>