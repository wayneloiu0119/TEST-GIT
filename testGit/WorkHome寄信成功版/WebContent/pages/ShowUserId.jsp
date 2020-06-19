<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>
<jsp:useBean id="memberBean" class="ModelDAO.MemberDAO" />
<c:set var="subTitle" value="查詢會員資料" />
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>${subTitle}</title>
</head>
<body>
<c:if test="${empty LoginOK}">
<c:set var="target" value="${pageContext.request.servletPath}" scope="session"/>
<c:redirect url="/pages/LogIn.jsp"/>
</c:if>
	<c:choose>
		<c:when test="${empty memberBean.allMembers}">
                        目前尚未有任何會員資料 
        </c:when>
	<c:otherwise>
                       會員資料：<br>
            <TABLE border='1'>
            <thead>
        <TR>
            <Td width=‘120’>帳號</Td>
            <Td width=‘120’>密碼</Td>
            <Td width=‘150’>名字</Td>
            <Td width=‘120’>生日</Td>
            <Td width=‘120’>信箱</Td>
            <Td width=‘120’>電話</Td>
         
        </TR>
		</thead>
		<tbody>
       <c:forEach  var="aBean" items="${memberBean.allMembers}">
       <c:url value="/pages/UpdateMember.jsp" var="link">
       <c:param name="mId" value="${aBean.memberId}" />
       <c:param name="pswd" value="${aBean.password}" />
       <c:param name="mName" value="${aBean.name}" />
       <c:param name="mBirthday" value="${aBean.birthday}" />
       <c:param name="mEmail" value="${aBean.email}" />
       <c:param name="mPhone" value="${aBean.phone}" />
       </c:url>
        <TR>
            <TD><a href="${link}">${aBean.memberId}</a></TD>
            <TD> ${aBean.password}</TD>
            <TD> ${aBean.name}</TD>
            <TD> ${aBean.birthday}</TD>
            <TD> ${aBean.email}</TD>
            <TD> ${aBean.phone}</TD>
            
         </TR>

				
        </c:forEach>
        </tbody>
    </TABLE>
  </c:otherwise>
</c:choose>
<br>
<a href="<c:url value='../index.jsp' /> ">回首頁</a>
</body>
</html>