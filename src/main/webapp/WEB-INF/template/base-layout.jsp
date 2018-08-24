<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
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
<c:url var="ctx" value="/resources"/>


<link rel="shortcut icon" href="${ctx}/images/logo.png">
<link rel="stylesheet" type="text/css" href="${ctx}/styles/style.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/demo.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/custom.css" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/addtask.css">
<link rel="stylesheet" href="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/themes/start/jquery-ui.css" type="text/css" media="all" />
<link rel="stylesheet" type="text/css" href="${ctx}/styles/animate-custom.css" />


<script src="http://ajax.googleapis.com/ajax/libs/jquery/1.4.2/jquery.min.js" type="text/javascript"></script>
<script src="http://ajax.googleapis.com/ajax/libs/jqueryui/1.8.2/jquery-ui.min.js" type="text/javascript"></script>

<script src="${ctx}/js/bootstrap.min.js"></script>
<script src="${ctx}/js/popper.min.js"></script>
<link rel="stylesheet" href="${ctx}/styles/bootstrap.min.css">

<style>
body {
    font-family: Arial, Helvetica, sans-serif;
}

.header {
    padding: 20px;
    text-align: center;
    font-size: 35px;
    color: white;
}

.article {
    padding: 20px;
    width: 100%;
}

/* Style the footer */
.footer {
	  position: absolute;
	  right: 0;
	  bottom: 0;
	  left: 0;
	  padding: 1rem;
	  text-align: center;
}

table th{font-weight: bold;}


</style>
</head>
<body>
		<div class="background:transparent;">
			<div class="header">
			  <tiles:insertAttribute name="header" />
			</div>

			<div class="article">
				<tiles:insertAttribute name="body" />
			</div>
		
			<%-- <div class="footer">
				<tiles:insertAttribute name="footer" />
			</div> --%>
		</div>

</body>
</html>