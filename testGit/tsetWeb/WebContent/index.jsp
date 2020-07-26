<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>

<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript">
function XXZX0100(){
	
	//按鈕
	var buttons = {
		//查詢按鈕
		 doQuery : function(){
			 alert("123"); 
		 
		 }
	}	
}

$('btn_query').observe( 'click' , buttons.doQuery );
</script>
</head>
<body>
<h2>歡迎!!!</h2>
<br>
<a href="view/user.jsp">註冊會員</a>
<br>
<a href="view/login.jsp">登入會員</a>
<br>
<a href="view/testjq.jsp">測試驗證</a>
<br>
<a href="view/all.jsp">測試所有</a>
</body>
<br>
<input id="btn_query" type="button" value="測試" >
</html>