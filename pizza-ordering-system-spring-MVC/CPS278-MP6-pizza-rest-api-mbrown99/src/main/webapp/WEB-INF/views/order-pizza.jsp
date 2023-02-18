<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customize Pizza - Pizza Ordering System</title>
</head>
<body>
	<h1>Order Pizza</h1>
	<table>
		<form:form action="processPizza" modelAttribute="newPizza">
			<form:hidden path="id" />
			<tr>
				<td><form:label path="size" name="size" id="size">Size:</form:label>
					<form:radiobuttons path="size" name="size" id="size"
						items="${sizes}" /></td>
			</tr>
			<tr>
				<td><form:label path="toppings" name="toppings" id="toppings">Toppings:</form:label>
					<form:checkboxes path="toppings" name="toppings" id="toppings"
						items="${toppings}" /></td>
			</tr>
			<tr>
				<td><input type="submit" value="Order Pizza" /></td>
			</tr>
			<tr>
				<td><a href=${pageContext.request.contextPath}/customer/list>Back to Customer List</a>
			</tr>
		</form:form>
	</table>

</body>
</html>