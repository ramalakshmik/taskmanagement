<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8" />
<!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
<title>Task Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Time Management System" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="resources/images/logo.png">
<link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/custom.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/addtask.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/themes/start/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js" type="text/javascript"></script>
<script type="text/javascript">
  $(document).ready(function (){
    $( "#datepicker1").datepicker();
	$( "#datepicker2").datepicker();
  } );
</script>
</head>
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
<body>
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
					<td>
						<!-- <button type="button" class="btn btn-link">Assign</button> -->
						<a data-toggle="modal" data-target="#taskModal"
						href="assign">Assign</a>
					</td>
					<td><button type="button" class="btn btn-link">View
							History</button></td>
					<td><button type="button" class="btn btn-link">Edit</button></td>
				</tr>
			</c:forEach>
		</table>

<div class="modal" id="taskModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content-w">
<div class="modal-body-w">
<div class="row">
  <div class="col-75">
    <div class="container">
      <form action="">
        <div class="row">
          <div class="col-50">
          <h1 align="center" style="color:#0c5978"><strong>Add Task</strong></h1>
           <form:form method="POST" action="">
			<table>
				<%-- <tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr> --%>
				<tr>
					<td>Name :</td>
					<td><form:input type="text" path="title" /></td>
				</tr>
				<tr>
					<td>Salary :</td>
					<td><form:input type="text" path="taskDescription" width="50%"/></td>
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
</div>
</div>
</body>
</html>