<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Message</title>
<script type="text/javascript" src="<%=request.getContextPath()%>/resources/ckeditor/ckeditor.js"></script>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript" src="../css/json2.js"></script>
<script type="text/javascript">
var contextPath="${pageContext.request.contextPath}";
$(document).ready(function() {
	$("input[name='messageId']").blur(function() {
		$.ajax({
			"url": contextPath+"/pages/blackFriend.view",
			"method": "POST",
			"data": "messageId="+$("input[name='messageId']").val(),
			"success": function(data) {
				var json = JSON.parse(data);
				if(json[0].hasMoreData) {
					$("input[name='messageId']").val(json[1].id);
					$("input[name='memberId']").val(json[1].nameid);
					$("input[name='memberName']").val(json[1].name)
					$("input[name='messageTime']").val(json[1].price);
					$("input[name='typeName']").val(json[1].make);
					$("input[name='messageText']").val(json[1].expire);
					$("input[name='messagePic']").val(json[1].expire);
					$("input[name='star']").val(json[1].expire);
				}
				$("span[class='error']").first().text(json[0].text);
			}
		});
	});
});

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
</head>
<body>

<%-- <h3>Welcome ${user.email}</h3> --%>
<h3>後台討論區</h3>


	<form action="<c:url value="/pages/message.controller"/>" method="post"
	enctype="multipart/form-data" >
		<table>
			<tr>
				<td>編號 :</td>
				<td><input type="text" name="messageId" value="${param.messageId}"></td>
				<td><span class="error">${errors.xxx1}</span></td>
			</tr>

			<tr>
				<td>會員編號 :</td>
				<td><input type="text" name="memberId"
					value="${param['memberId']}"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>會員名稱 :</td>
				<td><input type="text" name="memberName"
					value="${param['memberName']}"></td>
				<td></td>
			</tr>
			
<!-- 			<tr> -->
<!-- 				<td>MessageTime :</td> -->
<!-- 				<td><input type="text" name="messageTime" -->
<%-- 					value="${param['messageTime']}"></td> --%>
<!-- 				<td></td> -->
<!-- 			</tr> -->
			
			<tr>
				<td>主題分類 :</td>
				<td><input type="text" name="typeName"
					value="${param['typeName']}"></td>
				<td></td>
			</tr>
			
			<tr>
				<td>內容 :</td>
				<td>
				<textarea rows="20" cols="20" name="messageText" id="msgck">${param['messageText']}</textarea>
<!-- 				<input type="text" name="messageText" -->
<%-- 					value="${param['messageText']}"></td> --%>
<!-- 				<td> -->
				</td>
			</tr>
			
			<tr>
				<td>圖片 :</td>
				<td><img id="blah" alt="Image" width="100" height="100" />
				<input type="file" name="messagePic"
					value="${param['messagePic']}"
					onchange="document.getElementById('blah').src = window.URL.createObjectURL(this.files[0])">
					</td>
				<td></td>
			</tr>
			
			<tr>
				<td>評價 :</td>
				<td><input type="text" name="star"
					value="${param['star']}"></td>
				<td></td>
			</tr>
			
			

			<tr>
				<td><input type="submit" name="prodaction" value="Insert">
					<input type="submit" name="prodaction" value="Update"></td>
				<td><input type="submit" name="prodaction" value="Delete">
					<input type="submit" name="prodaction" value="Select"> 
					<input type="submit" name="prodaction" value="SelectMessageMemberId">
					<input type="reset" value="Clear"></td>
			</tr>
		</table>
	</form>
	<h3><span class="error">${errors.action}</span></h3>

	<c:if test="${not empty delete}">
	<h3>Delete Message Table Success : ${delete} row deleted</h3>
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<c:if test="${not empty insert}">
	<h3>Insert Message Table Success</h3>
	<table border="1">
			<tr><td>MessageId</td><td>${insert.messageId}</td></tr>
		<tr><td>MemberId</td><td>${insert.memberId}</td></tr>
		<tr><td>MessageTime</td><td>${insert.messageTime}</td></tr>
		<tr><td>TypeName</td><td>${insert.typeName}</td></tr>
		<tr><td>MessageText</td><td>${insert.messageText}</td></tr>
		<tr><td>MessagePic</td><td>${insert.messagePic}</td></tr>
		<tr><td>Star</td><td>${insert.star}</td></tr>
	</table>
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<c:if test="${not empty update}">
	<h3>Update Message Table Success</h3>
	<table border="1">
		<tr><td>MessageId</td><td>${update.messageId}</td></tr>
		<tr><td>MemberId</td><td>${update.memberId}</td></tr>
		<tr><td>MessageTime</td><td>${update.messageTime}</td></tr>
		<tr><td>TypeName</td><td>${update.typeName}</td></tr>
		<tr><td>MessageText</td><td>${update.messageText}</td></tr>
		<tr><td>MessagePic</td><td>${update.messagePic}</td></tr>
		<tr><td>Star</td><td>${update.star}</td></tr>
		
	</table>
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<script>
	CKEDITOR.replace('msgck');
   </script>
</body>
</html>