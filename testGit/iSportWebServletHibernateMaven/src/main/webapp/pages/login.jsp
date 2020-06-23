<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>iSport Login</title>

<!-- Meta tag Keywords -->
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="keywords" content="iSport Login" />
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false);
function hideURLbar(){ window.scrollTo(0,1); } </script>

<!-- css files -->
<link href="${pageContext.request.contextPath}/resources/css/bootstrap.css" rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/resources/css/style.css" rel='stylesheet' type='text/css' />
<link href="${pageContext.request.contextPath}/resources/css/login.css" rel="stylesheet"  type="text/css" media="all" /> <!-- Style-CSS -->
<link href="${pageContext.request.contextPath}/resources/css/font-awesome.css" rel="stylesheet" ><!-- Font-Awesome-Icons-CSS -->
<!-- web-fonts -->
<link href='//fonts.googleapis.com/css?family=Snippet' rel="stylesheet">
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
<!-- <link href="fonts/Snippet.ttf" rel="stylesheet"> -->

<!--JS for animate-->
	<link href="${pageContext.request.contextPath}/resources/css/animate.css" rel="stylesheet" type="text/css" media="all">
	<script src="${pageContext.request.contextPath}/resources/js/wow.min.js"></script>
		<script>
		<!--new WOW().init();-->
		</script>
<!--//end-animate-->
</head>
<body>
<!---header--->
	<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header wow fadeInLeft animated animated" data-wow-delay="0.1s">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <h1><a class="navbar-brand" href="index.jsp"><span><img src="${pageContext.request.contextPath}/resources/images/e.png"/></span> iSport</a></h1>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right wow fadeInRight animated animated" data-wow-delay="0.1s">
				<li class="active"><a class="nav-in" href="index.html"><span data-letters="Home">Home</span></a></li>
				<li ><a class="nav-in" href="about.html"><span data-letters="About">About</span></a> </li>
				<li><a class="nav-in" href="class.html"><span data-letters="Classes">Classes</span></a></li>
				<li><a class="nav-in" href="trainers.html"><span data-letters="Trainers">Trainers</span></a></li>
				<li><a class="nav-in" href="codes.html"><span data-letters="Codes">Codes</span></a></li>
				<li><a class="nav-in" href="contact.html"><span data-letters="Contact">Contact</span></a></li>
				<li><a class="nav-in" href="login.jsp"><span data-letters="Login">Login</span></a></li>

          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
   
<div data-vide-bg="${pageContext.request.contextPath}/resources/video/training">
<!-- <div data-vide-bg="../resources/video/training"> -->
<%-- <div data-vide-bg="<c:url value="/resources/video/training"/>"> --%>
	<div class="main-container">
		<!--header-->
		
		<div class="header-w3l">
			<!--<h1>iSport Login</h1> -->
		</div>
		<!--//header-->
		<!--main-->
		<div class="main-content-agile">
			<div class="w3ls-pro">
				<h2>Login Now</h2>
			</div>
			<div class="sub-main-w3ls">	
				<form action="#" method="post">
					<input placeholder="Enter your E-mail" name="enter mail" type="email" required="" size="30">
					<span class="icon1"><i class="fa fa-envelope" aria-hidden="true"></i></span>
					<input  placeholder="Enter Password" name="Password" type="password" required="">
					<span class="icon2"><i class="fa fa-unlock-alt" aria-hidden="true"></i></span>
					<div class="checkbox-w3">
						<span class="check-w3"><input type="checkbox" />Remember Me</span>
						<a href="#">Forgot Password?</a>
						<div class="clear"></div>
					</div>
					 
					<div class="social-icons"> 
							
							<ul>
								<li><a href="#"><i class="fa fa-facebook" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-twitter" aria-hidden="true"></i></a></li>
								<li><a href="#"><i class="fa fa-google-plus" aria-hidden="true"></i></a></li> 
							</ul>  
							
						</div>
						
					<input type="submit" value="">
				</form>
			</div>
		</div>
		<!--//main-->
		<!--footer-->
		<div class="footer">
			<p>&copy; 2017 iSport. All rights reserved | Design by EEIT96-06</p>
		</div>
		<!--//footer-->
	</div>
</div>
	<!-- Bootstrap core JavaScript
    ================================================== -->
    <!-- Placed at the end of the document so the pages load faster -->
	<script src="${pageContext.request.contextPath}/resources/js/jquery-2.1.4.min.js"></script><!--common-js-->
	<script src="${pageContext.request.contextPath}/resources/js/jquery.vide.min.js"></script><!--video-js-->
</body>
</html>