<%@ page language="java" contentType="text/html; charset=UTF-8"
		 pageEncoding="UTF-8"%> <%@ page
		import="com.lviat.util.constant.text.RelationText"
		import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>购买药品</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

	</head>
	<link rel="stylesheet" type="text/css" href="../css/query.css" />
	<body>
	<div class="container">
		<div class="row" style="background-color: #C0EBEF;text-align: center;font-size: large">添加药品</div>

		<div class="row">

			<div class="row">
				<div class="row">


<%--					SaleInfo销售记录添加--%>
					<form class="form-horizontal" method="${MethodText.SALES_INFO_ADD}">
						<div class="form-group">
							<label for="code" class="col-sm-3 control-label" >药品编码</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="code" name="${RelationText.WEB_MEDICINE_CODE}" >
							</div>
						</div>
						<div class="form-group">
							<label for="name" class="col-sm-3 control-label">药品名称</label>
							<div class="col-sm-7">
								<input type="text" class="form-control" id="name"name="${RelationText.WEB_MEDICINE_NAME}" >
							</div>
						</div>
						<div class="form-group">
							<label for="price" class="col-sm-3 control-label">药品单价</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" id="price"name="${RelationText.WEB_MEDICINE_PRICE}" >
							</div>
						</div>
						<div class="form-group">
							<label for="inventoryCount" class="col-sm-3 control-label">库存数量</label>
							<div class="col-sm-7">
								<input type="number" class="form-control" id="inventoryCount" name="${RelationText.WEB_MEDICINE_INVENTORY_COUNT}" >
							</div>
						</div>
						<div class="form-group">
							<label for="productionDate" class="col-sm-3 control-label">生产日期</label>
							<div class="col-sm-7">
								<input  type="Date" class="form-control" id="productionDate" name="${RelationText.WEB_MEDICINE_PRODUCTION_DATE}" >
							</div>
						</div>

						<div class="form-group">
							<label for="vendorName" class="col-sm-3 control-label">厂商名称</label>
							<div class="col-sm-7">
								<input  type="text" class="form-control" id="vendorName" list="vendorNamelist" name="${RelationText.WEB_MEDICINE_VENDOR_NAME}" >
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
						<div class="form-group">
							<label for="productionDate" class="col-sm-3 control-label">购买数量</label>
							<div class="col-sm-7">
								<input  type="number" class="form-control" id="salesCount" name="${RelationText.WEB_SALES_INFO_SALES_COUNT}" >
							</div>
						</div>
					</form>

				</div>
			</div>
			<div class="col-md-6"></div>
			<div class="col-md-6"><input class=" btn btn-info" id="Add_Drug"  type="submit" value="立即购买"/></div>

		</div>
	</div>
	</body>
</html>
<!--		<div id="top">当前位置：购买药品&#45;&#45;选购药品</div>-->
<!--		<form action="Buy_selectByPage.jsp">-->
<!--			<table id="tab">-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">药品编号：</td>-->
<!--					<td align="left"><input type="text" value="H10950030" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">药品名称：</td>-->
<!--					<td align="left"><input type="text" value="板蓝根冲剂" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">药品单价：</td>-->
<!--					<td align="left"><input type="text" value="20" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">库存数量：</td>-->
<!--					<td align="left"><input type="text" value="10000" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">生产日期：</td>-->
<!--					<td align="left"><input type="text" value="2017-01-01" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">厂商：</td>-->
<!--					<td align="left"><input type="text" value="上海制药厂" readonly="readonly"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 45%;">所属类别：</td>-->
<!--					<td align="left"><select>-->
<!--						<option value="请选择相应药品类别">请选择相应药品类别</option>-->
<!--						<option value="抗菌消炎类">抗菌消炎类</option>-->
<!--						<option value="清热解毒类">清热解毒类</option>-->
<!--						<option value="止咳平喘类">止咳平喘类</option>-->
<!--						<option value="胃肠道类">胃肠道类</option>-->
<!--						<option value="维生素类">维生素类</option>-->
<!--						<option value="心脑血管类">心脑血管类</option>-->
<!--						<option value="五官外用类">五官外用类</option>-->
<!--						<option value="抗糖尿病类">抗糖尿病类</option>-->
<!--					</select>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td align="right" style="width: 40%;">购买数量：</td>-->
<!--					<td align="left"><input type="text" style="width: 168px;"/></td>-->
<!--				</tr>-->
<!--				<tr>-->
<!--					<td colspan="2"><input type="submit"-->
<!--						value="立即购买" /></td>-->
<!--				</tr>-->
<!--			</table>-->
<!--		</form>-->
