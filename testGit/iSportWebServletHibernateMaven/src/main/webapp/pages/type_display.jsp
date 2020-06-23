<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Display</title>
</head>
<body>
	<c:if test="${not empty select}">
		<table>
			<thead>
				<tr>
					<th>TypeId</th>
					<th>TypeIdName</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${select}">
					<c:url value="/pages/type.jsp" var="link">
						<c:param name="typeId" value="${row.typeId}" />
						<c:param name="typeName" value="${row.typeName}" />

					</c:url>
					<tr>
						<td><a href="${link}">${row.typeId}</a></td>
						<td>${row.typeName}</td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>
	<!--
		<c:forEach var="row" items="${select}">
			<tr>
				<td>${row.typeId}</td>
				<td>${row.typeName}</td>
			</tr>
		</c:forEach>

		<h4>${select}</h4>
	-->
</body>
</html>