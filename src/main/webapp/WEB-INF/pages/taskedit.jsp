<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

</script>
<div class="container">
	<h3>Task Details</h3>
	<form:form method="POST" action="">
		<table style="width: 80%" align="center">
			<%-- <tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr> --%>
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
				<td>Status :</td>
				<td><form:input type="text" path="status" /></td>
			</tr>
			<tr>
				<td>Reason :</td>
				<td><form:input type="text" path="reason" /></td>
			</tr>
			<%-- <tr>
					<td>Project Name :</td>
					<td>
						<form:select path="project"> 
  							<form:options items="${projects}" itemValue="id" itemLabel="projectName" />
 						</form:select>
					</td>
				</tr> --%>
			<tr>
				<td colspan="2">
					<input type="submit" class="btn-save" value="Edit Save" /> 
					<input type="button" value="Cancel" class="btn-cancel"></td>
			</tr>
		</table>
	</form:form>
</div>