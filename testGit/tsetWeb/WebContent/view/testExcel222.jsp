<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
</head>
<body>
<a href="/Spring-Mybatis-Druid/user/export">導出</a>
<br/> 
<form action="/Spring-Mybatis-Druid/user/import" enctype="multipart/form-data" method="post"> 
<input type="file" name="file"/> 
<input type="submit" value="導入Excel"> 
</form>



</body>
</html>