<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>首頁</title>
</head>
<body>
<h1>首頁</h1>
<div id='column1'>
<a href="<c:url value='pages/LogIn.jsp'  />">登入</a><p/>
<a href="<c:url value='pages/ShowUserId.jsp'  />">會員資料</a><p/>
<a href="<c:url value='pages/InsertMember.jsp'  />">會員註冊</a><p/>

<%-- <c:out value = "${'<H1>, &'}"/> --%>
</div>
</body>
</html>