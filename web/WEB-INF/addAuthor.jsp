<%--
  Created by IntelliJ IDEA.
  User: Edgar
  Date: 9/8/2022
  Time: 1:46 PM
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Add Author</title>
</head>
<body>
fill this fields to add new Author
<form action="${pageContext.request.contextPath}/authors/add" method="post" enctype="multipart/form-data">
    <input type="text" name="name" placeholder="Input Author's name"/><br>
    <input type="text" name="surname" placeholder="Input Author's surname"/><br>
    <input type="email" name="email" placeholder="Input Author's email"/><br>
    <input type="text" name="password" placeholder="Input password"/><br>
    <input type="submit" value="Register"/>

    Profile Picture:
    <input type="file" name="profilePic"/>
</form>
</body>
</html>
