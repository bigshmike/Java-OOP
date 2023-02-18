<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer Info - Pizza Ordering System</title>
</head>
<body>
	<b>Customer Info:</b>
	<form:form action="processCustomer" modelAttribute="customer" method="post">
	<form:hidden path="id" />
		<table>
			<tr>
				<td>First Name: </td>
				<td><form:input path="firstName" /></td>
				<td>Last Name: </td>
				<td><form:input path="lastName" /></td>
			</tr>
			<tr>
				<td>Address: </td>
				<td><form:input path="street" /></td>
				<td>City: </td>
				<td><form:input path="city" /></td>
				<td>State: </td>
				<td>
					<form:select path="state" >
						<form:options items="${states }" />
					</form:select>
				</td>
				<td>Zip: </td>
				<td><form:input path="zip" /></td>
			</tr>
			<tr>
				<td>
					<input type="submit" value="Save Customer" />
				</td>
			</tr>
		</table>
		<a href= ${pageContext.request.contextPath}/customer/list>Back to Customer List</a>
	</form:form>
</body>
</html>

