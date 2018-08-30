<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>
	var ctx = "${pageContext.request.contextPath}"
</script>
<script type="text/javascript">
	$(document).ready(function() {
		$("#startDate").datepicker({
			  dateFormat: "dd/mm/yy"
		});
		$("#endDate").datepicker({
			  dateFormat: "dd/mm/yy"
		});
	});
</script>

<c:url var="saveTask" value="/task/saveTask" />
<c:url var="empList" value="/employeelist" />
<div class="container">
	<h1 align="center" style="color: #0c5978">
		<strong>Add Task</strong>
	</h1>
	<form:form method="POST" action="${saveTask}"  modelAttribute="task">
		<table style="width: 80%" align="center">
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="title" autocomplete="off" /></td>
			</tr>
			<tr>
				<td>Project :</td>
				<%-- <td><form:select path="project">
						<form:options name="project" items="${projectList}" itemValue="id"
							itemLabel="projectName" />
					</form:select></td> --%>
					<td><form:select path="project.id" items="${projectList}" /></td>
			</tr>
			<tr>
				<td>Module :</td>
				<%-- <td><form:select path="module">
						<form:options name="module" items="${moduleList}" itemValue="id"
							itemLabel="moduleName" />
					</form:select></td> --%>
					<td><form:select path="module.id" items="${moduleList}" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input type="text" path="taskDescription"
						autocomplete="off" /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td>
					<form:input id="startDate" type="text"
						path="actualStartDate" autocomplete="off"/> 
				</td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><form:input id="endDate" type="text" path="actualEndDate"
						autocomplete="off" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- <a href="saveTask" class="btn-save">Save</a> --> <input
					path="" type="submit" width="100%" class="btn-save" value="Save" />
					<a class="btn-cancel textNone" href="${empList}">Back</a>
				</td>
			</tr>
		</table>
		<div style="background-color: ${failure};">
			<span> ${msg}</span>
		</div>
	</form:form>
</div>
