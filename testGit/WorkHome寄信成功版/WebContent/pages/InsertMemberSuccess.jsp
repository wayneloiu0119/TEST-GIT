<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>會員註冊資料</title>
</head>
<body>
會員:${memberBean.name} 資料新增成功<br>

帳號:${memberBean.memberId}<br>
密碼:${memberBean.password}<br>
生日:${memberBean.birthday}<br>
E-mail:${memberBean.email}<br>
電話:${memberBean.phone}<br>

</body>
</html>