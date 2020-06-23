<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link rel="stylesheet" type="text/css" href="../css/main.css" />

<title>Product</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../css/json2.js"></script>
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
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
<body>

<h3>Welcome ${user.email}</h3>

<h3>Product Table</h3>

<form action="<c:url value="/Party/JoinQuitParty.controller"/>" method="post">
<table>
	<tr>
		<td>活動編號 : </td>
		<td><input type="text" name="partyId" value="${param.partyId}"></td>
		<td><span class="error">${errors.gameId}</span></td>
	</tr>
	<tr>
		<td>會員編號 : </td>
		<td><input type="text" name="memberId" value="${param.memberId}"></td>
		<td></td>
	</tr>

	<tr>
		<td>加入日期 : </td>
		<td><input type="text" name="partyJoinDate" value="${param.partyJoinDate}"></td>
		<td></td>
	</tr>
	<tr>
		<td>加入時間 : </td>
		<td><input type="text" name="partyJoinTime" value="${param.partyJoinTime}"></td>
		<td></td>
	</tr>
		<td>
			<input type="submit" name="prodaction" value="Insert">
		</td>
		<td>
			<input type="submit" name="prodaction" value="SelectAll">
			<input type="submit" name="prodaction" value="ShowPartyByMemberId">
			<input type="submit" name="prodaction" value="ShowMemberByPartyId">
			<input type="submit" name="prodaction" value="Delete">
			<input type="button" value="Clear" onclick="clearForm()">
		</td>
	</tr>
</table>

</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty delete}">
<h3>Delete Product Table Success : ${delete} row deleted</h3>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty insert}">
<h3>Insert Product Table Success</h3>
<table border="1">
	<tr><td>活動編號:</td><td>${insert.partyId}</td></tr>
	<tr><td>會員編號:</td><td>${insert.memberId}</td></tr>
	<tr><td>加入日期:</td><td>${insert.partyJoinDate}</td></tr>
	<tr><td>加入時間:</td><td>${insert.partyJoinTime}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>

<c:if test="${not empty update}">
<h3>Update Product Table Success</h3>
<table border="1">
	<tr><td>活動編號:</td><td>${update.partyId}</td></tr>
	<tr><td>會員編號:</td><td>${update.memberId}</td></tr>
	<tr><td>加入日期:</td><td>${update.partyJoinDate}</td></tr>
	<tr><td>加入時間:</td><td>${update.partyJoinTime}</td></tr>
</table>
<script type="text/javascript">clearForm();</script>
</c:if>
