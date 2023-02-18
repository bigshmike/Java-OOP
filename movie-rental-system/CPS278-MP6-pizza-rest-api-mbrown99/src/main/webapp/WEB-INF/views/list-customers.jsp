<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Customer List - Pizza Ordering System</title>
</head>
<body>
<h1>Customer List</h1>
	<table>
		<tr>
			<th>First Name</th>
			<th>Last Name</th>
			<th>Address</th>
			<th>City</th>
			<th>State</th>
			<th>Zip</th>
		</tr>
		<c:forEach var="eachCustomer" items="${customers}">
			<c:url var="updateLink" value="/customer/updateCustomer">
				<c:param name="customerId" value="${eachCustomer.id }" />
			</c:url>
			<c:url var="orderHistoryLink" value="/customer/pizzaHistory">
				<c:param name="customerId" value="${eachCustomer.id }" />
			</c:url>
			<c:url var="orderPizzaLink" value="/customer/orderPizza">
				<c:param name="customerId" value="${eachCustomer.id }" />
			</c:url>
			<tr>
				<td>${eachCustomer.firstName}</td>
				<td>${eachCustomer.lastName }</td>
				<td>${eachCustomer.street}</td>
				<td>${eachCustomer.city }</td>
				<td>${eachCustomer.state}</td>
				<td>${eachCustomer.zip }</td>
				<td><a href="${updateLink }"><button>Update Info</button></a></td>
				<td><a href="${orderHistoryLink }"><button>Order History</button></a></td>
				<td><a href="${orderPizzaLink }"><button>Order Pizza</button></a>
			</tr>
		</c:forEach>
	</table>
	<form action="addCustomer" method="post">
		<input type="submit" value="Add Customer" />
	</form>
</body>
</html>