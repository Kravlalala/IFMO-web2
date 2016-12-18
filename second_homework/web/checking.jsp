<%--
  Created by IntelliJ IDEA.
  User: Илья
  Date: 18.12.2016
  Time: 12:01
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Validation</title>
</head>
<body>
<%
    String result = (String)request.getAttribute("result");
    if ( result.equals("success") )
    {
%>
<script>
    alert("Registrarion successfully complete");
    window.location.replace("sign_in.jsp");
</script>
<%
    }
    else
    {
%>
<p>Failed: <%= result.toString() %>.</p>
<script>
    function redirect() {
        alert("Please check your username and password");
        window.location.replace("index.jsp");
}
setTimeout(redirect, 500);

</script>

<%
    }
%>
</body>
</html>
