<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>會員註冊頁面</title>
<!-- JQUERY validate 需要加入以下標籤 -->
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/jquery.validate.min.js"></script>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/dist/localization/messages_zh.js"></script>
<script type="text/javascript">
//JQUERY validate 檢核	
$(function(){
	//對應form表單的id
	 $('#form1').validate({	
    /* 常用檢測屬性
   required:必填
   noSpace:空白
   minlength:最小長度
   maxlength:最大長度
   email:信箱格式
   number:數字格式
   url:網址格式https://www.minwt.com
   equalTo:"#pswd" 是否相同
   dateISO:日期格式 例如：2009-06-23，1998/01/22
   creditcard: 信用卡格式
   */
	onkeyup: function(element, event) {
	 //去除欄位左側空白
	 var value = this.elementValue(element).replace(/^\s+/g, "");
	 $(element).val(value);
    },
    //rules為檢核規則
    rules: {
    	userId:{
    		required: true
    	},
    	userName:{
    		required: true
    	},
    	pswd:{
    		required: true,
    		minlength: 5
    	},
    	confirm_password:{
    		required: true,
    		equalTo:"#pswd"
    	},
    	email:{
            required: true,
            email: true
        },
        address: 'required',
        phone:{
            required: true,
            minlength: 8,
            number: true
        },
        gender: 'required',
        birthday:{
        	required: true,
        	dateISO:true    	
        },
        agree: 'required'
    },
  //messages為錯誤訊息
    messages: {
    	userId:{
    		required:'必填'
    	},
    	userName:{
    		required:'必填'
    	},
    	pswd:{
    		required:'必填',
    		minlength:'不得少於5位'
    	},
    	confirm_password:{
    		required:'必填',
    		equalTo:'驗證錯誤'
    	},
    	email:{
            required:'必填',
            email:'Email格式不正確'
        },
        address: '必填',
        phone:{
            required:'必填',
            minlength:'不得少於8位',
            number:'電話需為數字'
        },
        gender: '必填',
        birthday:{
        	required:'必填',
        	dateISO:'日期格錯誤'   	
        },
        agree:'請同意聲明'
    },
    //檢核完送出表單 submitHandler為默認名稱不可更改
    submitHandler: function(form) {
        $("#form1").submit();
      } 
});
});

</script>
<style>
.error {
  color: red;
  margin-left: 5px;
}
</style>
</head>
<body>
<h2>會員註冊</h2>
<form action="/tsetWeb/user" method="POST" id="form1" >
帳號:<input type="text" name="userId" id="userId">
<br>
姓名:<input type="text" name="userName" id="userName">
<br>
密碼:<input type="password" name="pswd" id="pswd">
<br>
密碼驗證:<input type="password" name="confirm_password" id="confirm_password">
<br>
信箱:<input type="text" name="email" id="email">
<br>
性別:
<input type="radio" name="gender" value="M" checked="checked">男性
<input type="radio" name="gender" value="F" >女性
<br>
地址:<input type="text" name="address" id="address">
<br>
電話:<input type="text" name="phone" id="phone">
<br>
生日:<input type="date" name="birthday" id="birthday">
<br>
 
<p>
    <label for="agree">请同意我们的聲明</label>
    <input type="checkbox" class="checkbox" id="agree" name="agree">
</p>

<!-- <input type="hidden" id = "nowTime" name="nowTime"> -->
<input type="submit"  value="送出">

</form>
</body>
</html>