<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script type="text/javascript">
</script>
</head>
<body>
<h2>登入成功頁面</h2>
會員: ${userbean.userName} 登入成功<br>
<br>
帳號:${userbean.userId}<br>
密碼:${userbean.pswd}<br>
生日:${userbean.birthday}<br>
E-mail:${userbean.email}<br>
電話:${userbean.phone}<br>
地址:${userbean.address}<br>
性別:${userbean.gender}<br>
</body>
</html>