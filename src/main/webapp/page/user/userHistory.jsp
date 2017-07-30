<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1">
<meta name="description" content="">
<meta name="author" content="">
<base href="/wbb/">
<title>个人历史</title>
<link href="css/basic.css" rel="stylesheet">
<link href="css/lib.css" rel="stylesheet">
<link href="css/infoCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="css/menu.css">
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">

<script src="js/iscroll.js"></script>
<script src="js/pullToRefresh.js"></script>

<title>个人历史</title>
</head>
<style>
body, html {
	padding: 0;
	margin: 0;
	height: 100%;
	font-family: Arial, Helvetica, sans-serif;
}
*{
    -webkit-box-sizing: border-box;
    -moz-box-sizing: border-box;
    box-sizing: border-box;
}
</style>
<body>
   	<div id="inner_div">
    	<ul>
    	<div class="header">个人历史</div>
    	<div class="dataList">
    		<div class="info_div">
				<div class="user-heading">
					<div class="headImg">
						<img style="width:100%;height:100%;"  src="img/QQ.png"/>
					</div>
					<div class="otherUserInfo">						<!-- fa fa-venus -->
						<p><span>温柔的太阳君</span> &nbsp;<span class="fa fa-mars sex male"></span></p>
						<p class="publishTime">刚刚</p>
					</div>	
				</div>
				<div class="info_body">
					<p class="info_content">你好吗</p>
					<div class="imgList" id="imgList">
						<div class="imgs imgMoreThanTwo" data-src="img/test1.jpg"  style="background-image:url('img/test1.jpg')" ></div>
						<div class="imgs imgMoreThanTwo" data-src="img/test2.jpg"  style="background-image:url('img/test2.jpg')" ></div>
						<div class="imgs imgMoreThanTwo" data-src="img/test3.jpg"  style="background-image:url('img/test3.jpg')" ></div>
					</div>
				</div>
				<div class="x-info" style="clear:both;">
					<div class="x_left">
						<span><span>0</span>喜欢</span>&nbsp;
						<span><span>0</span>评论</span>
					</div>
					<div class="x_right">
						<!-- fa fa-heart -->
						<i class="fa fa-heart like" onclick="clickLike(this)" aria-hidden="true"></i><i class="fa fa-commenting-o comment" aria-hidden="true"></i>
					</div>
					<div class="_clear"></div>
				</div>
			</div>
			
			<div class="info_div">
				<div class="user-heading">
					<div class="headImg">
						<img style="width:100%;height:100%;"  src="img/QQ.png"/>
					</div>
					<div class="otherUserInfo">						<!-- fa fa-venus -->
						<p><span>温柔的太阳君</span> &nbsp;<span class="fa fa-mars sex male"></span></p>
						<p class="publishTime">刚刚</p>
					</div>	
				</div>
				<div class="info_body">
					<p class="info_content">你好吗</p>
					<div class="imgList" id="imgList">
						<div class="imgs imgMoreThanOne" data-src="img/test1.jpg"  style="background-image:url('img/test1.jpg')" ></div>
						<div class="imgs imgMoreThanOne" data-src="img/test2.jpg"  style="background-image:url('img/test2.jpg')" ></div>
					</div>
				</div>
				<div class="x-info" style="clear:both;">
					<div class="x_left">
						<span><span>0</span>喜欢</span>&nbsp;
						<span><span>0</span>评论</span>
					</div>
					<div class="x_right">
						<!-- fa fa-heart -->
						<i class="fa fa-heart like" onclick="clickLike(this)" aria-hidden="true"></i><i class="fa fa-commenting-o comment" aria-hidden="true"></i>
					</div>
					<div class="_clear"></div>
				</div>
			</div>
			
			<div class="info_div">
				<div class="user-heading">
					<div class="headImg">
						<img style="width:100%;height:100%;"  src="img/QQ.png"/>
					</div>
					<div class="otherUserInfo">						<!-- fa fa-venus -->
						<p><span>温柔的太阳君</span> &nbsp;<span class="fa fa-mars sex male"></span></p>
						<p class="publishTime">刚刚</p>
					</div>	
				</div>
				<div class="info_body">
					<p class="info_content">你好吗</p>
					<div class="imgList" id="imgList">
						<img class="onlyImg" data-src="img/test1.jpg" src="img/test1.jpg"/>
					</div>
				</div>
				<div class="x-info" style="clear:both;">
					<div class="x_left">
						<span><span>0</span>喜欢</span>&nbsp;
						<span><span>0</span>评论</span>
					</div>
					<div class="x_right">
						<!-- fa fa-heart -->
						<i class="fa fa-heart like" onclick="clickLike(this)" aria-hidden="true"></i><i class="fa fa-commenting-o comment" aria-hidden="true"></i>
					</div>
					<div class="_clear"></div>
				</div>
			</div>
			
			<div class="info_div">
				<div class="user-heading">
					<div class="headImg">
						<img style="width:100%;height:100%;"  src="img/QQ.png"/>
					</div>
					<div class="otherUserInfo">						<!-- fa fa-venus -->
						<p><span>温柔的太阳君</span> &nbsp;<span class="fa fa-mars sex male"></span></p>
						<p class="publishTime">刚刚</p>
					</div>	
				</div>
				<div class="info_body">
					<p class="info_content">你好吗</p>
					<div class="imgList" id="imgList">
						<img class="onlyImg" data-src="img/IMG_7258.PNG" src="img/IMG_7258.PNG"/>
					</div>
				</div>
				<div class="x-info" style="clear:both;">
					<div class="x_left">
						<span><span>0</span>喜欢</span>&nbsp;
						<span><span>0</span>评论</span>
					</div>
					<div class="x_right">
						<!-- fa fa-heart -->
						<i class="fa fa-heart like" onclick="clickLike(this)" aria-hidden="true"></i><i class="fa fa-commenting-o comment" aria-hidden="true"></i>
					</div>
					<div class="_clear"></div>
				</div>
			</div>
			
    	</div>
		</ul>
	</div>

		
		<div id="right_corner_menu" class="dropup">
			<a href="javascript:void(0);" id="menu_a"><i class="fa fa-bars"   aria-hidden="true"></i></a>
			<div style="display:none;">
				<div id="menu_content">
					<p>写心情</p>
					<p>我的历史</p> 
					<p>吐槽广场</p> 
					<p>二手市场</p> 
				</div>
			</div>
		</div>
		
		<div id="category_menu">
			<a href="javascript:void(0);" id="menu_category">● ● ●</a>
			<div style="display:none;">
				<div id="category_content">
						<p>广场</p>
						<p>表白</p> 
						<p>吐槽</p>
						<p>自恋</p>
				</div>
			</div>
		</div>
		
</body>
 <!-- Bootstrap core JavaScript
    ================================================== -->
  
  
    <!-- Placed at the end of the document so the pages load faster -->
   <!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script src="js/bootstrap.min.js"></script>
   <!--  <script src="js/docs.min.js"></script> -->
    <!-- IE10 viewport hack for Surface/desktop Windows 8 bug -->
    <script src="js/ie10-viewport-bug-workaround.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
    <script type="text/javascript" src="js/info.js"></script>
    <script src="js/reflush.js"></script>
    <script src="js/initLightGallery.js"></script>
    <script>
    	setTooltip("menu_category","category_content"); 
    	$(".imgList").each(function(){
    		initLightGallerys(this)
    	})
    </script>
    
</html>