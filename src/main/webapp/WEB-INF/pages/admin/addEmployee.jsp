<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<c:url var="employeeList" value="/employeelist" />


	<div id="container_demo">
		<div id="wrapper">
			<div id="login" class="animate form">
				<form:form id="addemployee" method="post" action="addEmployee" modelAttribute="employee">
					<form:input type="hidden" path="id" />
					<table style="width: 80%" align="center">
						<thead>
						<tr>
							<th colspan="2" align="center" style="color:lightseagreen"><b>ADD NEW EMPLOYEE</b></th>
						</tr>
						<tr>
							<th colspan="2" align="center" style="color:red;">${validationMsg}</th>
						</tr>
						</thead>
						<tbody>
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
							<td><label for="reportingTo">Reporting To:</label></td>
							<td><form:select path="reportingTo.id" items="${reportingtolist}" /></td>
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
							<td><label for="address">Address:</label></td>
							<td></td>
						</tr>
						
						<tr>
							<td><label for="address.addressLineone">Addr Line 1:</label></td>
							<td>
								<form:input id="addressLineone" path="address.addressLineone"
									name="addressLineone" />
							</td>
						</tr>
						<tr>
							<td><label for="address.addressLineTwo">Addr Line 2:</label></td>
							<td>
								<form:input id="addressLineTwo" path="address.addressLineTwo"
									name="addressLineTwo" />
							</td>
						</tr>
						<tr>
							<td><label for="address.city">City:</label></td>
							<td>
								<form:input id="city" path="address.city"
									name="city" />
							</td>
						</tr> 
						<tr>
							<td><label for="address.state">State:</label></td>
							<td>
								<form:input id="state" path="address.state"
									name="state" />
							</td>
						</tr>
						<tr>
							<td><label for="address.zipcode">ZipCode:</label></td>
							<td>
								<form:input id="zipcode" path="address.zipcode"
									name="zipcode" />
							</td>
						</tr> 
						</tbody>
					</table>
				</form:form>
				<table style="width: 30%" align="center">
					<thead>
						 <tr>
							<th><button style="float:right;color:white;text-align:center;padding:3px;border-radius:4px;font-size:15px;cursor:pointer;" type="submit" class="tbl-btn-assign" form="addemployee" value="Add"><b>Add</b></button></th>
							<th><a style="float:right;color:white;text-align:center;padding:3px;border-radius:4px;font-size:15px;text-decoration:none;" class="tbl-btn-edit" href="${employeeList}">Cancel</a></th>
						</tr> 
					</thead>
				</table>
				
			</div>
		</div>
	</div>
