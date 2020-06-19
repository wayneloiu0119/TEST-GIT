<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員加入</title>

<!-- ------------------------------------------------------------------------------------------------------------ -->
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function subForm(theform){
	   if(document.form1.mId.value.length == 0){
	    alert("請輸入帳號");
	    document.form1.mId.focus();
	    return false;
	   }
	   if(document.form1.pswd.value.length == 0){
		    alert("請輸入密碼");
		    document.form1.pswd.focus();
		    return false;
		}
	var email = document.form1.email.value;
	if(email == ""){
		alert("請輸入信箱");
		document.form1.email.focus();
		return false;
	}
	var emailtest =  /^[a-zA-Z0-9]+[a-zA-Z0-9_.-]+[a-zA-Z0-9_-]+@[a-zA-Z0-9]+[a-zA-Z0-9.-]+[a-zA-Z0-9]+.[a-z]{2,4}$/;
	  if(!emailtest.test(email)){
		  alert("输入的email格式不正確");
		  document.form1.email.focus();
	 return false;
}
	 return true;
}

</script>
<!-- ------------------------------------------------------------------------------------------------------------ -->

</head>
<!-- <body onload="javascript:document.insertMemberFormA.mId.focus();"> -->
<div>
<Form Action="<c:url value='/Controller/MemberServlet'/>" method="POST" name="form1" onsubmit="return subForm(this);" >
<table>
<tr><td>新增會員資料</td></tr>
<tr></tr>
<tr>
<td>帳號:</td>
<td><input id="mId" name="mId" value="${param.mId}" type="text" class="required"></td>
<td  style="color:red;" >${ErrorMsg.id}${ErrorMsg.id2}</td>
</tr>
<tr>
<td>密碼:</td>
<td><input id="pswd" name="pswd" value="${param.pswd}" type="text" class="required"></td>
<td style="color:red;">${ErrorMsg.password}</td>
</tr>
<tr>
<td>姓名:</td>
<td><input id="num" name="mName" value="${param.mName}" type="text" class="required"></td>
<td style="color:red;">${ErrorMsg.name}</td>
</tr>
<tr>
<td>生日:</td>
<td><input id="num" name="mBirthday" value="${param.mBirthday}" type="text" class="required"></td>
<td style="color:red;">${ErrorMsg.bday}${ErrorMsg.bday2}</td>
</tr>
<tr>
<td>Email:</td>
<td><input id="email" name="mEmail" value="${param.mEmail}" type="text" class="required email"></td>
<td style="color:red;">${ErrorMsg.email}</td>
</tr>
<tr>
<td>電話:</td>
<td><input id="num" name="mPhone" value="${param.mPhone}" type="text" class="required"></td>
<td style="color:red;">${ErrorMsg.phone}</td>
</tr>
<tr>
<td><input type="submit" value="送出"/></td>
</tr>


</table>

<div>${ErrorMsg.exception}</div>
</form>
</div>




</body>
</html>