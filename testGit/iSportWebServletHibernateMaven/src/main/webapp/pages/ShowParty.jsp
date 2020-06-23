<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css" rel="stylesheet" integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u" crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/xxx.css" />

<title>Display</title>
</head>
<body>

<h3>Select Party Table Result : XXX row(s) selected</h3>

<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>活動編號 :</th>
		<th>活動名稱 :</th>
		<th>創建者編號:</th>
		<th>活動日期 :</th>
		<th>活動時間 :</th>
		<th>目前人數 :</th>
		<th>人數上限 :</th>
		<th>活動地點 :</th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/Party/PartyCRUD.jsp" var="link">
			<c:param name="partyId" value="${row.partyId}" />
			<c:param name="partyName" value="${row.partyName}" />
			<c:param name="memberId" value="${row.memberId}" />
			<c:param name="partyDate" value="${row.partyDate}" />
			<c:param name="partyTime" value="${row.partyTime}" />
			<c:param name="number" value="${row.number}" />
			<c:param name="numberMax" value="${row.numberMax}" />
			<c:param name="partyLocation" value="${row.partyLocation}" />
		</c:url>
	<tr>
		<td><a href="${link}">${row.partyId}</a></td>
		<td>${row.partyName}</td>
		<td>${row.memberId}</td>
		<td>${row.partyDate}</td>
		<td>${row.partyTime}</td>
		<td>${row.number}</td>
		<td>${row.numberMax}</td>
		<td>${row.partyLocation}</td>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/Party/PartyCRUD.jsp" />">Party Table</a></h3>
</body>
</html>