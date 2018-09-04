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
<c:url var="saveMenu" value="/authorization/save" />
<c:url var="authList" value="/authorization/list"/>
<div style="width:80%;"class="container">
	<h3>Role Management</h3>
	 <form:form id="taskForm" method="POST" action="${saveMenu}" modelAttribute="role">
		<table style="width: 80%" align="center">
			<form:input type="hidden" path="id" />
			<tr>
				<td>Role :</td>
				<td>${role.role}</td>
			</tr>
			<tr>
				<td>Menu :</td>
				<td> <form:select path="menuList" multiple="true" items="${menuMap}" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<input type="submit" class="btn-save" value="Save" /> 
					<a style=" text-align: center; " class="btn-cancel textNone" href="${authList}">Back</a>
			</tr>
		</table>
	</form:form> 
</div>