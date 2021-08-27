<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%> <%@ page
		import="com.lviat.util.constant.text.RelationText"
		import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>添加用户</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="../css/query.css"/>
	</head>
	<body>
		
		<div id="top"style="background-color: #C0EBEF;text-align: center;font-size: large">系统管理--添加用户</div>


<%--		User添加--%>
		<form action="Manager_selectByPage.jsp" method="${MethodText.USER_ADD}">
			<table id="tab"class="table table-bordered table-hover" style="margin-top: 30px;">
				<tr>
					<td align="right" style="width:40%;">用户名:</td>
					<td align="left"><input type="text" name="${RelationText.WEB_USER_USERNAME}" /></td>
				</tr>
				<tr>
					<td align="right" style="width: 40%;">密码:</td>
					<td align="left"><input type="text"name="${RelationText.WEB_USER_PASSWORD}"/></td>
				</tr>
				<tr>
					<td align="right" style="width: 40%;">重复输入密码:</td>
					<td align="left"><input type="text" name="${RelationText.WEB_USER_PASSWORD}"/></td>
				</tr>
				<tr>
					<td align="right" style="width: 40%;">用户昵称:</td>
					<td align="left"><input type="text" name="${RelationText.WEB_USER_NAME}"/></td>
				</tr>
				<tr>
					<td align="right" style="width:40%; ">联系方式:</td>
					<td align="left"><input type="text" name="${RelationText.WEB_USER_PHONE_NUM}"/></td>
				</tr>
				<tr>
					<td align="right" style="width: 40%;">用户类型：</td>
					<td align="left">
						&nbsp;&nbsp;&nbsp;&nbsp;普通用户：
						<input type="radio" checked="checked" name="${WEB_USER_ROLE}"/>
						&nbsp;&nbsp;&nbsp;&nbsp;管理员：
						<input type="radio" name="${WEB_USER_ROLE}"/>
					</td>
				</tr>
	            <tr>
					
					<td colspan="2" ><a href="Manager_selectByPage.jsp" class="btn btn-primary btn-sm active" role="button">提交</a></td>

				</tr>
			</table>
		</form>

	</body>
</html>

