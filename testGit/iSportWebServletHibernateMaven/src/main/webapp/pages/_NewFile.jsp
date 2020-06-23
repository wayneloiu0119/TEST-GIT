<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link rel="stylesheet"
	href="http://maxcdn.bootstrapcdn.com/font-awesome/4.3.0/css/font-awesome.min.css">
<script src='<c:url value="/resources/js/jquery-3.2.1.min.js" />'></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery-validate/1.13.1/jquery.validate.min.js"></script>
<script type="text/javascript"
	src="https://cdnjs.cloudflare.com/ajax/libs/jquery.payment/1.2.3/jquery.payment.min.js"></script>

<!-- If you're using Stripe for payments -->
<script type="text/javascript" src="https://js.stripe.com/v2/"></script>
<script src='<c:url value="/resources/js/bootstrap.min.js" />'></script>
<style type="text/css">
/* Padding - just for asthetics on Bootsnipp.com */
body {
	margin-top: 20px;
}

/* CSS for Credit Card Payment form */
.credit-card-box .panel-title {
	display: inline;
	font-weight: bold;
}

.credit-card-box .form-control.error {
	border-color: red;
	outline: 0;
	box-shadow: inset 0 1px 1px rgba(0, 0, 0, 0.075), 0 0 8px
		rgba(255, 0, 0, 0.6);
}

.credit-card-box label.error {
	font-weight: bold;
	color: red;
	padding: 2px 8px;
	margin-top: 2px;
}

.credit-card-box .payment-errors {
	font-weight: bold;
	color: red;
	padding: 2px 8px;
	margin-top: 2px;
}

.credit-card-box label {
	display: block;
}
/* The old "center div vertically" hack */
.credit-card-box .display-table {
	display: table;
}

.credit-card-box .display-tr {
	display: table-row;
}

.credit-card-box .display-td {
	display: table-cell;
	vertical-align: middle;
	width: 50%;
}
/* Just looks nicer */
.credit-card-box .panel-heading img {
	min-width: 180px;
}
</style>
<script type="text/javascript">
	var $form = $('#payment-form');
	$form.find('.subscribe').on('click', payWithStripe);

	/* If you're using Stripe for payments */
	function payWithStripe(e) {
		e.preventDefault();

		/* Abort if invalid form data */
		if (!validator.form()) {
			return;
		}

		/* Visual feedback */
		$form.find('.subscribe').html(
				'Validating <i class="fa fa-spinner fa-pulse"></i>').prop(
				'disabled', true);

		var PublishableKey = 'pk_test_6pRNASCoBOKtIshFeQd4XMUh'; // Replace with your API publishable key
		Stripe.setPublishableKey(PublishableKey);

		/* Create token */
		var expiry = $form.find('[name=cardExpiry]').payment('cardExpiryVal');
		var ccData = {
			number : $form.find('[name=cardNumber]').val().replace(/\s/g, ''),
			cvc : $form.find('[name=cardCVC]').val(),
			exp_month : expiry.month,
			exp_year : expiry.year
		};

		Stripe.card
				.createToken(
						ccData,
						function stripeResponseHandler(status, response) {
							if (response.error) {
								/* Visual feedback */
								$form.find('.subscribe').html('Try again')
										.prop('disabled', false);
								/* Show Stripe errors on the form */
								$form.find('.payment-errors').text(
										response.error.message);
								$form.find('.payment-errors').closest('.row')
										.show();
							} else {
								/* Visual feedback */
								$form
										.find('.subscribe')
										.html(
												'Processing <i class="fa fa-spinner fa-pulse"></i>');
								/* Hide Stripe errors on the form */
								$form.find('.payment-errors').closest('.row')
										.hide();
								$form.find('.payment-errors').text("");
								// response contains id and card, which contains additional card details            
								console.log(response.id);
								console.log(response.card);
								var token = response.id;
								// AJAX - you would send 'token' to your server here.
								$
										.post('/account/stripe_card_token', {
											token : token
										})
										// Assign handlers immediately after making the request,
										.done(
												function(data, textStatus,
														jqXHR) {
													$form
															.find('.subscribe')
															.html(
																	'Payment successful <i class="fa fa-check"></i>');
												})
										.fail(
												function(jqXHR, textStatus,
														errorThrown) {
													$form
															.find('.subscribe')
															.html(
																	'There was a problem')
															.removeClass(
																	'success')
															.addClass('error');
													/* Show Stripe errors on the form */
													$form
															.find(
																	'.payment-errors')
															.text(
																	'Try refreshing the page and trying again.');
													$form.find(
															'.payment-errors')
															.closest('.row')
															.show();
												});
							}
						});
	}
	/* Fancy restrictive input formatting via jQuery.payment library*/
	$('input[name=cardNumber]').payment('formatCardNumber');
	$('input[name=cardCVC]').payment('formatCardCVC');
	$('input[name=cardExpiry').payment('formatCardExpiry');

	/* Form validation using Stripe client-side validation helpers */
	jQuery.validator.addMethod("cardNumber", function(value, element) {
		return this.optional(element) || Stripe.card.validateCardNumber(value);
	}, "Please specify a valid credit card number.");

	jQuery.validator.addMethod("cardExpiry", function(value, element) {
		/* Parsing month/year uses jQuery.payment library */
		value = $.payment.cardExpiryVal(value);
		return this.optional(element)
				|| Stripe.card.validateExpiry(value.month, value.year);
	}, "Invalid expiration date.");

	jQuery.validator.addMethod("cardCVC", function(value, element) {
		return this.optional(element) || Stripe.card.validateCVC(value);
	}, "Invalid CVC.");

	validator = $form.validate({
		rules : {
			cardNumber : {
				required : true,
				cardNumber : true
			},
			cardExpiry : {
				required : true,
				cardExpiry : true
			},
			cardCVC : {
				required : true,
				cardCVC : true
			}
		},
		highlight : function(element) {
			$(element).closest('.form-control').removeClass('success')
					.addClass('error');
		},
		unhighlight : function(element) {
			$(element).closest('.form-control').removeClass('error').addClass(
					'success');
		},
		errorPlacement : function(error, element) {
			$(element).closest('.form-group').append(error);
		}
	});

	paymentFormReady = function() {
		if ($form.find('[name=cardNumber]').hasClass("success")
				&& $form.find('[name=cardExpiry]').hasClass("success")
				&& $form.find('[name=cardCVC]').val().length > 1) {
			return true;
		} else {
			return false;
		}
	}

	$form.find('.subscribe').prop('disabled', true);
	var readyInterval = setInterval(function() {
		if (paymentFormReady()) {
			$form.find('.subscribe').prop('disabled', false);
			clearInterval(readyInterval);
		}
	}, 250);
</script>
</head>
<body>
	<div class="container">
		<div class="row">
			<!-- You can make it whatever width you want. I'm making it full width
             on <= small devices and 4/12 page width on >= medium devices -->
			<div class="col-xs-12 col-md-4">


				<!-- CREDIT CARD FORM STARTS HERE -->
				<div class="panel panel-default credit-card-box">
					<div class="panel-heading display-table">
						<div class="row display-tr">
							<h3 class="panel-title display-td">Payment Details</h3>
							<div class="display-td">
								<img class="img-responsive pull-right"
									src="http://i76.imgup.net/accepted_c22e0.png">
							</div>
						</div>
					</div>
					<div class="panel-body">
						<form role="form" id="payment-form" method="POST"
							action="javascript:void(0);">
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="cardNumber">CARD NUMBER</label>
										<div class="input-group">
											<input type="tel" class="form-control" name="cardNumber"
												placeholder="Valid Card Number" autocomplete="cc-number"
												required autofocus /> <span class="input-group-addon"><i
												class="fa fa-credit-card"></i></span>
										</div>
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-7 col-md-7">
									<div class="form-group">
										<label for="cardExpiry"><span class="hidden-xs">EXPIRATION</span><span
											class="visible-xs-inline">EXP</span> DATE</label> <input type="tel"
											class="form-control" name="cardExpiry" placeholder="MM / YY"
											autocomplete="cc-exp" required />
									</div>
								</div>
								<div class="col-xs-5 col-md-5 pull-right">
									<div class="form-group">
										<label for="cardCVC">CV CODE</label> <input type="tel"
											class="form-control" name="cardCVC" placeholder="CVC"
											autocomplete="cc-csc" required />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<div class="form-group">
										<label for="couponCode">COUPON CODE</label> <input type="text"
											class="form-control" name="couponCode" />
									</div>
								</div>
							</div>
							<div class="row">
								<div class="col-xs-12">
									<button class="subscribe btn btn-success btn-lg btn-block"
										type="button">Start Subscription</button>
								</div>
							</div>
							<div class="row" style="display: none;">
								<div class="col-xs-12">
									<p class="payment-errors"></p>
								</div>
							</div>
						</form>
					</div>
				</div>
				<!-- CREDIT CARD FORM ENDS HERE -->


			</div>

		</div>
		<div class="col-xs-12 col-md-8"
			style="font-size: 12pt; line-height: 2em;">
			<p>
			<h1>Features:</h1>
			<ul>
				<li>As-you-type, input formatting</li>
				<li>Form field validation (also as you type)</li>
				<li>Graceful error feedback for declined card, etc</li>
				<li>AJAX form submission w/ visual feedback</li>
				<li>Creates a Stripe credit card token</li>
			</ul>
			</p>
			<p>Be sure to replace the dummy API key with a valid Stripe API
				key.</p>

			<p>
				Built upon: Bootstrap, jQuery, <a
					href="http://jqueryvalidation.org/">jQuery Validation Plugin</a>, <a
					href="https://github.com/stripe/jquery.payment">jQuery.payment
					library</a>, and <a href="https://stripe.com/docs/stripe.js">Stripe.js</a>
			</p>
		</div>

	</div>
</body>
</html>