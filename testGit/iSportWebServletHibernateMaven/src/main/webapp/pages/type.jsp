<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Type</title>
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

	<h3>Type Table</h3>


	<form action="<c:url value="/pages/type.controller"/>">
		<table>
			<tr>
				<td>TypeId :</td>
				<td><input type="text" name="typeId" value="${param.typeId}"></td>
				<td><span class="error">${errors.xxx1}</span></td>
			</tr>

			<tr>
				<td>TypeName :</td>
				<td><input type="text" name="typeName"
					value="${param['typeName']}"></td>
				<td><span class="error">${errors.xxx2}</span></td>
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
		<h3>Delete Type Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Type Table Success</h3>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>${insert.typeId}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${insert.typeName}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Type Table Success</h3>
		<table border="1">
			<tr>
				<td>Id</td>
				<td>${update.typeId}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${update.typeName}</td>
			</tr>

		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

</body>
</html>