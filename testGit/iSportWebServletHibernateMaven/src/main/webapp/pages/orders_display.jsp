<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Orders</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>OrderId</th>
				<th>MemberId</th>
				<th>OrderDate</th>
				<th>OrderPrice</th>
				<th>Payment</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/orders.jsp" var="link">
					<c:param name="orderId" value="${row.orderId}" />
					<c:param name="memberId" value="${row.memberId}" />
					<c:param name="orderDate" value="${row.orderDate}" />
					<c:param name="orderPrice" value="${row.orderPrice}" />
					<c:param name="payment" value="${row.payment}" />
				</c:url>
				<tr>
					<td><a href="${link}">${row.orderId}</a></td>
					<td>${row.memberId}</td>
					<td>${row.orderDate}</td>
					<td>${row.orderPrice}</td>
					<td>${row.payment}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>
		<a href="<c:url value="/pages/orders.jsp" />">Orders Table</a>
	</h3>
</body>
</html>