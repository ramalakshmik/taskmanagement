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
				<td><a class="tbl-btn-assign" href="task/assignTask?empId=${emp.id}">Assign</a></td>
				<td><div id="viewEmpTask_${emp.id}">
						<a class="tbl-btn-edit" href="task/list?empId=${emp.id}">View</a>
					</div></td>
				<td><a class="tbl-btn-edit" data-toggle="modal"
					data-target="#taskModal" href="adminTaskEdit/${emp.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>

	<%-- <div class="modal" id="taskModal" tabindex="-1" role="dialog"
		aria-hidden="true">
		<div class="modal-dialog modal-sm">
			<div class="modal-content-w">
				<div class="modal-body-w">
					<div class="row">
						<div class="col-75">
							<div class="container">
								<form:form method="POST" action="saveTask">
								<div class="row">
									<div class="col-50">
										<h1 align="center" style="color: #0c5978">
											<strong>Add Task</strong>
										</h1>
										<form:form method="POST" action="task/saveTask">
											<table>
												<tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr>
												<tr>
													<td>Name :</td>
													<td><form:input type="text" path="title" /></td>
												</tr>
												<tr>
													<td>Project :</td>
													<td><form:select path="project">
															<form:options name="project" items="${projects}"
																itemValue="id" itemLabel="projectName" />
														</form:select></td>
												</tr>
												<tr>
													<td>Module :</td>
													<td><form:select path="module">
															<form:options name="project" items="${moduleList}"
																itemValue="id" itemLabel="moduleName" />
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
														path="" type="submit" width="100%" class="btn-save"
														value="Save" /> <input value="Cancel" class="btn-cancel">
													</td>
												</tr>
											</table>
										</form:form>
									</div>
								</div>
							</div>
						</div>
					</div>
				</div>
			</div>
		</div>
	</div> --%>
</div>
