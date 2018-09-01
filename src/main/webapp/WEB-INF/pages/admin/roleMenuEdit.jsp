<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.readOnly {
	background-color: rgb(235, 235, 228);
}
<style>
table {
	font-family: arial, sans-serif;
	border-collapse: collapse;
	width: 100%;
}

td, th {
	border: 2px solid #dddddd;
	text-align: left;
	padding: 7px;
}

tr:nth-child(even) {
	background-color: #dddddd;
}
</style>
<c:url var="saveTask" value="/authorization/save" />
<div style="width:50%;"class="container">
	<h3>Role Management</h3>
	 <form:form id="taskForm" action="" method="" modelAttribute="role">
		<table style="width: 80%" align="center">
			<tr>
				<td>Role :</td>
				<td>${role.role}</td>
			</tr>
			<tr>
				<td>Menu :</td>
				<td> <form:select path="authorizationList" multiple="true" items="${menuMap}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn-save"
					value="Save" /> <a class="btn-cancel textNone"
					href="">Back</a>
			</tr>
		</table>
	</form:form> 
</div>