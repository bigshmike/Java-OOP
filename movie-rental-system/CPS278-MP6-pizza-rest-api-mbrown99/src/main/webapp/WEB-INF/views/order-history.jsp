<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Order History - Pizza Ordering System</title>
</head>
<body>
	<h1>Order History for ${customerName }</h1>
	<table>
		<tr>
			<th>Order ID</th>
		</tr>

		<c:forEach var="eachOrder" items="${orders}">
			<tr>
				<td>${eachOrder.id }</td>
				<td>
					<table>
						<tr>
							<th width="60">Size</th>
							<th>Toppings</th>
						</tr>
						<c:forEach var="eachPizza" items="${eachOrder.pizza}">
							<tr>
								<td>${eachPizza.size}</td>
								<td>${eachPizza.toppings}</td>
							</tr>
						</c:forEach>
					</table>
				</td>
				<td>
					<form action="deleteOrder" method="post">
						<input type="hidden" name="orderId" value="${eachOrder.id }" /><input
							type="submit" value="Delete Order">
					</form>
				</td>
			</tr>
		</c:forEach>
	</table>
	<div>
		<form action="list" method="get">
			<input type="submit" value="Back to Customer List" />
		</form>
	</div>
	<form action="orderPizza" method="post">
		<input type="hidden" name="customerId" value="${customerId }" /> <input
			type="submit" value="Place Another Order" />
	</form>
</body>
</html>