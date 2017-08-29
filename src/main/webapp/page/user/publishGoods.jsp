<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<title>发布信息</title>
<base href="/wbb/">
<link href="css/infoCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" >
<link  rel="stylesheet" href="easyui/css/easyui.css">
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">
<link href="css/publishInfo.css" rel="stylesheet">
</head>
<style>

.title_div{
	width:100%;
	margin-bottom:10px;
	margin-top:10px;
	height:40px;
	line-height:40px;
	background:#fff;
}
.title_input,.detail_input{
	border:none;
	height:90%;
    width:98%;
    font-size: 15px;
    padding: 0;
    padding-left: 5px;
}
.detail_info .detail_input{
	height:40px;
}
hr{
    border-top: none;
    margin: 5px;
}
.detail_info{
	width:100%;
	margin-top:10px;
	background:#fff;
}
.detail_info span{
	height: 40px;
    display: inline-block;
    line-height: 40px;
    padding-left:5px;
    color: #999;
}
.detail_info select{
	height:40px;
	-webkit-appearance:none;
	appearance:none;
	width:50%;
	font-size: 15px;
	border:none;
	padding:0px 10px;
	-webkit-box-sizing:border-box;
	box-sizing:border-box;
	background-color: #FFFFFF;
	color:#333333;
	border-radius:4px;
	color: #999;
}
</style>
<body>
	<div class="header">
		<span class="header_left"><span id="close_span_goods"  class="fa fa-times header_icon"
			aria-hidden="true"></span></span> <span class="header_title">二手广场</span> <span
			class="header_right">发送</span>
	</div>

	<div class="title_div">
		<input class="title_input" placeholder="标 题：" type="text" >
	</div>

	<div class="publish_div">
		<textarea class="publish_content" id="publish_textarea" placeholder="简 介：" ></textarea>
		<div class="tool_bar">
			<span class="face-icon" id="face-icon">☺</span>
			<span id="wordCount">150</span>
		</div>
	</div>

	<div class="img_area">
		<div class="img_area_inner">
			<div class="imgList" id="imgList"></div>
			<div class="img_div" id="plus_div">
				<i class="fa fa-plus" aria-hidden="true"></i>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<input id="add_file" type="file" multiple name="add_file"
		style="display: none">
		
	<div class="detail_info" >
		<input placeholder="价 格（元）：" class="detail_input">
		<hr>
		<span>分 类：</span>
		<select>
			<option>请选择分类 ></option>
			<option>1</option>
		</select>
		<hr>
		<input placeholder="Q Q(选填)：" class="detail_input">
	</div>	
	
</body>

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<script src="js/exif.js"></script>
<script src="js/initLightGallery.js"></script>
<script src="js/publishInfo.js"></script>

</html>