<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../resources/css/xxx.css" />

<title>Product</title>
<script
	src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../resources/js/json2.js"></script>
<script type="text/javascript">
	// var contextPath="${pageContext.request.contextPath}";
	// $(document).ready(function() {
	// 	$("input[name='id']").blur(function() {
	// 		$.ajax({
	// 			"url": contextPath+"/pages/product.view",
	// 			"method": "POST",
	// 			"data": "id="+$("input[name='id']").val(),
	// 			"success": function(data) {
	// 				var json = JSON.parse(data);
	// 				if(json[0].hasMoreData) {
	// 					$("input[name='id']").val(json[1].id);
	// 					$("input[name='name']").val(json[1].name);
	// 					$("input[name='price']").val(json[1].price);
	// 					$("input[name='make']").val(json[1].make);
	// 					$("input[name='expire']").val(json[1].expire);
	// 				}
	// 				$("span[class='error']").first().text(json[0].text);
	// 			}
	// 		});
	// 	});
	// });

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

	<h3>Welcome ${user.email}</h3>

	<h3>Product Table</h3>

	<form action="<c:url value="/Commercial/CommercialCRUD.controller"/>"
		method="post" enctype="multipart/form-data">
		<table>
			<tr>
				<td>廣告編號 :</td>
				<td><input type="text" name="commercialId"
					value="${param.commercialId}"></td>
				<td><span class="error">${errors.commercialId}</span></td>
			</tr>
			<tr>
				<td>比賽編號 :</td>
				<td><input type="text" name="gameId" value="${param.gameId}"></td>
				<td></td>
			</tr>

			<tr>
				<td>課程編號 :</td>
				<td><input type="text" name="courseId"
					value="${param.courseId}"></td>
				<td></td>
			</tr>
			<tr>
				<td>連結 :</td>
				<td><input type="text" name="link" value="${param.link}"></td>
				<td></td>
			</tr>
			<tr>
				<td>圖片 :</td>
				<td><input type=file name="pic" value="${param.pic}"></td>
				<td></td>
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
		<h3>Delete Product Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Product Table Success</h3>
		<table border="1">
			<tr>
				<td>廣告編號 :</td>
				<td>${param.commercialId}</td>
			</tr>
			<tr>
				<td>比賽編號 :</td>
				<td>${param.gameId}</td>
			</tr>
			<tr>
				<td>課程編號 :</td>
				<td>${param.courseId}</td>
			</tr>
			<tr>
				<td>連結 :</td>
				<td>${param.link}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Product Table Success</h3>
		<table border="1">
			<tr>
				<td>廣告編號 :</td>
				<td>${update.commercialId}</td>
			</tr>
			<tr>
				<td>比賽編號 :</td>
				<td>${update.gameId}</td>
			</tr>
			<tr>
				<td>課程編號 :</td>
				<td>${update.courseId}</td>
			</tr>
			<tr>
				<td>連結 :</td>
				<td>${update.link}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>


</body>
</html>