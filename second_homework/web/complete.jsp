<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.12.2016
  Time: 13:02
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Complete</title>
</head>
<body>
<%
    String result = (String)request.getAttribute("result");
    if ( result.equals("success") )
    {
%>
<script>
    alert("Registrarion successfully complete");
</script>
<h2>First name</h2>
<input id="name1" type="text" size="15"/>
<h2>Last name</h2>
<input id="name2" type="text" size="15"/>
<h2>Age</h2>
<input id="age" type="text" size="15"/>
<p>
    <button id="confirm" style="height:30px; width:75px">Confirm</button>
</p>
<div id="print" style="color:#b7110a"></div>
<%
}
else
{
%>
<p>Failed: <%= result.toString() %>.</p>
<script>
    function redirect() {
        alert("Please check your username and password");
        window.location.replace("sign_in.jsp");
    }
    setTimeout(redirect, 500);

</script>

<%
    }
%>
</body>
</html>
