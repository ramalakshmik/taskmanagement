<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>

<c:url var="taskURL" value="/task"/>

<style>
/* user */
body {
	margin: 0;
}

.navbar {
	overflow: hidden;
	background-color: #333;
	font-family: Arial, Helvetica, sans-serif;
}

.navbar a {
	float: left;
	font-size: 16px;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none;
}

.subnav {
	float: left;
	overflow: hidden;
}

.subnav .subnavbtn {
	font-size: 16px;
	border: none;
	outline: none;
	color: white;
	padding: 14px 16px;
	background-color: inherit;
	font-family: inherit;
	margin: 0;
}

.navbar a:hover, .subnav:hover .subnavbtn {
	background-color: red;
}

.subnav-content {
	display: none;
	position: absolute;
	left: 0;
	background-color: red;
	width: 100%;
	z-index: 1;
}

.subnav-content a {
	float: left;
	color: white;
	text-decoration: none;
}

.subnav-content a:hover {
	background-color: #eee;
	color: black;
}

.subnav:hover .subnav-content {
	display: block;
}

<!--
end of menu details-->table {
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

.navbar {
	overflow: hidden;
	background-color: #0c5978;
	position: fixed; /* Set the navbar to fixed position */
	top: 0; /* Position the navbar at the top of the page */
	left: 0;
	height: 1%;
	width: 20%; /* Full width */
}
</style>

<div class="container">
	<br />
	<h3>Task List</h3>
	<table style="width: 80%;" align="center">
		<tr>
			<th scope="col">Task Name</th>
			<th scope="col">Task Description</th>
			<th scope="col">Assigned By</th>
			<th scope="col">Start Date</th>
			<th scope="col">End Date</th>
			<th colspan="3">Actions</th>
		</tr>
		<c:choose>
			<c:when test="${not empty taskList}">
				<c:forEach var="task" items="${taskList}">
					<tr style="color: ${task.statusColor}">
						<td>${task.title}</td>
						<td>${task.taskDescription}</td>
						<td>${task.assignBy.firstName}</td>
						<td><fmt:formatDate value="${task.actualStartDate}" pattern="${pattern}" /></td>
						<td><fmt:formatDate value="${task.actualEndDate}" pattern="${pattern}" /></td>
						<td><form:form id="task_${task.id}" action="${taskURL}/${task.id}"
								method="GET">
								<input type="submit" value="Edit" class="w50p">
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

	<%-- <div class="modal" id="updateTaskModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content-w">
<div class="modal-body-w">
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="">
        <div class="row">
          <div class="col-50">
          <h1 align="center" style="color:#0c5978"><strong>Edit Task</strong></h1>
           <form:form method="POST" action="">
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
					<td>Project Name :</td>
					<td>
						<form:select path="project"> 
  							<form:options items="${projects}" itemValue="id" itemLabel="projectName" />
 						</form:select>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" width="100%" class="btn-save" value="Edit Save" />
					<input type="submit" value="Cancel" class="btn-cancel"></td>
				</tr>
			</table>
		</form:form>
          </div>
        </div>
      </form>
    </div>
  </div>
</div>
</div>
</div>
</div>
</div> --%>


</div>
