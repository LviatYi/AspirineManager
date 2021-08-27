<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"%>
<!DOCTYPE html>
<html>
	<head>
		<meta charset="utf-8">
		<title>编辑药品类别</title>
		<link rel="icon" href="../img/m1.jpg">
		<script type="text/javascript" src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"></script>
		<link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css" integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu" crossorigin="anonymous">

		<script src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js" integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd" crossorigin="anonymous"></script>

		<link rel="stylesheet" type="text/css" href="../css/query.css" />
	</head>
	<body style="background-color: #DAF3F5">
		<div class="container">
			<div class="row">
				<div id="top"style="background-color: #C0EBEF;text-align: center;font-size: large;">类别管理--添加类别</div>
			</div>
			<div class="row"style="height: 100px"></div>
			<div class="row">
<%--				MedicineType添加--%>
				<form class="form-horizontal" method="${MethodText.MEDICINE_TYPE_ADD}">
					<div class="form-group">
						<label for="typename" class="col-sm-3 control-label">类别名称</label>
						<div class="col-sm-7">
							<input type="text" class="form-control" id="typename" name="${RelationText.WEB_MEDICINE_TYPE_TYPE_NAME}" >
						</div>
					</div>
					<div class="form-group">
						<label for="describe" class="col-sm-3 control-label">药品名称</label>
						<div class="col-sm-7">
							<textarea type="text" class="form-control" id="describe"  name="${RelationText.WEB_MEDICINE_TYPE_DESCRIBE}" ></textarea>
						</div>
					</div>




				</form>
			</div>
			<div class="row">

				<div class="col-md-6"></div>
				<div class="col-md-6"><input class=" btn btn-info" id="Add_Drug"  type="submit" value="提交"/></div>

			</div>

		</div>
<script type="text/javascript">
	$("#submit_Category").click(function () {
		window.location.href="Category_selectByPage.html"
	})
</script>
	</body>
</html>
