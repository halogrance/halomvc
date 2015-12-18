<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="${path}/script/jquery.validate.min.js"></script>
<script src="${path}/script/messages_zh.js"></script>
<script src="${path}/script/form-validation.js"></script>
<!-- <script>
	$(function(){
		$("#update").submit(function(){
			$.ajax({
				type:"put",
				data:{
					stuName:$("#stuName").val(),
					stuNo:$("#stuName").val(),
					qqNo:$("#stuName").val(),
					stuDesc:$("#stuName").val()
				},
				url:$(this).attr("action");
			});
		});
	});
</script> -->
<main class="container">
<div class="row">
	<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
		<ol class="breadcrumb">
			<li><a href="${path}/api/student">首页</a></li>
			<li><a data-param="page" class="cg-auto-param" href="${path}/api/student">Student</a></li>
			<li class="active">修改</li>
		</ol>
	</div>
	<form id="update" role="form" class="form-horizontal cg-form"
		action="${path}/api/student/${student.id}" method="post">
		<div class="cg-form-header">
			<h4>修改Student</h4>
		</div>
		<div class="cg-form-body">
			<div class="form-group">
				<label for="stuName" class="control-label col-sm-2">姓名</label>
				<div class="col-sm-5">
					<input type="text" id="stuName" name="stuName" class="form-control"
						value="${student.stuName }">
				</div>
			</div>
			<div class="form-group">
				<label for="stuNo" class="control-label col-sm-2">编号</label>
				<div class="col-sm-5">
					<input type="text" id="stuNo" name="stuNo" class="form-control"
						value="${student.stuNo}">
				</div>
			</div>
			<div class="form-group">
				<label for="stuQQ" class="control-label col-sm-2">QQ</label>
				<div class="col-sm-5">
					<input type="text" id="stuQQ" name="stuQQ" class="form-control"
						value="${student.stuQQ }">
				</div>
			</div>
			<div class="form-group">
				<label for="stuPro" class="control-label col-sm-2">描述</label>
				<div class="col-sm-5">
					<input type="text" id="stuPro" name="stuPro" class="form-control"
						value="${student.stuPro }">
				</div>
			</div>
		</div>
		<div class="cg-form-footer">
			<button type="submit" class="btn btn-primary">
				<span class="glyphicon glyphicon-ok"></span> 提交
			</button>
			<button type="reset" class="btn btn-danger">
				<span class="glyphicon glyphicon-remove"></span> 重置
			</button>
		</div>
	</form>
</div>
</main>