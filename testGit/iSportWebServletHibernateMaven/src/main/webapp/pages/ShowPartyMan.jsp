<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">

<link
	href="https://maxcdn.bootstrapcdn.com/bootstrap/3.3.7/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-BVYiiSIFeK1dGmJRAkycuHAHRg32OmUcww7on3RYdg4Va+PmSTsz/K68vbdEjh4u"
	crossorigin="anonymous">
<link rel="stylesheet" type="text/css" href="../css/xxx.css" />

<title>Display</title>
</head>
<body>
	<div class="container">
		<div class="row">
			<div class="panel panel-primary filterable">
				<div class="panel-heading">
					<h3 class="panel-title">目前所有會員參加的活動</h3>
					<div class="pull-right">
						<button class="btn btn-default btn-xs btn-filter">
							<span class="glyphicon glyphicon-filter"></span> Filter
						</button>
					</div>
				</div>
				<table class="table">
					<thead>
						<tr class="filters">
							<th><input type="text" class="form-control"
								placeholder="PartyId" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="PartyName" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="LeaderId" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="PartyDate" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="PartyTime" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="Number" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="NumberMax" disabled></th>
							<th><input type="text" class="form-control"
								placeholder="PartyLocation" disabled></th>
						</tr>
					</thead>
					<tbody>
						<c:forEach var="row" items="${SelectOne}">
							<tr>
								<td>${row.partyId}</td>
								<td>${row.partyName}</td>
								<td>${row.memberId}</td>
								<td>${row.partyDate}</td>
								<td>${row.partyTime}</td>
								<td>${row.number}</td>
								<td>${row.numberMax}</td>
								<td>${row.partyLocation}</td>
								<td><input class="btn btn-default btn-xs btn-filter type="
									submit" name="prodaction" value="Delete"></td>
							</tr>
						</c:forEach>
					</tbody>
				</table>
			</div>
		</div>
	</div>

	<script src="https://code.jquery.com/jquery-3.2.1.slim.min.js"
		integrity="sha384-KJ3o2DKtIkvYIK3UENzmM7KCkRr/rE9/Qpg6aAZGJwFDMVNA/GpGFF93hXpG5KkN"
		crossorigin="anonymous"></script>
	<script
		src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.11.0/umd/popper.min.js"
		integrity="sha384-b/U6ypiBEHpOf/4+1nzFpr53nxSS+GLCkfwBdFNTxtclqqenISfwAzpKaMNFNmj4"
		crossorigin="anonymous"></script>
	<script
		src="https://maxcdn.bootstrapcdn.com/bootstrap/4.0.0-beta/js/bootstrap.min.js"
		integrity="sha384-h0AbiXch4ZDo7tp9hKZ4TsHbi047NrKGLO3SEJAg45jXxnGIfYzk4Si90RDIqNm1"
		crossorigin="anonymous"></script>
	
	<script>
	/*
	Please consider that the JS part isn't production ready at all, I just code it to show the concept of merging filters and titles together !
	*/
	$(document).ready(function(){
	    $('.filterable .btn-filter').click(function(){
	        var $panel = $(this).parents('.filterable'),
	        $filters = $panel.find('.filters input'),
	        $tbody = $panel.find('.table tbody');
	        if ($filters.prop('disabled') == true) {
	            $filters.prop('disabled', false);
	            $filters.first().focus();
	        } else {
	            $filters.val('').prop('disabled', true);
	            $tbody.find('.no-result').remove();
	            $tbody.find('tr').show();
	        }
	    });

	    $('.filterable .filters input').keyup(function(e){
	        /* Ignore tab key */
	        var code = e.keyCode || e.which;
	        if (code == '9') return;
	        /* Useful DOM data and selectors */
	        var $input = $(this),
	        inputContent = $input.val().toLowerCase(),
	        $panel = $input.parents('.filterable'),
	        column = $panel.find('.filters th').index($input.parents('th')),
	        $table = $panel.find('.table'),
	        $rows = $table.find('tbody tr');
	        /* Dirtiest filter function ever ;) */
	        var $filteredRows = $rows.filter(function(){
	            var value = $(this).find('td').eq(column).text().toLowerCase();
	            return value.indexOf(inputContent) === -1;
	        });
	        /* Clean previous no-result if exist */
	        $table.find('tbody .no-result').remove();
	        /* Show all rows, hide filtered ones (never do that outside of a demo ! xD) */
	        $rows.show();
	        $filteredRows.hide();
	        /* Prepend no-result row if all rows are filtered */
	        if ($filteredRows.length === $rows.length) {
	            $table.find('tbody').prepend($('<tr class="no-result text-center"><td colspan="'+ $table.find('.filters th').length +'">No result found</td></tr>'));
	        }
	    });
	});
	</script>
	
	
<script>
	$("input[name='prodaction']").on("click",function(){
		alert("ok");
		var y = $(this).parent().siblings();
		alert(y[0]);
	})

</script>


</body>
</html>