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

	<table>
		<thead>
			<tr>
				<th>Id</th>
				<th>Name</th>
				<th>Photo</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/blobEx.jsp" var="link">
					<c:param name="id" value="${row.id}" />
					<c:param name="name" value="${row.name}" />
					<c:param name="photo" value="${row.photo}" />
				</c:url>
				<tr>
					<td><a href="${link}">${row.id}</a></td>
					<td>${row.name}</td>
					<td><img height='100' width='100' alt=""
						src='${pageContext.servletContext.contextPath}/pages/BolbExGetImage?id=${row.id}' /></td>

				</tr>
			</c:forEach>
		</tbody>
	</table>
	<!--
		<c:forEach var="row" items="${select}">
			<tr>
				<td>${row.id}</td>
				<td>${row.name}</td>
			</tr>
		</c:forEach>

		<h4>${select}</h4>
	-->
</body>
</html>