<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
    <%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>BlackFriend</title>
<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->
<!-- <script type="text/javascript" src="../css/json2.js"></script> -->
<!---css--->
<link href='<c:url value="/resources/css/bootstrap.css" />'
	rel='stylesheet' type='text/css' />
<link href='<c:url value="/resources/css/style.css" />' rel='stylesheet'
	type='text/css' />
<!---css--->

<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="iSport" />
<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic'
	rel='stylesheet' type='text/css'>
<link
	href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic'
	rel='stylesheet' type='text/css'>
<!--JS for animate-->
<link href='<c:url value="/resources/css/animate.css" />'
	rel="stylesheet" type="text/css" media="all">
<script src='<c:url value="/resources/js/wow.min.js" />'></script>
<script>
	new WOW().init();
</script>
<!--//end-animate-->
<script type="application/x-javascript">
	
 	addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } 

</script>



<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<!-- /////////////////////////////////////////////////////////////////////////////////////////// -->
 <style>
.transition, form button, form .question label, form .question input[type="text"] {
  -moz-transition: all 0.25s cubic-bezier(0.53, 0.01, 0.35, 1.5);
  -o-transition: all 0.25s cubic-bezier(0.53, 0.01, 0.35, 1.5);
  -webkit-transition: all 0.25s cubic-bezier(0.53, 0.01, 0.35, 1.5);
  transition: all 0.25s cubic-bezier(0.53, 0.01, 0.35, 1.5);
}

* {
  font-family: Helvetica, sans-serif;
  font-weight: light;
  -webkit-font-smoothing: antialiased;
}

/* html { */
/*   background-color: #ff4a56; */
/* } */

form {
  position: relative;
  display: inline-block;
  max-width: 700px;
  min-width: 500px;
  box-sizing: border-box;
  padding: 30px 25px;
  background-color: white;
  border-radius: 40px;
  margin: 40px 0;
  left: 50%;
  -moz-transform: translate(-50%, 0);
  -ms-transform: translate(-50%, 0);
  -webkit-transform: translate(-50%, 0);
  transform: translate(-50%, 0);
}
form h1 {
  color: #ff4a56;
  font-weight: 100;
  letter-spacing: 0.01em;
  margin-left: 15px;
  margin-bottom: 35px;
  text-transform: uppercase;
}
form button {
  margin-top: 35px;
  background-color: white;
  border: 1px solid #ff4a56;
  line-height: 0;
  font-size: 17px;
  display: inline-block;
  box-sizing: border-box;
  padding: 20px 15px;
  border-radius: 60px;
  color: #ff4a56;
  font-weight: 100;
  letter-spacing: 0.01em;
  position: relative;
  z-index: 1;
}
form button:hover, form button:focus {
  color: white;
  background-color: #ff4a56;
}
form .question {
  position: relative;
  padding: 10px 0;
}
form .question:first-of-type {
  padding-top: 0;
}
form .question:last-of-type {
  padding-bottom: 0;
}
form .question label {
  transform-origin: left center;
  color: #ff4a56;
  font-weight: 100;
  letter-spacing: 0.01em;
  font-size: 17px;
  box-sizing: border-box;
  padding: 10px 15px;
  display: block;
  position: absolute;
  margin-top: -40px;
  z-index: 2;
  pointer-events: none;
}
form .question input[type="text"] {
  appearance: none;
  background-color: none;
  border: 1px solid #ff4a56;
  line-height: 0;
  font-size: 17px;
  width: 100%;
  display: block;
  box-sizing: border-box;
  padding: 10px 15px;
  border-radius: 60px;
  color: #ff4a56;
  font-weight: 100;
  letter-spacing: 0.01em;
  position: relative;
  z-index: 1;
}
form .question input[type="text"]:focus {
  outline: none;
  background: #ff4a56;
  color: white;
  margin-top: 30px;
}
form .question input[type="text"]:valid {
  margin-top: 30px;
}
form .question input[type="text"]:focus ~ label {
  -moz-transform: translate(0, -35px);
  -ms-transform: translate(0, -35px);
  -webkit-transform: translate(0, -35px);
  transform: translate(0, -35px);
}
form .question input[type="text"]:valid ~ label {
  text-transform: uppercase;
  font-style: italic;
  -moz-transform: translate(5px, -35px) scale(0.6);
  -ms-transform: translate(5px, -35px) scale(0.6);
  -webkit-transform: translate(5px, -35px) scale(0.6);
  

}
textarea{	
	width: 100%;
	border: none;
	border-radius: 20px;
	outline: none;
	padding: 10px;
	font-family: 'Sniglet', cursive;
	font-size: 1em;
	color: #ff4a56;
	transition: border 0.5s;
	-webkit-transition: border 0.5s;
	-moz-transition: border 0.5s;
	-o-transition: border 0.5s;
	border: solid 1px red;	
	-webkit-box-sizing:border-box;
	}



</style>

<script type="text/javascript">
var contextPath="${pageContext.request.contextPath}";
$(document).ready(function() {
	$("input[name='blackFriendId']").blur(function() {
		$.ajax({
			"url": contextPath+"/pages/blackFriend.view",
			"method": "POST",
			"data": "blackFriendId="+$("input[name='blackFriendId']").val(),
			"success": function(data) {
				var json = JSON.parse(data);
				if(json[0].hasMoreData) {
					$("input[name='blackFriendId']").val(json[1].id);
					$("input[name='memberId']").val(json[1].name);
					$("input[name='relationMemberId']").val(json[1].price);
					$("input[name='blackFriendType']").val(json[1].make);
					$("input[name='states']").val(json[1].expire);
				}
				$("span[class='error']").first().text(json[0].text);
			}
		});
	});
});

function clearForm() {
	var inputs = document.getElementsByTagName("input");
	for(var i=0; i<inputs.length; i++) {
		if(inputs[i].type=="text") {
			inputs[i].value="";
		}
	}
}
</script>
</head>
</head>
<body>


<!---header--->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div class="container">
		<div class="navbar-header wow fadeInLeft animated animated"
			data-wow-delay="0.1s">
			<button type="button" class="navbar-toggle collapsed"
				data-toggle="collapse" data-target="#navbar" aria-expanded="false"
				aria-controls="navbar">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<h1>
				<a class="navbar-brand" href="index.jsp"> <span> <img
						src="<c:url value="/resources/images/e.png"/>" />
				</span> iSport
				</a>
			</h1>
		</div>
		<div id="navbar" class="navbar-collapse collapse">
			<ul
				class="nav navbar-nav navbar-right wow fadeInRight animated animated"
				data-wow-delay="0.1s">
				<li class="active"><a class="nav-in"
					href='<c:url value="/index" />'><span data-letters="Home">Home</span></a></li>
				<li><a class="nav-in" href="about.html"><span
						data-letters="About">About</span></a></li>
				<li><a class="nav-in" href="class.html"><span
						data-letters="Classes">Classes</span></a></li>
				<li><a class="nav-in" href="trainers.html"><span
						data-letters="Trainers">Trainers</span></a></li>
				<li><a class="nav-in" href="codes.html"><span
						data-letters="Codes">Codes</span></a></li>
				<li><a class="nav-in" href="contact.html"><span
						data-letters="Contact">Contact</span></a></li>
				<li><a class="nav-in" href="ShowCartContent.jsp"><span
						data-letters="ShoppingCart">ShoppingCart</span></a></li>
				<li><a class="nav-in" href="login.jsp"><span
						data-letters="Login">Login</span></a></li>

			</ul>
		</div>
		<!--/.nav-collapse -->
	</div>
	</nav>
	<!---banner--->
	<div class="banner wow fadeInDownBig animated animated"
		data-wow-delay="0.1s">
		<div class="container">
			<h2>好友列表前台</h2>
		</div>
	</div>

    <!--body-->
<%-- <h3>Welcome ${user.email}</h3> --%>


<div>
	<form action="<c:url value="/pages/BlackFriendMrmber.controller"/>">
		<div class="question">
    <input type="text" name="blackFriendId"  value="${param.blackFriendId}"/>
    <label>編號</label>
  	</div>
  	
  	<div class="question">
    <input type="text" name="memberId"  value="${param['memberId']}"/>
    <label>會員編號</label>
  	</div>
  	
  	<div class="question">
    <input type="text" name="relationMemberId"  value="${param['relationMemberId']}"/>
    <label>會關係人編號</label>
  	</div>
  	
	<div style="color:red">關係</div>
	<div>
    <select style="color:#FF0000" name="blackFriendType" value="${param['blackFriendType']}">
	<option style="color:#FF0000" >好友</option>
	<option style="color:#FF0000">黑名單</option>
   </select>
  	</div>
  	
  	<div class="question">
    <input type="text" name="states"  value="${param['states']}"/>
    <label>狀態</label>
  	</div>
	
	
	<button  name="prodaction" value="Insert">Insert</button>
			<button name="prodaction" value="Update">Update</button>
			<button name="prodaction" value="Delete">Delete</button>
			<button name="prodaction" value="SelectMemberId">SelectMemberId</button>
			<button name="prodaction" value="SelectBlackFriendType">SelectBlackFriendType</button>

			
	</form>
	</div>
	<h3><span class="error">${errors.action}</span></h3>

	<c:if test="${not empty delete}">
<%-- 	<h3>Delete BlackFriend Table Success : ${delete} row deleted</h3> --%>
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<c:if test="${not empty insert}">
<!-- 	<h3>Insert BlackFriend Table Success</h3> -->
<!-- 	<table border="1"> -->
<%-- 			<tr><td>BlackFriendId</td><td>${insert.blackFriendId}</td></tr> --%>
<%-- 		<tr><td>MemberId</td><td>${insert.memberId}</td></tr> --%>
<%-- 		<tr><td>RelationMemberId</td><td>${insert.relationMemberId}</td></tr> --%>
<%-- 		<tr><td>BlackFriendType</td><td>${insert.blackFriendType}</td></tr> --%>
<%-- 		<tr><td>States</td><td>${insert.states}</td></tr> --%>
<!-- 	</table> -->
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<c:if test="${not empty update}">
<!-- 	<h3>Update BlackFriend Table Success</h3> -->
<!-- 	<table border="1"> -->
<%-- 		<tr><td>BlackFriendId</td><td>${update.blackFriendId}</td></tr> --%>
<%-- 		<tr><td>MemberId</td><td>${update.memberId}</td></tr> --%>
<%-- 		<tr><td>RelationMemberId</td><td>${update.relationMemberId}</td></tr> --%>
<%-- 		<tr><td>BlackFriendType</td><td>${update.blackFriendType}</td></tr> --%>
<%-- 		<tr><td>States</td><td>${update.states}</td></tr> --%>
		
<!-- 	</table> -->
	<script type="text/javascript">clearForm();</script>
	</c:if>


<!---footer--->
	<div class="footer-section">
		<div class="container">
			<div class="footer-grids">
				<div
					class="col-md-3 footer-grid wow fadeInDownBig animated animated"
					data-wow-delay="0.02s">
					<h4>About</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipig elit.
						Praesent vestibulummolestie lacus. Aenean nonummy hendrerit
						mauris. Praesent vestibulummolestie lacus.</p>
				</div>
				<div class="col-md-3 footer-grid wow fadeInLeft animated animated"
					data-wow-delay="0.02s">
					<h4>Categories</h4>
					<ul>
						<li>Beauty</li>
						<li>Diet & Fitness</li>
						<li>Lifestyle</li>
						<li>Help Desk</li>
						<li>Pregnancy</li>
						<li>Performance Metrics</li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid wow fadeInUpBig animated animated"
					data-wow-delay="0.02s">
					<h4>Work</h4>
					<ul>
						<li>Customer Support</li>
						<li>Platinum Support</li>
						<li>Gold Support</li>
						<li>Training</li>
						<li>Workshops</li>
						<li>Online Training</li>
					</ul>
				</div>
				<div class="col-md-3 footer-grid wow fadeInRight animated animated"
					data-wow-delay="0.02s">
					<h4>Contact</h4>
					<p>7801 Marmora Road</p>
					<p>Glasgow, DO5 98GR.</p>
					<p>Freephone: +1 800 558 8990</p>
					<p>Telephone: +1 659 803 9035</p>
					<p>FAX: + 1 314 889 9898</p>
					<a href="mailto:example@mail.com"> example@mail.com</a>
				</div>
				<div class="clearfix"></div>
			</div>
		</div>
	</div>
	<!---footer--->

	<!--copy-->
	<div class="copy-section wow animated animated" data-wow-delay="0.1s">
		<div class="container">
			<div class="social-icons">
				<a href="#"><i class="icon"></i></a> <a href="#"><i
					class="icon1"></i></a> <a href="#"><i class="icon2"></i></a> <a
					href="#"><i class="icon3"></i></a>
			</div>
			<p>&copy; 2017 iSport. All rights reserved | Design by EEIT96-06</p>
		</div>
	</div>
	<!--copy-->

	<!-- Bootstrap core JavaScript
    ================================================== -->
	<!-- Placed at the end of the document so the pages load faster -->
	<script src='<c:url value="/resources/js/jquery-3.2.1.min.js" />'></script>
	<script src='<c:url value="/resources/js/jquery-2.1.4.min.js" />'></script>
	<script>
		window.jQuery
				|| document
						.write('<script src="js/jquery-2.1.4.min.js"><\/script>')
	</script>
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
</body>
</html>