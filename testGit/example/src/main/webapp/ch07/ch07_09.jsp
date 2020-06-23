<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel='stylesheet' href='${pageContext.request.contextPath}/css/styles.css'  type="text/css" />
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
	<h2>getContextPath()與getServletContextName()的比較</h2>
		<p>
			request.getContextPath() = ${rcp}<br> 
			context.getContextPath() = ${ccp}<br> 
			context.getServletContextName() = ${cscn}<br>
		</p>

<p/>
<BR><BR><HR>
<small>&lt;&lt;<a href="index.jsp">回前頁</a>&gt;&gt;</small>
</body>
</body>
</html>