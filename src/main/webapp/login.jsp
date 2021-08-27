<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"%>
<!DOCTYPE html>
<html>
  <head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <title>Aspirine | Login</title>
    <link
      rel="stylesheet"
      type="text/css"
      href="${pageContext.request.contextPath}/css/index.css"
    />
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
    <div id="total">
      <form action="${pageContext.request.contextPath}/login.do" method="post">
        <table id="tab">
          <tr>
            <td>用户 ID</td>
            <td>
              <input
                type="text"
                placeholder="请输入用户 ID"
                id="userId"
                title="请输入用户 ID"
                name="${RelationText.WEB_USER_ID}"
              />
            </td>
          </tr>
          <tr>
            <td>用户密码</td>
            <td>
              <input
                type="password"
                placeholder="请输入密码"
                id="password"
                title="请输入密码"
                name="${RelationText.WEB_USER_PASSWORD}"
              />
            </td>
          </tr>
          <tr>
            <td><input type="submit" id="submit" value="登陆" /></td>
            <td><input type="reset" value="重置" /></td>
          </tr>
        </table>
      </form>
    </div>
  </body>
</html>
