<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">

function ShowTime(){
	　document.getElementById('nowTime').innerHTML = new Date();
	　setTimeout('ShowTime()',1000);
	}

	

</script>
</head>
<body>
<h2>會員註冊</h2>
<form action="/testWeb/user" method="POST">
姓名:<input type="text" name="userName">
<br>
密碼:<input type="password" name="pswd">
<br>
信箱:<input type="text" name="email">
<br>
性別:<input type="text" name="gender">
<br>
電話:<input type="text" name="phone">
<br>
生日:<input type="date" name="birthday">
<br>
<input type="hidden" id = "nowTime" name="nowTime">
<input type="submit" value="送出">

</form>
</body>
</html>