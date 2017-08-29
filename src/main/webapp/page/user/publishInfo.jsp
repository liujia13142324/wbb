<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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
<!-- <link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" > -->
<link  rel="stylesheet" href="easyui/css/easyui.css">
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">
<link href="css/publishInfo.css" rel="stylesheet">
<link rel="stylesheet" href="css/menu.css">

</head>
<body>
	<div class="header">
		<span class="header_left"><span id="close_span" class="fa fa-times header_icon"
			aria-hidden="true"></span></span> <span id="menu_category" class="header_title tooltip-f" themeid="-1">广场</span> <span
			id="publishInfo_send" class="header_right">发送</span>
	</div>

	<div class="publish_div">
		<textarea class="publish_content" id="publish_textarea"></textarea>
		<div class="tool_bar">
			<span class="face-icon" id="face-icon"> ☺ </span>
			<span id="wordCount">300</span>
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
	<div style="display:none;">
		<div id="category_content">
			<c:forEach var="item" items="${themes}">
				<p class="publishTheme_p" id="theme_${item.themeId }">${item.themeName }</p>
			</c:forEach>
		</div>
	
	<input id="add_file" type="file" multiple style="display: none" ><!-- accept="image/*"  好慢-->
</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<script src="js/exif.js"></script>
<script src="js/initLightGallery.js"></script>
<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script src="js/publishInfo.js"></script>
</html>