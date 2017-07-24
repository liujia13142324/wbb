var refreshera = refresher.init({
	id:"inner_div",
	pullDownAction:Refresh,
	pullUpAction:Load,
	onBeforeScrollStart:function (e) {
		var target = e.target;
		while (target.nodeType != 1) target = target.parentNode;
		if (target.tagName != 'SELECT'&& target.tagName != 'INPUT' & target.tagName != 'TEXTAREA')
			e.preventDefault();
		}
});


function Refresh() {
	console.info("up");
	setTimeout(function () {	// <-- Simulate network congestion, remove setTimeout from production!
		myScroll.refresh();/****remember to refresh when you action was completed！！！****/
	}, 1000);
}
function Load() {
	console.info("down ");
	for(var i=0 ; i<10 ;i++){
		$($(".dataList")[0]).append("<div class='goods_div'>"+$("#data").html()+"</div>");
	}
	myScroll.refresh();
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
