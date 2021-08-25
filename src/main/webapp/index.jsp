<%@ page import="com.lviat.util.*"%>
<html>
<body>
<h2>Hello World!</h2>
<p>
    <% out.println("Login User: "+session.getAttribute("id"));%>
</p>
</body>
</html>
