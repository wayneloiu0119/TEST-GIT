﻿<%@ page language="java" contentType="text/html; charset=UTF-8"
    import="java.util.*, java.text.*" %>
<!DOCTYPE HTML>

<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type='text/css' />

<meta charset="UTF-8">
<title>Hello, World, 大家好(JSP版)</title>
</head>
<body> 
<H3>Hello, World, 大家好(JSP版)</H3>
<p/>
<%
   java.util.Date d = new java.util.Date();
   SimpleDateFormat  sdf = new SimpleDateFormat("yyyy年MM月dd日 HH時mm分ss秒 SSS豪秒");
   String s =  sdf.format(d);
   out.println("現在時刻是" + s);
%>          
<jsp:include page="/commons/previousPage.jsp" />
</body>
</html>
<!--      ch01\hello.jsp    -->