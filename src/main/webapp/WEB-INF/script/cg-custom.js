/*
* @Author: Black Lotus
* @Date:   2014-10-06 18:11:00
* @Last Modified by:   Black Lotus
* @Last Modified time: 2014-10-11 01:30:07
*/
!function($,cg){
// "use strict";
$(function(){
	show_active_nav();
//	auto_page();
	auto_params();
});
// show actived nav
var show_active_nav=function(){
	var nav=$("nav ul.navbar-nav");
	var navs=nav.find('>li');
	var navi;
	var nava=nav.find('>li.active');
	if(!nava.length){
		navi=$.cookie("nav-index")||0;
		navs.eq(navi).addClass('active');
	}else{
		navi=navs.index(nava[0]);
	}
	navs.click(function(event) {
		navs.eq(navi).removeClass('active');
		navi=navs.index(this);
		$(this).addClass('active');
		$.cookie("nav-index",navi);
		// console.log("navi:"+navi)
	});
};//show_active_nav

var auto_param=function(param){
	var value=  cg.parseParam(document.location.toString(),param);
	$("a.cg-auto-param").each(function(){
		if(value){
			if (this.href.indexOf("?")==-1){
				this.href+="?"+param+"="+value;
			}else{
				this.href+="&"+param+"="+value;
			}
		}
	});
};//auto_param
var auto_params=function(){
//	var params=arguments;
	var url=document.location.toString();
	var strcahce={};
	var getParamStr=function(dataparam){
		if(strcahce[dataparam]){
			return strcahce[dataparam];
		}
		var str="";
		var j=0;
		var params=dataparam.split(/\s/);
		for(var i=params.length-1;i>=0;i--){
			var param=params[i];
			var value=cg.parseParam(url,params[i]);
			if (value){
				if(j!=0){
					str+="&"+param+"="+value;
				}else{
					str+=param+"="+value;
				}
				j++;
			}
		};
		strcahce[dataparam]=str;
		return str;
	};
	$("a.cg-auto-param").each(function(){
		var dataparam=$(this).data("param");
		var str=null;
		if(dataparam) str=getParamStr(dataparam);
		if(str){
			if (this.href.indexOf("?")==-1){
				this.href+="?"+str;
			}else{
				this.href+="&"+str;
			}
		}
	});
};//auto_param


var auto_page=function(){
	var page= cg.currentPage();
	$("a.cg-auto-page").each(function(){
		if(page){
			if (this.href.indexOf("?")==-1){
				this.href+="?page="+page;
			}else{
				this.href+="&page="+page;
			}
		}
	});
};//auto_page
//export

cg.show_active_nav=show_active_nav;
cg.auto_param=auto_param;
cg.auto_params=auto_params;
}(window.jQuery,window.cg);