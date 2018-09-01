<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
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
<c:url var="editRoleAuth" value="/authorization/edit"/>
<%-- <div>
	<table style="width: 80%;" align="center">
		<tr style="background-color:#0c5978;color:white;">
			<th>Role</th>
			<th>Menu</th>
			<th>Action</th>
			
			<c:forEach var="entry" items="${roleAuthMap}">
				<c:set var="role" scope="session" value="${entry.key}"></c:set>
				<tr>
					<td>${role.role}</td>
					<td>
						 <c:forEach var="menu" items="${entry.value}" varStatus="index">
							<div style="float: left;padding-right:5px">
								${menu.menu} 
								<c:if test="${!index.last}">,</c:if>
							</div>
						</c:forEach>
					</td>
					<td>
						 <a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-edit" href="${editRoleAuth}/${role.id}">Edit</a> 
					</td>
				</tr>
			</c:forEach> 
			
		</tr>
	</table>
</div> --%>

<div>
<form:form modelAttribute="roleDto" action="${editRoleAuth}" method="POST">
	<table style="width: 80%;" align="center">
		<tr style="background-color:#0c5978;color:white;">
			<th>Role</th>
			<th>Menu</th>
			<th>Action</th>
			
			<c:forEach var="role" items="${roleDto.roleList}" varStatus="status">
			
				<tr>
					<td>${role.role}</td>
					 <td>
						 <%-- <c:forEach var="menu" items="${entry.value}" varStatus="index">
							<div style="float: left;padding-right:5px">
								${menu.menu} 
								<c:if test="${!index.last}">,</c:if>
							</div>
						</c:forEach> --%>
						 <form:select path="roleList[${status.index}].menuList" items="${menuMap}" multiple="true" /> 
						<%-- <form:select path="role.id">
						<form:options name="autho" items="${menuMap}" itemValue="id"
							itemLabel="menu" /> 
					</form:select>--%>
						
					</td> 
					<td>
						<%--  <a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-edit" href="${editRoleAuth}/${role.id}">Edit</a>  --%>
					
					</td>
				</tr>
			</c:forEach>
			<tr>
				<td><input type="submit" value="Save"></td>
			</tr>
			 
	</table>
	</form:form>
</div>