<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>物流配送中心管理系统-注册界面</title>
	<link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/global.css" />
	<link rel="stylesheet" type="text/css" href="css/register.css" />
	<script language="javascript" type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script type="text/javascript">
       $(function(){
       	var pageWidth=$(window).width();
       	var inputWidth=$('.model_input').width();
       	$('.user select').width(inputWidth);
       	$('.bodyLogin').width(pageWidth);
       	$(window).resize(function(){
       		var pageWidth=$(window).width();
       	    $('.bodyLogin').width(pageWidth);
       	})
       })
	</script>
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
      	<form class="login" id="registerCustomer"  method="post" accept-charset="utf-8">
      	<h3 class="user_login">用户注册</h3>
      	<p class="text">西南快运账号注册</p>
      	<p class="user"><span>用户名:</span><input type="text" name="cust_name" value="" placeholder="" /></p>
      	<p class="user"><span>账&nbsp;号:</span><input type="text" name="account" value="" placeholder="首字母不能为'g'或'G'" /></p>
      	<p class="user user_password"><span class="password">密 码:</span><input class="model_input" type="password" name="password" value="" placeholder="" /></p>
      	<p class="user"><span>手机号:</span><input type="text" name="cust_mobile" value="" placeholder="" /></p>
      	<p class="user"><span>类&nbsp;型:</span>
      		<select class="cust_type" name="cust_type">
      			<option>普通用户</option>
      			<option>企业用户</option>
      		</select>
      	</p>
      	<p class="user"><span>企业名:</span>
      		<select class="cust_type" name="cust_company">
      			<option value="">无</option>
      			<option>申通物流公司</option>
      			<option>顺丰物流公司</option>
      			<option>圆通物流公司</option>
      			<option>天天物流公司</option>
      		</select>
      	</p>
      	<p class="user"><span>地&nbsp;址:</span><input type="text" name="cust_address" value="" placeholder="" /></p>
      	<input class="register_input" type="button" onclick="registerCustomer()" value="注册" />
     	</form>
  </div>



  <div>
  <div class="body-foot">
	</div>	
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
<script type="text/javascript">
function registerCustomer(){
	   $.post("<%=basePath%>registerCustomer.action",$("#registerCustomer").serialize(),
		function(data){
		   if(data.cust_name==""){
			   alert("账号首字母不能为'g'或'G'");
		   }else if(data.cust_name=="erro"){
			     alert("普通用户不能存在物流企业单位");
		   }else{
		   alert("用户注册成功！");
		   window.location.reload();
		   }
	   });
}
</script>
</body>
</html>