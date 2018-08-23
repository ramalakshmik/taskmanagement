<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<script>

</script>
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
	  <td><!-- <a class="tbl-btn-view" data-toggle="modal" data-target=""
						href="assign">View</a> -->
					<td>
						<form:form id="task_${task.id}" action="task/${task.id}" method="GET">
							<input type="submit" value="Edit" class="w50p">
						</form:form>
					</td>
  </tr>
  </c:forEach>
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
