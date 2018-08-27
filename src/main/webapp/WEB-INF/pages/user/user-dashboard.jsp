<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="taskURL" value="/task"/>

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

<div>
	<br />
	<table style="width: 80%;" align="center">
		<tr style="background-color:#0c5978;color:white;">
			<th>Task Name</th>
			<th>Task Description</th>
			<th>Assigned By</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th colspan="3">Actions</th>
		</tr>
		<c:choose>
			<c:when test="${not empty taskList}">
				<c:forEach var="task" items="${taskList}">
					<tr>
						<td>${task.title}</td>
						<td>${task.taskDescription}</td>
						<td>${task.assignBy.firstName}</td>
						<td><fmt:formatDate value="${task.actualStartDate}" pattern="${pattern}" /></td>
						<td><fmt:formatDate value="${task.actualEndDate}" pattern="${pattern}" /></td>
						<td><form:form id="task_${task.id}" action="${taskURL}/${task.id}"
								method="GET">
								<input style="align:center;color:white;text-align:center;padding:3px;border-radius:4px;font-size:15px;cursor:pointer;text-decoration:none;" 
								class="tbl-btn-edit" type="submit" value="Edit">
							</form:form></td>
					</tr>
				</c:forEach>
			</c:when>
			<c:otherwise>
				<tr>
					<td colspan='6'><h5 style="color: red; text-align: center">Currently
							No Task assigned!!</h5></td>
				</tr>
			</c:otherwise>
		</c:choose>
	</table>
</div>
