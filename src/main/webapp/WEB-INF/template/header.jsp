<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:url var="ctx" value="/resources" />
<style>
.header {
	overflow: hidden;
	padding: 5px;
}

.header a {
	float: left;
	color: white;
	text-align: center;
	padding: 3px;
	text-decoration: none;
	border-radius: 4px;
	font-size:15px;
}

.header a:hover {
	background-color: #ddd;
	color: black;
}

.header a.active {
	background-color: dodgerblue;
	color: white;
}

.header-right {
	float: right;
}

.logoutLblPos {
	position: fixed;
	right: 10px;
	top: 5px;
}

</style>
<c:url var="logoutUrl" value="/logout" />
<c:url var="changePass" value="/change-password" />
<div class="header"
	style="display: flex; flex-direction: row; justify-content: space-between;">
	<img class="" style="float: left; width: 18%" alt="Logo"
		src="${ctx}/images/logo.png">
	<h2 style="color:#0c5978;">Task Management System</h2>
	<nav>
		<a href="${changePass}" style="color:#007bff">Change Password</a>
		<p>
			<div id="logout">
				<a class="tbl-btn-edit" href="${logoutUrl}">Logout</a>
			</div>
		</p>
	</nav>
</div>

