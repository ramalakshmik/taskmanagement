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
<c:url var="saveTask" value="/task/updateTask" />
<div style="width:80%;"class="container">
	<h3>Role Management</h3>
	 <form:form id="taskForm" modelAttribute="role">
		<table style="width: 80%" align="center">
			<tr>
				<td>Role :</td>
				<td><form:input type="text" path="role" /></td>
			</tr>
			<tr>
				<td>Menu :</td>
				<td><%-- <form:select path="status" items="${statusMap}" /> --%></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn-save"
					value="Save" /> <a class="btn-cancel textNone"
					href="">Back</a>
			</tr>
		</table>
	</form:form> 
</div>