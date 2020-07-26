<%@ page import="java.io.File" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="java.util.List" %>
<%@page language="java" contentType="text/html;charset=UTF-8" pageEncoding="utf-8" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%@ page isELIgnored="false" %>
<%--顯示資料夾中已上傳的檔案--%>
<%
    String savePath = getClass().getResource("/").getPath();
    File file = new File(savePath);
    File[] arr = file.listFiles();
    List<String> array = new ArrayList<String>();
    for(int m=0;m<arr.length;m++){
        if(arr[m].getName().endsWith(".xls")) {
            array.add(arr[m].getName());
        }
    }
    System.out.println(array.size());

%>
<html>
<body>
<h2>Hello World!</h2>
<meta charset="utf-8">

<h3>上傳</h3>
<form action="UploadServlet" enctype="multipart/form-data" method="post">
<input type="file" id="excel" name="excel" />
<input  type="submit" value="Upload">
</form>

<hr>
<h3>下載目錄</h3>
<ul>
    <%--這裡是下載操作--%>
<c:forEach var="i" items="<%=array%>">
    <a href="DownloadServlet?filename=${i}"><li>${i}</li></a>
</c:forEach>
</ul>
</body>
</html>