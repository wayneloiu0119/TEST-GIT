<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>MessageDisplay</title>
</head>
<body>

	<h3>後台討論區</h3>
	<c:if test="${not empty select}">
		<table>
			<thead>
				<tr>
					<th>編號</th>
					<th>會員編號</th>
					<th>會員名稱</th>
					<th>發布時間</th>
					<th>主題分類</th>
					<th>內容</th>
					<th>圖片</th>
					<th>評價</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${select}">
					<c:url value="/pages/message.jsp" var="link">
						<c:param name="messageId" value="${row[0]}" />
						<c:param name="memberId" value="${row[1]}" />
						<c:param name="memberName" value="${row[2]}" />
						<c:param name="messageTime" value="${row[3]}" />
						<c:param name="typeName" value="${row[4]}" />
						<c:param name="messageText" value="${row[5]}" />
						<c:param name="messagePic" value="${row[6]}" />
						<c:param name="star" value="${row[7]}" />
					</c:url>
					<tr>
						<td><a href="${link}">${row[0]}</a></td>
						<td>${row[1]}</td>
						<td>${row[2]}</td>
						<td>${row[3]}</td>
						<td>${row[4]}</td>
						<td>${row[5]}</td>
						<td><img height='100' width='100'
							src='${pageContext.servletContext.contextPath}/pages/getImage.controller?messageId=${row[0]}' />
						</td>
						<td>${row[7]}</td>
<%-- 						<td>${row.memberName}</td> --%>
<%-- 						<td>${row.messageTime}</td> --%>
<%-- 						<td>${row.typeName}</td> --%>

<%-- 						<td>${row.messageText}</td> --%>
<!-- 						<td> -->
<!-- 						<img height='100' width='100' -->
<%-- 							src='${pageContext.servletContext.contextPath}/pages/getImage.controller?messageId=${row[0]}' /> --%>
<!-- 						</td> -->
<%-- 						<td>${row.star}</td> --%>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<h3>
		<a href="<c:url value="/pages/message.jsp" />">Message Table</a>
	</h3>
</body>
</html>