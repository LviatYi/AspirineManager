<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"%>
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
					<form>
						<input type="text" title="药品ID、药品编号、药品名称" placeholder="药品ID、药品编号、药品名称"/>
						<input type="submit"  class=" btn btn-info" value="查询" />
					</form>
			</td>
		</tr>
		<tr bgcolor="#EOFBC4">
			<th>药品ID</th>
			<th>药品编号</th>
			<th>药品名称</th>
			<th>药品单价</th>
			<th>库存数量</th>
			<th>生产日期</th>
			<th>厂商</th>
			<th>所属类别</th>
			<th colspan="1">操作</th>
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
		
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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
			<td><a href="Buy_toSale.html">立即购买</a></td>
			
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