<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>Insert title here</title>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">

$(function(){
    $('#form1').validate({
    /* 常用檢測屬性
   required:必填
   noSpace:空白
   minlength:最小長度
   maxlength:最大長度
   email:信箱格式
   number:數字格式
   url:網址格式https://www.minwt.com
   */
   onkeyup: function(element, event) {
     //去除左側空白
     var value = this.elementValue(element).replace(/^\s+/g, "");
     $(element).val(value);
    },
    rules: {
      fname: {
        required: true
      },
      phone:{
        required: true,
        minlength: 8,
                number: true
      },
      address: 'required',
      url:{
        url: true
      },
      email: {
        required: true,
        email: true
      }
    },
    messages: {
      fname: {
        required:'必填'
      },
      phone: {
        required:'必填',
        minlength:'不得少於8位',
        number:'電話需為數字'
      },
      address: '必填',
      email: {
        required:'必填',
        email:'Email格式不正確'
      },
      url:'網址格式不正確'
    },
    submitHandler: function(form) {
      form.submit();
    }
});

});
</script>

<style type="text/css">
form label {
  display: inline-block;
  width: 100px;
}
form div {
  margin-bottom: 10px;
}
.error {
  color: red;
  margin-left: 5px;
}
label.error {
  display: inline;
}
</style>
</head>
<body>
<form action="/tsetWeb/user" id="form1" method="POST" >


    姓名:<input type="text" id="fname" name="fname"></input>
    <br>

    電話:
    <input type="text" id="phone" name="phone"></input>
<br>

    地址:
    <input type="text" id="address" name="address"></input>
<br>
    Email:
    <input type="text" id="email" name="email"></input>
<br>
   網址:
    <input type="text" id="url" name="url"></input>
<br>


    <input type="submit" value="送出" />
<br>
</form>


</body>
</html>