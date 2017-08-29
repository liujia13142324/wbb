<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<base href="/wbb/">
<title>历史发布</title>
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
.header{
	height:50px;
}
</style>
<body>
<div id="out_div">
   	<div id="inner_div" >
	<div class="header" data-type="history_goods">历史发布</div>
	
	<div id="goodsList" class="dataList">
		<div id="goodsList" class="dataList">
	<c:forEach items="${products }" var="product" varStatus="proStatus">
		<div class="goods_div" onclick="lookGoods(this)">
			<form action="goods/detailGoods" method="post">
			<input type="hidden" name="mainImage.imgId" value="${product.mainImage.imgId }" />
			<input type="hidden" name="mainImage.imgPath" value="${product.mainImage.imgPath }" />
			<input type="hidden" name="goodsId"  value="${product.goodsId }"/>
			<input type="hidden" name="goodsTitle"  value="${product.goodsTitle }"/>
			<input type="hidden" name="tips"  value="${product.tips }"/>
			<input type="hidden" name="price" value="${product.price }" />
			<input type="hidden" name="qq" value="${product.qq }" />
			<input type="hidden" name="publishTime" value="<fmt:formatDate value="${product.publishTime }" pattern="yyyy-MM-dd HH:mm:ss E"/>"/>
			<input type="hidden" name="goodsIntroduction" value="${product.goodsIntroduction }">
				<div class="goods_img" style="background-image:url('${product.mainImage.imgPath }')" ></div>
				<div class="goods_info">
					<p class="title" >${product.goodsTitle }</p>
					<p class="tipss">${product.tips }</p>
					<p class="price"><span>￥</span>${product.price }</p>
				</div>
			</form>
		</div>
	</c:forEach>
	</div>
	<div style="clear:both;"></div>
</div>
</div>
</div>
<div id="right_corner_menu" class="dropup">
	<a href="javascript:void(0);" id="menu_a"><i class="fa fa-bars"   aria-hidden="true"></i></a>
	<div style="display:none;">
		<div id="menu_content" class="goods_menu">
		</div>
	</div>
</div>

</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
 <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
   <script type="text/javascript" src="js/basic.js"></script>
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