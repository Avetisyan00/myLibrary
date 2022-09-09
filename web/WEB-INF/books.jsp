<%@ page import="model.Book" %>
<%@ page import="java.util.List" %>
<%@ page import="manager.AuthorManager" %>
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Books</title>
</head>
<body>
<%
    AuthorManager authorManager = new AuthorManager();
    List<Book> bookList = (List<Book>) request.getAttribute("bookList");
%>
<table border="1" style="border-style: solid">
    <tr>
        <th>id</th>
        <th>title</th>
        <th>description</th>
        <th>price</th>
        <th>author's name</th>
        <th>action</th>
    </tr>

    <%
        for (Book book : bookList) { %>
    <tr>
        <td><%=book.getId()%>
        </td>
        <td><%=book.getTitle()%>
        </td>
        <td><%=book.getDescription()%>
        </td>
        <td><%=book.getPrice()%>
        </td>
        <td><%=book.getAuthor().getName() + " " + book.getAuthor().getSurname()%>
        </td>
        <td><a href="${pageContext.request.contextPath}/books/remove?bookId=<%=book.getId()%>">Remove</a>
            <a href="${pageContext.request.contextPath}/books/edit?bookId=<%=book.getId()%>">Edit</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>