
initImg();

function initImg(){
	if($(".imgList .imgMoreThanTwo").length>0){
		$(".imgList .imgMoreThanTwo").height($($(".imgList .imgMoreThanTwo")[0]).width())
	}
	if($(".imgList .imgMoreThanOne").length>0){
		$(".imgList .imgMoreThanOne").height($($(".imgList .imgMoreThanOne")[0]).width())
	}
	$(".onlyImg").css("max-width",screen.width);
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


function clickLike(obj,infoId,e){
	e.stopPropagation();
	var likespan = $(obj).parent().parent().find(".likeSpan");
	if($(obj).attr("class").indexOf("fa-heart-o")>0){
		sendAsynRequest("get","info/setLikeInfo",{"infoId":infoId,"setStatus":1},function(data){
			if(data =='success'){
				$(obj).removeClass("fa-heart-o").addClass("fa-heart").addClass('heartpop')
				var flag = true;
				$(obj).one('mozAnimationEnd MSAnimationEnd oanimationend webkitAnimationEnd', function(){
					$(obj).removeClass('heartpop'); // 如果运行的话，下面的setTimeout不走。代码在这里运行。
				    flag = false;
				});
				//定时器去掉心跳类
				setTimeout(function () {
				    if(flag != false) {
				    	$(obj).one('animationend',function () {
				    		$(obj).removeClass('heartpop'); // 如果上面不支持的话，则运行这里。
				        })
				    }
				},10)
				likespan.text(parseInt(likespan.text())+1);
				/*不知道为什么没用
				 * $(obj).removeClass("fa-heart-o").addClass("fa-heart").addClass('heartpop').animationEnd(function(){
					$(obj).removeClass('heartpop');
				});*/
			}else{
				alert("出错啦...");
			}
		}
	);
		
	}else if($(obj).attr("class").indexOf("fa-heart")>0){
		sendAsynRequest("get","info/setLikeInfo",{"infoId":infoId,"setStatus":0},function(data){
			if(data=='success'){
				$(obj).removeClass("fa-heart").addClass("fa-heart-o");
				likespan.text(likespan.text()-1)
			}else{
				alert("出错啦...");
			}
		});
	}
}