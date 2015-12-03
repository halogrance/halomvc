!function($){
$(function(){
	var getContextPath=function(){
	    var pathName = document.location.pathname;
	    var index = pathName.substr(1).indexOf("/");
	    var result = pathName.substr(0,index+1);
	    return result;
	}
	var opt = $(".cg-data-list-option");
	opt.css("position","absolute");
	opt.css("padding-right","15px");
	opt.css("right",0);
	var datalist=$("table.cg-data-list");
	datalist.find("tbody tr").hover(function() {
		$(this).find("td:last").append(opt);
		opt.removeClass('hidden');
	}, function() {
		opt.addClass('hidden');
	});
	var optbtn=opt.find("a");
	var detail_or_edit=function (){
		var id=opt.closest('tr').find("td:first").html();
		var page=cg.currentPage();
		var url=$(this).data("href")+id;
		document.location=url;
		return false;
	};
	var show_modal=function(title,body,btnstyle,btnname,btncallback){
		var modal = $("#tip_modal");
		modal.find(".modal-title").html(title);
		modal.find('.modal-body p').html(body);
		var btnok=modal.find(".modal-footer button:eq(0)");
		btnok.addClass(btnstyle).html(btnname)
		.click(function(event) {
			modal.modal('hide');
			btncallback();
			btnok.removeClass(btnstyle).unbind('click');
		});
		modal.modal({
			keyboard: true
		});
		modal.on('hidden.bs.modal', function (e) {
		  btnok.removeClass(btnstyle).unbind('click');
		});
	};
	var delete_data=function(baseurl,id){
		var id=opt.closest('tr').find("td:first").html();
		var page=cg.currentPage();
		var url=getContextPath()+"/api/student/"+id;
		$.ajax({
			type:"delete",
			url:url,
			success:function(msg){
				window.location.reload();
			}
		});
		
	};
	var delete_ensure=function(){
		var id=opt.closest('tr').find("td:first").html();
		show_modal(
			"提示",
			"是否删除id为"+id+"的数据?",
			"btn-danger","确定删除",
			function(){
				delete_data(datalist.data("base-url"),id);
			}
		);
	};
	$(optbtn[0]).click(detail_or_edit);
	$(optbtn[1]).click(detail_or_edit);
	$(optbtn[2]).click(delete_ensure);

});
}(jQuery);