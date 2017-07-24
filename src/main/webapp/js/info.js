
initImg();

function initImg(){
	if($(".imgList img").length>0){
		$(".imgList img").attr("height",$(".imgList img")[0].width)
	}
}
//.x_left 是 infoCenter.jsp 或者 infoDeatil.jsp 发布信息底部的信息  评论数，点赞数
$(".x_left").css("line-height",$(".x_right").css("height"))

function orientationChange(){
	initImg();
}

// 旋转自适应
addEventListener('load', function(){
    orientationChange();
    window.onorientationchange = orientationChange;
});


function clickLike(obj){
	if($(obj).attr("class").indexOf("fa-heart-o")>0){
		$(obj).removeClass("fa-heart-o").addClass("fa-heart");
	}else if($(obj).attr("class").indexOf("fa-heart")>0){
		$(obj).removeClass("fa-heart").addClass("fa-heart-o");
	}
}