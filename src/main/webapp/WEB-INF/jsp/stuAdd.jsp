<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<script src="${path}/script/jquery.validate.min.js"></script>
<script src="${path}/script/messages_zh.js"></script>
<script src="${path}/script/form-validation.js"></script>
<main class="container">
<div class="row">
	<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
		<ol class="breadcrumb">
			<li><a href="${path}/student">首页</a></li>
			<li><a data-param="page" class="cg-auto-param" href="${path}/student">Student</a></li>
			<li class="active">添加</li>
		</ol>
		<form role="form" class="form-horizontal cg-form"
			action="${path}/student/" method="post">
			<div class="cg-form-header">
				<h4>添加Student</h4>
			</div>
			<div class="cg-form-body">
				<div class="form-group">
					<label for="stuName" class="control-label col-sm-2">姓名</label>
					<div class="col-sm-5">
						<input type="text" id="stuName" name="stuName" class="form-control"
							placeHolder="Enter stuName">
					</div>
				</div>
				<div class="form-group">
					<label for="stuNo" class="control-label col-sm-2">编号</label>
					<div class="col-sm-5">
						<input type="text" id="stuNo" name="stuNo" class="form-control"
							placeHolder="Enter stuNo">
					</div>
				</div>
				<div class="form-group">
					<label for="stuQQ" class="control-label col-sm-2">QQ</label>
					<div class="col-sm-5">
						<input type="text" id="stuQQ" name="stuQQ" class="form-control"
							placeHolder="Enter stuQQ">
					</div>
				</div>
				<div class="form-group">
					<label for="stuPro" class="control-label col-sm-2">描述</label>
					<div class="col-sm-5">
						<input type="text" id="stuPro" name="stuPro" class="form-control"
							placeHolder="Enter stuPro">
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
</div>
</main>