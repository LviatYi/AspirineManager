<%@ page import="com.lviat.util.constant.text.RelationText"%>
<html>
  <head>
    <title>Aspirine | ASPN 医药管理系统</title>
  </head>
  <body>
    <h2>Hello World!</h2>
    <p>
      <% Object userId = session.getAttribute(RelationText.WEB_USER_ID);
      if(userId==null){ out.println("User not login"); }else{ out.println("Login
      User: "+userId.toString()); } %>
    </p>
  </body>
</html>
