<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%> <%@ page
		import="com.lviat.util.constant.text.RelationText"
		import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>药品类别管理</title>
	<link rel="icon" href="../img/m1.jpg">
	<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
	<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

	<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

	<link rel="stylesheet" type="text/css" href="../css/query.css" />
</head>
<body>
	<div id="top"style="background-color: #C0EBEF;text-align: center;font-size: large"> 系统管理 -- 查看用户</div>
	<div id="contexttop">
		<table id="tab" border="1" class="table table-bordered table-hover">
			<tr>
				<td colspan="8" height="50px">
<%--					用户ID查询--%>
					<form method="${MethodText.USER_SELECT}">
						<input type="text" title="用户ID" placeholder="用户ID" name="${RelationText.WEB_USER_ID}" />
						<input type="submit" value="查询" class="btn-info btn" />
					</form>
				</td>
			</tr>
			<tr bgcolor="#E0FBC4">
				<th style="text-align: center">用户ID</th>
				<th style="text-align: center">用户名</th>
				<th style="text-align: center">用户昵称</th>
				<th style="text-align: center">联系方式</th>
				<th style="text-align: center">用户类型</th>
				<th style="text-align: center" colspan=3>操作</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<td>${item.id}</td>
				<td>${item.username}</td>
				<td>${item.name}</td>
				<td>${item.phoneNum}</td>
				<c:if test="${item.role}==1"><td>管理员</td></c:if>
				<c:if test="${item.role}==2"><td>购买者</td></c:if>
				<td><a href="Manager_toUpdatePassword.jsp">重置密码</a></td>
			</c:forEach>
			<tr>
				<td>1001</td>
				<td>admin</td>
				<td>Admin</td>
				<td>12345678911</td>
				<td>管理员</td>
				<td><a href="">编辑</a></td>
				<td><a href="">重置密码</a></td>
				<td><a href="">删除</a></td>
			</tr>

			
		</table>
	</div>
	<div class="col-md-6" id="page_context">
	</div>
	<!--分页条信息 -->
	<div class="col-md-6" id="page_info">

	</div>

</body>
</html>