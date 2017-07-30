
var Refresh =function Refresh() {
	console.info("up");
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		myScroll.refresh();/****remember to refresh when you action was completed！！！****/
	}, 1000);
}
var LoadGoods = function LoadGoods() {
	console.info("down ");
	for(var i=0 ; i<10 ;i++){
		$($(".dataList")[0]).append("<div class='goods_div'>"+$("#data").html()+"</div>");
	}
	myScroll.refresh();
}

var LoadInfo = function LoadInfo(){
	console.info("down ");
	for(var i=0 ; i<10 ;i++){
		//$($(".dataList")[0]).append("<div class='info_div'>"+$("#data").html()+"</div>");
	}
	myScroll.refresh();
}

if($($(".header")[0]).text()=='二手市场'||$($(".header")[0]).text()=="宝贝详情"||$($(".header")[0]).text()=="历史发布"){
	initIscroll(Refresh,LoadGoods);
}else if($($(".header")[0]).text()=='发布广场'||$($(".header")[0]).text()=="发布详情"||$($(".header")[0]).text()=="个人历史"){
	initIscroll(Refresh,LoadInfo);
}



function initIscroll(Refresh,Load){
	var refreshera = refresher.init({
		id:"inner_div",
		pullDownAction:Refresh,
		pullUpAction:Load
	});
}


window.onorientationchange = function(){
	// 不能重新获得旋转后正确的 maxScrollY 值
/*	refreshera = refresher.init({
		id:"inner_div",
		pullDownAction:Refresh,
		pullUpAction:Load,
		onBeforeScrollStart:function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;
			if (target.tagName != 'SELECT'&& target.tagName != 'INPUT' & target.tagName != 'TEXTAREA')
				e.preventDefault();
			}
	});*/
}
