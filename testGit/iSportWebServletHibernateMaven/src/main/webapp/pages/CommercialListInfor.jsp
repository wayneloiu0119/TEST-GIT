<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/table.css" />

<title>Display</title>
</head>
<body>

<h3>Select Product Table Result : XXX row(s) selected</h3>

<c:if test="${not empty select}">
<table>
	<thead>
	<tr>
		<th>廣告編號 :</th>
		<th>比賽編號 :</th>
		<th>課程編號 :</th>
		<th>連結 : </th>
		<th>圖片 : </th>
	</tr>
	</thead>
	<tbody>
	<c:forEach var="row" items="${select}">
		<c:url value="/Commercial/CommercialListInfor.jsp" var="link">
			<c:param name="commercialId" value="${row.commercialId}" />
			<c:param name="gameId" value="${row.gameId}" />
			<c:param name="courseId" value="${row.courseId}" />
			<c:param name="link" value="${row.link}" />
		<c:param name="pic" value="${row.pic} }" />
		</c:url>
	<tr>
		<td><a href="${link}">${row.commercialId}</a></td>
		<td>${row.gameId}</td>
		<td>${row.courseId}</td>
		<td>${row.link}</td>
		<td><img height='100' width='100' 
		src='${pageContext.request.contextPath}/Commercail/getImage.controller?commercialId=${row.commercialId}'/></td>
<%-- 		<td><img src="${row.pic}"/></td> --%>
	</tr>
	</c:forEach>
	</tbody>
</table>
</c:if>

<h3><a href="<c:url value="/Commercial/CommercialCRUD.jsp" />">Product Table</a></h3>
</body>
</html>