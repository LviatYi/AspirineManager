<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%> <%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"
import="com.lviat.service.MedicineServiceImpl"
import="com.lviat.model.Medicine"
import="java.util.ArrayList"
import="java.util.List"
%>
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
	<%
        List<Medicine> medicineList = new ArrayList<>();
        (new MedicineServiceImpl()).getMedicine(medicineList,1);
    %>
		<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">  医药管理--查看药品</div>
		<div id="contexttop">
		<table class="table table-bordered table-hover"  align="center" id="tab" border="1">
			<tr>
				<td colspan="10" height="50">

                <%--Medicine药品查询--%>
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

        <%
            for (Medicine medicine : medicineList) {
        %>
        <tr>
            <td><%=medicine.getId()%></td>
            <td><%=medicine.getCode()%></td>
            <td><%=medicine.getName()%></td>
            <td><%=medicine.getPrice()%></td>
            <td><%=medicine.getInventoryCount()%></td>
            <td><%=medicine.getProductionDate()%></td>
            <td><%=medicine.getVendorName()%></td>
            <td><%=medicine.getTypeId()%></td>
            <td>
                <a href="${pageContext.request.contextPath}/${UrlText.DATA_MANAGER}.do?method=<%=MethodText.MEDICINE_MODIFY%>,<%=RelationText.WEB_MEDICINE_ID%>=<%=medicine.getId()%>&<%=RelationText.WEB_MEDICINE_CODE%>=<%=medicine.getCode()%>&<%=RelationText.WEB_MEDICINE_NAME%>=<%=medicine.getName()%>,&<%=RelationText.WEB_MEDICINE_PRICE%>=<%=medicine.getPrice()%>,&<%=RelationText.WEB_MEDICINE_PRICE%>=<%=medicine.getPrice()%>,&<%=RelationText.WEB_MEDICINE_INVENTORY_COUNT%>=<%=medicine.getInventoryCount()%>,&<%=RelationText.WEB_MEDICINE_PRODUCTION_DATE%>=<%=medicine.getProductionDate()%>,&<%=RelationText.WEB_MEDICINE_VENDOR_NAME%>=<%=medicine.getVendorName()%>,&<%=RelationText.WEB_MEDICINE_TYPE_ID%>=<%=medicine.getTypeId()%>">编辑</a>
            </td>
            <td>
                <a href="${pageContext.request.contextPath}/${UrlText.DATA_MANAGER}.do?method=<%=MethodText.MEDICINE_DEL%>,<%=RelationText.WEB_MEDICINE_ID%>=<%=medicine.getId()%>"
                   class="delete">删除</a></td>
        </tr>
        <%
            }
        %>

		</table>
		</div>
	<div class="container">
		<div class="row"></div>
		<div class="row"></div>
		<div class="row">
			<div class="col-md-5"></div>
			<div class="col-md-5">总页数：1页 <button class="btn" id="prePage">上一页</button>
				<button class="btn" id="btn1">1</button>
				<button class="btn" id="sufPage">下一页</button></div>
		</div>
	</div>
	<script type="text/javascript">
		$("#update").click(function () {
			window.location.href="../Category/Category_toAdd.jsp"
		})
	</script>
	</body>
</html>
