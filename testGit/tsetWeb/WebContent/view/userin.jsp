<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">
//Jquery發送POST
function changeLV(){
	alert("發送");
	 $.post("/tsetWeb/userLogin",
			    {
		    	//傳參數可以直接包在引號裡面
				userId:"${loginBean.userId}" ,
				userLevel:"${loginBean.userLevel}"
			    });
}

</script>
<style type="text/css">



</style>
</head>
<body>

<c:if test="${userbean.userLevel != '9'}">
<h2>登入成功頁面</h2><br>
會員: ${loginBean.userName} 登入成功<br>
</c:if>
<table style="border:3px #cccccc solid" border='1'>
<tr>
<th>帳號</th>
<th>密碼</th>
<th>生日</th>
<th>E-mail</th>
<th>電話</th>
<th>地址</th>
<th>性別</th>
</tr>
<tr>
<td>${loginBean.userId}</td>
<td>${loginBean.pswd}</td>
<td>${loginBean.birthday}</td>
<td>${loginBean.email}</td>
<td>${loginBean.phone}</td>
<td>${loginBean.address}</td>
<td>${loginBean.gender}</td>
</tr>
<c:if test="${userbean.userLevel == '9'}">
<tr>
<th>變更權限</th>
<td><input type="button" value="變更" onclick="changeLV()"></td>
</tr>
</c:if>
</table>
<c:if test="${loginBean.userLevel == '9'}">
<a href="view/admini.jsp">後臺管理頁面</a>
</c:if>
</body>
</html>