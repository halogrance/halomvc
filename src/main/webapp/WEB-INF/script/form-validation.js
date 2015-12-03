/*
 * @Author: Black Lotus
 * @Date:   2014-10-07 03:10:35
 * @Last Modified by:   Black Lotus
 * @Last Modified time: 2014-10-11 17:01:53
 */

!function($) {
	$(function() {
		var getContextPath = function() {
			var pathName = document.location.pathname;
			var index = pathName.substr(1).indexOf("/");
			var result = pathName.substr(0, index + 1);
			return result;
		}
		$(".cg-form").validate({
			rules : {
				stuName : {
					required : true,
					rangelength : [ 2, 8 ],
					remote : {
						url : "/PttengTask/api/check",
						data : {
							type : "stuName",
							value : function() {
								return $("#stuName").val();
							}
						}
					}
				},
				stuNo : {
					required : true,
					rangelength : [ 3, 10 ],
					remote : {
						url : "/PttengTask/api/check",
						data : {
							type : "stuNo",
							value : function() {
								return $("#stuNo").val();
							}
						}
					}
				},
				qqNo : {
					required : true,
					rangelength : [ 6, 11 ],
					remote : {
						url : "/PttengTask/api/check",
						data : {
							type : "qqNo",
							value : function() {
								return $("#qqNo").val();
							}
						}
					}
				}
			},
			messages : {
				stuName : {
					required : "不能为空",
					remote : "姓名已存在"
				},
				stuNo : {
					required : "不能为空",
					remote : "学员编号已存在"
				},
				qqNo : {
					required : "不能为空",
					remote : "QQ号已存在"
				}
			},
			errorPlacement : function(error, element) {
				element.closest("div.form-group").addClass("has-error");
				error.insertAfter(element.closest("div"));
			},
			errorElement : "p",
			errorClass : "help-block",
			success : function(error, element) {
				$(element).closest("div.form-group").removeClass("has-error");
				error.remove();
			}
		});
 	});
}(window.jQuery);