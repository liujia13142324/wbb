<%@page import="com.l.wbb.bean.Info"%>
<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions"%> 
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
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
<link href="css/infoCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="easyui/css/easyui.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" href="css/style.css">
<link rel="stylesheet" href="css/menu.css">
<link rel="stylesheet" href="css/pullToRefresh.css"/>
<link rel="stylesheet" href="css/comment.css"/>
<link rel="stylesheet" href="css/jquery.sinaEmotion.css"/>
<link rel="stylesheet" href="css/common.css"/>
<link href="lightGallery/css/lightgallery.css" rel="stylesheet">
<title>发布详情</title>
</head>
<style>
</style>
<body>
<div id="out_div">
   	<div id="inner_div" >
<div class="header" data-type="comment">发布详情</div>
<div class="info_div">
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
		<input id="infoId" value="${info.infoId }" type="hidden"/>
		<div class="headImg">
			<img style="width:100%;height:100%;"  src="${info.user.headimgurl }"/>
		</div>
		<div class="otherUserInfo">						<!-- fa fa-venus -->
			<p><span>${info.user.nickname }</span> &nbsp;
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
						<div class="imgs imgMoreThanTwo imgPath" data-src="${img.imgPath }"  style="background-image:url('${img.imgPath }')" ></div>
					</c:forEach>
				</c:when>
			</c:choose>
		</div>
	</div>
		<div class="x-info" style="clear:both;">
		<div class="x_left">
	 	<%
			
				Info info = (Info)request.getAttribute("info");
	 	//     莫名其妙取不到cookies,得深入研究
	 	/* 		Cookie[] cookies = request.getCookies();
			 	boolean islike = false;
				int likeCount = 0;
				for(Cookie c:cookies){
					System.out.println("infoDetail--->"+c.getName() +"  "+c.getValue());
					if(c.getName().equals("likeInfo_"+info.getInfoId())){
						islike = Boolean.valueOf(c.getValue());
						break;
					}
					if(c.getName().equals("likeCount_"+info.getInfoId())){
						likeCount = Integer.parseInt(c.getValue());
						break;
					}
				}
				request.setAttribute("islike", islike);
				request.setAttribute("likeCount", likeCount); */
			%>	 
			<%-- el表达式取 cookie
			${cookie.likeCount_1.value}
			${cookie.likeInfo_1.value} 
			--%>
			<span><span id="likeSpan" class="likeSpan"></span>喜欢</span>&nbsp;
			<span><span id="commentCount" class="commentCount"></span>评论</span>
		</div>
		<div class="x_right">
			<!-- fa fa-heart -->
		<%-- <c:choose>
				<c:when test="${islike}">
					<i class="fa fa-heart like" onclick="clickLike(this,${info.infoId},event)" aria-hidden="true"></i>
				</c:when>
				<c:otherwise>
					<i class="fa fa-heart-o like" onclick="clickLike(this,${info.infoId},event)" aria-hidden="true"></i>
				</c:otherwise>
		</c:choose> --%>
			
			
			<i class="fa fa-commenting-o comment" id="comment" aria-hidden="true"></i>
		</div>
		<div class="_clear"></div>
	</div>
	</form>
</div>
<div id="comment_list"  class="comment_list">
	<p class="comment_list_header">全部<span class="commentCount"></span>条评论</p>
	<c:forEach var="comment" items="${comments }"  varStatus="status">
		 <div class="comment_div">
			<div class="user-heading">
				<div class="headImg">
					
					<img style="width:100%;height:100%;"  src="${comment.user.headimgurl }"/>
				</div>
				<div class="otherInfo">
					<p><span>${comment.user.nickname }</span> (<span class="floor">${status.index+1 }</span>楼)</p>
				 	<p class="publishTime"><fmt:formatDate value="${comment.publishDate }" pattern="yyyy-MM-dd HH:mm:ss E"/></p>
					<p class="commentContent">${comment.commentContent }</p>
				</div>	
			</div>
		</div> 
	</c:forEach>
	<div id="commentList_clear" style="clear:both;"></div>
</div>
</div>
</div>
<div class="clearfix blank_bottom"></div>
		<div class="navbar nav_fix_bottom">
			<div class="item_link nav">
				<div class="item_cell">
					<a class="nav_icon" href="info/infoCenter">
						<span class="icons icon-home">
						<i class="fa fa-home" aria-hidden="true"></i>
							<span class="nav_tit">首页</span>
						</span>
					</a>
				</div>
				<div class="item_cell" onclick="clickComment()">
					<a class="nav_icon"><span class="icons icon-user">
					<i class="fa fa-commenting-o comment" aria-hidden="true"></i>
						<span class="nav_tit">评论</span>
					</span></a>
				</div>
				<div class="item_cell" id="likeMenu">
					<a class="nav_icon"><span class="icons icon-user">
						<span class="nav_tit">点赞</span>
					</span></a>
				</div>

			</div>
		</div>
<div id="publishComment_div" >
	<div class="comment_user">
		<div class="headImg">
			<img style="width:100%;height:100%;" src="${sessionScope.user.headimgurl }">
		</div>
		<p id="comment_userNike">${sessionScope.user.nickname }</p>
	</div>

	<textarea id="comment_text"  class="text"  placeholder="输入你的评论"></textarea>
	<div class="comment_bottom">
		<span class="face-icon" id="face-icon">☺</span>
		<button disabled="disabled" id="comment_button" class="comment_button">发 送</button>
		<button id="cancel_bottom" class="comment_button">取消</button>
		<span style=" display: inline-block; width: 38px;"></span>
	</div>
</div> 
 
</body>
	<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>    
	<script type="text/javascript" src="easyui/jquery.easyui.min.js"></script>
   	<script type="text/javascript" src="js/jquery.sinaEmotion.js"></script>
   	<script src="js/initLightGallery.js"></script>
    <script type="text/javascript" src="js/basic.js"></script>
    <script src="js/pullToRefresh.js"></script>
    <script type="text/javascript" src="js/info.js"></script>
    <script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
    <script type="text/javascript" src="js/jquery.flexText.min.js"></script>
	<script src="js/reflush.js"></script>
	<script type="text/javascript" src="js/dateFormat.js"></script> 
	<script type="text/javascript" src="js/common.js"></script>
	<script type="text/javascript" src="js/comment.js"></script>
</html>