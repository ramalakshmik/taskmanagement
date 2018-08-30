<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.readOnly {
	background-color: rgb(235, 235, 228);
}
</style>
<script type="text/javascript">
	$(document).ready(function() {
		$("#actualStartDate").datepicker({
			  dateFormat: "dd/mm/yy"
		});
		$("#actualEndDate").datepicker({
			  dateFormat: "dd/mm/yy"
		});
	});
</script>
<c:url var="employeeList" value="/employeelist" />
<c:url var="saveTask" value="/task/updateTask" />
<div style="width:80%;"class="container">
	<h3>Task Details</h3>
	<form:form method="POST" action="${saveTask}" id="taskForm">
		<form:input type="hidden" path="id"></form:input>
		<table style="width: 80%" align="center">
			<tr>
				<td>Title :</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input type="text" path="taskDescription" /></td>
			</tr>
			<tr>
				<td>Assigner :</td>
				<td><form:input type="text" path="assignBy.firstName" /></td>
			</tr>
			<tr>
				<td>Actual Start Date :</td>
				<td><form:input type="text" path="actualStartDate" autocomplete="off" /></td>
			</tr>
			<tr>
				<td>Actual End Date :</td>
				<td><form:input type="text" path="actualEndDate" autocomplete="off"/></td>
			</tr>
			<!--  <tr>
				<td>ExpectedStart Date :</td>
				<td><form:input type="text" path="expectedStartDate" /></td>
			</tr>
			<tr>
				<td>Expected End Date :</td>
				<td><form:input type="text" path="expectedEndDate" /></td>
			</tr> -->
			
			<tr>
				<td>Project :</td>
				<td><form:select path="project.id">
						<form:options name="project" items="${projects}" itemValue="id"
							itemLabel="projectName" />
					</form:select></td>
			</tr>
			<tr>
				<td>Module :</td>
				<td><form:select path="module.id">
						<form:options name="module" items="${moduleList}" itemValue="id"
							itemLabel="moduleName" />
					</form:select></td>
			</tr>

			<!--  <tr>
				<td>Project :</td>
				<td><form:input type="text" path="project.projectName" />
				</td>
			</tr>
			<tr>
				<td>Module :</td>
				<td><form:input type="text" path="module.moduleName" /></td>
			</tr> -->
			<tr>
				<td>Status :</td>
				<td><form:select path="status" items="${statusMap}" /></td>
			</tr>
			<tr>
				<td>Reason :</td>
				<td><form:textarea class="mt10p w100p"
						path="reason" rows="3" cols="50" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn-save"
					value="Save" /> <a class="btn-cancel textNone"
					href="${employeeList}">Back</a>
			</tr>
		</table>
	</form:form>
</div>