<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<link rel="stylesheet" type="text/css" href="../css/table.css" />
<title>Insert title here</title>
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

<style>


@import url('https://fonts.googleapis.com/css?family=Amarante');

html, body, div, h1, h2, h3, a, tr, th, td {
  margin: 0;
  padding: 0;
  border: 0;
  text-align:center;
  font-size: 10px;
  font: inherit;
  vertical-align: baseline;
  outline: none;
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
}


html { overflow-y: scroll; }
body { 
  background: #eee url('https://i.imgur.com/eeQeRmk.png'); /* https://subtlepatterns.com/weave/ */
  font-family: 'Helvetica Neue', Helvetica, Arial, sans-serif;
  font-size: 14px;
  line-height: 1;
  color: #585858;
  padding: 22px 10px;
  padding-bottom: 55px;
}

::selection { background: #5f74a0; color: #fff; }
::-moz-selection { background: #5f74a0; color: #fff; }
::-webkit-selection { background: #5f74a0; color: #fff; }

br { display: block; line-height: 1.6em; } 

article, aside, details, figcaption, figure, footer, header, hgroup, menu, nav, section { display: block; }
ol, ul { list-style: none; }

input, textarea { 
  -webkit-font-smoothing: antialiased;
  -webkit-text-size-adjust: 100%;
  -ms-text-size-adjust: 100%;
  -webkit-box-sizing: border-box;
  -moz-box-sizing: border-box;
  box-sizing: border-box;
  outline: none; 
}

blockquote, q { quotes: none; }
blockquote:before, blockquote:after, q:before, q:after { content: ''; content: none; }
strong, b { font-weight: bold; } 

table { border-collapse: collapse; border-spacing: 0; }
img { border: 0; max-width: 100%; }

h3 { 
  font-family: 'Amarante', Tahoma, sans-serif;
  font-weight: bold;
  font-size: 2.4em;
  line-height: 1.7em;
  margin-bottom: 10px;
  text-align: center;
}

th td{
font-size:65%
}


/** page structure **/
#wrapper {
  display: block;
  width: 850px;
  background: #fff;
  margin: 0 auto;
  padding: 10px 17px;
  -webkit-box-shadow: 2px 2px 3px -1px rgba(0,0,0,0.35);
}

#keywords {
  margin: 0 auto;
  font-size: 1.2em;
  margin-bottom: 15px;
}


#keywords thead {
  cursor: pointer;
  background: #c9dff0;
}
#keywords thead tr td { 
  font-weight: bold;
  text-align:center;
  padding: 12px 30px ;
  padding-left: 42px;
}
#keywords thead tr td  { 
  padding-right: 20px;
  background-repeat: no-repeat;
  background-position: 100% 100%;
}

#keywords thead tr td.headerSortUp, #keywords thead tr td.headerSortDown {
  background: #acc8dd;
}

#keywords thead tr td.headerSortUp  {
  background-image: url('https://i.imgur.com/SP99ZPJ.png');
}
#keywords thead tr td.headerSortDown  {
  background-image: url('https://i.imgur.com/RkA9MBo.png');
}


#keywords tbody tr { 
  color: #555;
}
#keywords tbody tr td {
  text-align: center;
  padding: 15px 10px;
}
#keywords tbody tr td.lalign {
  text-align: left;
}

</style>

<!-- <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script> -->




</head>


<body>


<!---header--->
	<nav class="navbar navbar-default navbar-fixed-top">
	<div  class="container">
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
			<h2>OrderConfirm</h2>
		</div>
	</div>

    <!--body-->
     <div id="wrapper">
<h3>比賽公告</h3>
<c:if test="${not empty select}">

	<table id="keywords" cellspacing="0" cellpadding="0">
		<thead>
			<tr>
				<th style="width:5%;">公告編號</th>
				<th style="width:5%;">發布人編號</th>
				<th style="width:5%;">比賽編號</th>
				<th style="width:8%;">比賽名稱</th>
				<th style="width:20%;">公告內容</th>
			</tr>
		</thead>
		<tbody>
				
			<c:forEach var="row" items="${select}">
				<c:url value="/pages/announcement.jsp" var="link">
				<c:param name="announcementId" value="${row[0]}" />
				<c:param name="memberId" value="${row[1]}" />
					<c:param name="gameId" value="${row[2]}" />
					<c:param name="gameName" value="${row[3]}" />
					<c:param name="announcemenText" value="${row[4]}" />
				</c:url>
				<tr>
					<td><a href="${link}">${row[0]}</a></td>
					<td>${row[1]}</td>
					<td>${row[2]}</td>
					<td>${row[3]}</td>
					<td>${row[4]}</td>
				</tr>
			</c:forEach>
		</tbody>
	</table>
	</c:if>

<h3><a href="<c:url value="/pages/announcement.jsp" />">Back Announcement</a></h3>
</div>



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