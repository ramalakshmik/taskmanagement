<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<style>
ul {
	list-style-type: none;
	margin: 0;
	padding: 0;
	overflow: hidden;
	background-color: #333;
}

li {
	float: left;
	border-right: 1px solid #bbb;
}

li:last-child {
	border-right: none;
}

li a {
	display: block;
	color: white;
	text-align: center;
	padding: 14px 16px;
	text-decoration: none !important;
}

li a:hover:not (.active ) {
	background-color: #4CAF50;
}

.active {
	background-color: #4CAF50;
}
</style>
<c:url var="project" value="/project" />
<c:url var="module" value="/module" />
<c:url var="employeelist" value="/employeelist" />

<div id="adminMenuContainer">
	<ul>
		<c:forEach var="menu" items='${sessionScope["menuList"]}'>
			<c:url var="actionLink" value="${menu.actions}" />
			<li><a href="${actionLink}">${menu.menu}</a></li>
		</c:forEach>
	</ul>
</div>