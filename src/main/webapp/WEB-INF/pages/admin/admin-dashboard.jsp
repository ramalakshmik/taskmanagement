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
			<td colspan="7">
				<div class="fright whiteTxt" id="addEmp">
					<a class="" href="addEmployee">Add Employee</a>
				</div>
			</td>
		</tr>
		<tr style="background-color: #0c5978; color: white;">
			<th>Id</th>
			<th>Employee Name</th>
			<th>Department</th>
			<th colspan="2">Designation</th>
			<th colspan="2">Task Actions</th>
		</tr>

		<c:forEach var="emp" items="${employeeList}">
			<tr>
				<td>SMI_${emp.id}</td>
				<td>${emp.firstName}${emp.lastName}</td>
				<td>${emp.department}</td>
				<td>${emp.designation}</td>
				<td><a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-edit" data-toggle="modal" data-target="#taskModal"
					href="empEdit?empId=${emp.id}">Edit</a></td>
				<td><a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-assign" href="task/assignTask?empId=${emp.id}">Assign</a></td>
				<td><div id="viewEmpTask_${emp.id}">
						<a
							style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
							class="tbl-btn-edit" href="task/list?empId=${emp.id}">View</a>
					</div></td>
			</tr>
		</c:forEach>
	</table>

</div>
