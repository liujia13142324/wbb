


var starTime 

addEventListener("touchend",function(e){
	var endTime = new Date().getTime();
	// 点击时间过短，就按照点击事件处理
	if(endTime-starTime<150){
		
		//移动端点击事件有点问题，解决方案：放到触屏事件里面
		if(t!=null && t!="undefined"){
			t.tooltip('hide');
		}
		hideComment(e);
	}
});

addEventListener("touchstart",function(e){
	starTime = new Date().getTime();
});

function hideComment(e) {
	console.info($(e.target).attr("id"));
	if(  $(e.target).attr("id") !="comment_text" 
			&& $(e.target).attr("id") !="comment"
				&& $(e.target).attr("id") !="face-icon"
					&& $(e.target).parent().parent().parent().attr("id") !="emotions"
						&& $(e.target).parent().parent().attr("id") !="emotions"
							&& $(e.target).parent().attr("id") !="emotions"
								&& $(e.target).attr("id") !="emotions")
							$("#publishComment_div").css("display","none");
}

$(".comment").click(function(){
	$("#publishComment_div").css("display","block");
})

$(function () {
    $('#comment_text').flexText();
});

document.onclick = function(e){
	hideComment(e);
}
