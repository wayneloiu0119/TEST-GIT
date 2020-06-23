<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>CartTest</title>
<script src="../resources/js/jquery-3.2.1.min.js"></script>
<script type="text/javascript" src="../resources/js/json2.js"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {
		$("input[name='id']").blur(function() {
			$.ajax({
				"url" : contextPath + "/pages/course.view",
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
	<h3>CartTest</h3>
	
	<A href="<c:url value='/pages/_ShowCartContent.jsp' />" >購物清單</A>
	<p/>
	<A href="<c:url value='/pages/ShowCartContent.jsp' />" >購物清單Cart</A>
	<p/>
	<A href="<c:url value='/shoppingCart/processOrder.controller' />" >結帳</A>
	<p/>
	<A href="<c:url value='/shoppingCart/giveUp.controller' />" >清除</A>
	
	<hr>

	<form action="<c:url value="/pages/course.controller"/>" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>CourseId :</td>
				<td><input type="text" name="courseId"
					value="${param.courseId}"></td>
				<td><span class="error">${errors.xxx01}</span></td>
			</tr>
			<tr>
				<td>CourseName :</td>
				<td><input type="text" name="courseName"
					value="${param.courseName}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CourseStartDate :</td>
				<td><input type="text" name="courseStartDate"
					value="${param.courseStartDate}"></td>
				<td><span class="error">${errors.xxx02}</span></td>
			</tr>
			<tr>
				<td>CourseEndDate :</td>
				<td><input type="text" name="courseEndDate"
					value="${param.courseEndDate}"></td>
				<td><span class="error">${errors.xxx03}</span></td>
			</tr>
			<tr>
				<td>CourseWeek :</td>
				<td><input type="text" name="courseWeek"
					value="${param.courseWeek}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CourseStartTime :</td>
				<td><input type="text" name="courseStartTime"
					value="${param.courseStartTime}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CourseEndTime :</td>
				<td><input type="text" name="courseEndTime"
					value="${param.courseEndTime}"></td>
				<td></td>
			</tr>
			<tr>
				<td>Frequency :</td>
				<td><input type="text" name="frequency"
					value="${param.frequency}"></td>
				<td><span class="error">${errors.xxx04}</span></td>
			</tr>
			<tr>
				<td>CoursePrice :</td>
				<td><input type="text" name="coursePrice"
					value="${param.coursePrice}"></td>
				<td><span class="error">${errors.xxx05}</span></td>
			</tr>
			<tr>
				<td>Discount :</td>
				<td><input type="text" name="discount"
					value="${param.discount}"></td>
				<td><span class="error">${errors.xxx06}</span></td>
			</tr>
			<tr>
				<td>DiscountPrice :</td>
				<td><input type="text" name="discountPrice"
					value="${param.discountPrice}"></td>
				<td><span class="error">${errors.xxx07}</span></td>
			</tr>
			<tr>
				<td>TypeId :</td>
				<td><input type="text" name="typeId" value="${param.typeId}"></td>
				<td><span class="error">${errors.xxx08}</span></td>
			</tr>
			<tr>
				<td>CourseKind :</td>
				<td><input type="text" name="courseKind"
					value="${param.courseKind}"></td>
				<td></td>
			</tr>
			<tr>
				<td>CoursePic :</td>
				<td><input type="file" name="coursePic"
					value="${param.coursePic}" accept="image/png,image/gif,image/jpeg">
					<!--限制只能傳圖片 --></td>
				<td><span class="error">${errors.xxx09}</span></td>
			</tr>
			<tr>
				<td>RoomId :</td>
				<td><input type="text" name="roomId" value="${param.roomId}"></td>
				<td><span class="error">${errors.xxx10}</span></td>
			</tr>
			<tr>
				<td>MemberId :</td>
				<td><input type="text" name="memberId"
					value="${param.memberId}"></td>
				<td><span class="error">${errors.xxx11}</span></td>
			</tr>
			<tr>
				<td><input type="submit" name="prodaction" value="Insert">
					<input type="submit" name="prodaction" value="Update"></td>
				<td><input type="submit" name="prodaction" value="Delete">
					<input type="submit" name="prodaction" value="Select"> <input
					type="button" value="Clear" onclick="clearForm()"></td>
			</tr>
		</table>
	</form>

	<h3>
		<span class="error">${errors.action}</span>
	</h3>

	<c:if test="${not empty delete}">
		<h3>Delete Course Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Course Table Success</h3>
		<table border="1">
			<tr>
				<td>CourseId</td>
				<td>${insert.courseId}</td>
			</tr>
			<tr>
				<td>CourseName</td>
				<td>${insert.courseName}</td>
			</tr>
			<tr>
				<td>CourseStartDate</td>
				<td>${insert.courseStartDate}</td>
			</tr>
			<tr>
				<td>CourseEndDate</td>
				<td>${insert.courseEndDate}</td>
			</tr>
			<tr>
				<td>CourseWeek</td>
				<td>${insert.courseWeek}</td>
			</tr>
			<tr>
				<td>CourseStartTime</td>
				<td>${insert.courseStartTime}</td>
			</tr>
			<tr>
				<td>CourseEndTime</td>
				<td>${insert.courseEndTime}</td>
			</tr>
			<tr>
				<td>Frequency</td>
				<td>${insert.frequency}</td>
			</tr>
			<tr>
				<td>CoursePrice</td>
				<td>${insert.coursePrice}</td>
			</tr>
			<tr>
				<td>Discount</td>
				<td>${insert.discount}</td>
			</tr>
			<tr>
				<td>DiscountPrice</td>
				<td>${insert.discountPrice}</td>
			</tr>
			<tr>
				<td>TypeId</td>
				<td>${insert.typeId}</td>
			</tr>
			<tr>
				<td>CourseKind</td>
				<td>${insert.courseKind}</td>
			</tr>
			<tr>
				<td>CoursePic</td>
				<td>${insert.coursePic}</td>
			</tr>
			<tr>
				<td>RoomId</td>
				<td>${insert.roomId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${insert.memberId}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Course Table Success</h3>
		<table border="1">
			<tr>
				<td>CourseId</td>
				<td>${update.courseId}</td>
			</tr>
			<tr>
				<td>CourseName</td>
				<td>${update.courseName}</td>
			</tr>
			<tr>
				<td>CourseStartDate</td>
				<td>${update.courseStartDate}</td>
			</tr>
			<tr>
				<td>CourseEndDate</td>
				<td>${update.courseEndDate}</td>
			</tr>
			<tr>
				<td>CourseWeek</td>
				<td>${update.courseWeek}</td>
			</tr>
			<tr>
				<td>CourseStartTime</td>
				<td>${update.courseStartTime}</td>
			</tr>
			<tr>
				<td>CourseEndTime</td>
				<td>${update.courseEndTime}</td>
			</tr>
			<tr>
				<td>Frequency</td>
				<td>${update.frequency}</td>
			</tr>
			<tr>
				<td>CoursePrice</td>
				<td>${update.coursePrice}</td>
			</tr>
			<tr>
				<td>Discount</td>
				<td>${update.discount}</td>
			</tr>
			<tr>
				<td>DiscountPrice</td>
				<td>${update.discountPrice}</td>
			</tr>
			<tr>
				<td>TypeId</td>
				<td>${update.typeId}</td>
			</tr>
			<tr>
				<td>CourseKind</td>
				<td>${update.courseKind}</td>
			</tr>
			<tr>
				<td>CoursePic</td>
				<td>${update.coursePic}</td>
			</tr>
			<tr>
				<td>RoomId</td>
				<td>${update.roomId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${update.memberId}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>
</body>
</html>