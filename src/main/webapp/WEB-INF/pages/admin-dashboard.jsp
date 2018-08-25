<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
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
	<table style="width: 80%" align="center">
		<tr>
			<th>Employee Name</th>
			<th>Department</th>
			<th>Designation</th>
			<th colspan="3">Task Actions</th>
		</tr>
		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td>${emp.firstName}</td>
				<td>${emp.department}</td>
				<td>${emp.designation}</td>
				<td><a class="tbl-btn-assign" href="task/assignTask">Assign</a></td>
				<td><div id="viewEmpTask_${emp.id}">
						<a class="tbl-btn-edit" href="task/list?empId=${emp.id}">View</a>
					</div></td>
				<td><a class="tbl-btn-edit" data-toggle="modal"
					data-target="#taskModal" href="adminTaskEdit/${emp.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
