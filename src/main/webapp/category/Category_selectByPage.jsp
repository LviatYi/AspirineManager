<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>药品类别管理</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="../css/query.css" />
	</head>
	<body style="background-color: #DAF3F5">
		<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">类别管理--查看类别</div>
		<div id="contexttop">
		    <table class="table table-bordered table-hover" id="tab" border="1">
				<thead><tr>
					<td colspan="6" height="50">
<%--						MEdicineType类别查询--%>
						<form method="${MethodText.MEDICINE_TYPE_SELECT}">
							<input id="search_Category" type="text" title="类别ID" placeholder="输入类别ID" name="${RelationText.WEB_MEDICINE_TYPE_TYPE_ID}" /> <input
							  class="btn btn-info" type="submit" value="查询"/>
						</form>
					</td>
				</tr>

				</thead>
				<tbody>
				<tr bgcolor="yellow" >
					<th style="text-align: center" >类别ID</th>
					<th style="text-align: center">类别名称</th>
					<th style="text-align: center">创建时间</th>
					<th style="text-align: center">描述</th>
					<th style="text-align: center" colspan="2">操作</th>
				</tr>
				<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.typeId}</td>
					<td>${item.typeName}</td>
					<td>${item.createDate}</td>
					<td>${item.describe}</td>
					<td><button id="update" type="button" class="btn btn-info">
						编辑</button></td>
					<td><button id="delete" type="button" class="btn btn-danger">
						删除</button></td>
				</tr>
				</c:forEach>
				<tr>
					<td>c1002</td>
					<td>抗菌消炎类</td>
					<td>2017-01-01</td>
					<td>可以抗菌消炎</td>
					<td><a href="Category_toAdd.jsp">编辑</a></td>
					<td><a href="">删除</a></td>
				</tr>
				<tr>
					<td>c1003</td>
					<td>抗菌消炎类</td>
					<td>2017-01-01</td>
					<td>可以抗菌消炎</td>
					<td><a href="Category_toAdd.jsp">编辑</a></td>
					<td><a href="">删除</a></td>
				</tr>
				</tbody>
			</table>
			</div>
		<div class="col-md-6" id="page_context">
		</div>
<!--分页条信息 -->
		<div class="col-md-6" id="page_info">

		</div>
	<script type="text/javascript">

	</script>
	</body>
</html>
