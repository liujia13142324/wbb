<%@page import="com.l.wbb.bean.Info"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
	<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
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

<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/basic.js"></script>
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
    	<div class="header" data-type="history_info">个人历史</div>
    	<div class="dataList">
    		<c:forEach items="${infos }" var="info" varStatus="infoStatus">
					<div class="info_div"  >
					<form action="info/detailInfo" method="post">
					<input type="hidden" name="infoId" value="${info.infoId}"/>
					<input type="hidden" name="user.headimgurl" value="${info.user.headimgurl }"/>
					<input type="hidden" name="user.nickname" value="${info.user.nickname }"/>
					<input type="hidden" name="user.sex" value="${info.user.sex }"/>
					<input type="hidden" name="publishTime" value="<fmt:formatDate value="${info.publishTime }" pattern="yyyy-MM-dd HH:mm:ss E"/>"/>
					<input type="hidden" name="infoContent" value="${info.infoContent }"/>
					<c:forEach items="${info.imgs }" var="img" varStatus="status">
						<input type="hidden" name="imgs[${status.index }]" value="${img.imgPath }"/>
					</c:forEach>
						<div class="user-heading">
							<div class="headImg">
								<img style="width:100%;height:100%;" class="headimgurl" src="${info.user.headimgurl }"/>
							</div>
							<div class="otherUserInfo">						
								<p><span class="nickname">${info.user.nickname }</span> &nbsp;
								<c:choose>
									<c:when test="${info.user.sex==1 }">
										<span sex="${info.user.sex }" class="fa fa-mars sex male"></span>
									</c:when>
									<c:otherwise>
										<span sex="${info.user.sex }" class="fa fa-venus sex female"></span>
									</c:otherwise>
								</c:choose>
								</p>
								<p class="publishTime"><fmt:formatDate value="${info.publishTime }" pattern="yyyy-MM-dd HH:mm:ss E"/></p>
							</div>	
						</div>
						<div class="info_body">
							<p class="info_content">${info.infoContent }</p>
							<div class="imgList" id="imgList">
								<c:choose>
									<c:when test="${fn:length(info.imgs) ==1}">
										<img class="onlyImg imgPath" data-src="${info.imgs[0].imgPath }" src="${info.imgs[0].imgPath }"/>
									</c:when>
									<c:when test="${fn:length(info.imgs) ==2}">
										<div class="imgs imgMoreThanOne imgPath" data-src="${info.imgs[0].imgPath }"  style="background-image:url('${info.imgs[0].imgPath }')" ></div>
										<div class="imgs imgMoreThanOne imgPath" data-src="${info.imgs[1].imgPath }"  style="background-image:url('${info.imgs[1].imgPath }')" ></div>
									</c:when>
									<c:when test="${fn:length(info.imgs) >2}">
										<c:forEach items="${info.imgs }" var="img" varStatus="status">
											<div class="imgs imgMoreThanTwo imgPath"  data-src="${img.imgPath }"  style="background-image:url('${img.imgPath }')" ></div>
											<%-- <input type="hidden" name="imgs[${status.index }]" value="${info.imgs[0].imgPath }"/> 这里面的循环，会让lightGallery失效--%>
										</c:forEach>
									</c:when>
								</c:choose>
							</div>
							<div style="clear:both"></div>
						</div>
						
						<div class="x-info" style="clear:both;">
							<div class="x_left">
								<span><span class="likeSpan">${fn:length(info.likeinfo)}</span>喜欢</span>&nbsp;
								<span><span class="commentCount">${info.commentCount }</span>评论</span>
							</div>
							<div class="x_right">
								<!-- fa fa-heart -->
								<!-- 需要有user来测试点赞 -->
								<i class="fa fa-commenting-o comment" aria-hidden="true"></i>
								<script type="text/javascript">setIsLike('${info.infoId}','${infoStatus.index}')</script>
							</div>
							<div class="_clear"></div>
						</div>
						</form>
					</div>
			</c:forEach>   
    	</div>
		</ul>
	</div>

		
		<div id="right_corner_menu" class="dropup">
			<a href="javascript:void(0);" id="menu_a"><i class="fa fa-bars"   aria-hidden="true"></i></a>
			<div style="display:none;">
				<div id="menu_content">
				</div>
			</div>
		</div>
		
</body>
  
  
    <script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
  	<script type="text/javascript" src="js/jquery.sinaEmotion.js"></script>
 	<script src="js/initLightGallery.js"></script>
 	<script type="text/javascript" src="js/info.js"></script>
 	 <script src="js/infoCenter.js"></script>
    <script type="text/javascript" src="js/dateFormat.js"></script>
    <script src="js/reflush.js"></script>
</html>