<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Calendar</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/json2.js"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {
		$("input[name='id']").blur(function() {
			$.ajax({
				"url" : contextPath + "/pages/product.view",
				"method" : "POST",
				"data" : "id=" + $("input[name='id']").val(),
				"success" : function(data) {
					var json = JSON.parse(data);
					if (json[0].hasMoreData) {
						$("input[name='id']").val(json[1].id);
						$("input[name='name']").val(json[1].name);
						$("input[name='price']").val(json[1].price);
						$("input[name='make']").val(json[1].make);
						$("input[name='expire']").val(json[1].expire);
					}
					$("span[class='error']").first().text(json[0].text);
				}
			});
		});
	});

	function clearForm() {
		var inputs = document.getElementsByTagName("input");
		for (var i = 0; i < inputs.length; i++) {
			if (inputs[i].type == "text") {
				inputs[i].value = "";
			}
		}
	}
</script>
</head>
<body>
	<h3>Calendar Table</h3>
	<form action="<c:url value="/pages/calendar.controller"/>" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>CalendarId :</td>
				<td><input type="text" name="calendarId" value="${param.calendarId}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CourseId :</td>
				<td><input type="text" name="courseId" value="${param.courseId}"></td>
<%-- 				<td><span class="error">${errors.xxx01}</span></td> --%>
			</tr>
			<tr>
				<td>CourseName :</td>
				<td><input type="text" name="courseName" value="${param.courseName}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CourseStart :</td>
				<td><input type="text" name="courseStart" value="${param.courseStart}"></td>
<%-- 				<td><span class="error">${errors.xxx02}</span></td> --%>
			</tr>
			<tr>
				<td>CourseEnd :</td>
				<td><input type="text" name="courseEnd" value="${param.courseEnd}"></td>
<%-- 				<td><span class="error">${errors.xxx03}</span></td> --%>
			</tr>
			<tr>
				<td>
					<input type="submit" name="prodaction" value="Insert">
					<input type="submit" name="prodaction" value="Update">
				</td>
				<td>
					<input type="submit" name="prodaction" value="Delete">
					<input type="submit" name="prodaction" value="Select"> 
					<input type="button" value="Clear" onclick="clearForm()">
				</td>
			</tr>
		</table>
	</form>

	<h3>
		<span class="error">${errors.action}</span>
	</h3>

	<c:if test="${not empty delete}">
		<h3>Delete Calendar Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Calendar Table Success</h3>
		<table border="1">
<!-- 			<tr> -->
<!-- 				<td>CalendarId</td> -->
<%-- 				<td>${insert.calendarId}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>CourseId</td> -->
<%-- 				<td>${insert.courseId}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>CourseName</td> -->
<%-- 				<td>${insert.courseName}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>CourseStart</td> -->
<%-- 				<td>${insert.courseStart}</td> --%>
<!-- 			</tr> -->
<!-- 			<tr> -->
<!-- 				<td>CourseEnd</td> -->
<%-- 				<td>${insert.courseEnd}</td> --%>
<!-- 			</tr> -->
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Calendar Table Success</h3>
		<table border="1">
			<tr>
				<td>CalendarId</td>
				<td>${update.calendarId}</td>
			</tr>
			<tr>
				<td>CourseId</td>
				<td>${update.courseId}</td>
			</tr>
			<tr>
				<td>CourseName</td>
				<td>${update.courseName}</td>
			</tr>
			<tr>
				<td>CourseStart</td>
				<td>${update.courseStart}</td>
			</tr>
			<tr>
				<td>CourseEnd</td>
				<td>${update.courseEnd}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>
</body>
</html>