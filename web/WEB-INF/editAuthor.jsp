<%@ page import="model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Edgar
  Date: 9/8/2022
  Time: 2:53 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Author</title>
</head>
<body>
<%
    Author author = (Author) request.getAttribute("author");
%>
Edit an Author
<form action="${pageContext.request.contextPath}/author/edit" method="post">
    <input type="hidden" name="authorId" value="<%=author.getId()%>"/><br>
    <input type="text" name="name" value="<%=author.getName()%>"/><br>
    <input type="text" name="surname" value="<%=author.getSurname()%>"/><br>
    <input type="email" name="email" value="<%=author.getEmail()%>"/><br>
    <input type="text" name="password" value="<%=author.getPassword()%>"/><br>
    <select>
        <input type="submit" value="Edit Author"/>
    </select>
</form>
</body>
</html>
