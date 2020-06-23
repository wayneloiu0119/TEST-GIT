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
			<th>編號</th>
			<th>會員編號</th>
			<th>關係人編號</th>
			<th>關係人</th>
			<th>關係</th>
			<th>狀態</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/blackFriend.jsp" var="link">
					<c:param name="blackFriendId" value="${row[0]}" />
					<c:param name="memberId" value="${row[1]}" />
					<c:param name="relationMemberId" value="${row[2]}" />
					<c:param name="blackFriendName" value="${row[3]}" />
					<c:param name="blackFriendType" value="${row[4]}" />
					<c:param name="states" value="${row[5]}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row[0]}</a></td>
					<td>${row[1]}</td>
					<td>${row[2]}</td>
					<td>${row[3]}</td>
					<td>${row[4]}</td>
					<td>${row[5]}</td>
					
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>

<h3><a href="<c:url value="/pages/blackFriend.jsp" />">BlackFriend Table</a></h3>
</body>
</html>