

// 0是控制方向的
$('.face-icon').SinaEmotion($('.text'),0,$(".face-icon"));
$(".commentContent").parseEmotion();
/*addEventListener("touchend",function(e){
	//alert($(e.target).attr("id"))
	if(typeof($(e.target).attr("id"))!='undefined' && $(e.target).attr("id")=="face-icon"){
		 $("#comment_text").focus();
	}
})*/
var dataId

$(function () {
    $('#comment_text').flexText();
    $("#comment_text").attr("placeholder","输入你的评论...")
    
	if( header_div.attr("data-type") == "comment"){
		dataId= $("#infoId").val()
	}else if(header_div.attr("data-type") == "goods_comment"){
		dataId=$("#goodsId").val();
	}
    
    $("#likeSpan").text(getCookie("likeCount_"+dataId));
    $(".commentCount").text(getCookie("commentCount_"+dataId));
    
    if(header_div.attr("data-type")!="goods_comment"){
    	setIsLike(dataId);
    }
    
    // 判断如果评论数为0 ， 就改点样式
    if(parseInt($(".commentCount").text())==0){
    	$(".comment_list_header").text("还没有小伙伴来发言哦~");
    	$(".comment_list_header").css({"border":"none"});
    	$("#comment_list").append("<div style='height:50px'></div>");
    	//如果
    	$("#comment_list").css({"margin-bottom":"0"});
    	$("#pullUp").css("display","none");
    	refresher.isBottom = true;
    	
    }
});
$("#comment_text").focus(function(){
	startPPP = scrollY;
	isfocus = true;
	//$("#publishComment_div").css({"display":"none"})
	//$("#publishComment_div").css({"position":"absolute","background":"#f6f6f6 none"})
	//$("#face-icon").css({"height":"36px","width":"24.52px"})
	//$('pre').animate({"min-height":"200px"},200);
	setTimeout(function(){
		//$("#publishComment_div").css({"display":"block"})
		
		//$('html,body').animate({scrollTop:($(document).scrollTop()+$("body").height()-$("#publishComment_div").height()-343)}, 100)
		//("#publishComment_div").css({"position":"fixed","bottom":"0px","top":""})
	}, 300)
})
$("#comment_text").blur(function(){
//	$('pre').animate({"min-height":"50px"},200);
//	$("#publishComment_div").css({"position":"fixed","bottom":"0px","top":""})
	isfocus = false;
})
var startPPP = scrollY;
var timeNotLock =true;
var isfocus = false;

window.addEventListener("scroll", function() {
	$("#emotions").css("display","none");
	/*if(timeNotLock ){
		timeNotLock = false;
		isfocus = false;
		var scrollendTime = setInterval(function(){
			$("#comment_text").val("start..  end:"+refresher.srollEnd);
			if(refresher.srollEnd){
				clearInterval(scrollendTime);
				timeNotLock = true;
				$("#publishComment_div").css({"position":"fixed","bottom":"0px","top":""})
			}
		},200)
	}*/
	/*if(timeNotLock && isfocus){
		timeNotLock = false;
		setTimeout(function(){
			var endPPP = scrollY;
			//$("#comment_text").val((endPPP-startPPP) +"   scrollTop:"+$(document).scrollTop()+" minus:"+(343-endPPP+startPPP));
			if(endPPP-startPPP<343){
				$('html,body').animate({scrollTop:($(document).scrollTop()+(343-endPPP+startPPP))}, 100);
			}
			timeNotLock = true;
		}, 100)
	}*/
	//$("#comment_text").val("");
	/*if(isfocus){
		// top:auto???
		//$(document).scrollTop()+"  body:"+$("body").height()+"  top:"+$("#publishComment_div").css("top")+
	//	$("#comment_text").val(" background:"+$("#publishComment_div").css("background"))
		// 255 = 343（软键盘）-88（工具栏）
		$("#publishComment_div").css("top",$("body").height()-$("#publishComment_div").height()+$(document).scrollTop()-255);
	}*/
})

$(".comment").click(function(){
	if($("#comment_userNike").text() ==""){
		alert("未登陆");
		location.href = "/wbb/index.jsp";
	}else{
		$("#publishComment_div").animate({"height":"320px"},200)
		// $('#comment_text').focus();
	}
})

function clickComment(){
	$('.comment')[0].click();
}

$("textarea").keydown(function(event){
	if(event.which == 13){
		event.preventDefault();
		ClickpublishComment();
	}
}) 
$("textarea").on('input propertychange', function() {
	// 320:publishComment_div的初始化高度  100：flex-text-wrap的初始化高度
	$("#publishComment_div").height(320-100+$($(".flex-text-wrap")[0]).height())
	if($("#comment_text").val().length>0){
		$("#comment_button").removeAttr("disabled")
		$("#comment_button").css("background","#0a8af2")
	}else{
		$("#comment_button").attr("disabled","disabled")
		$("#comment_button").css("background","#999")
	}
}) 

$("#likeMenu").click(function(){
	$("#likeMenu").find(".like").click();
})
$("#cancel_bottom").click(function(){
	$("#publishComment_div").animate({"height":"0px"},200)
})
$("#comment_button").click(ClickpublishComment)

function ClickpublishComment(){
	var paramete,url,redirctUrl="/wbb/index.jsp";
	if( header_div.attr("data-type") == "comment"){
		paramete = {"commentContent":$("#comment_text").val(),"infoId":dataId}
		url = "info/publishComment";
	}else if(header_div.attr("data-type") == "goods_comment"){
		paramete = {"commentContent":$("#comment_text").val(),"goodsId":dataId}
		url = "goods/publishGoodsComment";
	}
	
	sendAsynRequest("post",url, paramete, function(comment){
		if(comment == "unlogin"){
			alert("未登陆！");
			location.href=redirctUrl;
		}else if(comment == "fail"){
			$.errorTip("出错啦...请稍后再试");
		}else if(comment!=null){
			if($("#comment_list .comment_div").length<10){
				console.info(comment)
				var floor =  parseInt( $(".floor").last().text())
				console.info(floor);
				if(isNaN(floor)){
					floor=0;
				}
				$("#comment_list").append('<div class="comment_div">'+
						'<div class="user-heading">'+
						'<div class="headImg">'+
						'<img style="width:100%;height:100%;"  src="'+comment.user.headimgurl +'"/>'+
						'</div>'+
						'<div class="otherInfo">'+
						'<p><span>'+comment.user.nickname +'</span> (<span class="floor">'+(++floor)+'</span>楼)</p>'+
						'<p class="publishTime">'+FormatDate(comment.publishDate)+'</p>'+
						'<p class="commentContent">'+comment.commentContent+'</p>'+
						'</div>'+
						'</div>'+
						'</div>');
			}
			//设置commentCount
			var commentCout = parseInt($("#commentCount").text());
			$(".commentCount").text(++commentCout);
			delCookie("commentCount_"+dataId);
			document.cookie = "commentCount_"+dataId+"="+commentCout; 
			//弹框
			$.successTip("评论发送成功", 500);
			//清空评论框内容
			$("textarea").val("");
			$("#publishComment_div").animate({"height":"0px"},200)
			$("#comment_text").blur();
			if($(".comment_div").length ==1){
				//reload直接跳回首页去了
				$("form").submit();
			}
		}  // else if(comment !=null)
	});  
}
//点击文本框，focus后软键盘不会遮住文本框 ---> 适用于安卓
if (/Android [4-6]/.test(navigator.appVersion)) {
	   window.addEventListener('resize', function () {
		 //  alert("resize");
	     if (document.activeElement.tagName === 'INPUT' || document.activeElement.tagName === 'TEXTAREA') {
	        window.setTimeout(function () {
	          document.activeElement.scrollIntoViewIfNeeded()
	        }, 0)
	      }
	   })
	}