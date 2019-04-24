<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page trimDirectiveWhitespaces="true"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ taglib prefix="itcast" uri="http://itcast.cn/common/"%>
<%
	String path = request.getContextPath();
	String basePath = request.getScheme() + "://" + request.getServerName() + ":" + request.getServerPort()
			+ path + "/";
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">

<title>物流列表-${cust_company}</title>

<!-- Bootstrap Core CSS -->
<link href="<%=basePath%>css/bootstrap.min.css" rel="stylesheet">

<!-- MetisMenu CSS -->
<link href="<%=basePath%>css/metisMenu.min.css" rel="stylesheet">

<!-- DataTables CSS -->
<link href="<%=basePath%>css/dataTables.bootstrap.css" rel="stylesheet">

<!-- Custom CSS -->
<link href="<%=basePath%>css/sb-admin-2.css" rel="stylesheet">

<!-- Custom Fonts -->
<link href="<%=basePath%>css/font-awesome.min.css" rel="stylesheet"
	type="text/css">
<link href="<%=basePath%>css/boot-crm.css" rel="stylesheet"
	type="text/css">

<!-- HTML5 Shim and Respond.js IE8 support of HTML5 elements and media queries -->
<!-- WARNING: Respond.js doesn't work if you view the page via file:// -->
<!--[if lt IE 9]>
        <script src="https://oss.maxcdn.com/libs/html5shiv/3.7.0/html5shiv.js"></script>
        <script src="https://oss.maxcdn.com/libs/respond.js/1.4.2/respond.min.js"></script>
    <![endif]-->

</head>

<body>

	<div id="wrapper">

		<!-- Navigation -->
		<nav class="navbar navbar-default navbar-static-top" role="navigation"
			style="margin-bottom: 0">
		<div class="navbar-header">
			<button type="button" class="navbar-toggle" data-toggle="collapse"
				data-target=".navbar-collapse">
				<span class="sr-only">Toggle navigation</span> <span
					class="icon-bar"></span> <span class="icon-bar"></span> <span
					class="icon-bar"></span>
			</button>
			<a class="navbar-brand" href="index.html">西南快运物流管理系统</a>
		</div>
		<!-- /.navbar-header -->

		<ul class="nav navbar-top-links navbar-right">
			<li class="dropdown">
			<!-- /.dropdown -->
			<li class="dropdown"><a class="dropdown-toggle"
				data-toggle="dropdown" href="#"> <i class="fa fa-user fa-fw"></i>
					<i class="fa fa-caret-down"></i>
			</a>
				<ul class="dropdown-menu dropdown-user">
					<li><a href="<%=basePath%>login.jsp"><i class="fa fa-sign-out fa-fw"></i>
							退出登录</a></li>
				</ul> <!-- /.dropdown-user --></li>
			<!-- /.dropdown -->
		</ul>
		<!-- /.navbar-top-links -->

		<div class="navbar-default sidebar" role="navigation">
			<div class="sidebar-nav navbar-collapse">
				<ul class="nav" id="side-menu">
					<li class="sidebar-search">
						<div class="input-group custom-search-form">
						</div> <!-- /input-group -->
					</li>
					<li><a href="#" class="active"><i
							class="fa fa-edit fa-fw"></i> 物流管理</a></li>
					<li><a 
					<c:if test="${companyId==null}">href="#"</c:if>
					<c:if test="${companyId==0}">href="<%=basePath%>logistics/carList.action?company_id=0"</c:if>
					<c:if test="${companyId==1}">href="<%=basePath%>logistics/carList.action?company_id=1"</c:if>
					<c:if test="${companyId==2}">href="<%=basePath%>logistics/carList.action?company_id=2"</c:if>
					<c:if test="${companyId==3}">href="<%=basePath%>logistics/carList.action?company_id=3"</c:if>
					 class="active"><i
							class="fa fa-edit fa-fw"></i>车辆管理</a></li>
				</ul>
			</div>
			<!-- /.sidebar-collapse -->
		</div>
		<!-- /.navbar-static-side --> </nav>

		<div id="page-wrapper">
			<div class="row">
				<div class="col-lg-12">
					<h1 class="page-header">物流管理</h1>
				</div>
				<!-- /.col-lg-12 -->
			</div>
			<!-- /.row -->
			<div class="panel panel-default">
				<div class="panel-body">
					<form class="form-inline" action="${pageContext.request.contextPath }/logistics/list.action" method="post">
						<div class="form-group">
							<label for="customerName">客户名称</label> 
							<input type="text" class="form-control" id="customerName" value="${custName}" name="custName">
						</div>
						<div class="form-group">
							<label for="customerFrom">商品编号</label> 
							<input type="text" class="form-control" id="customerName" value="${commodity_id}"  name="commodity_id">
						</div>
						<div class="form-group">
							<label for="custIndustry">验收类型</label> 
							<select	class="form-control" id="custIndustry" name="acceptance">
								<option value=''>--请选择--</option>
							    <option  <c:if test="${wys}">selected</c:if>>未验收</option>
							    <option  <c:if test="${yys}">selected</c:if>>已验收</option>
							</select>
						</div>
						<div class="form-group">
							<label for="custLevel">物流公司</label>
							<select	class="form-control" id="custLevel" name="cust_company">
									<option value="${cust_company}">${cust_company}</option>
							</select>
						</div>
						<button type="submit" class="btn btn-primary">查询</button>
					</form>
				</div>
			</div>
			<div class="row">
				<div class="col-lg-12">
					<div class="panel panel-default">
						<div class="panel-heading">客户信息列表</div>
						<!-- /.panel-heading -->
						<table class="table table-bordered table-striped">
							<thead>
								<tr>
									<th>客户名称</th>
									<th>商品编号</th>
									<th>商品名称</th>
									<th>收货地址</th>
									<th>发货地址</th>
									<th>物流信息</th>
									<th>验收信息</th>
									<th>操作</th>
								</tr>
							</thead>
							<tbody>
								<c:forEach items="${page.rows}" var="row">
									<tr>
										<td>${row.username}</td>
										<td>${row.commodity_id}</td>
										<td>${row.commodity_name}</td>
										<td>${row.logistics_address}</td>
										<td>${row.supplier}</td>
										<td>${row.logistics_massage}</td>
										<td>${row.acceptance}</td>
										<td>
											<a href="#" class="btn btn-primary btn-xs" data-toggle="modal" data-target="#customerEditDialog" onclick="editCustomer(${row.id})">修改</a>
											<a href="#" class="btn btn-danger btn-xs" onclick="deleteCustomer(${row.id})">删除</a>
										</td>
									</tr>
								</c:forEach>
							</tbody>
						</table>
						<!-- /.panel-body -->
					</div>
					<!-- /.panel -->
				</div>
				<!-- /.col-lg-12 -->
			</div>
		</div>
		<!-- /#page-wrapper -->

	</div>
	<!-- 客户编辑对话框 -->
	<div class="modal fade" id="customerEditDialog" tabindex="-1" role="dialog"
		aria-labelledby="myModalLabel">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header">
					<button type="button" class="close" data-dismiss="modal" aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
					<h4 class="modal-title" id="myModalLabel">修改客户信息</h4>
				</div>
				<div class="modal-body">
					<form class="form-horizontal" id="edit_customer_form">
						<input type="hidden"  id="edit_cust_id" name="id"  />
						<div class="form-group">
							<label for="edit_customerName" class="col-sm-2 control-label">客户名称</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_username" placeholder="客户名称" name="username">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_customerFrom" style="float:left;padding:7px 15px 0 27px;">商品编号</label> 
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_commodity_id" placeholder="商品编号" name=commodity_id>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_custIndustry" style="float:left;padding:7px 15px 0 27px;">商品名称</label>
							<div class="col-sm-10"> 
								<input type="text" class="form-control" id="edit_commodity_name" placeholder="商品名称" name=commodity_name>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_custLevel" style="float:left;padding:7px 15px 0 27px;">收货地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_logistics_address" placeholder="收货地址" name=logistics_address>
							</div>
						</div>
						<div class="form-group">
							<label for="edit_linkMan" class="col-sm-2 control-label">发货地址</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_supplier"  name="supplier">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_phone" class="col-sm-2 control-label">物流信息</label>
							<div class="col-sm-10">
								<input type="text" class="form-control" id="edit_logistics_massage"  name="logistics_massage">
							</div>
						</div>
						<div class="form-group">
							<label for="edit_mobile" class="col-sm-2 control-label">验收信息</label>
							<div class="col-sm-10">
							<select	class="form-control"  name="acceptance">
							<option id="edit_acceptance"></option>
							</select>
							</div>
						</div>
					</form>
				</div>
				<div class="modal-footer">
					<button type="button" class="btn btn-default" data-dismiss="modal">关闭</button>
					<button type="button" class="btn btn-primary" onclick="updateCustomer()">保存修改</button>
				</div>
			</div>
		</div>
	</div>
	<!-- /#wrapper -->

	<!-- jQuery -->
	<script src="<%=basePath%>js/jquery.min.js"></script>

	<!-- Bootstrap Core JavaScript -->
	<script src="<%=basePath%>js/bootstrap.min.js"></script>

	<!-- Metis Menu Plugin JavaScript -->
	<script src="<%=basePath%>js/metisMenu.min.js"></script>

	<!-- DataTables JavaScript -->
	<script src="<%=basePath%>js/jquery.dataTables.min.js"></script>
	<script src="<%=basePath%>js/dataTables.bootstrap.min.js"></script>

	<!-- Custom Theme JavaScript -->
	<script src="<%=basePath%>js/sb-admin-2.js"></script>
	
	<script type="text/javascript">
		function editCustomer(id) {
			$.ajax({
				type:"get",
				url:"<%=basePath%>logistics/detail.action",
				data:{"id":id},
				success:function(data) {
					$("#edit_cust_id").val(data.id);
					$("#edit_username").val(data.username);
					$("#edit_commodity_id").val(data.commodity_id);
					$("#edit_commodity_name").val(data.commodity_name)
					$("#edit_logistics_address").val(data.logistics_address)
					$("#edit_supplier").val(data.supplier)
					$("#edit_logistics_massage").val(data.logistics_massage);
					$("#edit_acceptance").html(data.acceptance);
					<!--$("#edit_acceptance").val(data.acceptance);-->
				}
			});
		}
		function updateCustomer() {
			$.post("<%=basePath%>logistics/update.action",$("#edit_customer_form").serialize(),function(data){
				alert("客户信息更新成功！");
				window.location.reload();
			});
		}
		
		function deleteCustomer(id) {
			if(confirm('确实要删除该客户吗?')) {
				$.post("<%=basePath%>logistics/delete.action",{"id":id},function(data){
					alert("客户删除更新成功！");
					window.location.reload();
				});
			}
		}
	</script>
</body>

</html>
