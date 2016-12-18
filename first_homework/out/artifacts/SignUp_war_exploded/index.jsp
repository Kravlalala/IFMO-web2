<%--
  Created by IntelliJ IDEA.
  User: kravlala
  Date: 20.11.16
  Time: 20:37
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
  <title>Sign Up</title>
  <script src="jquery.js"></script>
  <script src="SignParams.js"></script>
</head>
<body>
<h2>Print your ID</h2>
<input id="id" type="text" size="15"/>
<h2>Print your password</h2>
<input id="password" type="text" size="15"/>
<h2>Confirm your password</h2>
<input id="password2" type="text" size="15"/>
<p>
  <button id="confirm" style="height:30px; width:75px">Confirm</button>
</p>
<div id="print" style="color:#b7110a"></div>
</body>
</html>