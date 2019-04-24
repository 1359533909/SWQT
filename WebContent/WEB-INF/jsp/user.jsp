<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt"  prefix="fmt"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<title>物流配送中心管理系统-用户中心</title>
    <link rel="shortcut icon" href="favicon.ico" />
	<link rel="stylesheet" type="text/css" href="css/global.css" />
	<link rel="stylesheet" type="text/css" href="css/user.css" />
	<link rel="stylesheet" type="text/css" href="css/lun_bo_img.css" />
	<script language="javascript" type="text/javascript" src="js/jquery-1.7.2.min.js"></script>
	<script language="javascript" type="text/javascript" src="js/lun_bo_img.js"></script>
	<script type="text/javascript">
	$(function(){
		$('.body-inner-frame li').click(function(){
			$(this).addClass('current').siblings().removeClass('current');
			var index=$(this).index();
			$('.body-inner div').eq(index).addClass('current').siblings().removeClass('current');
		})
		var pageWidth=$(window).width();
		$('.lun_bo_img').width(pageWidth);
		$('.lun_bo_img').height(pageWidth*0.3);
		$(window).resize(function(){
			var pageWidth=$(window).width();
			$('.lun_bo_img').width(pageWidth);
		    $('.lun_bo_img').height(pageWidth*0.3);
		})
	})
	function registerCommodity(id){
		if(confirm('确实收货吗?')){
		$.post("<%=basePath%>registerCommodity.action",{"id":id},function(){
			alert("收货成功！");
			window.location.reload();
		})
	}
	}
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
	    <div class="nav-r">
		<ul>
		 <li>欢迎</li>
		 <li>丨</li>
		 <li>${customer.cust_name}</li>
		</ul>
		</div>
	</div>
	<div>
</div>
</div>


<!-- 轮播图 -->
<div id="banner_lun_bo_img_box">
	 <a href="javascript:;" id="banner_lun_bo_a">
	 		<img class="lun_bo_img" src="images/logisticsUser/banner_1.png" id="banner_lun_bo_img"/>
	 </a>
	<h1 id="banner_lun_bo_img_desc"></h1>
	<div style="position:absolute; right: 5px; bottom:0px;color:#FFF;">
		<ul class="banner_lun_bo_img_ul">
			<li>
				<a href="javascript:;" id="banner_lun_bo_a_1" onclick="setLunBoImage(0)">1</a>
			</li>
			<li id="banner_lun_bo_li_2">
				<a href="javascript:;" id="banner_lun_bo_a_2" onclick="setLunBoImage(1)">2</a>
			</li>
			<li id="banner_lun_bo_li_3">
				<a href="javascript:;" id="banner_lun_bo_a_3" onclick="setLunBoImage(2)">3</a>
			</li>
		</ul>
	</div>
</div>




<div class="body-order">
	<p class="body-order-text">我的订单</p>	
</div>

<div class="body-inner">
	<ul class="body-inner-frame">
		<li class="current">
		<img src="images/user/01.png" alt="图片" />
		</li>
		<li>
		<img src="images/user/02.png" alt="">
		</li>
		<li><img src="images/user/03.png" alt=""></li>
	</ul>
	
<!-- 个人信息 -->
<div class="current">
	<h1>个人信息</h1>
	     <span class="person_message">
	     <p>用户名:${customer.cust_name}</p>
	     <p>账&nbsp;号:${customer.account}</p>
	     <p>手机号:${customer.cust_mobile}</p>
	     <p>地&nbsp;址:${customer.cust_address}</p>
	     </span>
</div>
<!-- 商品信息 -->
<div>
	   <h1>商品信息</h1>
<table  border=1>
<tr>
    <td>商品编号</td>
	<td>商品名称</td>
	<td>收件人</td>
	<td>收件地址</td>
	<td>商品供货商</td>
	<td>商品细节</td>
	<td>操作</td>
</tr>
<c:forEach items="${commodities}" var="commodity">
<tr>
    <td>${commodity.commodity_id}</td>
	<td>${commodity.commodity_name}</td>
	<td>${commodity.commodity_price}</td>
	<td>${commodity.address }</td>
	<td>${commodity.supplier }</td>
	<td>${commodity.acceptance }</td>
	<td><input  type="button" onclick="registerCommodity(${commodity.commodity_id})" value="确定收货" /></td>
	<!-- <td><a href="${pageContext.request.contextPath }/commodityAcceptance.action?id=${commodity.commodity_id}">确定收货</a></td> -->
</tr>
</c:forEach>

</table>
</div>

<!-- 物流信息 -->
<div>
<h1>物流信息</h1>
<table width="100%" border=1>
<tr>
	<td>商品编号</td>
	<td>商品名称</td>
	<td>商品价格</td>
	<td>快件物流</td>
	<td>派件公司</td>
</tr>
<c:forEach items="${Logistics}" var="Logistics">
<tr>
	<td>${Logistics.commodity_id}</td>
	<td>${Logistics.commodity_name}</td>
	<td>${Logistics.commodity_price}</td>
	<td>${Logistics.logistics_massage}</td>
	<td>${Logistics.company_name}</td>
</tr>
</c:forEach>

</table>
</div>
</div>

</body>
</html>