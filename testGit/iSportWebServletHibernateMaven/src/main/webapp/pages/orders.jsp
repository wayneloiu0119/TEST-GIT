<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Orders</title>
<script	src="../js/jquery.min.js"></script>
<script type="text/javascript" src="../css/json2.js"></script>
<script type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {
		$("input[name='id']").blur(function() {
			$.ajax({
				"url" : contextPath + "/pages/orders.view",
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
	<h3>Orders Table</h3>
	<form action="<c:url value="/pages/orders.controller"/>" method="post">
		<table>
			<tr>
				<td>OrderId :</td>
				<td><input type="text" name="orderId" value="${param.orderId}"></td>
				<td><span class="error">${errors.orderIdError}</span></td>
			</tr>
			<tr>
				<td>MemberId :</td>
				<td><input type="text" name="memberId"
					value="${param.memberId}"></td>
				<td><span class="error">${errors.xxx1}</span></td>
			</tr>
			<tr>
				<td>OrderDate :</td>
				<td><input type="text" name="orderDate"
					value="${param.orderDate}"></td>
				<td><span class="error">${errors.xxx2}</span></td>
			</tr>
			<tr>
				<td>OrderPrice :</td>
				<td><input type="text" name="orderPrice"
					value="${param.orderPrice}"></td>
				<td><span class="error">${errors.xxx3}</span></td>
			</tr>
			<tr>
				<td>Payment :</td>
				<td><input type="text" name="payment" value="${param.payment}"></td>
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
		<h3>Delete Orders Table Success : ${delete} row deleted</h3>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty insert}">
		<h3>Insert Orders Table Success</h3>
		<table border="1">
			<tr>
				<td>OrderId</td>
				<td>${insert.orderId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${insert.memberId}</td>
			</tr>
			<tr>
				<td>OrderDate</td>
				<td>${insert.orderDate}</td>
			</tr>
			<tr>
				<td>OrderPrice</td>
				<td>${insert.orderPrice}</td>
			</tr>
			<tr>
				<td>Payment</td>
				<td>${insert.payment}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>

	<c:if test="${not empty update}">
		<h3>Update Orders Table Success</h3>
		<table border="1">
			<tr>
				<td>OrderId</td>
				<td>${update.orderId}</td>
			</tr>
			<tr>
				<td>MemberId</td>
				<td>${update.memberId}</td>
			</tr>
			<tr>
				<td>OrderDate</td>
				<td>${update.orderDate}</td>
			</tr>
			<tr>
				<td>OrderPrice</td>
				<td>${update.orderPrice}</td>
			</tr>
			<tr>
				<td>Payment</td>
				<td>${update.payment}</td>
			</tr>
		</table>
		<script type="text/javascript">
			clearForm();
		</script>
	</c:if>
</body>
</html>