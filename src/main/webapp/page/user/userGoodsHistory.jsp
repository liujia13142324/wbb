<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<base href="/wbb/">
<title>个人发布历史</title>
</head>
<link href="css/basic.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/goodsCenter.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="easyui/css/easyui.css">
<style>
#right_corner_menu{
	border-color:#777;
    background: #777;
}
*{
box-sizing: content-box;
}
</style>
<body>
<div id="inner_div">
<ul style="background:#efefef">
	<div class="header">个人发布历史</div>
	
	<div id="goodsList" class="dataList">
		<div class="goods_div">
			<div class="goods_img" ></div>
			<div class="goods_info">
				<p class="title">豪车1</p>
				<p class="tips">汽车/九成新，可小刀，包邮</p>
				<p class="price"><span>￥</span>10</p>
			</div>
		</div>
		
		<div class="goods_div">
			<div class="goods_img" style="background-image:url('img/test2.jpg')" ></div>
			<div class="goods_info">
				<p class="title">豪车2，亏本大甩卖，走过路过不要错过！</p>
				<p class="tips">汽车/九成新，可小刀，包邮,送老司机一枚</p>
				<p class="price"><span>￥</span>20000000</p>
			</div>
		</div>
		
		<div class="goods_div">
			<div class="goods_img" style="background-image:url('img/test3.jpg')" ></div>
			<div class="goods_info">
				<p class="title">豪车3，亏本大甩卖，走过路过不要错过！</p>
				<p class="tips">汽车/九成新，可小刀，包邮</p>
				<p class="price"><span>￥</span>20000000</p>
			</div>
		</div>
		
		<div class="goods_div">
			<div class="goods_img" style="background-image:url('img/test3.jpg')" ></div>
			<div class="goods_info">
				<p class="title">豪车3，亏本大甩卖，走过路过不要错过！</p>
				<p class="tips">汽车/九成新，可小刀，包邮</p>
				<p class="price"><span>￥</span>20000000</p>
			</div>
		</div>
		
		<div class="goods_div">
			<div class="goods_img" style="background-image:url('img/test3.jpg')" ></div>
			<div class="goods_info">
				<p class="title">豪车3，亏本大甩卖，走过路过不要错过！</p>
				<p class="tips">汽车/九成新，可小刀，包邮</p>
				<p class="price"><span>￥</span>20000000</p>
			</div>
		</div>
		
	</div>
	<div style="clear:both;"></div>
</ul>
</div>

<div id="data" style="display:none" class="goods_div">
			<div class="goods_img" style="background-image:url('img/test3.jpg')" ></div>
			<div class="goods_info">
				<p class="title">豪车3，亏本大甩卖，走过路过不要错过！</p>
				<p class="tips">汽车/九成新，可小刀，包邮</p>
				<p class="price"><span>￥</span>20000000</p>
			</div>
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

</body>
<script>
	window.jQuery
			|| document.write('<script src="js/jquery.min.js"><\/script>')
</script>
 <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
   <script type="text/javascript" src="js/basic.js"></script>
<script src="js/iscroll.js"></script>
<script src="js/pullToRefresh.js"></script>
<script src="js/reflush.js"></script>

<script type="text/javascript">
	$($(".fa-search")[0]).css("line-height",$($(".fa-search")[0]).css("height"))
	setTooltip("menu_category","category_content");
	
	//下面是强行去掉浏览器工具栏的代码，不过
	//  不能重新获得旋转后正确的 maxScrollY 值， 所以会导致滑不下去
	/* 
 	//强制让内容超过   
	$("html").css("height",window.innerHeight);   
	window.scrollTo(0, 1);   
	//重置成新高度   
	$("html").css("height",window.innerHeight);   
	//非常重要，用于兼容不同机型，防止浏览器窗口移动   
	document.addEventListener('touchmove', function (e) { e.preventDefault(); }, false);  */
	
</script>
</html>