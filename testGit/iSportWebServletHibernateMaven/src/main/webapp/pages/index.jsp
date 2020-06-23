<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<title>iSport</title>
<!---css--->
<link href='<c:url value="/resources/css/bootstrap.css" />' rel='stylesheet' type='text/css' />
<link href='<c:url value="/resources/css/style.css" />' rel='stylesheet' type='text/css' />
<!---css--->
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta name="viewport" content="width=device-width, initial-scale=1">
<script type="application/x-javascript"> addEventListener("load", function() { setTimeout(hideURLbar, 0); }, false); function hideURLbar(){ window.scrollTo(0,1); } </script>

<!--web-fonts-->
<link href='//fonts.googleapis.com/css?family=Ubuntu+Condensed' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Open+Sans:400,300,300italic,400italic,600,600italic,700,700italic,800,800italic' rel='stylesheet' type='text/css'>
<link href='//fonts.googleapis.com/css?family=Ubuntu:400,300,300italic,400italic,500,500italic,700,700italic' rel='stylesheet' type='text/css'>
<!--JS for animate-->
	<link href='<c:url value="/resources/css/animate.css" />' rel="stylesheet" type="text/css" media="all">
	<script src='<c:url value="/resources/js/wow.min.js" />'></script>
		<script>
			new WOW().init();
		</script>
<!--//end-animate-->


</head>
<body>

<!---header--->
	<nav class="navbar navbar-default navbar-fixed-top">
      <div class="container">
        <div class="navbar-header wow fadeInLeft animated animated" data-wow-delay="0.02s">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
         <h1><a class="navbar-brand" href="index.jsp">
		         <span>
		         	<img src="<c:url value="/resources/images/e.png"/>"/>
		         </span> iSport</a></h1>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
			<ul class="nav navbar-nav navbar-right wow fadeInRight animated animated" data-wow-delay="0.01s">
				<li class="active"><a class="nav-in" href="index.html"><span data-letters="Home">Home</span></a></li>
				<li ><a class="nav-in" href="about.html"><span data-letters="About">About</span></a> </li>
				<li><a class="nav-in" href="class.html"><span data-letters="Classes">Classes</span></a></li>
				<li><a class="nav-in" href="trainers.html"><span data-letters="Trainers">Trainers</span></a></li>
				<li><a class="nav-in" href="codes.html"><span data-letters="Codes">Codes</span></a></li>
				<li><a class="nav-in" href="ShowCartContent.jsp"><span data-letters="ShoppingCart">ShoppingCart</span></a></li>
				<li><a class="nav-in" href="login.jsp"><span data-letters="Login">Login</span></a></li>

          </ul>
        </div><!--/.nav-collapse -->
      </div>
    </nav>
<!---banner--->
	<div class="banner-section">
		<div class="container">
			<div class="slider">
				<div class="callbacks_container">
					<ul class="rslides" id="slider">
						 <li>	 
							<div class="caption">
							<div class="col-md-6 cap-left wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta Fusce</p>
					
							</div>
							<div class="col-md-6 cap-right wow fadeInUpBig animated animated" data-wow-delay="0.02s">
								<h3>Pain is temporary. quitting lasts forever.</h3>
							</div>
							<div class="clearfix"></div>
							</div>
						</li>
						 <li>	 
							<div class="caption">
							<div class="col-md-6 cap-left wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<p>Pain may last a minute, an hour, or a day, but it will eventually subside & something else will take its place. But quitting, however, lastsFusce porta porta</p>
								
							</div>
							<div class="col-md-6 cap-right wow fadeInUpBig animated animated" data-wow-delay="0.02s">
								<h3>Work hard everyday No guts no glory</h3>
							</div>
								<div class="clearfix"></div>
							</div>
							
						 </li>
						<li>	 
							<div class="caption">
							<div class="col-md-6 cap-left wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy hendrerit mauris. Phasellus porta</p>
								
							</div>
							<div class="col-md-6 cap-right wow fadeInUpBig animated animated" data-wow-delay="0.02s">
								<h3>Pain is temporary. quitting lasts forever.</h3>
							</div>
							<div class="clearfix"></div>
							</div>
							
						 </li>
					</ul>
				</div>
			</div>
		</div>
	</div>
<!---banner--->
		<!---content--->
			<div class="content">
				<!---train--->
					<div class="train w3-agile">
						<div class="container">
						<!---728x90--->
							<h2>Train with us</h2>
							<div class="train-grids">
								<div class="col-md-3 train-grid wow fadeInLeft animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e1.png"/>"/>
										</div>
										<h4>Group Flat Gym</h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInDownBig animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e2.png"/>"/>
										</div>
										<h4>Dumbbell Gym</h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInUpBig animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e3.png"/>"/>
										</div>
										<h4>Lifting Weight </h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
								<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e4.png"/>"/>
										</div>
										<h4>Stretching</h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<div class="train-grids">
								<div class="col-md-3 train-grid wow fadeInLeft animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e5.png"/>"/>
										</div>
										<h4>Cardio Blast</h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInDownBig animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e6.png"/>"/>
										</div>
										<h4>Pulling</h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInUpBig animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e7.png"/>"/>
										</div>
										<h4>Jump Rope </h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="col-md-3 train-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
									<div class="train-top hvr-bounce-to-right">
										<div class="train-img">
											<img src="<c:url value="/resources/images/e8.png"/>"/>
										</div>
										<h4>Upper Chest </h4>
										<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									</div>
								</div>
								<div class="clearfix"></div>
							</div>
							<!---728x90--->
						</div>
					</div>
				<!---train--->
				<div class="fit-section w3l-layouts">
					<div class="container">
						<div class="fit-grids">
							<div class="col-md-4 fit-grid wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<div class="fit-left hvr-bounce-to-bottom">
									<h3>Course days</h3>
									<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									<ul>
									<li>MONDAY - FRIDAY : 08:00 - 16:00</li>
									<li>SATURDAY : 09:30 - 15:30</li>
									<li>SUNDAY : Closed</li>
									</ul>
								</div>
							</div>
							<div class="col-md-4 fit-grid wow fadeInUpBig animated animated" data-wow-delay="0.02s">
								<img src="<c:url value="/resources/images/f2.jpg"/>" class="img-responsive" alt=""/>
							</div>
							<div class="col-md-4 fit-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
								<div class="fit-right hvr-bounce-to-right">
									<h3>Fitness</h3>
									<p>Improving technique that allows to change the body shape and weight and permanently fix the result achieved. It includes physical training combined with properly chosen diet And exercise. </p>
									
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="fit-grids1">
							<div class="col-md-8 fit-grid2 wow fadeInLeft animated animated" data-wow-delay="0.02s">
								<img src="<c:url value="/resources/images/f3.jpg"/>" class="img-responsive" alt=""/>
							</div>
							<div class="col-md-4 fit-grid1 hvr-bounce-to-bottom wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<div class="fit-right">
									<h3>Fitness</h3>
									<p>Improving technique that allows to change the body shape and weight and permanently fix the result achieved. It includes physical training combined with properly chosen diet And exercise. </p>
									
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="fit-grids wow fadeInLeft animated animated" data-wow-delay="0.02s">
						<div class="col-md-4 fit-grid">
								<img src="<c:url value="/resources/images/f1.jpg"/>" class="img-responsive" alt=""/>
							</div>
							<div class="col-md-4 fit-grid wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<div class="fit-left hvr-bounce-to-bottom">
									<h3>Course days</h3>
									<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy</p>
									<ul>
									<li>MONDAY - FRIDAY 08:00 - 16:00</li>
									<li>SATURDAY 09:30 - 15:30</li>
									<li>SUNDAY 09:30 - 15:30</li>
									</ul>
								</div>
							</div>
							<div class="col-md-4 fit-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
								<div class="fit-right hvr-bounce-to-right">
									<h3>Fitness</h3>
									<p>Improving technique that allows to change the body shape and weight and permanently fix the result achieved. It includes physical training combined with properly chosen diet And exercise. </p>
									
								</div>
							</div>
							<div class="clearfix"></div>
						</div>
						<div class="fit-grids1">
						<div class="col-md-4 fit-grid1 hvr-bounce-to-bottom wow fadeInDownBig animated animated" data-wow-delay="0.02s">
								<div class="fit-right">
									<h3>Fitness</h3>
									<p>Improving technique that allows to change the body shape and weight and permanently fix the result achieved. It includes physical training combined with properly chosen diet And exercise. </p>
									
								</div>
							</div>
							<div class="col-md-8 fit-grid2 wow fadeInUpBig animated animated" data-wow-delay="0.02s">
								<img src="<c:url value="/resources/images/f4.jpg"/>" class="img-responsive" alt=""/>
							</div>
							<div class="clearfix"></div>
						</div>
					</div>
				</div>
				<!---Benefits - Join Today!--->
					<div class="benefits w3l">
						<div class="container">
						<!---728x90--->
							<div class="benefits-grids">
								<div class="col-md-6 benefits-grid wow fadeInLeft animated animated" data-wow-delay="0.02s">
									<h3>benefits join today</h3>
									<div class="benefit-top">
										<div class="benefit-left">
											<h4>1</h4>
										</div>
										<div class="benefit-right">
											<p> porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci Neque velit.</p>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="benefit-top">
										<div class="benefit-left">
											<h4>2</h4>
										</div>
										<div class="benefit-right">
											<p> porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci Neque velit.</p>
										</div>
										<div class="clearfix"></div>
									</div><div class="benefit-top">
										<div class="benefit-left">
											<h4>3</h4>
										</div>
										<div class="benefit-right">
											<p> porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci Neque velit.</p>
										</div>
										<div class="clearfix"></div>
									</div>
									<div class="benefit-top">
										<div class="benefit-left">
											<h4>4</h4>
										</div>
										<div class="benefit-right">
											<p> porro quisquam est, qui dolorem ipsum quia dolor sit amet, consectetur, adipisci Neque velit.</p>
										</div>
										<div class="clearfix"></div>
									</div>
								</div>
								<div class="col-md-6 benefits-grid1 wow fadeInRight animated animated" data-wow-delay="0.02s">
									<form action="#" method="post">
										<input type="text" name="name" placeholder="Name *" required>
										<input type="text" name="email" class="email" placeholder="Email *" required>
										<input type="text" name="phone"  class="phone"placeholder="Phone Number *" required>
										<textarea name="text area" placeholder="Message *"></textarea>
										<input type="submit" value="Join Now">
									</form>
								</div>
								<div class="clearfix"></div>
							</div>
						</div>
					</div>
				<!---Benefits - Join Today!--->
			</div>
			<div class="testimonials-section">
			<div class="container">
				<h3>Testimonials</h3>
				<div class="testimonials-grids">
					<div class="col-md-2 testimonials-grid1 test1 wow fadeInDownBig animated animated" data-wow-delay="0.02s">
						<img src="<c:url value="/resources/images/t1.png"/>" class="img-responsive" alt=""/>
					</div>
					<div class="col-md-10 testimonials-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
						<p>Epsum factorial non deposit quid pro quo hic escorol. Olypian quarrels et gorilla congolium sic ad nauseum. Souvlaki ignitus carborundum e pluribus unum. Defacto lingo est igpay atinlay. Marquee selectus non provisio incongruous feline nolo contendre. Gratuitous octopus niacin, sodium glutimate. Quote meon an estimate et non interruptus stadium.</p>
						<h5>Antonio Brightman</h5>
					</div>
					<div class="clearfix"></div>
				</div>
				<div class="testimonials-grids">
					<div class="col-md-10 testimonials-grid wow fadeInUpBig animated animated" data-wow-delay="0.02s">
						<p>Epsum factorial non deposit quid pro quo hic escorol. Olypian quarrels et gorilla congolium sic ad nauseum. Souvlaki ignitus carborundum e pluribus unum. Defacto lingo est igpay atinlay. Marquee selectus non provisio incongruous feline nolo contendre. Gratuitous octopus niacin, sodium glutimate. Quote meon an estimate et non interruptus stadium.</p>
						<h5>Brightman</h5>
					</div>
					<div class="col-md-2 testimonials-grid1 test wow fadeInLeft animated animated" data-wow-delay="0.02s">
						<img src="<c:url value="/resources/images/t2.png"/>" class="img-responsive" alt=""/>
					</div>
					<div class="clearfix"></div>
				</div>
			</div>
		</div>
		<!---Testimonials--->
<!---footer--->
		<div class="footer-section">
			<div class="container">
			<div class="footer-grids">
				<div class="col-md-3 footer-grid wow fadeInDownBig animated animated" data-wow-delay="0.02s">
					<h4>About</h4>
					<p>Lorem ipsum dolor sit amet, consectetuer adipig elit. Praesent vestibulummolestie lacus. Aenean nonummy hendrerit mauris. Praesent vestibulummolestie lacus.</p>
				</div>
				<div class="col-md-3 footer-grid wow fadeInLeft animated animated" data-wow-delay="0.02s">
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
				<div class="col-md-3 footer-grid wow fadeInUpBig animated animated" data-wow-delay="0.02s">
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
				<div class="col-md-3 footer-grid wow fadeInRight animated animated" data-wow-delay="0.02s">
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
	<div class="copy-section wow fadeInDownBig animated animated" data-wow-delay="0.02s">
		<div class="container">
				<div class="social-icons">
					<a href="#"><i class="icon"></i></a>
					<a href="#"><i class="icon1"></i></a>
					<a href="#"><i class="icon2"></i></a>
					<a href="#"><i class="icon3"></i></a>
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
    <script>window.jQuery || document.write('<script src="js/jquery-2.1.4.min.js"><\/script>')</script>
	<script src='<c:url value="/resources/js/responsiveslides.min.js" />'></script>
 <script>
    $(function () {
      $("#slider").responsiveSlides({
      	auto: true,
      	nav: true,
      	speed: 500,
        namespace: "callbacks",
        pager: true,
      });
    });
  </script>
	<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script></body>
</html>