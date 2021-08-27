<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%> <%@ page
		import="com.lviat.util.constant.text.RelationText"
		import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>添加药品</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

	</head>
	<body>

	<div class="container">
		<div class="row" style="background-color: #C0EBEF;text-align: center;font-size: 25px;height: 50px">添加药品</div>
	</div>
	<div class="row"style="height: 80px"></div>
	<div class="row">

<%--		medicine插入--%>
		<form class="form-horizontal" method="${MethodText.MEDICINE_ADD}">
			<div class="form-group">
				<label for="code" class="col-sm-3 control-label">药品编号</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="code" name="${RelationText.WEB_MEDICINE_CODE}">
				</div>
			</div>
			<div class="form-group">
				<label for="name" class="col-sm-3 control-label" >药品名称</label>
				<div class="col-sm-7">
					<input type="text" class="form-control" id="name" name="${RelationText.WEB_MEDICINE_NAME}" >
				</div>
			</div>
			<div class="form-group">
				<label for="price" class="col-sm-3 control-label">药品单价</label>
				<div class="col-sm-7">
					<input type="number" class="form-control" id="price" name="${RelationText.WEB_MEDICINE_PRICE}">
				</div>
			</div>
			<div class="form-group">
				<label for="inventoryCount" class="col-sm-3 control-label"name="${RelationText.WEB_MEDICINE_INVENTORY_COUNT}">库存数量</label>
				<div class="col-sm-7">
					<input type="number" class="form-control" id="inventoryCount" >
				</div>
			</div>
			<div class="form-group">
				<label for="productionDate" class="col-sm-3 control-label">生产日期</label>
				<div class="col-sm-7">
					<input  type="Date" class="form-control" id="productionDate" name="${RelationText.WEB_MEDICINE_PRODUCTION_DATE}" >
				</div>
			</div>

			<div class="form-group">
				<label for="vendorName" class="col-sm-3 control-label">生产厂商</label>
				<div class="col-sm-7">
<%--					下拉框 火狐双击出现，chrome尾部有点击按钮--%>
					<input  type="text" class="form-control" id="vendorName" list="vendorNamelist"name="${RelationText.WEB_MEDICINE_VENDOR_NAME}" >
					<datalist id="vendorNamelist">
						<option>抗菌消炎类</option>
						<option>清热解毒类</option>
						<option>止咳平喘类</option>
						<option>胃肠道类</option>
						<option>维生素类</option>
						<option>心脑血管类</option>
						<option>五官外用类</option>
						<option>抗糖尿病类</option>
					</datalist>
				</div>
			</div>
		</form>

	</div>
<div class="row">
	<div class="col-md-6"></div>
	<div class="col-md-6"><input class=" btn btn-info" id="Add_Drug"  type="submit" value="提交"/></div>

</div>
	<script type="text/javascript">
		$("#Add_Drug").click(function () {
			alert("sdd")
			alert($("#productionDate").val());
		})
	</script>

	</body>
</html>
