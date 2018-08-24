<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>
</script>
<div class="container">
	<h3>Task Details</h3>
	<form:form method="POST" action="" id="taskForm">
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
				<td>Assigner  :</td>
				<td><form:input type="text" path="assignBy.firstName" /></td>
			</tr>
			<tr>
				<td>Actual Start Date :</td>
				<td><form:input type="text" path="actualStartDate" /></td>
			</tr>
			<tr>
				<td>ExpectedStart Date :</td>
				<td><form:input type="text" path="expectedStartDate" /></td>
			</tr>
			<tr>
				<td>Expected End Date :</td>
				<td><form:input type="text" path="expectedEndDate" /></td>
			</tr>
				<tr>
					<td>Reason :</td>
					<td><form:input type="text" path="reason" /></td>
				</tr>
				<tr>
						<td>Project :</td>
						<td>
						 	<form:input type="text" path="project.projectName" />
						</td>
					</tr> 
				<tr>
						<td>Module :</td>
						<td>
							<form:input type="text" path="module.moduleName" />
							<%-- <form:select path="module"> 
	  							<form:options items="${module}" itemValue="id" itemLabel="projectName" />
	 						</form:select> --%>
						</td>
					</tr>
					<tr>
						<td>Status :</td>
						<td><form:input id="stat" type="text" path="status" readonly="false"/></td>
					</tr>
					<tr>
					<td colspan="2">
						<input type="submit" class="btn-save" value="Save" /> 
						<div class="btn-cancel"><a style="color:#fff" href="${employeeList}">back</a></div>
				</tr>
			</table>
			
				
		
	</form:form>
</div>