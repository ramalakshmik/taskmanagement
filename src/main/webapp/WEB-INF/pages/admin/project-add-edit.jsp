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
		$("#projectStartDate").datepicker({
			dateFormat : 'dd/mm/yy'
		});
		$("#projectEndDate").datepicker({
			dateFormat : 'dd/mm/yy'
		});
	});
</script>
<c:url var="addProject" value="/project/addProject" />
<c:url var="project" value="/project" />
<div style="width:80%;" class="container">
	<h3>Project Details</h3>
	<form:form id="projectForm" modelAttribute="project" method="POST"
		action="${addProject}">
		<form:input type="hidden" path="id"></form:input>
		<table style="width: 80%" align="center">
			<tr>
				<th colspan="2" align="center" style="color: red;">${errorMsg}</th>
			</tr>
			<tr>
				<td>Project Name :</td>
				<td><form:input type="text" path="projectName" /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><form:input type="text" id="projectStartDate"
						path="startDate" /></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><form:input type="text" id="projectEndDate" path="endDate" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:textarea class="mt10p w100p" path="projectDesc"
						rows="3" cols="50" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn-save"
					value="Save" /> <a class="btn-cancel textNone"
					href="${project}/list">Back</a>
			</tr>
		</table>
	</form:form>
</div>