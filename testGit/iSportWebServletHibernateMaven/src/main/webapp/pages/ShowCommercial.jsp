<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<link rel="stylesheet"
	href="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/css/bootstrap.min.css"
	integrity="sha384-/Y6pD6FV/Vv2HJnA6t+vslU6fwYXjCFtcEpHbNJ0lyAFsXTsjBbfaDjzALeQsN6M"
	crossorigin="anonymous">

</head>
<body>
	<!-- <div class="table-users"> -->
	<!--         <div class="header">Users</div> -->

	<c:if test="${not empty select}">
		<table class="table table-hover table-inverse">
			<thead>
				<tr>
					<th>廣告編號 :</th>
					<th>比賽編號 :</th>
					<th>課程編號 :</th>
					<th>圖片 :</th>
				</tr>
			</thead>
			<c:forEach var="row" items="${select}">
				<tr>
					<td><a href="${link}">${row.commercialId}</a></td>
					<td>${row.gameId}</td>
					<td>${row.courseId}</td>
					<%-- 		<td>${row.link}</td> --%>
					<td><img height='100' width='100'
						src='${pageContext.request.contextPath}/Commercail/getImage.controller?commercialId=${row.commercialId}' /></td>
				</tr>
			</c:forEach>
			</tbody>
		</table>
	</c:if>
	<!--     </div> -->



	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>

</body>
</html>