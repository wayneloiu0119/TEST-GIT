<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../resources/css/main.css" />

<title>Product</title>
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

	<form action="<c:url value="/Game/GameCRUD.controller"/>" method="post">
		<table>
			<tr>
				<td>比賽編號 :</td>
				<td><input type="text" name="gameId" value="${param.gameId}"></td>
				<td><span class="error">${errors.gameId}</span></td>
			</tr>
			<tr>
				<td>比賽名稱 :</td>
				<td><input type="text" name="gameName"
					value="${param.gameName}"></td>
				<td></td>
			</tr>

			<tr>
				<td>比賽日期 :</td>
				<td><input type="text" name="gameDate"
					value="${param.gameDate}"></td>
				<td>${errors.gameDate}</td>
			</tr>
			<tr>
				<td>比賽時間 :</td>
				<td><input type="text" name="gameTime"
					value="${param.gameTime}"></td>
				<td>${errors.gameTime}</td>
			</tr>
			<tr>
				<td>目前人數 :</td>
				<td><input type="text" name="number" value="${param.number}"></td>
				<td>${errors.number}</td>
			</tr>
			<tr>
				<td>人數上限 :</td>
				<td><input type="text" name="numberMax"
					value="${param.numberMax}"></td>
				<td>${errors.numberMax}</td>
			</tr>
			<tr>
				<td>比賽地點 :</td>
				<td><input type="text" name="gameLocation"
					value="${param.gameLocation}"></td>
				<td></td>
			</tr>
			<tr>
				<td>報名截止日期 :</td>
				<td><input type="text" name="deadLine"
					value="${param.deadLine}"></td>
				<td>${errors.deadLine}</td>
			</tr>
			<tr>
				<td>報名狀態 :</td>
				<td><input type="text" name="states" value="${param.states}"></td>
				<td></td>
			</tr>
			<tr>
				<td>比賽類型 :</td>
				<td><input type="text" name="typeId" value="${param.typeId}"></td>
				<td>${errors.gameType}</td>
			</tr>
			<tr>
				<td>比賽描述 :</td>
				<td><input type="text" name="gameText"
					value="${param.gameText}"></td>
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
				<td>比賽編號 :</td>
				<td>${param.gameId}</td>
			</tr>
			<tr>
				<td>比賽名稱 :</td>
				<td>${param.gameName}</td>
			</tr>
			<tr>
				<td>比賽日期 :</td>
				<td>${param.gameDate}</td>
			</tr>
			<tr>
				<td>比賽時間 :</td>
				<td>${param.gameTime}</td>
			</tr>
			<tr>
				<td>目前人數 :</td>
				<td>${param.number}</td>
			</tr>
			<tr>
				<td>人數上限 :</td>
				<td>${param.numberMax}</td>
			</tr>
			<tr>
				<td>比賽地點 :</td>
				<td>${param.gameLocation}</td>
			</tr>
			<tr>
				<td>報名截止日期 :</td>
				<td>${param.deadLine}</td>
			</tr>
			<tr>
				<td>報名狀態 :</td>
				<td>${param.states}</td>
			</tr>
			<tr>
				<td>比賽類型 :</td>
				<td>${param.typeId}</td>
			</tr>
			<tr>
				<td>比賽描述 :</td>
				<td>${param.gameText}</td>
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
				<td>比賽編號 :</td>
				<td>${update.gameId}</td>
			</tr>
			<tr>
				<td>比賽名稱 :</td>
				<td>${update.gameName}</td>
			</tr>
			<tr>
				<td>比賽日期 :</td>
				<td>${update.gameDate}</td>
			</tr>
			<tr>
				<td>比賽時間 :</td>
				<td>${update.gameTime}</td>
			</tr>
			<tr>
				<td>目前人數 :</td>
				<td>${update.number}</td>
			</tr>
			<tr>
				<td>人數上限 :</td>
				<td>${update.numberMax}</td>
			</tr>
			<tr>
				<td>比賽地點 :</td>
				<td>${update.gameLocation}</td>
			</tr>
			<tr>
				<td>報名截止日期 :</td>
				<td>${update.deadLine}</td>
			</tr>
			<tr>
				<td>報名狀態 :</td>
				<td>${update.states}</td>
			</tr>
			<tr>
				<td>比賽類型 :</td>
				<td>${update.typeId}</td>
			</tr>
			<tr>
				<td>比賽描述 :</td>
				<td>${update.gameText}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<script src='<c:url value="/resources/js/jquery-3.2.1.min.js" />'></script>

</body>
</html>