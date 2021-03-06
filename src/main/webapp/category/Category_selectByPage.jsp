<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"%>
<%@ page
import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.MethodText"
import="com.lviat.service.MedicineTypeServiceImpl"
import="com.lviat.model.MedicineType"
import="java.util.ArrayList"
import="java.util.List"
%>
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
	<%
		List<MedicineType> medicineList = new ArrayList<>();
		(new MedicineTypeServiceImpl()).getMedicineType(medicineList,1);
	%>
		<div id="top" style="background-color: #C0EBEF;text-align: center;font-size: large">类别管理--查看类别</div>
		<div id="contexttop">
		    <table class="table table-bordered table-hover" id="tab" border="1">
				<thead><tr>
					<td colspan="6" height="50">
<%--						medicineType类别查询--%>
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

				<%
                    for (MedicineType medicineType : medicineList) {
                %>
                <tr>
                    <td><%=medicineType.getTypeId()%></td>
                    <td><%=medicineType.getTypeName()%></td>
                    <td><%=medicineType.getCreateDate()%></td>
                    <td><%=medicineType.getDescribe()%></td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${UrlText.DATA_MANAGER}.do?method=<%=MethodText.MEDICINE_TYPE_MODIFY%>&<%=RelationText.WEB_MEDICINE_TYPE_ID%>=<%=medicineType.getTypeId()%>
                        &<%=RelationText.WEB_MEDICINE_TYPE_ID%>=<%=medicineType.getTypeId()%>
                        &<%=RelationText.WEB_MEDICINE_NAME%>=<%=medicineType.getTypeName()%>
                        &<%=RelationText.WEB_MEDICINE_TYPE_CREATE_DATE%>=<%=medicineType.getCreateDate()%>
                        &<%=RelationText.WEB_MEDICINE_TYPE_DESCRIBE%>=<%=medicineType.getDescribe()%>">编辑</a>
                    </td>
                    <td>
                        <a href="${pageContext.request.contextPath}/${UrlText.DATA_MANAGER}.do?method=<%=MethodText.MEDICINE_TYPE_DEL%>&<%=RelationText.WEB_MEDICINE_TYPE_ID%>=<%=medicineType.getTypeId()%>"
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

		</div>

	</body>
</html>
