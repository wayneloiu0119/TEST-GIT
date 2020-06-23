<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Card &ndash; the better way to collect credit cards</title>
<meta name="viewport" content="initial-scale=1">
<!-- CSS is included through the card.js script -->
<script src="resources/js/jquery.card.js"></script>

<style>
.demo-container {
	width: 100%;
	max-width: 350px;
	margin: 50px auto;
}

form {
	margin: 30px;
}

input {
	width: 200px;
	margin: 10px auto;
	display: block;
}
</style>
</head>
<body>
	<div class="demo-container">
		<div class="card-wrapper"></div>

		<div class="form-container active">
			<form action="">
				<input placeholder="Card number" type="tel" name="number"> 
				<input placeholder="Full name" type="text" name="name"> 
				<input placeholder="MM/YY" type="tel" name="expiry">
				<input placeholder="CVC" type="number" name="cvc">
			</form>
		</div>
	</div>

<!-- 	<script src="resources/js/card.js"></script> -->
	<script src="resources/js/jquery.card.js"></script>
	
	<script>
		new Card({
			form : document.querySelector('form'),
			container : '.card-wrapper'
		});
		
	</script>
</body>
</html>