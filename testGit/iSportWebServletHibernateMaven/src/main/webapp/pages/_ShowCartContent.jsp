<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>購物清單</title>
</head>
<body>

	<h3>ShoppingCart = ${ShoppingCart}</h3>
	<h3>ShoppingCart.subtotal = ${ShoppingCart.subtotal}</h3>
	<h3>ShoppingCart.content = ${ShoppingCart.content}</h3>
	<h3>ShoppingCart.ItemNumber = ${ShoppingCart.itemNumber}</h3>
	<hr>
	<c:forEach varStatus="vs" var="anEntry" items="${ShoppingCart.content}">
		<h4>第${vs.count}筆</h4>
		<h4>Key=${anEntry.key}</h4>
		<h4>courseId=${anEntry.value.courseId}</h4>
		<h4>courseName=${anEntry.value.courseName}</h4>
		<h4>courseStartDate=${anEntry.value.courseStartDate}</h4>
		<h4>courseStartTime=${anEntry.value.courseStartTime}</h4>
		<h4>coursePrice=${anEntry.value.coursePrice}</h4>
		<h4>discount=${anEntry.value.discount}</h4>
		<h4>memberId=${anEntry.value.memberId}</h4>

	</c:forEach>
	<hr>
	<c:forEach varStatus="vs" var="course" items="${Course}">
		<h4>第${vs.count}筆</h4>
		<h4>courseId=${course.courseId}</h4>
		<h4>courseName=${course.courseName}</h4>
		<h4>coursePrice=${course.coursePrice}</h4>
		<h4>courseStartDate=${course.courseStartDate}</h4>
		<h4>discount=${course.discount}</h4>
		<h4>discountPrice=${course.discountPrice}</h4>

	</c:forEach>
	<%-- 
	<c:choose>
		<c:when test="${ShoppingCart.subtotal > 0}">
			<c:set var="subtotalMessage" value="金額小計:${ShoppingCart.subtotal} 元" />
			<c:set var="subtotal" value="${ShoppingCart.subtotal}" />
		</c:when>
		<c:otherwise>
			<c:set var="subtotalMessage" value="金額小計:  0 元" />
			<c:set var="subtotal" value="0" />
		</c:otherwise>
	</c:choose>

	<center>
		<p />
		<TABLE border='2' width="820" style="background: #EFEFFB;">
			<TR>
				<TD colspan='4'>
					<!--          購物車的標題          -->
					<TABLE width="820">
						<TR height='18'>
							<TD width="270">&nbsp;</TD>
							<TD width="280" align='center'><FONT size='+2'>購 物 清
									單</FONT></TD>
							<TD width="270" align='right'></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>

			<TR>
				<TD><font size='-1' face='標楷體, Arial'>
						<TABLE border='1'>
							<TR>
								<TH width="280">課程名稱</TH>
								<TH width="70">教練</TH>
								<TH width="60">單價</TH>
								<TH width="40">數量</TH>
								<TH width="110">小計</TH>
								<TH width="110">修改</TH>
							</TR>
							<c:forEach varStatus="vs" var="anEntry"
								items="${ShoppingCart.content}">
								<TR height='16'>
									<TD>${anEntry.value.title}</TD>
									<TD style="text-align: center;">${fn:substring(anEntry.value.author, 0, 3)}</TD>
									<TD style="text-align: center;">${fn:substring(anEntry.value.companyName, 0, 2)}</TD>
									<TD style="text-align: right;"><fmt:formatNumber
											value="${anEntry.value.price * anEntry.value.discount }"
											pattern="#,###" />元</TD>
									<TD style="text-align: right;"><Input
										id="newQty${vs.index}" style="width: 28px; text-align: right"
										name="newQty" type="text"
										value="<fmt:formatNumber value="${anEntry.value.qty}" />"
										name="qty" onkeypress="return isNumberKey(event)" /></TD>
									<TD style="text-align: right;"><fmt:formatNumber
											value="${anEntry.value.price * anEntry.value.discount * anEntry.value.qty}"
											pattern="#,###,###" />元</TD>
									<TD><Input type="button" name="delete" value="刪除"
										onClick="confirmDelete(${anEntry.key})"></TD>
								</TR>
							</c:forEach>
							<TR height='16'>
								<TD colspan='5' align='right'>合計金額：</TD>
								<TD align='right'><fmt:formatNumber value="${subtotal}"
										pattern="#,###,###" />元</TD>
								<TD align='right'>&nbsp;</TD>
							</TR>
							<TR>
								<TD colspan='5' align='right'>營業稅：</TD>
								<c:set var="VAT" value="${subtotal*0.05 + 0.0001}" />
								<TD align='right'><fmt:formatNumber value="${VAT}"
										pattern="#,###,###" />元</TD>
								<TD align='right'>&nbsp;</TD>
							</TR>
							<TR>
								<TD colspan='5' align='right'>總計金額：</TD>
								<TD align='right'><fmt:formatNumber
										value="${subtotal + VAT }" pattern="#,###,###" />元</TD>
								<TD align='right'>&nbsp;</TD>
							</TR>
						</TABLE>
				</font></TD>
			</TR>
			<TR height='80'>
				<TD>
					<TABLE border='1'>
						<TR>
							<TD width="260" align='center'><A
								href="<c:url value='../_03_listBooks/DisplayPageProducts?pageNo=${param.pageNo}' />">繼續購物</A>
							</TD>
							<TD width="260" align='center'><A
								href="<c:url value='/shoppingCart/checkOrder.controller' />"
								onClick="return Checkout(${subtotal});">再次確認</A></TD>
							<TD width="260" align='center'><A
								href="<c:url value='/shoppingCart/giveUp.controller' />"
								onClick="return Abort();">放棄購物</A></TD>
						</TR>
					</TABLE>
				</TD>
			</TR>
		</TABLE>
	</center>

	<form>
		<input type="hidden" name="a" />
	</form>
--%>
</body>
</html>