<%@ page import="model.Book" %>
<%@ page import="model.Author" %>
<%@ page import="java.util.List" %><%--
  Created by IntelliJ IDEA.
  User: Edgar
  Date: 9/9/2022
  Time: 3:00 AM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Edit Book</title>
</head>
<body>
<%
    Book book = (Book) request.getAttribute("book");
    List<Author> authorList = (List<Author>) request.getAttribute("authors");
%>
Edit the book
<form action="${pageContext.request.contextPath}/books/edit" method="post">
    <input type="hidden" name="bookId" value="<%=book.getId()%>">
    <input type="text" name="title" value="<%=book.getTitle()%>"/> <br>
    <input type="text" name="description" value="<%=book.getDescription()%>"/><br>
    <input type="number" name="price" value="<%=book.getPrice()%>"/><br>
    <select name="authorId">
        <%
            for (Author author : authorList) {
                if (author.equals(book.getAuthor())) {
        %>

        <option selected value="<%=author.getId()%>"><%=author.getName()%> <%=author.getSurname()%>
        </option>
        <%} else {%>
        <option value="<%=author.getId()%>"
        <%=author.getName()%> <%=author.getSurname()%>
        <% }
        }
        %>
        <input type="submit" name="edit"/>
    </select>
</form>
</body>
</html>
