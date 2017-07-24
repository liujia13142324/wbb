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
<title>发布详情</title>
<link href="css/basic.css" rel="stylesheet">
<link href="css/lib.css" rel="stylesheet">
<link href="css/infoCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="css/comment.css"/>
<title>发布详情</title>
</head>
<style>
#emotions .container a{
	height: auto;
}
#emotions #prev, #emotions #next{
	height:auto;
}
</style>
<body>
<div id="inner_div">
	<ul>
<div class="header">发布详情</div>
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
		<div class="imgList">
			<img/><img /><img /><img /><img /><img />
		</div>
	</div>
	<div class="x-info" style="clear:both;">
		<div class="x_left">
			<span><span>0</span>喜欢</span>&nbsp;
			<span><span>0</span>评论</span>
		</div>
		<div class="x_right">
			<!-- fa fa-heart -->
			<i class="fa fa-heart like" onclick="clickLike(this)" aria-hidden="true"></i><i class="fa fa-commenting-o comment" id="comment" aria-hidden="true"></i>
		</div>
		<div class="_clear"></div>
	</div>
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
					<p>写心情</p>
					<p>我的历史</p> 
				</div>
			</div>
		</div>

<div id="publishComment_div">
<span class="face-icon" id="face-icon">☺</span><textarea id="comment_text"  class="text"  placeholder="输入你的评论"></textarea>
</div> 

 
</body>
<!--  <script src="https://ajax.googleapis.com/ajax/libs/jquery/1.12.4/jquery.min.js"></script> -->
    <script>window.jQuery || document.write('<script src="js/jquery.min.js"><\/script>')</script>
    <script type="text/javascript" src="js/picturefill.min.js"></script>
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
    <script type="text/javascript" src="js/info.js"></script>
    <script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
    <script type="text/javascript" src="js/jquery.flexText.min.js"></script>
    <script src="js/iscroll.js"></script>
	<script src="js/pullToRefresh.js"></script>
	<script src="js/reflush.js"></script>
	 <script type="text/javascript" src="js/comment.js"></script>
    <script type="text/javascript">
    	$('.face-icon').SinaEmotion($('.text'),0);
    	
    	/* 
    	$("textarea").keydown(function(){
    		event.preventDefault();
    		if(event.which == 13){
    			alert("hello world")
    		}
    	}) */
    	
    </script>
</html>