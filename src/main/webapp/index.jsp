<%@ page language="java" contentType="text/html; charset=UTF-8"
pageEncoding="UTF-8" import="com.lviat.util.constant.text.RelationText"
import="com.lviat.util.constant.text.UrlText"%>
<!DOCTYPE html>
<html>
  <head>
    <meta charset="GB2312" />

    <title>Aspirine | Aspn 医药管理系统</title>
    <link rel="icon" href="img/m1.jpg" />
    <script
      type="text/javascript"
      src="https://cdn.staticfile.org/jquery/2.1.1/jquery.min.js"
    ></script>
    <link
      rel="stylesheet"
      href="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/css/bootstrap.min.css"
      integrity="sha384-HSMxcRTRxnN+Bdg0JdbxYKrThecOKuH5zCYotlSAcp1+c8xmyTe9GYg1l9a69psu"
      crossorigin="anonymous"
    />

    <script
      src="https://stackpath.bootstrapcdn.com/bootstrap/3.4.1/js/bootstrap.min.js"
      integrity="sha384-aJ21OjlMXNL5UyIl/XNwTMqvzeRMZH2w8c5cRVpzpU8Y5bApTppSuUkhZXN0VxHd"
      crossorigin="anonymous"
    ></script>

    <script src="js/menu.js" type="text/javascript" charset="utf-8"></script>
    <style type="text/css">
      .navbar-nav.dropdown-menu a:hover {
        background-color: #74d2d9;
      }
      .dropdown a:hover {
        background-color: #74d2d9;
      }
    </style>
  </head>
  <body background="img/1.jpg">
    <nav
      class="navbar navbar-default"
      role="navigation"
      style="background: lavenderblush"
    >
      <!--导航图-->
      <div class="container-fluid">
        <div class="navbar-header">
          <a
            class="navbar-brand"
            href="#"
            style="font-size: 25px; background: #74d2d9"
            >医药管理系统</a
          >
        </div>
        <div>
          <ul class="nav navbar-nav">
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                类别管理
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="category/Category_selectByPage.jsp" target="show"
                    >查看类别</a
                  >
                </li>
                <li class="divider"></li>
                <li>
                  <a href="category/Category_toAdd.jsp" target="show"
                    >添加类别</a
                  >
                </li>
              </ul>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                药品管理
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="drug/Drug_selectByPage.jsp" target="show"
                    >查看药品</a
                  >
                </li>
                <li class="divider"></li>
                <li>
                  <a href="drug/Drug_toAdd.jsp" target="show">添加药品</a>
                </li>
                <li class="divider"></li>
              </ul>
            </li>
            <li class="dropdown">
              <a
                href="buy/Buy_selectByPage.jsp"
                class="dropdown-toggle"
                data-toggle="dropdown"
              >
                购买药品
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="buy/Buy_selectByPage.jsp" target="show">查看药品</a>
                </li>
              </ul>
            </li>
            <li>
              <a href="sale/Sale_selectByPage.jsp" target="show">销售管理</a>
            </li>
            <li class="dropdown">
              <a href="#" class="dropdown-toggle" data-toggle="dropdown">
                系统管理
                <b class="caret"></b>
              </a>
              <ul class="dropdown-menu">
                <li>
                  <a href="manager/Manager_selectByPage.jsp" target="show"
                    >查看用户</a
                  >
                </li>
                <li class="divider"></li>
                <li>
                  <a href="manager/Manager_toAdd.jsp" target="show">添加用户</a>
                </li>
                <li class="divider"></li>
                <li>
                  <a href="manager/Manager_toUpdatePassword.jsp" target="show"
                    >添加密码</a
                  >
                </li>
              </ul>
            </li>
          </ul>
        </div>
      </div>
    </nav>
    <div
      style="
        position: absolute;
        bottom: 10px;
        right: 10px;
        font-size: 30px;
        color: goldenrod;
      "
    >
      <a href="./login_new.jsp ">
        <button type="button" class="btn btn-info">EXIT</button></a
      >
    </div>
  </body>
</html>
