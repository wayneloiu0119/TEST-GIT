<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>

<%
	response.setHeader("Cache-Control", "no-cache");//Forces caches to obtain a new copy of the page from the origin server
	response.setHeader("Cache-Control", "no-store"); //Directs caches not to store the page under any circumstance 
	response.setDateHeader("Expires", 0); //Causes the proxy cache to see the page as "stale" 
	response.setHeader("Pragma", "no-cache"); //HTTP 1.0 backward compatibility
%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>ShoppingCart</title>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<!---css--->
<link href='<c:url value="/resources/css/bootstrap.css" />'
	rel='stylesheet' type='text/css' />
<link href='<c:url value="/resources/css/style.css" />' rel='stylesheet'
	type='text/css' />
<!---css--->
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

<script>
	function Checkout(cart) {
		if (cart == null || cart == 0)  {
			alert("無購買任何課程，不需結帳");
			return false;
		}else{
			document.forms[0].action="<c:url value='/pages/OrderConfirm.jsp'/>" ;
			//method="POST","GET"成功
			document.forms[0].method="POST";
			document.forms[0].submit();	
// 			window.location.href='<c:url value="/pages/OrderConfirm.jsp"/>' ;
		}
// 		if (confirm("再次確認訂單內容 ? ") ) {
// 			return true;
// 		} else {
// 			return false;
// 		}
	}
	function Shopping(){
// 		document.forms[0].action='<c:url value="/pages/counse_front.controller"/>' ;
// 		//method="POST"成功,GET失敗
// 		document.forms[0].method="GET";
// 		document.forms[0].submit();
		window.location.href='<c:url value="/pages/counse_front.controller"/>' ;
	}
	function RemoveAll(cart){
		if (cart == null || cart == 0)  {
			alert("購物車已為空");
			return false;
		}else{
		document.forms[0].action='<c:url value="/shoppingCart/giveUp.controller"/>' ;
		//method="POST"成功,GET失敗
		document.forms[0].method="POST";
		document.forms[0].submit();		
		}
	}
</script>

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
			<h2>ShoppingCart</h2>
		</div>
	</div>

	<!---body--->
	<div class="container">
		<div
			class="row navbar-nav navbar-right wow fadeInRight animated animated"
			style="margin-top: 100px; margin-bottom: 100px;">
			<div class="col-sm-12 col-md-10 col-md-offset-1">
				<form>
					<table class="table table-hover">
						<thead>
							<tr>
								<th class="text-center" style="width: 0">Item</th>
								<th>Course</th>
								<th class="text-center">Price</th>
								<th class="text-center">Discount</th>
								<th class="text-center">Total</th>
								<th> </th>
							</tr>
						</thead>
						<tbody>
							<c:forEach varStatus="vs" var="anEntry"
								items="${ShoppingCart.content}">
								<tr>

									<td class="col-sm-1 col-md-1 text-center">${vs.count}</td>

									<td class="col-sm-8 col-md-6 col-lg-8">
										<div class="media">
											<a class="thumbnail pull-left" href="#"> <img
												class="media-object"
												src="${pageContext.servletContext.contextPath}/pages/CourseGetImage?courseId=${anEntry.value.courseId}"
												style="width: 72px; height: 72px;">
											</a>
											<div class="media-body">
												<h4 class="media-heading">
													<a href="#">${anEntry.value.courseName}</a>
												</h4>
												<h5 class="media-heading">
													<%--by <a href="#">${anEntry.value.memberId}</a>  --%>
													<span>StartDay: </span> <span class="text-success">
														<strong><fmt:formatDate
																value="${anEntry.value.courseStartDate}"
																pattern="yyyy-MM-dd" /></strong>
													</span>
												</h5>
												<span>StartTime: </span> <span class="text-success">
													<strong>${fn:substring(anEntry.value.courseStartTime, 0, 10)}</strong>
												</span>

											</div>
										</div>
									</td>
									<td class="col-sm-1 col-md-1 text-center">${anEntry.value.coursePrice}</td>
									<td class="col-sm-1 col-md-1 text-center">${anEntry.value.discount}</td>
									<td class="col-sm-1 col-md-1 text-center">${anEntry.value.coursePrice * anEntry.value.discount }</td>
									<td class="col-sm-1 col-md-1 text-center">
										<%-- 										<input type="text" value="${anEntry.value.courseId}" /> --%>
										<button type="button" class="btn btn-danger"
											value="${anEntry.value.courseId}">
											<%--onClick="removeCourse(${anEntry.key});"> --%>
											<span class="glyphicon glyphicon-trash"></span>
										</button>
									</td>
								</tr>
							</c:forEach>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h5>Subtotal</h5></td>
								<td class="text-right">
									<h5>
										<strong>$${ShoppingCart.subtotal}</strong>
									</h5>
								</td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h5>Tax</h5></td>
								<td class="text-right">
									<h5>
										<strong>Include</strong>
									</h5>
								</td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td> </td>
								<td><h3>Total</h3></td>
								<td class="text-right">
									<h3>
										<strong>$${ShoppingCart.subtotal}</strong>
									</h3>
								</td>
							</tr>
							<tr>
								<td> </td>
								<td> </td>
								<td> </td>
								<td>
									<button type="button" class="btn btn-default"
										onClick="Shopping();">
										<span class="glyphicon glyphicon-shopping-cart"></span>
										Continue Shopping
									</button>
								</td>
								<td>
									<button type="button" class="btn btn-warning"
										onClick="RemoveAll(${ShoppingCart.subtotal});">
										Remove all <span class="glyphicon glyphicon-trash"></span>
									</button>
								</td>
								<td>
									<button type="button" class="btn btn-success"
										onClick="return Checkout(${ShoppingCart.subtotal})">
										Checkout <span class="glyphicon glyphicon-play"></span>
									</button>
								</td>
							</tr>
						</tbody>
					</table>
				</form>
			</div>
		</div>
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
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
	<script language="JavaScript" type="text/javascript">
	var contextPath = "${pageContext.request.contextPath}";
	$(document).ready(function() {
			
		$('.btn-danger').click(function(){
			var CourseKey = $(this).val();
				$.ajax({
					"url" : contextPath + "/shoppingCart/updateOrder.controller",
					"method" : "POST",
					"data" : "courseId=" + CourseKey,
				})
			
			$(this).parent().parent().remove();
		})

})
</script>
</body>
</html>