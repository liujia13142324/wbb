<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
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
<title>商品详情</title>

<link href="css/basic.css" rel="stylesheet">
<link href="css/lib.css" rel="stylesheet">
<link href="css/goodsCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="css/comment.css"/>
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">
<link rel="stylesheet" href="css/idangerous.swiper.css">
<script src="js/idangerous.swiper.js"></script>
<title>商品详情</title>
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
		margin-top:5px;
	    font-size: 15px;
	}
	.goods_title{
		font-weight: 600;
	}
	.goods_price{
		color:red;
		width:100%;
		font-weight: 600;
	}
	.tips{
		float: right;
	    margin-right: 20px;
	    color: #999;
	    font-size: 13px;
	    font-weight: 400;
	}
	.goodsDetail_div .goods_introduce{
		height:100px;
		text-indent: 2em;
	    margin-top: 10px;
		line-height: 24px;
	}
.pagination {
    position: absolute;
    left: 0;
    text-align: center;
    bottom: 5px;
    width: 100%;
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
<div id="inner_div">
	<ul>
		<div class="header">发布详情</div>
		
		<div class="goodsDetail_div" >
			<div class="swiper-container">
				 <div class="swiper-wrapper" id="imgList">
					<div class="goodsDetail_img swiper-slide" style="background-image:url('img/test2.jpg');" data-src="img/test2.jpg" ></div>
				 	<div class="goodsDetail_img swiper-slide" style="background-image:url('img/test1.jpg');" data-src="img/test1.jpg" ></div>
				 	<div class="goodsDetail_img swiper-slide" style="background-image:url('img/IMG_7258.PNG');" data-src="img/IMG_7258.PNG" ></div>
				</div>
				<p class="pagination"></p>
			</div>
			
			<p class="goods_title">豪车1</p>
			<p class="goods_price"><span>￥</span>10 <span class="tips"> 汽车/九成新，可小刀，包邮 </span></p> 
				
			<p class="goods_introduce">
				归本大甩卖，本人缺钱坐三轮车，快来买呀，有钱的捧个钱场，有人的捧个人场，谢谢。。
			</p>
			<p class="goods_bottom"><i class="fa fa-commenting-o comment" id="comment" aria-hidden="true"></i><i class="fa fa-qq" aria-hidden="true"></i></p>
			<div style="clear:both"></div>
		</div>
		
		<div  class="comment_list">
			<p class="comment_list_header">全部<span>4</span>条评论</p>
			<div class="comment_div">
				<div class="user-heading">
					<div class="headImg">
						<img style="width:100%;height:100%;"  src="img/QQ.png"/>
					</div>
					<div class="otherInfo">						
						<p><span>温柔的太阳君</span> (1楼)</p>
						<p class="publishTime">刚刚</p>
						<p class="commentContent">沙发~~</p>
					</div>	
				</div>
				<div style="clear:both;"></div>
			</div>
		</div>
	</ul>
</div>
<div id="right_corner_menu" class="dropup">
			<a href="javascript:void(0);" id="menu_a"><i class="fa fa-bars"   aria-hidden="true"></i></a>
			<div style="display:none;">
				<div id="menu_content">
					<p>发布二手信息</p>
					<p>我的历史发布</p> 
					<p>吐槽广场</p>
				</div>
			</div>
		</div>

<div id="publishComment_div">
<span class="face-icon" id="face-icon">☺</span><textarea id="comment_text"  class="text"  placeholder="输入你的评论"></textarea>
</div> 

 
</body>
  <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
<script>

/* alert("window.innerWidth:"+window.innerWidth + " window.innerHeight:"+window.innerHeight
		+"  window.screen.height:"+screen.height+"  window.screen.width:"+screen.width
		) */
// 移动设备的比例一般为 0.56 ， pc端为0.75
if((screen.width/screen.height) <0.64){
	$(".swiper-container").css("height",(screen.width/screen.height)*screen.width);
	$(".swiper-container").css("width",window.innerWidth);
}

 var mySwiper = new Swiper('.swiper-container',{
	 
	    pagination: '.pagination',
	    grabCursor: true,
	    paginationClickable: true,
	    autoplay:1500,
	    autoplayDisableOnInteraction:false,
	    loop:true
	  })

</script>
    <script src="js/bootstrap.min.js"></script>
   <!--  <script src="js/docs.min.js"></script> -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
    <script type="text/javascript" src="js/info.js"></script>
    <script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
    <script type="text/javascript" src="js/jquery.flexText.min.js"></script>
    <script type="text/javascript" src="js/comment.js"></script>
	<script src="js/initLightGallery.js"></script>
	
    <script type="text/javascript">
    	$('.face-icon').SinaEmotion($('.text'),0);
		initLightGallery("imgList");
    	/* 
    	$("textarea").keydown(function(){
    		event.preventDefault();
    		if(event.which == 13){
    			alert("hello world")
    		}
    	}) */

    </script>
     <script src="js/iscroll.js"></script>
	<script src="js/pullToRefresh.js"></script>
	<script src="js/reflush.js"></script>
</html>