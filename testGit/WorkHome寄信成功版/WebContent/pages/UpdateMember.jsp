<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>修改會員資料</title>
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script type="text/javascript">
var contextPath="${pageContext.request.contextPath}";
$(document).ready(function() {
$("input[name='mId']").blur(function() {
$.ajax({
"url": contextPath+"/pages/UpdateMember.view",
"method": "POST",
"data": "mId="+$("input[name='memberId']").val(),
"success": function(data) {
var json = JSON.parse(data);
if(json[0].hasMoreData) {
$("input[name='mId']").val(json[1].id);
$("input[name='pswd']").val(json[1].pswd);
$("input[name='mName']").val(json[1].name);
$("input[name='mBirthday']").val(json[1].bday);
$("input[name='mEmail']").val(json[1].mail);
$("input[name='mPhone']").val(json[1].hone);
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
<body onload="javascript:document.insertMemberFormA.mId.focus();">
<body>



<Form Action="<c:url value='/Controller/UpdateServlet'/>" method="POST">
                            
<table>
<tr><td>修改會員資料</td></tr>
<tr>
<td><input id="num" type="hidden" type="text" name="mId" value="${param.mId}"/></td>

</tr>
<tr>
<td>密碼:</td>
<td><input id="num" type="text" name="pswd" value="${param.pswd}"/></td>
<td style="color:red;">${ErrorMsg.password}</td>
</tr>
<tr>
<td>名字:</td>
<td><input id="num" type="text" name="mName" value="${param.mName}"/></td>
<td style="color:red;">${ErrorMsg.name}</td>
</tr>
<tr>
<td>生日:</td>
<td><input id="num" type="text" name="mBirthday" value="${param.mBirthday}"/></td>
<td style="color:red;">${ErrorMsg.bday}${ErrorMsg.bday2}</td>
</tr>
<tr>
<td>信箱:</td>
<td><input id="num" type="text" name="mEmail" value="${param.mEmail}"/></td>
<td style="color:red;">${ErrorMsg.email}</td>
</tr>
<tr>
<td>電話:</td>
<td><input id="num" type="text" name="mPhone" value="${param.mPhone}"/></td>
<td style="color:red;">${ErrorMsg.phone}</td>
</tr>
<tr>
<td><input type="submit" value="修改">
<!-- 	<input type="reset" value="Clear" onclick="clearForm()"></td> -->
</tr>



</table>
<div>${ErrorMsg.exception}</div>
</form>

<h3><span class="error">${errors.action}</span></h3>

<c:if test="${not empty update}}">
<h3>Update Member Table Success</h3>
	<table border="1">
	<tr><td>MemberId</td><td>${update.memberId}</td></tr>
		<tr><td>Password</td><td>${update.password}</td></tr>
		<tr><td>Name</td><td>${update.name}</td></tr>
		<tr><td>Birthday</td><td>${update.birthday}</td></tr>
		<tr><td>Email</td><td>${update.email}</td></tr>
		<tr><td>Phone</td><td>${update.phone}</td></tr>
		</table>
	<script type="text/javascript">clearForm();</script>
</c:if>
</body>
</html>