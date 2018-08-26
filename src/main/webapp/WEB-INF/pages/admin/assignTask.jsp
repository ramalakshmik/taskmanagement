<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<script>var ctx = "${pageContext.request.contextPath}"</script>
<script type="text/javascript">
 $(document).ready(function (){
    $( "#datepicker1").datepicker();
	$( "#datepicker2").datepicker();
  } ); 
</script>

<c:url var="saveTask" value="/task/saveTask"/>
<div class="container">
	<h1 align="center" style="color: #0c5978">
		<strong>Add Task</strong>
	</h1>
	<form:form method="POST" action="${saveTask}">
		<table style="width: 80%" align="center">
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<tr>
				<td>Project :</td>
				<td><form:select path="project">
						<form:options name="project" items="${projects}" itemValue="id"
							itemLabel="projectName" />
					</form:select></td>
			</tr>
			<tr>
				<td>Module :</td>
				<td><form:select path="module">
						<form:options name="project" items="${moduleList}" itemValue="id"
							itemLabel="moduleName" />
					</form:select></td>
			</tr>
			<tr>
				<td>Description :</td>
				<td><form:input type="text" path="taskDescription" /></td>
			</tr>
			<tr>
				<td>Start Date :</td>
				<td><form:input id="datepicker1" type="text"
						path="actualStartDate" /></td>
			</tr>
			<tr>
				<td>End Date :</td>
				<td><form:input id="datepicker2" type="text"
						path="actualEndDate" /></td>
			</tr>
			<tr>
				<td colspan="2">
					<!-- <a href="saveTask" class="btn-save">Save</a> --> <input
					path="" type="submit" width="100%" class="btn-save" value="Save" />
					<input value="Cancel" class="btn-cancel">
				</td>
			</tr>
		</table>
	</form:form>
</div>