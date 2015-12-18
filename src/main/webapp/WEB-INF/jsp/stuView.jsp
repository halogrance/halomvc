<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<main class="container">
<div class="row">
	<div class="col-xs-12 col-sm-9 col-md-9 col-lg-9">
		<ol class="breadcrumb">
			<li><a href="${path}/api/student">首页</a></li>
			<li><a data-param="page" class="cg-auto-param" href="${path}/api/student">Student</a></li>
			<li class="active">查看</li>
		</ol>
		<div class="page-header">
			<h1>
				<small>student详请</small>
			</h1>
			<div class="btn-group">
				<a href="${path}/api/reAdd" data-param="page id"
					class="cg-auto-param btn btn-primary">新增</a> <a
					href="${path}/api/student/edit/${student.id}" data-param="page id"
					class="cg-auto-param btn btn-warning">修改</a>
			</div>
			<table class="table table-bordered table-striped">
				<colgroup>
					<col class="col-xs-1">
					<col class="col-xs-7">
				</colgroup>
				<thead>
					<tr>
						<th>属性</th>
						<th>值</th>
					</tr>
				</thead>
				<tbody>
					<tr>
						<td><code>姓名</code></td>
						<td>${student.stuName}</td>
					</tr>
					<tr>
						<td><code>编号</code></td>
						<td>${student.stuNo}</td>
					</tr>
					<tr>
						<td><code>QQ</code></td>
						<td>${student.qqNo}</td>
					</tr>
					<tr>
						<td><code>描述</code></td>
						<td>${student.stuDesc}</td>
					</tr>
					<tr>
						<td><code>创建时间</code></td>
						<td>${student.createTime}</td>
					</tr>
					<tr>
						<td><code>更新时间</code></td>
						<td>${student.updateTime}</td>
					</tr>
				</tbody>
			</table>
		</div>
	</div>
</div>
</main>