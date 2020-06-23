<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
        <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<script src="https://ajax.googleapis.com/ajax/libs/jquery/3.2.1/jquery.min.js"></script>
<title>Insert title here</title>
<script type="text/javascript">
var contextPath="${pageContext.request.contextPath}";
$(document).ready(function() {
	$("input[name='messageId']").blur(function() {
		$.ajax({
			"url": contextPath+"/pages/blackFriend.view",
			"method": "POST",
			"data": "messageId="+$("input[name='messageId']").val(),
			"success": function(data) {
				var json = JSON.parse(data);
				if(json[0].hasMoreData) {
					$("input[name='messageId']").val(json[1].id);
					$("input[name='memberId']").val(json[1].nameid);
					$("input[name='memberName']").val(json[1].name)
					$("input[name='messageTime']").val(json[1].price);
					$("input[name='typeName']").val(json[1].make);
					$("input[name='messageText']").val(json[1].expire);
					$("input[name='messagePic']").val(json[1].expire);
					$("input[name='star']").val(json[1].expire);
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
<body>
<h3>後台討論區</h3>
	<c:if test="${not empty select}">
		<table>
			<thead>
				<tr>
					<th>編號</th>
					<th>會員編號</th>
					<th>會員名稱</th>
					<th>發布時間</th>
					<th>主題分類</th>
					<th>內容</th>
					<th>圖片</th>
					<th>評價</th>
				</tr>
			</thead>
			<tbody>
				<c:forEach var="row" items="${select}">
					<c:url value="/pages/messageMemberSelect.jsp" var="link">
						<c:param name="messageId" value="${row[0]}" />
						<c:param name="memberId" value="${row[1]}" />
						<c:param name="memberName" value="${row[2]}" />
						<c:param name="messageTime" value="${row[3]}" />
						<c:param name="typeName" value="${row[4]}" />
						<c:param name="messageText" value="${row[5]}" />
						<c:param name="messagePic" value="${row[6]}" />
						<c:param name="star" value="${row[7]}" />
					</c:url>
					<tr>
						<td><a href="${link}">${row[0]}</a></td>
						<td>${row[1]}</td>
						<td>${row[2]}</td>
						<td>${row[3]}</td>
						<td>${row[4]}</td>
						<td>${row[5]}</td>
						<td><img height='100' width='100'
							src='${pageContext.servletContext.contextPath}/pages/getImage.controller?messageId=${row[0]}' />
						</td>
						<td>${row[7]}</td>
<%-- 						<td>${row.memberName}</td> --%>
<%-- 						<td>${row.messageTime}</td> --%>
<%-- 						<td>${row.typeName}</td> --%>

<%-- 						<td>${row.messageText}</td> --%>
<!-- 						<td> -->
<!-- 						<img height='100' width='100' -->
<%-- 							src='${pageContext.servletContext.contextPath}/pages/getImage.controller?messageId=${row[0]}' /> --%>
<!-- 						</td> -->
<%-- 						<td>${row.star}</td> --%>
                          <td><input type="submit" name="prodaction" value="Delete"></td>
					</tr>
				</c:forEach>
			</tbody>
		</table>
	</c:if>

	<h3>
		<a href="<c:url value="/pages/messageMemberSelect.jsp" />">Message Table</a>
	</h3>
	<h3><span class="error">${errors.action}</span></h3>

	<c:if test="${not empty delete}">
	<h3>Delete Message Table Success : ${delete} row deleted</h3>
	<script type="text/javascript">clearForm();</script>
	</c:if>
	
	<script>
	CKEDITOR.replace('msgck');
   </script>
</body>
</html>