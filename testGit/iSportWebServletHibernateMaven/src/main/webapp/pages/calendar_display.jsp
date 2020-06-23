<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Calendar</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>日曆編號</th>
				<th>課程編號</th>
				<th>課程名稱</th>
				<th>開始日期</th>
				<th>結束日期</th>
			</tr>
		</thead>
		<tbody>
			<!--回傳內容至calendar.jsp -->
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/calendar.jsp" var="link">
					<c:param name="calendarId" value="${row.calendarId}" />
					<c:param name="courseId" value="${row.courseId}" />
					<c:param name="courseName" value="${row.courseName}" />
					<c:param name="courseStart" value="${row.courseStart}" />
					<c:param name="courseEnd" value="${row.courseEnd}" />
					
				</c:url>
				<tr>
					<td><a href="${link}">${row.calendarId}</a></td>
					<td>${row.courseId}</td>
					<td>${row.courseName}</td>
					<td>${row.courseStart}</td>
					<td>${row.courseEnd}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>
		<a href="<c:url value="/pages/calendar.jsp" />">Calendar Table</a>
	</h3>
</body>
</html>