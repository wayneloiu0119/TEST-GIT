<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>登入</title>

 
</head>

<body>

	<Form Action="<c:url value='/Controller/LoginServlet'/>" method="POST">
		<table>
		
			<tr>
				<td>帳號:</td>
				<td><input  type="text" id="d1" name="mId"  /></td>
				<td ><small><Font  color='red' size="-1">${ErrorMsgKey.AccountEmptyError}</Font></small></td>
			</tr>
			
			<tr>
				<td>密碼:</td>
				<td><input type="text" id="d2" name="pswd" /></td>
				<td><small><Font color='red' size="-1">${ErrorMsgKey.PasswordEmptyError}</Font></small></td>
			</tr>
			<tr>
				<td align="CENTER" colspan='3'><font color='red' size="-1">${ErrorMsgKey.LoginError}&nbsp;</font></td>
			</tr>
			<tr>
				<td><input type="submit" name="login" value="登入" /></td>
			</tr>
		</table>
	</Form>
	<Form Action="<c:url value='Forgot.jsp'/>" method="POST">
	<input type="submit" name="Forgot" value="忘記密碼">
	</Form>


</body>
</html>