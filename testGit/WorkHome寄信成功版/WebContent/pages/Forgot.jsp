<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>忘記密碼</title>

<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<script>
function subForm(theform){
	   if(document.form1.mId.value.length == 0){
	    alert("請輸入帳號");
	    document.form1.mId.focus();
	    return false;
	   }
	   
	var email = document.form1.mEmail.value;
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
</head>
<body>
<h3>請輸入信箱:</h3>
<Form Action="<c:url value='/Controller/ForgotPassword'/>" method="POST" name="form1" onsubmit="return subForm(this);"> 
    帳號  ：<input type="text" name="mId" value="${param.mId}"/><a style="color:red;">${ErrorMsg.id}${ErrorMsg.id2}</a><br>
  <br>  
  Email：<input type="text" name="mEmail"  value="${param.mEmail}"/><a style="color:red;">${ErrorMsg.email}</a><br>
    
    <input type="submit" value="提交" /><a href=""></a> <br>
    <a style="color:red;">${ErrorMsg.ForgotEmailOKerror}</a>
     
</Form>  


</body>
</html>