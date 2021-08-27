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
	<div id="top"style="background-color: #C0EBEF;text-align: center;font-size: large"> 销售管理 -- 查看明细</div>
	<div id="contexttop">
		<table class="table table-bordered table-hover" id="tab" border="1">
			<tr>
				<td colspan="6" height="50px">
<%--					SaleInfo 查询--%>
					<form method="${MethodText.SALES_INFO_SELECT}">
						<input type="text" title="销售记录编号" placeholder="销售记录编号ID" name="${RelationText.WEB_SALES_INFO_ID}" />
						<input type="submit" value="查询" class="btn btn-info" />
					</form>
				</td>
			</tr>
			<tr bgcolor="#E0FBC4">
				<th style="text-align: center">销售记录编号</th>
				<th style="text-align: center">销售日期</th>
				<th style="text-align: center">药品编号</th>
				<th style="text-align: center">销售数量</th>
				<th style="text-align: center">销售价格</th>
				<th style="text-align: center">购买人ID</th>
			</tr>
			<c:forEach items="${list}" var="item">
				<tr>
					<td>${item.id}</td>
					<td>${item.salesDate}</td>
					<td>${item.medicineId}</td>
					<td>${item.salesCount}</td>
					<td>${item.payment}</td>
					<td>${item.consumerId}</td>
				</tr>
			</c:forEach>

		</table>
	</div>
	<div class="col-md-6" id="page_context">
	</div>
	<!--分页条信息 -->
	<div class="col-md-6" id="page_info">

	</div>

</body>
</html>