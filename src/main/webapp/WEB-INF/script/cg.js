/*
* @Author: Black Lotus
* @Date:   2014-10-11 01:04:49
* @Last Modified by:   Black Lotus
* @Last Modified time: 2014-10-11 01:26:38
*/

/**
 * some usefule functions
 */
!function(W){
var cg= {};
cg.parseParam =function (url, name){
	var p0 = url.lastIndexOf("?");
	if (p0 != -1) {
		var p1=url.lastIndexOf("#");
		var param ;
		if(p1!=-1) param=url.substring(p0 + 1,p1);
		else param=url.substring(p0+1);
		var kv = param.split("&");
		for (var i = kv.length - 1; i >= 0; i--) {
			var pair = kv[i].split("=");
			if (pair[0] == name) {
				return pair[1];
			}
		};
	}
};//end of cg.parseParam

cg.currentPage=function (){
	var page= cg.parseParam(document.location.toString(),"page");
	return Math.max(page||0,0);
};

//export
W.cg=cg;
if(W.$){
	$.cg=cg;
}
}(window);