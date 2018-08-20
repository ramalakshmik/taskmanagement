<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Header</title>
<link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
      <link rel="stylesheet" type="text/css" href="resources/styles/demo.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/animate-custom.css" />
<link rel="stylesheet" href="resources/styles/bootstrap.min.css">

<!--<link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/4.7.0/css/font-awesome.min.css">-->

      <script src="resources/js/jquery.min.js"></script>
      <script src="resources/js/popper.min.js"></script>
      <script src="resources/js/bootstrap.min.js"></script>
      
   <style>
* {
    box-sizing: border-box;
}

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
		
			<div class="footer">
				<tiles:insertAttribute name="footer" />
			</div>
		</div>

</body>
</html>