<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
</head>
<body>
		main layout
		<div class="container" style="border: #C1C1C1 solid 1px; border-radius:10px;">
			<!-- Header -->
			<tiles:insertAttribute name="header" />
			<!-- Body Page -->
			<div class="span-19 last">
				<tiles:insertAttribute name="body" />
			</div>
			<!-- Footer Page -->
			<tiles:insertAttribute name="footer" />
		</div>

</body>
</html>