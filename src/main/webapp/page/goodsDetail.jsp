<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1 , user-scalable=no">
<meta name="description" content="">
<meta name="author" content="">
<base href="/wbb/">
<title>宝贝详情</title>

<link href="css/basic.css" rel="stylesheet">
<link href="css/goodsCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="css/comment.css"/>
<link rel="stylesheet" href="css/common.css"/>
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">
<link rel="stylesheet" href="css/idangerous.swiper.css">
<script src="js/idangerous.swiper.js"></script>

<title>宝贝详情</title>
</head>
<style>
#right_corner_menu{
	border-color:#777;
    background: #777;
}
	#emotions .container a{
		height: auto;
	}
	#emotions #prev, #emotions #next{
		height:auto;
	}
	.goodsDetail_div{
		height:auto;
		width: 100%;
		margin-bottom: 20px;
		padding-top: 10px;
		background:#fff;
	}
	.swiper-container #imgList .goodsDetail_img{
		background: center center / cover  no-repeat;
	}
	.swiper-container{
		/* height:212px; */
	}
	p{
	margin: 0;
	}
	.goodsDetail_div p{
		margin-left:10px;
	    margin-top: 10px;
	    font-size: 15px;
	}
	.goods_title{
		font-weight: 600;
	}
	.goods_price{
		color:red;
		width: 97%;
		font-weight: 600;
	}
	.tips{
		float: right;
	    margin-right: 20px;
	    color: #999;
	    font-size: 13px;
	    font-weight: 400;
        max-width: 140px;
        line-height: 16px; 
	    height: auto; 
	    padding: 0px 0px; 
	}
	.goodsDetail_div .goods_introduce{
		min-height:50px;
		text-indent: 2em;
	    margin-top: 10px;
		line-height: 24px;
		margin-right: 10px;
   		margin-left: 0px;
	    color: black;
	}
.pagination {
    position: absolute;
    left: 0;
    text-align: center;
    bottom: 5px;
    width: 97%;
    margin:  0; 
}
.swiper-pagination-switch {
    display: inline-block;
    width: 10px;
    height: 10px;
    border-radius: 10px;
    background: #999;
    box-shadow: 0px 1px 2px #555 inset;
    margin: 0 3px;
    cursor: pointer;
}
.swiper-active-switch{
	background:#fff;
}
.swiper-wrapper{
	width:100%;
}
.goods_bottom i{
 	width:40px;
 	height:40px;
 	float:right;
 	margin-right:10px;
    line-height: 40px;
    text-align: center;
}
.goods_bottom i:last-child{
	margin-right:0px;
}
</style>
<body>
<div id="out_div">
   	<div id="inner_div" >
		<div class="header" data-type="goods_comment">宝贝详情</div>
		<div class="goodsDetail_div" >
		<input type="hidden" id="goodsId" value="${lastGoods.goodsId }"/>
			<div class="swiper-container">
				 <div class="swiper-wrapper" id="imgList">
				 <c:choose>
				 	<c:when test="${fn:length(imgs) ==1}">
				 		<div class="goodsDetail_img" style="background-image:url('${imgs[0].imgPath}');width:100%;height:100%" data-src="${imgs[0].imgPath}" ></div>
				 	</c:when>
					<c:otherwise>
						<c:forEach items="${imgs }" var="img" varStatus="imgStatus">
 							<div class="goodsDetail_img swiper-slide" style="background-image:url('${img.imgPath}');" data-src="${img.imgPath}" ></div>
				 		</c:forEach>
					</c:otherwise>				 	
				 </c:choose>
				</div>
				<p class="pagination"></p>
			</div>
			
			<p class="goods_title">${lastGoods.goodsTitle }</p>
			<div>
				<p class="goods_price"><span>￥</span>${lastGoods.price } <span class="tips">${lastGoods.tips } </span></p> 
				<div style="clear:both"></div>
			</div>	
			<p class="goods_introduce">
				${lastGoods.goodsIntroduction }
			</p>
			<p class="goods_bottom"><i class="fa fa-commenting-o comment" id="comment" aria-hidden="true"></i><i onclick="openQQ(${lastGoods.qq })" class="fa fa-qq" aria-hidden="true"></i></p>
			<div style="clear:both"></div>
		</div>
		
<div id="comment_list"  class="comment_list">
	<p class="comment_list_header">全部<span class="commentCount">${lastGoods.commentCount }</span>条评论</p>
	<c:forEach var="comment" items="${comments }"  varStatus="status">
		 <div class="comment_div">
			<div class="user-heading">
				<div class="headImg">
					<img style="width:100%;height:100%;"  src="${comment.user.headimgurl }"/>
				</div>
				<div class="otherInfo">
					<p><span>${comment.user.nickname }</span> (<span class="floor">${status.index+1 }</span>楼)</p>
				 	<p class="publishTime"><fmt:formatDate value="${comment.publishDate }" pattern="yyyy-MM-dd HH:mm:ss E"/></p>
					<p class="commentContent">${comment.commentContent }</p>
				</div>	
			</div>
		</div> 
	</c:forEach>
	<div id="commentList_clear" style="clear:both;"></div>
</div>
</div>
</div>

<div class="clearfix blank_bottom"></div>
		<div class="navbar nav_fix_bottom">
			<div class="item_link nav">
				<div class="item_cell">
					<a class="nav_icon" href="goods/goodsCenter">
						<span class="icons icon-home">
						<i class="fa fa-home" aria-hidden="true"></i>
							<span class="nav_tit">首页</span>
						</span>
					</a>
				</div>
				<div class="item_cell" onclick="clickComment()">
					<a class="nav_icon"><span class="icons icon-user">
					<i class="fa fa-commenting-o comment" aria-hidden="true"></i>
						<span class="nav_tit">评论</span>
					</span></a>
				</div>

			</div>
		</div>
		<!-- 底部导航 end -->

<div id="publishComment_div" >
	<div class="comment_user">
		<div class="headImg">
			<img style="width:100%;height:100%;" src="${sessionScope.user.headimgurl }">
		</div>
		<p id="comment_userNike">${sessionScope.user.nickname }</p>
	</div>

	<textarea id="comment_text"  class="text"  placeholder="输入你的评论"></textarea>
	<div class="comment_bottom">
		<span class="face-icon" id="face-icon">☺</span>
		<button disabled="disabled" id="comment_button" class="comment_button">发 送</button>
		<button id="cancel_bottom" class="comment_button">取消</button>
		<span style=" display: inline-block; width: 38px;"></span>
	</div>
</div> 

</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script>
/* alert("window.innerWidth:"+window.innerWidth + " window.innerHeight:"+window.innerHeight
		+"  window.screen.height:"+screen.height+"  window.screen.width:"+screen.width
		) */
// 移动设备的比例一般为 0.56 ， pc端为0.75
if((screen.width/screen.height) <0.64){
	// screen.width/screen.height = realHeight/realWidth
	$(".swiper-container").css("height",(screen.width/screen.height)*screen.width);
	$(".swiper-container").css("width",window.innerWidth-5);
}else{
	// screen.width/screen.height = realWidth/realHeight
	$(".swiper-container").css("height",screen.width*0.5/(screen.width/screen.height));
	$(".swiper-container").css("width",window.innerWidth*0.5-5);
}
 var mySwiper = new Swiper('.swiper-container',{
	 
	    pagination: '.pagination',
	    grabCursor: true,
	    paginationClickable: true,
	    autoplay:2000,
	    autoplayDisableOnInteraction:false,
	    loop:true
	  })

</script>
   <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
   	<script type="text/javascript" src="js/jquery.sinaEmotion.js"></script>
   	<script src="js/initLightGallery.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
    <script src="js/pullToRefresh.js"></script>
    <script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
    <script type="text/javascript" src="js/jquery.flexText.min.js"></script>
	<script src="js/reflush.js"></script>
	<script type="text/javascript" src="js/dateFormat.js"></script> 
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/comment.js"></script>
    <script type="text/javascript">
		initLightGallery("imgList");
		$("#sinaEmotion").remove();
		function openQQ(qq){
			location.href="mqqwpa://im/chat?chat_type=wpa&uin="+qq+"&version=1&src_type=web&web_src=oicqzone.com";
		}
    	/* 
    	$("textarea").keydown(function(){
    		event.preventDefault();
    		if(event.which == 13){
    			alert("hello world")
    		}
    	}) */

    </script>
</html>