<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8" />
        <!-- <meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">  -->
        <title>Task Management System</title>
        <meta name="viewport" content="width=device-width, initial-scale=1.0"> 
        <meta name="description" content="Task Management System" />
        <meta name="keywords" content="html5, css3, form, switch, animation, :target, pseudo-class" />
        <meta name="author" content="Codrops" />
     <link rel="shortcut icon" href="resources/images/logo.png">
<link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/custom.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/addtask.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/themes/start/jquery-ui.css" type="text/css" media="all" />
<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js" type="text/javascript"></script>
<style>
<!-- menu details--
body {margin:0;}

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
<!--end of menu details-->
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
.navbar {
    overflow: hidden;
    background-color:#0c5978;
    position: fixed; /* Set the navbar to fixed position */
    top: 0; /* Position the navbar at the top of the page */
	left:0;
height:1%;
    width: 20%; /* Full width */
}
</style>
<script>var ctx = "${pageContext.request.contextPath}"</script>
<script>
function getTask(taskId){
	$.ajax({url: ctx+"/task/"+taskId, success: function(result){
       
    }});
}

</script>
</head>
<body>
  <div class="container">
  
<br/>
<br/>
<br/>
<br/>
<table style="width:80%" align="center" >
    <tr>
      <th scope="col">Task Name</th>
      <th scope="col">Task Description</th>
      <th scope="col">Assigned By</th>
      <th scope="col">Actual Start Date</th>
      <th scope="col">Planned End Date</th>
	  <th colspan="3">Actions</th>
    </tr>
  <c:forEach var="task" items="${taskList}">
  <tr>
    <td>${task.title}</td>
    <td>${task.taskDescription}</td>
    <td>${task.assignBy.firstName}</td>
    <td>${task.actualStartDate}</td>
    <td>${task.expectedEndDate}</td>
	  <!-- <td><button type="button" class="btn btn-link">Edit</button>
	  	<a data-toggle="modal" data-target="#updateTaskModal" href="assign">Assign</a>
	  </td>
	  <td><button type="button" class="btn btn-link">View</button></td> -->
	  <td><a class="tbl-btn-view" data-toggle="modal" data-target=""
						href="assign">View</a>
					<td><div onclick="getTask(${task.id});" id="updateTask_${task.id}"><a class="tbl-btn-edit" data-toggle="modal" data-target="#updateTaskModal"
						href="/task/${task.id}">Edit</a></div></td>
  </tr>
  </c:forEach>
</table>

<div class="modal" id="updateTaskModal" tabindex="-1" role="dialog" aria-hidden="true">
<div class="modal-dialog modal-sm">
<div class="modal-content-w">
<div class="modal-body-w">
<div class="row">
  <div class="col-75">
    <div class="container">
        <div class="row">
          <div class="col-50">
          <h1 align="center" style="color:#0c5978"><strong>Edit Task</strong></h1>
           <form:form method="POST" action="">
			<table>
				<%-- <tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr> --%>
				<tr>
					<td>Name :</td>
					<td>${task.title}</td>
					<%-- <td><form:input type="text" path="task.title" /></td> --%>
				</tr>
				<tr>
					<td>Project Name :</td>
					<td>
						<%-- <form:select path="project"> 
  							<form:options items="${projects}" itemValue="id" itemLabel="projectName" />
 						</form:select> --%>
					</td>
				</tr>
				<tr>
					<td colspan="2"><input type="submit" width="100%" class="btn-save" value="Edit Save" />
					<input type="button" value="Cancel" class="btn-cancel"></td>
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
</div>
</div>
</body>
</html>
