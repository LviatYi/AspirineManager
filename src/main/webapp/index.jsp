<%@ page import="com.lviat.util.constant.text.RelationText"%>
<html>
  <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
  <head>
    <title>Aspirine | ASPN 医药管理系统</title>
  </head>
  <body>
    <h2>Hello World!</h2>
    <p>
      <% Object userId = session.getAttribute(RelationText.WEB_USER_ID);
      if(userId==null){ out.println("User not login"); }
      else
      { out.println("Login User: "+userId.toString());}
      %>
    </p>
  </body>
</html>
