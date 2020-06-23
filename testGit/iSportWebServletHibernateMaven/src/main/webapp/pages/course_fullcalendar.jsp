<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<link href='${pageContext.request.contextPath}/resources/css/fullcalendar.min.css' rel='stylesheet' />
<link href='${pageContext.request.contextPath}/resources/css/fullcalendar.print.min.css' rel='stylesheet'
	media='print' />
<script src='${pageContext.request.contextPath}/resources/js/moment.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/jquery-3.2.1.min.js'></script>
<script src='${pageContext.request.contextPath}/resources/js/fullcalendar.min.js'></script>
<script>
	$(document).ready(function() {
		$('#calendar').fullCalendar({
			header : {
				left : 'prev,next today',
				center : 'title',
				right : 'month,agendaWeek,agendaDay,listWeek'
			},
			defaultDate : '2017-09-12',
			navLinks : true, // can click day/week names to navigate views
			editable : true,
			eventLimit : true, // allow "more" link when too many events
			events : 
			{
				url: "${pageContext.request.contextPath}"+'/json'
				
			}
// 				[ {
// 				title : '全方位雕塑',
// 				start : '2017-10-03T15:00:00',
// 				end : '2017-10-03T17:00:00'
// 			}, {
// 				title : '全方位雕塑',
// 				start : '2017-10-06T15:00:00',
// 				end : '2017-10-06T17:00:00'
// 			} ]
		});
	});
// 	console.log('${pageContext.request.contextPath}'+'/json');
</script>
<style>
body {
	margin: 40px 10px;
	padding: 0;
	font-family: "Lucida Grande", Helvetica, Arial, Verdana, sans-serif;
	font-size: 14px;
}

#calendar {
	max-width: 900px;
	margin: 0 auto;
}
</style>
</head>
<body>

	<div id='calendar'></div>

</body>
</html>
