<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--使用c標籤需要加入 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>所有會員資訊</title>
<!-- JQUERY 需要加入以下標籤 -->
<script src="//ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script>
<script type="text/javascript">

// var table = document.getElementById("BBS");
// var currentPage=0;//設定當前頁預設值為
// var pageSize=5;//設定每一頁要顯示的數目

// function getget() {
// 	//表格行數 
// 	var rows = document.getElementById("BBS").rows.length; 
// 	//表格列數 
// 	var cells = document.getElementById("BBS").rows.item(0).cells.length; 
// 	var sumPages=Math.ceil(rows/pageSize);//得到總頁數

// 	alert("rows"+rows+"cells"+rows);
// 	alert(sumPages);
// }


    window.onload=display();
      
          
      $(document).ready(function display(){   
         
    	  
    	  
      });
		
      function display(){
    	  alert("1334");
    	  ar result_style = document.getElementById('mytable').style;
    	  result_style.display = 'none';
    	  
      };




</script>
<style type="text/css">

table{
    border-collapse:separate;
    collapse;border:1px solid black;
}
td{
    collapse;border:1px solid black;
}

</style>

</head>
<body>
<h2>所有會員資訊</h2>

<input type="button" onclick="getget()" value="獲取行數資料">

<a id="btn0"></a>
                <input id="pageSize" type="text" size="1" maxlength="2" value="getDefaultValue()"/><a> 条 </a> <a href="#" id="pageSizeSet">设置</a>&nbsp;
                <a id="sjzl"></a>&nbsp;
                <a  href="#" id="btn1">首页</a>
                <a  href="#" id="btn2">上一页</a>
                <a  href="#" id="btn3">下一页</a>
                <a  href="#" id="btn4">尾页</a>&nbsp;
                <a>转到&nbsp;</a>
                <input id="changePage" type="text" size="1" maxlength="4"/>
                <a>页&nbsp;</a>
                <a  href="#" id="btn5">跳转</a>

<table id="mytable" >
<tr>
<td>帳號</td>
<td>密碼</td>
<td>生日</td>
<td>E-mail</td>
<td>電話</td>
<td>地址</td>
<td>性別</td>
</tr>
<c:forEach items="${allbean}" var="all">
<tr>
<td>${all.userId}</td>
<td>${all.pswd}</td>
<td>${all.birthday}</td>
<td>${all.email}</td>
<td>${all.phone}</td>
<td>${all.address}</td>
<td>${all.gender}</td>
</tr>
</c:forEach>

</table>

<!--分頁駐點-->

<div id=Pager></div>

<!--當 DOM 物件節點形成後，才開始分頁機制-->

</body>
</html>