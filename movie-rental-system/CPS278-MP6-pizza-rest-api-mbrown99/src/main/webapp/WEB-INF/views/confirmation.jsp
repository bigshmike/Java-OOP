<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order Confirmation - Pizza Ordering System</title>
</head>
<body>
	<h2>${pizzaOrder.customer.firstName }&nbsp;${pizzaOrder.customer.lastName }'s
		cart:</h2>
	<table>
		<c:forEach var="eachPizza" items="${pizzaOrder.pizza }"
			varStatus="theCount">
			<tr>
				<td>Pizza ${theCount.count}</td>
				<td>Size:</td>
				<td>${eachPizza.size }</td>

				<td>Toppings:</td>
				<td><c:forEach var="eachTopping" items="${eachPizza.toppings }">${eachTopping }&emsp;</c:forEach></td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<form action="orderPizza" method="post">
			<input type="hidden" name="customerId"
				value="${pizzaOrder.customer.id }" /> <input type="submit"
				value="Add More Pizza">
		</form>
	</div>
	<form action="placeOrder" method="post">
		<input type="hidden" name="customerId"
			value="${pizzaOrder.customer.id }" /> <input type="submit"
			value="Place Order">
	</form>
</body>
</html>