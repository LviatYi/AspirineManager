<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
    <meta charset="utf-8">
    <title>医药管理系统</title>
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/index.css"/>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/jquery-3.2.1.js"></script>
    <script type="text/javascript" src="${pageContext.request.contextPath}/js/index.js"></script>
</head>
<body>
<div id="total">
    <form action="${pageContext.request.contextPath}/login.do" method="post">
        <table id="tab">
            <tr>
                <td>用户名</td>
                <td><input type="text"
                           placeholder="请输入用户 ID" id="username" title="请输入用户 ID" name="userId"/></td>
            </tr>
            <tr>
                <td>用户密码</td>
                <td><input type="password"
                           placeholder="请输入密码" id="password" title="请输入密码" name="password"/></td>
            </tr>
            <tr>
                <td><input type="submit" id="submit" value="登陆"/></td>
                <td><input type="reset" value="重置"/></td>
            </tr>
            <tr>
                <td colspan="2"><span style="color: red">${requestScope.message}</span></td>
            </tr>
        </table>
    </form>
</div>
</body>
</html>
