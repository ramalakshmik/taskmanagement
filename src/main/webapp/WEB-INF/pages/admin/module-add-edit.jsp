<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
.readOnly {
	background-color: rgb(235, 235, 228);
}
</style>
<c:url var="addModule" value="/module/addModule" />
<c:url var="module" value="/module" />
<div style="width: 80%;" class="container">
	<h3>Module Details</h3>
	<form:form id="projectForm" modelAttribute="module" method="POST"
		action="${addModule}">
		<form:input type="hidden" path="id"></form:input>
		<table style="width: 80%; border-spacing: 10px; border-collapse: separate;" align="center">
			<tr>
				<th colspan="2" align="center" style="color: red;">${errorMsg}</th>
			</tr>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="moduleName" /></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:textarea class="mt10p w100p" path="moduleDesc"
						rows="3" cols="50" /></td>
			</tr>
			<br/>			
			<tr>
				<td>Project :</td>
				<td><form:select path="project.id" items="${projects}" /></td>
			</tr>
			<tr>
				<td colspan="2"><input type="submit" class="btn-save"
					value="Save" /> <a class="btn-cancel textNone"
					href="${module}/list">Back</a></td>
			</tr>
		</table>
	</form:form>
</div>