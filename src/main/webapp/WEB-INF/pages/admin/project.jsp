<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<c:url var="projectUrl" value="/project" />
<div>
	<table style="width: 80%" align="center">
		<tr >
			<td colspan="7">
				<div class="fright whiteTxt" id="addEmp">
					<a class="" href="addProject">Add Project</a>
				</div>
			</td>
		</tr>

		<tr style="background-color:#0c5978;color:white;">
			<th>Project Name</th>
			<th>Start Date</th>
			<th>End Date</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="project" items="${projectList}">
			<tr>
				<td>${project.projectName}</td>
				<td><fmt:formatDate value="${project.startDate}"
						pattern="${pattern}" /></td>
				<td><fmt:formatDate value="${project.endDate}"
						pattern="${pattern}" /></td>
				<td>${project.projectDesc}</td>
				<td class="tAlignCenter"><a style="color:white;text-align:center;padding:3px;border-radius:4px;font-size:15px;cursor:pointer;text-decoration:none;" 
						class="tbl-btn-edit" href="${projectUrl}/${project.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
