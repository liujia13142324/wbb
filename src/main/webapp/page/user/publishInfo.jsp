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
<body>
	<div class="header">
		<span class="header_left"><span class="fa fa-times header_icon"
			aria-hidden="true"></span></span> <span class="header_title">广场</span> <span
			class="header_right">发送</span>
	</div>

	<div class="publish_div">
		<textarea class="publish_content" id="publish_textarea"></textarea>
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
	<input id="add_file" type="file" multiple style="display: none">
	
</body>

<script>
	window.jQuery
			|| document.write('<script src="js/jquery.min.js"><\/script>')
</script>
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<script src="js/exif.js"></script>
<script src="js/initLightGallery.js"></script>
<!-- 图片自适应的包  -->
<!-- <script src="js/backStretch.min.js"></script> -->
<script src="js/publishInfo.js"></script>
</html>