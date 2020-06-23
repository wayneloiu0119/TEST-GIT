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
				<th>ShoppingCartId</th>
				<th>MemberId</th>
				<th>CourseId</th>
				<th>CourseName</th>
				<th>CoursePrice</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/shoppingCart.jsp" var="link">
					<c:param name="shoppingCartId" value="${row.shoppingCartId}" />
					<c:param name="memberId" value="${row.memberId}" />
					<c:param name="courseId" value="${row.courseId}" />
					<c:param name="courseName" value="${row.courseName}" />
					<c:param name="coursePrice" value="${row.coursePrice}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row.shoppingCartId}</a></td>
					<td>${row.memberId}</td>
					<td>${row.courseId}</td>
					<td>${row.courseName}</td>
					<td>${row.coursePrice}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
</body>
</html>