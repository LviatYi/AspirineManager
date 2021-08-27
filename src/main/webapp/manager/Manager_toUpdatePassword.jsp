<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>修改密码</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="../css/query.css"/>
	</head>
	<body>
		<div class="container">
			<div class="row">
				<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">系统管理--修改密码</div>
			</div>
			<div class="row" style="height: 80px"></div>
			<div class="row" style="width: 10px;height: 20px"></div>
			<div class="row">
				<div class="row">


<%--					User password 修改--%>
					<form class="form-horizontal" method="${MethodText.USER_MODIFY}">
						<div class="form-group">
							<label for="username" class="col-sm-3 control-label">用户名</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="username" name="${RelationText.WEB_USER_USERNAME}" >
							</div>
						</div>
						<div class="form-group">
							<label for="password_old" class="col-sm-3 control-label">旧密码</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="password_old" name="${RelationText.WEB_USER_PASSWORD}" >
							</div>
						</div>
						<div class="form-group">
							<label for="password_new" class="col-sm-3 control-label">新密码</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="password_new"  name="${RelationText.WEB_USER_PASSWORD}">
							</div>
						</div>
						<div class="form-group">
							<label for="password_new1" class="col-sm-3 control-label">重复输入新密码</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="password_new1" name="${RelationText.WEB_USER_PASSWORD}">
							</div>
						</div>



					</form>

				</div>

			</div>
			<div class="col-md-6"></div>
			<div class="col-md-6"><input class=" btn btn-info" id="Add_Drug"  type="submit" value="提交"/></div>

		</div>


	</body>
</html>
<!--			<div class="row">-->
<!--				<form action="Manager_selectByPage.jsp">-->
<!--					<table id="tab" style="margin-top: 30px;">-->
<!--						<tr>-->
<!--							<td align="right" style="width:40%;">用户名:</td>-->
<!--							<td align="left"><input type="text" /></td>-->
<!--						</tr>-->
<!--						<tr>-->
<!--							<td align="right" style="width: 40%;">旧密码:</td>-->
<!--							<td align="left"><input type="text"/></td>-->
<!--						</tr>-->
<!--						<tr>-->
<!--							<td align="right" style="width: 40%;">新密码:</td>-->
<!--							<td align="left"><input type="text"/></td>-->
<!--						</tr>-->
<!--						<tr>-->
<!--							<td align="right" style="width: 40%;">重复输入新密码:</td>-->
<!--							<td align="left"><input type="text"/></td>-->
<!--						</tr>-->

<!--						<tr>-->

<!--							<td colspan="2"><input style="width: 60px;" type="submit"-->
<!--												   value="提交"/></td>-->

<!--						</tr>-->
<!--					</table>-->
<!--				</form>-->

<!--			</div>-->



