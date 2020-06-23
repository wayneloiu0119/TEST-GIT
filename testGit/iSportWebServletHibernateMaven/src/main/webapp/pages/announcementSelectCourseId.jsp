<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Insert title here</title>
</head>
<body>
<h3>Select Product Table Result : XXX row(s) selected</h3>
<c:if test="${not empty select}">
	<table>
		<thead>
			<tr>
			    <th>課程公告編號</th>
				<th>發布人編號</th>
				<th>課程編號</th>
				<th>課程名稱</th>
				<th>公告內容</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/announcement.jsp" var="link">
					<c:param name="announcementId" value="${row[0]}" />
					<c:param name="memberId" value="${row[1]}" />
					<c:param name="courseId" value="${row[2]}" />
					<c:param name="courseName" value="${row[3]}" />
					<c:param name="announcemenText" value="${row[4]}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row[0]}</a></td>
					<td>${row[1]}</td>
					<td>${row[2]}</td>
					<td>${row[3]}</td>
					<td>${row[4]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>

<h3><a href="<c:url value="/pages/announcement.jsp" />">Announcement Table</a></h3>
</body>
</html>