<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>
		<div class="header">
			  <tiles:insertAttribute name="header" />
		</div>

		<div style="padding-left:20px">
			<tiles:insertAttribute name="body" />
		</div>
		
		<div>
			<tiles:insertAttribute name="footer" />
		</div>

</body>
</html>