<%@ page import="java.util.List" %>
<%@ page import="model.Author" %><%--
  Created by IntelliJ IDEA.
  User: Edgar
  Date: 9/8/2022
  Time: 5:09 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Book</title>
</head>
<body>
<%
    List<Author> authorList = (List<Author>) request.getAttribute("authors");
%>
Fill the fields to add new book
<form action="${pageContext.request.contextPath}/books/add" method="post">
    <input type="text" name="title" placeholder="Input title"/> <br>
    <input type="text" name="description" placeholder="Input description"/><br>
    <input type="number" name="price" placeholder="Input price"/><br>
    <select name="authorId"
        <%for (Author author : authorList) { %>
        <option value="<%=author.getId()%>">
            <%=author.getName()%>
            <%=author.getSurname()%></option><%}%>
    </select>

    <input type="submit" name="add"/>
</form>


</body>
</html>
