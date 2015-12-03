<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ include file="header.jsp"%>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@ taglib uri="/tagss" prefix="date"%>
<script src="${path}/script/jquery.pagination-2.2.js"></script>
<script src="${path}/script/jquery.pagination.bs3render.js"></script>
<script src="${path}/script/cg-data-list-option.js"></script>
<script>
	!function($) {
		$(function() {
			var current_page = cg.currentPage();
			var page = $("#pagination");
			var total = ${totalCount};
			pagesize = 10;
			page.pagination(total, {
				callback : function(i, $e) {
					if (i !== current_page)
						document.location = "?page=" + i;
				},
				current_page : current_page,
				load_first_page : false,
				prev_text : "上一页",
				next_text : "下一页",
				renderer : "bs3Renderer",
				num_edge_entries : 2,
				show_if_single_page : true,
				items_per_page : pagesize
			// Show only one item per page
			});
			$("#modal-click").click(function() {
				$("#tip_modal").modal();
			});
		});
	}(window.jQuery);
</script>
<body>
	<main class="container">
	<div class="row">
		<div class="col-xs-12 col-sm-10 col-md-10 col-lg-10">
			<ol class="breadcrumb">
				<li><a href="${path}/api/student/">首页</a></li>
				<li class="active">student</li>
			</ol>
			<div class="page-header">
				<h1>
					<small>student列表</small>
				</h1>
			</div>
			<div class="btn-group cg-data-list-option hidden">
				<a data-href="${path}/api/student/" class="btn btn-info btn-xs">
					<span class="glyphicon glyphicon-info-sign"></span>&nbsp;查看
				</a> <a data-href="${path}/api/student/edit/"
					class="btn btn-warning btn-xs"> <span
					class="glyphicon glyphicon-edit"></span>&nbsp;编辑
				</a> <a class="btn btn-danger btn-xs" data-href="${path}/api/student/">
					<span class="glyphicon glyphicon-remove"></span>&nbsp;删除
				</a>
			</div>

			<div id="tip_modal" class="modal fade">
				<div class="modal-dialog">
					<div class="modal-content">
						<div class="modal-header">
							<button type="button" class="close" data-dismiss="modal">
								<span aria-hidden="true">&times;</span><span class="sr-only">Close</span>
							</button>
							<h4 class="modal-title"></h4>
						</div>
						<div class="modal-body">
							<p></p>
						</div>
						<div class="modal-footer">
							<button type="button" class="btn btn-danger"></button>
							<button type="button" class="btn btn-default"
								data-dismiss="modal">取消</button>
						</div>
					</div>
					<!-- /.modal-content -->
				</div>
				<!-- /.modal-dialog -->
			</div>
			<!-- /.modal -->
			<!-- visible if after add/delete/edit operation -->
			<div class="btn-group">
				<a href="${path}/api/reAdd" data-param="page"
					class="cg-auto-param btn btn-sm btn-primary"> <span
					class="glyphicon glyphicon-plus"></span>新增数据
				</a>
				<!-- 	  <button type="button" class="btn btn-default">Middle</button>
				  <button type="button" class="btn btn-default">Right</button> -->
			</div>
			<table class="cg-data-list table table-striped table-hover">
				<thead>
					<tr>
						<th class="hidden"></th>
						<th>姓名</th>
						<th>编号</th>
						<th>QQ</th>
						<th>描述</th>
						<th>创建时间</th>
						<th>更新时间</th>
						<th></th>
					</tr>
				</thead>
				<tbody>
					<c:forEach var="stu" items="${students}">
						<tr>
							<td class="hidden">${stu.id}</td>
							<td>${stu.stuName}</td>
							<td>${stu.stuNo}</td>
							<td>${stu.stuQQ}</td>
							<td><date:substr value="${stu.stuPro}" /></td>
							<td><date:date value="${stu.createAt}" /></td>
							<td><date:date value="${stu.updateAt}" /></td>
							<td></td>
						</tr>
					</c:forEach>
				</tbody>
			</table>
			<div id="pagination"></div>
		</div>
	</div>
	</main>
</body>
</html>