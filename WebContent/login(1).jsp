<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>物流配送中心管理系统-登录界面</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/global.css">
	<link rel="stylesheet" type="text/css" href="css/login.css">
</head>
<body>
<div class="head">
	<div class="nav">
	    <div class="nav-l">
		<p>西南快运</p>
		</div>
	    <div class="nav-m">
		<ul>
		    <li><a href="demo.html">首页</a></li>
			<li><a href="function.html">功能中心</a></li>
			<li><a href="aboutus.html">关于我们</a></li>
			<li><a href="aboutCompany.html">公司动态</a></li>
			<li><a href="#">咨询我们</a></li>
		</ul>
		</div>
	</div>
</div>
<div class="bodyLogin">
<!-- ${pageContext.request.contextPath } -->
      	<form class="login" action="${pageContext.request.contextPath }/login_submit.action" method="post" accept-charset="utf-8">
      	<h3 class="user_login">用户登录</h3>
      	<p class="text">西南快运账号登录</p>
      	<p class="user"><span>用户名:</span><input type="text" name="account" value="" placeholder=""></p>
      	<p class="user user_password"><span class="password">密 码:</span><input type="password" name="password" value="" placeholder=""></p>
      	<input class="user_submit" type="submit" name=""  value="登录">
     	</form>
  </div>

  <div class="foot">
	<div class="foot-nav">
	<ul class="foot-nav-inner">
	    <li><a href="demo.html">首页</a></li>
		<li>丨</li>
		<li><a href="function.html">功能中心</a></li>
		<li>丨</li>
		<li><a href="aboutus.html">关于我们</a></li>
		<li>丨</li>
		<li><a href="aboutCompany.html">公司动态</a></li>
		<li>丨</li>
		<li><a href="#">咨询我们</a></li>
	</ul>
	</div>
	<div class="foot-bottom">
	  <p><span class="zixun">客服支持 / 购买咨询：</span> <span class="tellphone">1359533909</span>版权所有·西南快运 粤ICP备17034677号-1 Copyright © 2018 msd1997.com All Rights Reserved</p>
	</div>
</div>
</body>
</html>