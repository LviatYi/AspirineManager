<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"%>
<%@taglib  uri="http://java.sun.com/jsp/jstl/core"  prefix="c"%>
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
		<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">医药管理--查看药品</div>
		<div id="contexttop">
		<table  class="table table-bordered table-hover" align="center" id="tab" border="1">
			<tr>
				<td colspan="10" height="50">


<%--					根据药品id查询--%>
					<form method="${MethodText.MEDICINE_SELECT}">
						<input type="text" title="药品ID" placeholder="药品ID" name="${RelationText.WEB_MEDICINE_ID}"/>
						<input type="submit"  class=" btn btn-info" value="查询"/>
					</form>
			</td>
		</tr>
		<tr bgcolor="#EOFBC4">
			<th name="${RelationText.WEB_MEDICINE_ID}">药品ID</th>
			<th name="${RelationText.WEB_MEDICINE_CODE}">药品编号</th>
			<th name="${RelationText.WEB_MEDICINE_NAME}">药品名称</th>
			<th name="${RelationText.WEB_MEDICINE_PRICE}">药品单价</th>
			<th name="${RelationText.WEB_MEDICINE_INVENTORY_COUNT}">库存数量</th>
			<th name="${RelationText.WEB_MEDICINE_PRODUCTION_DATE}">生产日期</th>
			<th name="${RelationText.WEB_MEDICINE_VENDOR_NAME}">厂商</th>
			<th name="${RelationText.WEB_MEDICINE_TYPE_ID}">所属类别</th>
			<th colspan="1">操作</th>
		</tr>
		<c:forEach items="${list}" var="item">
			<tr>

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