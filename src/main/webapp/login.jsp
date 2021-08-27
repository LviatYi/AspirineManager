<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8"
 import="com.lviat.util.constant.text.RelationText"
 import="com.lviat.util.constant.text.UrlText"%>
<!doctype html>
<html lang="zh-CN">
<head>
	<meta http-equiv="X-UA-Compatible" content="IE=edge">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<!-- The above 3 meta tags *must* come first in the head; any other head content must come *after* these tags -->
	<meta name="description" content="">
	<meta name="author" content="">
	<link rel="icon" href="img/m1.jpg">
	<link rel="canonical" href="https://getbootstrap.com/docs/3.4/examples/signin/">

	<title>医药管理系统登陆</title>

	<!-- Bootstrap core CSS -->
	<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/dist/css/bootstrap.min.css" rel="stylesheet">

	<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
	<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/css/ie10-viewport-bug-workaround.css" rel="stylesheet">

	<!-- Custom styles for this template -->
	<link href="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/examples/signin/signin.css" rel="stylesheet">

	<!-- Just for debugging purposes. Don't actually copy these 2 lines! -->
	<!--[if lt IE 9]><script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/js/ie8-responsive-file-warning.js"></script><![endif]-->
	<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/js/ie-emulation-modes-warning.js"></script>

	<!-- HTML5 shim and Respond.js for IE8 support of HTML5 elements and media queries -->
	<!--[if lt IE 9]>
	<script src="https://oss.maxcdn.com/html5shiv/3.7.3/html5shiv.min.js"></script>
	<script src="https://oss.maxcdn.com/respond/1.4.2/respond.min.js"></script>
	<![endif]-->
</head>

<body background="./img/12.jpg">

<div class="container" >

	<form class="form-signin" action="${UrlText.LOGIN}.do" method="post">
		<h2 class="form-signin-heading" style="text-align: center">登陆</h2>
		<label for="inputEmail" class="sr-only"></label>用户名：
		<input type="text" id="inputEmail" class="form-control" placeholder="name"  name="${RelationText.WEB_USER_ID}" required autofocus>
		<label for="inputPassword" class="sr-only"></label>密码:
		<input type="password" id="inputPassword" class="form-control" placeholder="Password"name="${RelationText.WEB_USER_PASSWORD}" required>

		<button class="btn btn-lg btn-primary btn-block" type="submit">Log</button>
	</form>

</div>


<!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
<script src="https://cdn.jsdelivr.net/npm/@bootcss/v3.bootcss.com@1.0.13/assets/js/ie10-viewport-bug-workaround.js"></script>
</body>
</html>
