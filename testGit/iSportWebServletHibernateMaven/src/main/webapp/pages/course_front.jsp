<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<title>課程</title>
<style type="text/css">
table {
	width: 100%;
	/* 	border: 1px solid black; */
	/* 	table邊框合在一起 */
	border-collapse: collapse;
	margin: 0 auto;
}

tr, td {
	width: 10%;
	/* 	font-size: 30px; */
	/* 	border: 1px solid black; */
	/* 	text-align: center; */
	border-collapse: collapse;
	//
}

.row {
	/* 	border: 1px solid black; */
	width: 1024px;
	margin: 0 auto;
	/* 	font-size: 200%; */
}
</style>
<script></script>
</head>
<body>
	<a href="<c:url value="/index" />">回首頁</a>
	<h1 style="text-align: center;">課程列表</h1>

	<!-- div -->

	<c:forEach varStatus="zz" var="co" items="${select}">
	
		

		<div>
			<div class="row">
				<div class="col-md-12"
					style="background-color: #97CBFF; font-size: 20px">
					${co.courseName}
					<button type="button" class="btn btn-primary" style="float: right;">收藏課程</button>
					<FORM action="<c:url value='/shoppingCart/buycourse.controller' />" method="POST"
						style="float: right;">
						<!-- 這些隱藏欄位都會送到後端 -->
						<Input type='hidden' name='courseId' value='${co.courseId}'>
						<Input type='hidden' name='courseName' value='${co.courseName}'>
						<Input type='hidden' name='courseStartDate' value='${co.courseStartDate}'>
						<Input type='hidden' name='courseStartTime' value='${co.courseStartTime}'>
						<Input type='hidden' name='coursePrice' value='${co.coursePrice}'>
						<Input type='hidden' name='discount' value='${co.discount}'>
						<Input type='hidden' name='memberId' value='${co.memberId}'> <Input
							type='submit' value='加入購物車'>
					</FORM>
				</div>
				<!-- 				<div class="col-md-1" style="background-color: #97CBFF"> -->
				<!-- 				</div> -->
			</div>
			<div class="row">
				<div class="col-md-12">
					<c:if test="${not empty co.coursePic}">
						<img
							style="max-height: 600px; max-width: 800px; display: block; margin: auto;"
							src="${pageContext.servletContext.contextPath}/pages/CourseGetImage?courseId=${co.courseId}" />
					</c:if>
				</div>
			</div>
			<div class="row">
				<div class="col-md-6">
					課程日期:
					<fmt:formatDate pattern="yyyy-MM-dd" value="${co.courseStartDate}" />
					~
					<fmt:formatDate pattern="yyyy-MM-dd" value="${co.courseEndDate}" />
				</div>
				<div class="col-md-6">上課時間:每週${co.courseWeek}從${fn:substring(co.courseStartTime,0,5)}到${fn:substring(co.courseEndTime,0,5)}</div>
			</div>
			<div class="row">
				<%-- 				<div class="col-md-6">課程價錢:${co.coursePrice}元</div> --%>
				<div class="col-md-6">
					課程價錢:
					<fmt:formatNumber value="${co.coursePrice}" pattern="#####" />
					元
				</div>
				<div class="col-md-6">堂數:${co.frequency}堂</div>
			</div>
			<div class="row">
				<%-- 				<div class="col-md-6">類型:${co.courseKind} ${co.typeName}</div> --%>
				<div class="col-md-6">類型:${co.courseKind}
				
				
				<c:forEach varStatus="xx" var="co1" items="${select1}">
				<c:if test="${co.typeId == co1.typeId}">${co1.typeName}</c:if>
				</c:forEach>
				
				</div>
				<div class="col-md-6">上課地點:${co.roomId}教室</div>
			</div>
			<div class="row">
				<div class="col-md-6">教練:${co.memberId}</div>
				<div class="col-md-6"></div>
			</div>
			<div class="row">
				<div class="col-md-12">
					<p />
				</div>
			</div>
		</div>
	</c:forEach>
	




	<!-- 	<br /> -->
	<!-- 	<br /> -->
	<!-- 	<br /> -->
	<!-- 	<br /> -->
	<!-- 	<br /> -->
	<!-- 		<form> -->
	<%-- 					<c:forEach var="course" items="${select}"> --%>
	<!-- 			<tbody> -->
	<!-- 				<tr> -->
	<%-- 					<td colspan="8">課程名稱 ${courseName}</td> --%>
	<!-- 					<td colspan="2" width="100px"><button type="button" -->
	<!-- 							class="btn btn-primary">Primary</button></td> -->
	<!-- 				</tr> -->
	<!-- 				<tr> -->
	<%-- 		<td colspan="10">圖片<c:if test="${not empty coursePic}"> --%>
	<!-- 				<img style="max-height: 200px; max-width: 400px" -->
	<%-- 					src="${pageContext.servletContext.contextPath}/pages/CourseGetImage?courseId=${courseId}" /> --%>
	<%-- 			</c:if></td> --%>
	<!-- 				</tr> -->
	<!-- 				<tr> -->
	<%-- 					<td colspan="5">課程日期:${courseStartDate}~${courseEndDate}</td> --%>
	<!-- 					<td colspan="5">上課時間:每週 -->
	<%-- 						${courseWeek}的${courseStartTime}到${courseEndTime}</td> --%>
	<!-- 				</tr> -->
	<!-- 				<tr> -->
	<%-- 					<td colspan="5">課程價錢:${coursePrice}</td> --%>
	<%-- 					<td colspan="5">堂數:${frequency}</td> --%>
	<!-- 				</tr> -->
	<!-- 				<tr> -->
	<%-- 					<td colspan="5">類型:${courseKind} ${typeName}</td> --%>
	<%-- 					<td colspan="5">教室:${roomId}</td> --%>
	<!-- 				</tr> -->
	<!-- 				<tr> -->
	<!-- 					<td></td> -->
	<!-- 					<td></td> -->
	<!-- 				</tr> -->
	<!-- 			</tbody> -->
	<%-- 			</c:forEach> --%>
	<!-- 		</form> -->
</body>
</html>