<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>美美的圖片</title>
</head>
<body Bgcolor="#CCFF99">
<CENTER>
<TABLE border="5">
<TR>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?a=1"></TD>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?a=2"></TD>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?a=3"></TD>
</TR>
<TR>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?b=1"></TD>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?b=2"></TD>
<TD><IMG width='320' height='240' SRC="ShowPictureServlet?b=3"></TD>
</TR>
</TABLE> 
</CENTER>
<a href="ch02_06.jsp">回前頁</a>
</body>
</html>