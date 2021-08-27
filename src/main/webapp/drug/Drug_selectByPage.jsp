<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"%>

<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>查看药品</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="../css/query.css"/>
	</head>
	<body>
		<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">  医药管理--查看药品</div>
		<div id="contexttop">
		<table class="table table-bordered table-hover"  align="center" id="tab" border="1">
			<tr>
				<td colspan="10" height="50">



<%--					Medicine药品查询--%>
					<form method="${MethodText.MEDICINE_SELECT}">
						<input type="text" title="药品ID" placeholder="药品ID" name="${RelationText.WEB_MEDICINE_ID}"/>
						<input type="submit" value="查询" class="btn btn-info" />
					</form>
			</td>
		</tr>
		<tr bgcolor="#EOFBC4">
			<th style="text-align: center">药品ID</th>
			<th style="text-align: center">药品编号</th>
			<th style="text-align: center">药品名称</th>
			<th style="text-align: center">药品单价</th>
			<th style="text-align: center">库存数量</th>
			<th style="text-align: center">生产日期</th>
			<th style="text-align: center">厂商</th>
			<th style="text-align: center">所属类别</th>
			<th style="text-align: center" colspan="2">操作</th>
		</tr>
		<tr>
			<td>D1001</td>
			<td>H10950030</td>
			<td>板蓝根冲剂</td>
			<td>20</td>
			<td>10000</td>
			<td>2017-01-01</td>
			<td>上海制药厂</td>
			<td>清热解毒类</td>
			<td><button id="update" type="button" class="btn btn-info">
				编辑</button></td>
			<td><button id="delete" type="button" class="btn btn-danger">
				删除</button></td>
		</tr>
		<tr>
			<td>D1001</td>
			<td>H10950030</td>
			<td>板蓝根冲剂</td>
			<td>20</td>
			<td>10000</td>
			<td>2017-01-01</td>
			<td>上海制药厂</td>
			<td>清热解毒类</td>
			<td><a href=" ../Category_toAdd.jsp">编辑</a></td>
			<td><a href="#">删除</a></td>
		</tr>

		</table>
		</div>
		<div class="col-md-6" id="page_context">
		</div>
		<!--分页条信息 -->
		<div class="col-md-6" id="page_info">

		</div>
	<script type="text/javascript">
		$("#update").click(function () {
			window.location.href="../Category/Category_toAdd.jsp"
		})
	</script>
	</body>
</html>
