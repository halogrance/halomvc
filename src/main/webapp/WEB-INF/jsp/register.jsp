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
			<li><a data-param="page" class="cg-auto-param" href="${path}/regUser">注册</a></li>
			<li class="active">添加</li>
		</ol>
		<form role="form" class="form-horizontal cg-form"
			action="${path}/userinfo/registerUser" method="post">
			<div class="cg-form-header">
				<h4>登陆Student</h4>
			</div>
			<div class="cg-form-body">
				<div class="form-group">
					<label for="UserName" class="control-label col-sm-2">姓名</label>
					<div class="col-sm-5">
						<input type="text" id="UserName" name="UserName" class="form-control"
							placeHolder="Enter UserName">
					</div>
				</div>
				<div class="form-group">
					<label for="UserPass" class="control-label col-sm-2">密码</label>
					<div class="col-sm-5">
						<input type="text" id="UserPass" name="UserPass" class="form-control"
							placeHolder="Enter UserPass">
					</div>
				</div>
				<div class="form-group">
					<label for="UserPass2" class="control-label col-sm-2">再次输入密码</label>
					<div class="col-sm-5">
						<input type="text" id="UserPass2" name="UserPass2"  class="form-control"
							placeHolder="Enter UserPass2">
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