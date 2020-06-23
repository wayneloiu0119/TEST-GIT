<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>ShoppingCart</title>
<script type="text/javascript">
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

	<h3>ShoppingCart Table</h3>


	<form action="<c:url value="/pages/shoppingCart.controller"/>">
		<table>
			<tr>
				<td>ShoppingCartId :</td>
				<td><input type="text" name="shoppingCartId"
					value="${param.shoppingCartId}"></td>
				<td><span class="error">${errors.xxx1}</span></td>
			</tr>

			<tr>
				<td>MemberId :</td>
				<td><input type="text" name="memberId"
					value="${param['memberId']}"></td>
				<td><span class="error">${errors.xxx2}</span></td>
			</tr>

			<tr>
				<td>CourseId :</td>
				<td><input type="text" name="courseId"
					value="${param.courseId}"></td>
				<td><span class="error">${errors.xxx3}</span></td>
			</tr>
			<tr>
				<td>CourseName :</td>
				<td><input type="text" name="courseName"
					value="${param.courseName}"></td>
				<td><span class="error">${errors.xxx4}</span></td>
			</tr>
			<tr>
				<td>CoursePrice :</td>
				<td><input type="text" name="coursePrice"
					value="${param.coursePrice}"></td>
				<td><span class="error">${errors.xxx5}</span></td>
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
		<h3>Delete Blob Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Blob Table Success</h3>
		<table border="1">
			<tr>
				<td>ShoppingCartId</td>
				<td>${insert.shoppingCartId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${insert.memberId}</td>
			</tr>
			<tr>
				<td>CourseId</td>
				<td>${insert.courseId}</td>
			</tr>
			<tr>
				<td>CourseName</td>
				<td>${insert.courseName}</td>
			</tr>
			<tr>
				<td>CoursePrice</td>
				<td>${insert.coursePrice}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Blob Table Success</h3>
		<table border="1">

			<tr>
				<td>ShoppingCartId</td>
				<td>${update.shoppingCartId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${update.memberId}</td>
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
				<td>CoursePrice</td>
				<td>${update.coursePrice}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

</body>
</html>