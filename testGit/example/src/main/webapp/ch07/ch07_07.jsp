<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix='c' uri="http://java.sun.com/jsp/jstl/core" %>    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body bgcolor="#EEFFBB">
<div align="center">
<h1>貓咪咖啡</h1>
<table border='1'>
<tr align ="center" bgcolor="99ccff">
<td width="80">代號</td><td width="80">咖啡</td><td width="80">折扣</td><td width="80">價格</td>
</tr>
<c:forEach var='cof' items='${COFFEE_LIST}'>

	   

		
   <tr align ="center" bgcolor="99ccff">
   	<td>${cof.coffeeCode}</td>
   	<td>${cof.coffeeName}</td>
   	<td>${cof.discount}</td>
   	<td>${cof.price}</td>
   </tr>
</c:forEach>
</table>
<IMG SRC='/example/ch07/images/coffeecat.jpg'  width="400">


</div>
</body>
</html>