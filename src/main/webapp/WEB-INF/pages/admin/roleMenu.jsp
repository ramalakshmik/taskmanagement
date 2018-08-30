<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
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
	<table style="width: 80%;" align="center">
		<tr style="background-color:#0c5978;color:white;">
			<th>Role</th>
			<th>Menu</th>
			<th>Action</th>
			
			<c:forEach var="role" items="${roleList}">
				<tr>
					<td>${role.role }</td>
					<td>
						<c:forEach var="menu" items="${role.authorizationList}" varStatus="index">
							<div style="float: left;padding-right:5px">
								${menu.menu} 
								<c:if test="${!index.last}">,</c:if>
							</div>
						</c:forEach>
						
					</td>
					<td>
						<a
					style="color: white; text-align: center; padding: 3px; border-radius: 4px; font-size: 15px; cursor: pointer; text-decoration: none;"
					class="tbl-btn-edit" href="">Edit</a>
					</td>
				</tr>
			</c:forEach>
			
		</tr>
	</table>
</div>