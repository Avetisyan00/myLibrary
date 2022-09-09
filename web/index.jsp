<%--
  Created by IntelliJ IDEA.
  User: Edgar
  Date: 9/8/2022
  Time: 12:35 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Main Page</title>
</head>
<body>
<div style="width: 1000px;position: center">
</div>
<div><img src="${pageContext.request.contextPath}/image/taxa_for_web.jpg"></div>
<div>
    <a href="${pageContext.request.contextPath}/authors">Show All Authors</a> <br>
    <a href="${pageContext.request.contextPath}/authors/add">Add New Author</a> <br>
    <a href="${pageContext.request.contextPath}/books">Show All Books</a> <br>
    <a href="${pageContext.request.contextPath}/books/add">Add New Book</a> <br>
</div>
</body>
</html>
