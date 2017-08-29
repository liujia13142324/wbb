<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta charset="utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<base href="/wbb/">
<title>二手市场</title>
</head>
<link href="css/basic.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/goodsCenter.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/common.css">
<style>
#right_corner_menu{
	border-color:#777;
    background: #777;
}
*{
box-sizing: content-box;
}
#goodsList{
margin-bottom:10px;
}
</style>
<body>
<div id="out_div">
   	<div id="inner_div" >
	<div class="header" data-type="goodsInfo">二手市场</div>
	<div class="tool_div">
		<span class="select_span">
			<select cateId="-1" id="category">
				<option  cateId="-1">全部</option>
				<c:forEach items="${categories }" var="categorie" varStatus="categorieStatus">
					<option cateId="${categorie.categoryId }">${categorie.name }</option>
				</c:forEach>
			</select><i class="fa fa-angle-down" style="color:#999;" aria-hidden="true"></i>
		</span><span class="search_span">
			<input id="search_input" type="text"/><i class="fa fa-search" aria-hidden="true"></i>
		</span>
	</div>
	
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
				<input type="hidden" name="commentCount" value="${product.commentCount }">	
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
<script type="text/javascript" src="js/dateFormat.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
<script src="js/pullToRefresh.js"></script>
<script src="js/reflush.js"></script>
<script type="text/javascript" src="js/common.js"></script>
<script type="text/javascript">
	$("#pullUp").css("height","40px");
	$($(".fa-search")[0]).css("line-height",$($(".fa-search")[0]).css("height"))
	setTooltip("menu_category","category_content");
	$("#category").change(function(e){
		var ops = this.options
		var categoryId = $(ops[this.selectedIndex]).attr("cateId")
		$("#category").attr("cateId",categoryId);
		$.showLoad("加载页面");
		sendAsynRequest("post", "goods/getCategoryGoods", {"categoryId":categoryId}, function(data){
			$(".goods_div").remove();
			displayGoods(data);
			$.hideLoad();
		})
		
	})
	function lookGoods(obj){
		if($(".tooltip").css("display") == "block"){
			$(".tooltip").css("display","none")
		}else{
			$(obj).find("form").submit();
		}
	}
	
	$(".fa-search").click(function(){
		var searchCondition = $("#search_input").val();
		if(searchCondition.length>0){
			searchCondition = "%"+searchCondition+"%";
			$.showLoad("加载页面");
			sendAsynRequest("post", "goods/getGoodsBySearch", {"searchCondition":searchCondition}, function(data){
				console.info(data)
				$(".goods_div").remove();
				displayGoods(data);
				$.hideLoad();
			})	
		}
	})
	
</script>
</html>