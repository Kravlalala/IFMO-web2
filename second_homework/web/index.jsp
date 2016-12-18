<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.12.2016
  Time: 11:14
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign Up</title>
</head>
<body>

<p>
  <form method="GET" action="/SignUp">
    <h2>Print your ID</h2>
    <input type="text" name="username" size="15" />
    <h2>Print your password</h2>
    <input type="password" name="password" size="15" />
    <h2>Confirm your password</h2>
    <input type="password" name="password2" size="15"/>
     <p> <input type="submit" value="Confirm" /></p>
  </form>

</p>
<div id="print" style="color:#b7110a"></div>
</body>
</html>
