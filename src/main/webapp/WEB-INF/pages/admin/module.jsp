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
<c:url var="moduleUrl" value="/module" />
<div>
	<table style="width: 80%" align="center">
		<tr>
			<td colspan="7">
				<div class="fright whiteTxt" id="addModule">
					<a class="" href="addModule">Add Module</a>
				</div>
			</td>
		</tr>

		<tr>
			<th>Module Name</th>
			<th>Description</th>
			<th>Action</th>
		</tr>
		<c:forEach var="module" items="${moduleList}">
			<tr>
				<td>${module.moduleName}</td>
				<td>${module.moduleDesc}</td>
				<td class="tAlignCenter"><a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-edit" href="${moduleUrl}/${module.id}">Edit</a></td>
			</tr>
		</c:forEach>
	</table>
</div>
