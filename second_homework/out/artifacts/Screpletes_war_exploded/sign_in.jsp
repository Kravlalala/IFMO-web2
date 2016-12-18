<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.12.2016
  Time: 11:17
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html lang="en">
<head>
    <meta charset="UTF-8">
    <title>Success</title>
</head>
<body>
<h2>Sign in</h2>
<form method="GET" action="/SignIn">
    <h2>Print your ID</h2>
    <input type="text" name="id" size="15" />
    <h2>Enter your password</h2>
    <input type="password" name="password" size="15" />
    <p> <input type="submit" value="Sign in" /></p>
</form>
</body>
</html>
