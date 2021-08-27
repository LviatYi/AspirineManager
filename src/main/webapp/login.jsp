<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Aspirine | Login</title>
    <link rel="icon" href="img/m1.jpg">
    <link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">

    <title>医药管理系统登陆</title>

    <!-- Bootstrap core CSS -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

    <!-- Custom styles for this template -->
    <link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/examples/signin/signin.css" rel="stylesheet">

    <!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
    <!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
    <script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/js/ie-emulation-modes-warning.js"></script>

    <!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
    <!--[if lt IE 9]-->
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>

    <script
      type="text/javascript"
      src="${pageContext.request.contextPath}/js/jquery.js"
    ></script>
    <script
      type="text/javascript"
      src="${pageContext.request.contextPath}/js/menu.js"
    ></script>
  </head>
  <body background="./img/12.jpg">
  <div class="container" >

    <form class="form-signin" action="${pageContext.request.contextPath}/login.do" method="post">
      <h2 class="form-signin-heading" style="text-align: center">登陆</h2>
      <label for="inputEmail" class="sr-only"></label>用户名：
      <input type="text" id="inputEmail" class="form-control" placeholder="name"  name="${RelationText.WEB_USER_ID}" required autofocus>
      <label for="inputPassword" class="sr-only"></label>密码:
      <input type="password" id="inputPassword" class="form-control" placeholder="Password"name="${RelationText.WEB_USER_PASSWORD}" required>

      <button class="btn btn-lg btn-primary btn-block" type="submit">Log</button>
    </form>

  </div>
  </body>
</html>
<%--    <div id="total">--%>
<%--      <form action="${pageContext.request.contextPath}/login.do" method="post">--%>
<%--        <table id="tab">--%>
<%--          <tr>--%>
<%--            <td>用户 ID</td>--%>
<%--            <td>--%>
<%--              <input--%>
<%--                type="text"--%>
<%--                placeholder="请输入用户 ID"--%>
<%--                id="userId"--%>
<%--                title="请输入用户 ID"--%>
<%--                name="${RelationText.WEB_USER_ID}"--%>
<%--              />--%>
<%--            </td>--%>
<%--          </tr>--%>
<%--          <tr>--%>
<%--            <td>用户密码</td>--%>
<%--            <td>--%>
<%--              <input--%>
<%--                type="password"--%>
<%--                placeholder="请输入密码"--%>
<%--                id="password"--%>
<%--                title="请输入密码"--%>
<%--                name="${RelationText.WEB_USER_PASSWORD}"--%>
<%--              />--%>
<%--            </td>--%>
<%--          </tr>--%>
<%--          <tr>--%>
<%--            <td><input type="submit" id="submit" value="登陆" /></td>--%>
<%--            <td><input type="reset" value="重置" /></td>--%>
<%--          </tr>--%>
<%--        </table>--%>
<%--      </form>--%>
<%--    </div>--%>

