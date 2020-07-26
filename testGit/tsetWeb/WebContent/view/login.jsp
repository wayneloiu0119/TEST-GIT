<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--使用c標籤需要加入 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>登入頁面</title>
<!-- JQUERY 需要加入以下標籤 -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

//驗證輸入欄位不能為空
function checklogin(){
		//取得value值的長度，及內容
   if($("#userId").val().length == 0 || $("#userId").val() == ""){
	   
	   $("#fid").show();
	   //讓焦点固定於此標籤上
	   $("#userId").focus();
	   
   }else if($("#pswd").val().length == 0 || $("#pswd").val() == ""){
	   
	   $("#fpw").show();
	   $("#pswd").focus();
	   
   }else{
	   //檢核完成送出表單
	   $("#from1").submit();
   }
};	

</script>

</head>
<body>
<h2>會員登入</h2>
<form action="/tsetWeb/userLogin" method="POST" id="from1">
<!-- 回傳的errorMsg -->
<font color="red">${ErrorMsgKey.loginerror}</font>
<br>
帳號:<input type="text" id="userId" name="userId">
<!-- style=display:none 先隱藏錯誤訊息，檢核出錯再讓其顯示出-->
<font id="fid" color="red" style=display:none>請輸入帳號</font>
<br>
密碼:<input type="password" id="pswd" name="pswd">
<font id="fpw" color="red" style=display:none>請輸入密碼</font>
<br>
<!-- <input type="hidden" id = "nowTime" name="nowTime"> -->
<!-- 不用type=submit 是為了檢核後才能發送表單-->
<input type="button" id ="subm" onclick="checklogin()" value="送出">
<br>
</form>
</body>
</html>