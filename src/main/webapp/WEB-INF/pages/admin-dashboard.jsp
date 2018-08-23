<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

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
						<a class="tbl-btn-assign" data-toggle="modal" data-target="#taskModal"
						href="">Assign</a>
					</td>
					<td><a class="tbl-btn-view" data-toggle="modal" data-target=""
						href="">View</a>
					<td><a class="tbl-btn-edit" data-toggle="modal" data-target=""
						href="">Edit</a></td>
				</tr>
			</c:forEach>
		</table>

<%-- <div class="modal" id="taskModal" tabindex="-1" role="dialog" aria-hidden="true">
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
				<tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr>
				<tr>
					<td>Name :</td>
					<td><form:input type="text" path="title" /></td>
				</tr>
				<tr>
					<td>Praject Name :</td>
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
