<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
 <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>BlackFriendDisplay</title>
</head>
<body>
<h3>後台好友列表</h3>
<c:if test="${not empty select}">
	<table>
		<thead>
			<tr>
				<th>BlackFriendId</th>
				<th>MemberId</th>
				<th>RelationMemberId</th>
				<th>BlackFriendType</th>
				<th>States</th>
			</tr>
		</thead>
		<tbody>
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/blackFriend.jsp" var="link">
					<c:param name="blackFriendId" value="${row.blackFriendId}" />
					<c:param name="memberId" value="${row.memberId}" />
					<c:param name="relationMemberId" value="${row.relationMemberId}" />
					<c:param name="blackFriendType" value="${row.blackFriendType}" />
					<c:param name="states" value="${row.states}" />

				</c:url>
				<tr>
					<td><a href="${link}">${row.blackFriendId}</a></td>
					<td>${row.memberId}</td>
					<td>${row.relationMemberId}</td>
					<td>${row.blackFriendType}</td>
					<td>${row.states}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>

<h3><a href="<c:url value="/pages/blackFriend.jsp" />">BlackFriend Table</a></h3>

</body>
</html>