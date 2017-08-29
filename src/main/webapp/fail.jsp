<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<base href="/wbb/">
<title>失败啦！</title>
<style>
	body{
		text-align:center;
	}
</style>
</head>
<body>
	<div id="fail_div">
		<p style="font-size:30px">OH NO!</p>
		<img id="fail_img" src="img/fail.jpg"/>
		<h2>failed！please try again</h2>
		<h3>are you kidding me?</h3>
	</div>
</body>
<script src="js/jquery-2.1.4.min.js"></script>
<script src="js/backStretch.min.js"></script>
<script>
	var isload=false;
	// 可能图片还没有加载完全，没有height
	 $("#fail_img").load(function(){
		setHeigt(); 
		isload=true;
	}) 
	if(!isload){
		// 可能因为缓存不加载图片 
		setHeigt(); 
	}
	
	function setHeigt(){
		var originWidth = $('#fail_img').width;
		var originHeight = $('#fail_img').height;
		if(screen.width < 700){
			$('#fail_img').width(screen.width);
			$("#fail_img").height((screen.width/originWidth)*originHeight)
		}
		var marginTop = (screen.height - $("#fail_div").height())/4
		$("#fail_div").css("margin-top",marginTop);
	}

</script>
</html>