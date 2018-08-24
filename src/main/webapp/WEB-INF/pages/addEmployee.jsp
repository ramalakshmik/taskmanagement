<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
	pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Task Management System</title>
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<meta name="description" content="Time Management System" />
<meta name="keywords"
	content="html5, css3, form, switch, animation, :target, pseudo-class" />
<meta name="author" content="Codrops" />
<link rel="shortcut icon" href="resources/images/logo.png">
<link rel="stylesheet" type="text/css" href="resources/styles/style.css" />
<link rel="stylesheet" type="text/css" href="resources/styles/demo.css" />
<link rel="stylesheet" type="text/css"
	href="resources/styles/custom.css" />
</head>
<body>
	<div id="container_demo">
		<div id="wrapper">
			<div id="login" class="animate form">
				<form:form method="post" action="addEmployee">
					<table style="width: 80%" align="center">
						<tr>
							<th colspan="2" align="center"><b>ADD NEW EMPLOYEE</b></th>
							<th>${validationMsg}</th>
						</tr>
						<tr>
							<td><label for="firstName">FirstName: </label></td>
							<td><form:input id="firstName" path="firstName"
									name="firstName" /></td>
						</tr>
						<tr>
							<td><label for="lastName">LastName:</label></td>
							<td><form:input id="lastName" path="lastName"
									name="lastName" /></td>
						</tr>
						<tr>
							<td><label for="designation">Designation:</label></td>
							<td><form:input id="designation" path="designation"
									name="designation" /></td>
						</tr>
						<tr>
							<td><label for="department">Department:</label></td>
							<td><form:input id="department" path="department"
									name="department" /></td>
						</tr>
						<tr>
							<td><label for="email">EmailAddress:</label></td>
							<td><form:input id="emailAddress" path="emailAddress"
									name="emailAddress" /></td>
						</tr>
						<tr>
							<td><label for="phone">Phone:</label></td>
							<td><form:input id="phone" path="phone"
									name="phone" /></td>
						</tr>
						<tr>
							<td><input type="submit" id="save" width="100%"
								class="login button" value="ADD" /></td>
							<td><input type="submit" value="Cancel" id="cancel"
								class="login button" /></td>
						</tr>
					</table>
				</form:form>
			</div>
		</div>
	</div>
</body>
</html>