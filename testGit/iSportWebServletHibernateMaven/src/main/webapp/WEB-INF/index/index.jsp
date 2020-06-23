<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Home</title>
</head>
<body>
	<h3>Home</h3>

	<h3>
		<a href="<c:url value="/pages/blobEx.jsp" />">BlobEx</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/ordersList.jsp" />">OredersList</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/shoppingCart.jsp" />">ShoppingCart</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/type.jsp" />">Type</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/course.jsp"/>">Course</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/counse_front.controller"/>">課程</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/orders.jsp"/>">Orders</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/GameCRUD.jsp"/>">Game</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/JoinQuitGame.jsp"/>">GameList</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/PartyCRUD.jsp"/>">Party</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/JoinQuitParty.jsp"/>">PartyList</a>
	</h3>
	<h3>
		<a href="<c:url value="/pages/CommercialCRUD.jsp"/>">DM</a>
	</h3>
</body>
</html>