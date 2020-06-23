<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Blob</title>
</head>
<body>

	<h3>Blob Table</h3>


	<form action="<c:url value="/pages/blobEx.controller"/>" method="post"
		enctype="multipart/form-data">
		<table>
			<tr>
				<td>Id :</td>
				<td><input type="text" name="id" value="${param.id}"></td>
				<td><span class="error">${errors.xxx1}</span></td>
			</tr>

			<tr>
				<td>Name :</td>
				<td><input type="text" name="name" value="${param['name']}"></td>
				<td></td>
			</tr>

			<tr>
				<td>Photo :</td>
				<td><img id="blah" alt="Image" width="100" height="100" /> <input
					type="file" name="photo" value="${param.photo}"
					onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])">
				</td>
				<td><span class="error">${errors.xxx3}</span></td>
			</tr>

			<tr>
				<td><input type="submit" name="prodaction" value="Insert">
					<input type="submit" name="prodaction" value="Update"></td>
				<td><input type="submit" name="prodaction" value="Delete">
					<input type="submit" name="prodaction" value="Select"> <input
					type="reset" value="Clear"></td>
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
				<td>Id</td>
				<td>${insert.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${insert.name}</td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>${insert.photo}</td>
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
				<td>Id</td>
				<td>${update.id}</td>
			</tr>
			<tr>
				<td>Name</td>
				<td>${update.name}</td>
			</tr>
			<tr>
				<td>Photo</td>
				<td>${update.photo}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

</body>
</html>