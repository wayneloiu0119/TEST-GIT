<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Course</title>
</head>
<body>
	<table>
		<thead>
			<tr>
				<th>courseId</th>
				<th>courseName</th>
				<th>courseStartDate</th>
				<th>courseEndDate</th>
				<th>courseWeek</th>
				<th>courseStartTime</th>
				<th>courseEndTime</th>
				<th>frequency</th>
				<th>coursePrice</th>
				<th>discount</th>
				<th>discountPrice</th>
				<th>typeId</th>
				<th>courseKind</th>
				<th>coursePic</th>
				<th>roomId</th>
				<th>memberId</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/course.jsp" var="link">
					<c:param name="courseId" value="${row.courseId}" />
					<c:param name="courseName" value="${row.courseName}" />
					<c:param name="courseStartDate" value="${row.courseStartDate}" />
					<c:param name="courseEndDate" value="${row.courseEndDate}" />
					<c:param name="courseWeek" value="${row.courseWeek}" />
					<c:param name="courseStartTime" value="${row.courseStartTime}" />
					<c:param name="courseEndTime" value="${row.courseEndTime}" />
					<c:param name="frequency" value="${row.frequency}" />
					<c:param name="coursePrice" value="${row.coursePrice}" />
					<c:param name="discount" value="${row.discount}" />
					<c:param name="discountPrice" value="${row.discountPrice}" />
					<c:param name="typeId" value="${row.typeId}" />
					<c:param name="courseKind" value="${row.courseKind}" />
					<c:param name="coursePic" value="${row.coursePic}" />
					<c:param name="roomId" value="${row.roomId}" />
					<c:param name="memberId" value="${row.memberId}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row.courseId}</a></td>
					<td>${row.courseName}</td>
					<td>${row.courseStartDate}</td>
					<td>${row.courseEndDate}</td>
					<td>${row.courseWeek}</td>
					<td>${row.courseStartTime}</td>
					<td>${row.courseEndTime}</td>
					<td>${row.frequency}</td>
					<td>${row.coursePrice}</td>
					<td>${row.discount}</td>
					<td>${row.discountPrice}</td>
					<td>${row.typeId}</td>
					<td>${row.courseKind}</td>
					<%-- 					<td>${row.coursePic}</td> --%>
					<td><c:if test="${not empty row.coursePic}">
							<img style="max-height: 200px; max-width: 200px"
								src="${pageContext.servletContext.contextPath}/pages/CourseGetImage?courseId=${row.courseId}" />
						</c:if></td>
					<td>${row.roomId}</td>
					<td>${row.memberId}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>

	<h3>
		<a href="<c:url value="/pages/course.jsp" />">Product Table</a>
	</h3>
</body>
</html>