<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>AnnouncementDisplay</title>

</head>
<body>
<h3>Select Product Table Result : XXX row(s) selected</h3>
<c:if test="${not empty select}">
	<table>
		<thead>
			<tr>
				<th>AnnouncementId</th>
				<th>MemberId</th>
				<th>GameId</th>
				<th>courseId</th>
				<th>AnnouncemenText</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/announcement.jsp" var="link">
					<c:param name="announcementId" value="${row.announcementId}" />
					<c:param name="memberId" value="${row.memberId}" />
					<c:param name="gameId" value="${row.gameId}" />
					<c:param name="courseId" value="${row.courseId}" />
					<c:param name="announcemenText" value="${row.announcemenText}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row.announcementId}</a></td>
					<td>${row.memberId}</td>
					<td>${row.gameId}</td>
					<td>${row.courseId}</td>
					<td>${row.announcemenText}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>

<h3><a href="<c:url value="/pages/announcement.jsp" />">Announcement Table</a></h3>

</body>
</html>