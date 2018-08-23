<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<div class="container">
	<form:form method="POST" action="">
		<table style="width: 80%" align="center">
			<%-- <tr>
					<td></td>
					<td><form:hidden path="id" /></td>
				</tr> --%>
			<tr>
				<td>Name :</td>
				<td><form:input type="text" path="title" /></td>
			</tr>
			<%-- <tr>
					<td>Project Name :</td>
					<td>
						<form:select path="project"> 
  							<form:options items="${projects}" itemValue="id" itemLabel="projectName" />
 						</form:select>
					</td>
				</tr> --%>
			<tr>
				<td colspan="2">
					<input type="submit" class="btn-save" value="Edit Save" /> 
					<input type="submit" value="Cancel" class="btn-cancel"></td>
			</tr>
		</table>
	</form:form>
</div>