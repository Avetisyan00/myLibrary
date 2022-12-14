<%@ page import="model.Author" %>
<%@ page import="java.util.List" %>
<%@ page contentType="text/html;charset=UTF-16" %>
<html>
<head>
    <title>Authors</title>
</head>
<body>
<%
    List<Author> authorList = (List<Author>) request.getAttribute("authorList");
%>
<table border="1" style="border-style: solid">
    <tr>
        <th>image</th>
        <th>id</th>
        <th>name</th>
        <th>surname</th>
        <th>email</th>
        <th>action</th>

    </tr>

    <%
        for (Author author : authorList) { %>
    <tr>
        <td>
            <% if (author.getProfilePic() == null || author.getProfilePic().length() == 0) {%>
                <img src="${pageContext.request.contextPath}/image/projectImages189913895524500_profile_picture_for_web.jpg" width="100"/>
            <%} else {%>
                 <img src="${pageContext.request.contextPath}/getImage?profilePic=<%=author.getProfilePic()%>" width="100"/>
            <%}%>
        </td>
        <td><%=author.getId()%>
        </td>
        <td><%=author.getName()%>
        </td>
        <td><%=author.getSurname()%>
        </td>
        <td><%=author.getEmail()%>
        </td>
        <td><a href="${pageContext.request.contextPath}/author/remove?authorId=<%=author.getId()%>">Remove</a>|<a
                href="${pageContext.request.contextPath}/author/edit?authorId=<%=author.getId()%>">Edit</a>
        </td>
    </tr>
    <%
        }
    %>
</table>
</body>
</html>
