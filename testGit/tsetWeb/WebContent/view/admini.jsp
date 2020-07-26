<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!--使用c標籤需要加入 -->    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>管理員頁面</title>
<style type="text/css">

	   #menu,.main,.sub,.sub li,.item{
            margin:0px ;
            padding:0px;
        }
        #menu{
           margin: auto; 
           width:100%;	
           height:100px;
        }
        .main{
            background-color:#e33535;
            color:white;
            font-family:微軟正黑體;
            font-weight:bold;
            font-size:20px;
            cursor:pointer;
            text-align:center;
            height:35px;
            line-height:35px;
            width:100px;
        }
        .main:hover{
            background-color:#4d4949;
        }
        .sub{
            cursor:pointer;
            background-color:#4d4949;
            color:white;
            font-family:微軟正黑體;
            text-align:center;
            font-weight:bold;
            width:100px;
        }
        .sub li{
            list-style-type:none;
            line-height:25px;
        }
        .item{
            float:left;
        }
        
        #left1{
         width:100%;
         float:left;
        }

</style>
<script src="https://static.runoob.com/assets/jquery-validation-1.14.0/lib/jquery.js"></script>
<script type="text/javascript">
 
	 $(document).ready(function(){
     
         for(i=0;i<$(".main").length;i++){
				 $(".sub").slideUp(0)
             $(".main:eq("+i+")").mouseover({id:i},function(e){
                 n=e.data.id
                 $(".sub:eq("+n+")").slideToggle()
                 $(".sub:not(:eq("+n+"))").slideUp()
             })
         }
         $("#menu").css("width",$(".main").length*100)
         
         //滑鼠移入移出改變字體顏色
         $("li").hover(
                 function() {
                     $(this).css("color", "#a5e5aa");   //滑鼠移動上去的顏色
                 },
                
                 function() {
                     $(this).css("color", "white");   //滑鼠離開的顏色
                 }
             );
     })
     
	 
<!--輸入檢核-->	 
function checklogin(){
			//取得value值的長度，及內容
	   if($("#userId").val().length == 0 || $("#userId").val() == ""){
		   
		   $("#fid").show();
		   //讓焦点固定於此標籤上
		   $("#userId").focus();
		   
	   }else{
		   //檢核完成送出表單
		   $("#from1").submit();
	   }
	};
	
function selID() {
	$("#seltId").show();
}	

//Jquery發送POST
function selAll(){
	alert("發送");
	 $.post("/tsetWeb/userAll",
			    {
		    	//傳參數可以直接包在引號裡面
				userId:"${loginBean.userId}" ,
				userLevel:"${loginBean.userLevel}",
				sendType:"all"
			    });
}

</script>

</head>
<body>
<!-- 上排橫幅 -->
<h2>管理員您好</h2>

<div id="menu">
	<!-- 第一組 -->
  <div class="item">	
	<div class="main">客戶資訊</div>
	<div class="sub">
		<ul>
			<li id="" onclick="selAll()">全部客戶查詢</li>
			<li id="selID" onclick="selID()">依ID查詢</li>
		</ul>
	</div>
  </div>		
	<!-- 第組 -->
  <div class="item">		
	<div class="main">客戶管理</div>
	<div class="sub">
		<ul>
			<li>黑名單</li>
			<li>VIP</li>
		</ul>
	</div>
  </div>	
</div>
<br>

<!-- 上排橫幅 -->
<div id="left1">
<div id="seltId" style=display:none>
<form action="/tsetWeb/userLogin" method="POST" id="from1">
<input type="hidden" value="9" name="userlevel">
請輸入帳號:<input type="text" id="userId" name="userId">
<input type="button" id ="subm" onclick="checklogin()" value="送出">
</form>
</div>
</div>
</body>
</html>