
var pullUpEl
var Refresh =function Refresh() {
	location.reload(true);
}

var LoadGoods = function LoadGoods() {
	var cateid = $("#category").attr("cateid");
	var start = $(".goods_div").length ;
	var isLast = $(".goods_div").length%10 > 0
	//除了第一条最大的查出来，都还得多查一条
	var offset = 10;
	//如果没有到最后，就可以刷新，否则就不用再刷新
	if(!isLast){
		if(cateid<0){
			sendAsynRequest("get", "goods/getGoodsByScroll", {"start":start,"offset":offset}, function(data){
				displayGoods(data);
				refresher.result=true;
				judgeIsBottom(data)
			})
		}else{
			sendAsynRequest("get", "goods/getCategoryGoodsByScroll", {"categoryId": cateid ,"start":start,"offset":offset}, function(data){
				displayGoods(data);
				refresher.result=true;
				judgeIsBottom(data)
			})
		}
	}else{
		//如果页面本来就不够10条，直接到底
		refresher.result=true;
		setBottom()
	}
}
var LoadInfo = function LoadInfo(){
	//console.info("down ");
	
	var themeid = $($(".header")[0]).attr("themeid");
	var start = (Math.floor($(".info_div").length/10)-1)*10+9;
	var isLast = $(".info_div").length%10 > 0
	//除了第一条最大的查出来，都还得多查一条
	var offset = 10;
	//如果没有到最后，就可以刷新，否则就不用再刷新
	if(!isLast){
		if(themeid<0){
			sendAsynRequest("get", "info/getInfoByScroll", {"start":start,"offset":offset}, function(data){
				displayInfo(data);
				refresher.result=true;
				judgeIsBottom(data)
			})
		}else{
			//themeId>0的时候，即加载相关主题下面的信息
			sendAsynRequest("get", "info/getThemeInfoByScroll", {"ThemeId": themeid ,"start":start,"offset":offset}, function(data){
				displayInfo(data);
				refresher.result=true;
				judgeIsBottom(data)
			})
		}
	}else{
		//如果页面本来就不够10条，直接到底
		refresher.result=true;
		setBottom()
	}
	
}

var LoadUserHistoryGoods = function(){
}
var LoadUserHistoryInfo = function(){
}
var LoadGoodsComment = function(){
	var goodsId = $("#goodsId").val();
	var start = $(".comment_div").length
	var isLast = $(".comment_div").length%10 > 0
	//除了第一条最大的查出来，都还得多查一条
	var offset = 10;
	//如果没有到最后，就可以刷新，否则就不用再刷新
	if(!isLast){
			sendAsynRequest("get", "goods/getGoodsCommentByScroll", {"goodsId":goodsId,"start":start,"offset":offset}, function(data){
				dispalyComment(data);
				//refresher.result 当数据加载完毕，去掉loadding的样式
				refresher.result=true;
				judgeIsBottom(data)
			})
	}else{
		//如果页面本来就不够10条，直接到底
		refresher.result=true;
		setBottom()
	}
}

var LoadComment = function(){
	var infoId = $("#infoId").val();
	var start = $(".comment_div").length
	var isLast = $(".comment_div").length%10 > 0
	//除了第一条最大的查出来，都还得多查一条
	var offset = 10;
	//如果没有到最后，就可以刷新，否则就不用再刷新
	if(!isLast){
			sendAsynRequest("get", "info/getCommentByScroll", {"infoId":infoId,"start":start,"offset":offset}, function(data){
				dispalyComment(data);
				refresher.result=true;
				judgeIsBottom(data);
			})
	}else{
		//如果页面本来就不够10条，直接到底
		refresher.result=true;
		setBottom()
	}
}

var header_div = $($(".header")[0])

if(header_div.attr("data-type")=='goodsInfo'){
	initIscroll(Refresh,LoadGoods);
}else if(header_div.attr("data-type")=='goods_comment'){
	initIscroll(Refresh,LoadGoodsComment);
}else if(header_div.attr("data-type")=='info'){
	initIscroll(Refresh,LoadInfo);
}else if(header_div.attr("data-type")=="comment"){
	initIscroll(Refresh,LoadComment);
}/*else if($($(".header")[0]).attr("data-type")=="history_info"){
	initIscroll(Refresh,LoadUserHistoryInfo);
}else if($($(".header")[0]).attr("data-type")=='history_goods'){
	initIscroll(Refresh,LoadUserHistoryGoods);
}*/



function initIscroll(Refresh,Load){
	var refreshera = refresher.init({
		pullDownAction:Refresh,
		pullUpAction:Load
	});
	pullUpEl =  document.getElementById('pullUp');
}


window.onorientationchange = function(){
	// 不能重新获得旋转后正确的 maxScrollY 值
/*	refreshera = refresher.init({
		id:"inner_div",
		pullDownAction:Refresh,
		pullUpAction:Load,
		onBeforeScrollStart:function (e) {
			var target = e.target;
			while (target.nodeType != 1) target = target.parentNode;
			if (target.tagName != 'SELECT'&& target.tagName != 'INPUT' & target.tagName != 'TEXTAREA')
				e.preventDefault();
			}
	});*/
}

function dispalyComment(data){
	var floor = parseInt($(".floor").last().text());
	for(var i=0 ; i<data.length ; i++){
		$("#commentList_clear").before('<div class="comment_div">'
								+'<div class="user-heading">'
								+'<div class="headImg">'
								+'<img style="width:100%;height:100%;"  src="'+data[i].user.headimgurl+'"/>'
								+'</div>'
								+'<div class="otherInfo">'
								+'<p><span>'+data[i].user.nickname+'</span> (<span class="floor">'+(++floor)+'</span>楼)</p>'
								+'<p class="publishTime">'+FormatDate(data[i].publishDate)+'</p>'
								+'<p class="commentContent">'+data[i].commentContent+'</p>'
								+'</div>'
								+'</div>'
								+'</div> ');
	}
}

function displayInfo(data){
	// 第一条info为最火，不需要每次都取，实际查出来 11条数据
	for(var i=1; i<data.length ; i++){
		var sexStr=""
		if(data[i].user.sex==1){
			sexStr='<span sex="1" class="fa fa-mars sex male"></span>'
		}else if(data[i].user.sex==2){
			sexStr='<span sex="2" class="fa fa-venus sex female"></span>'
		}
		var imgs = data[i].imgs;
		var imgStr="";
		if(imgs.length>0){
			if(imgs.length == 1){
				imgStr='<img class="onlyImg imgPath" data-src="'+imgs[0].imgPath+'" src="'+imgs[0].imgPath+'"/>';
			}else if(imgs.length == 2){
				imgStr='<div class="imgs imgMoreThanOne imgPath" data-src="'+imgs[0].imgPath+'"  style="background-image:url('+imgs[0].imgPath+')" ></div>'+
					   '<div class="imgs imgMoreThanOne imgPath" data-src="'+imgs[1].imgPath+'"  style="background-image:url('+imgs[1].imgPath+')" ></div>'
			}else if(imgs.length > 2){
				for(var j=0 ; j<imgs.length ; j++){
					imgStr += '<div class="imgs imgMoreThanTwo imgPath"  data-src="'+imgs[j].imgPath+'"  style="background-image:url('+imgs[j].imgPath+')" ></div>';
				}
			}
		}
		var imgsInputStr = "";
		for(var j=0 ; j<imgs.length ; j++){
			imgsInputStr += '<input type="hidden" name="imgs['+j+']" value="'+imgs[j].imgPath+'"/>';
		}
		
		var likeStr = "";
		
		var likeCookie = getCookie("likeInfo_"+data[i].infoId);	
		
		//console.info(likeCookie);
		if(likeCookie==null || likeCookie=='false'){
			likeStr='<i class="fa fa-heart-o like" onclick="clickLike(this,'+data[i].infoId+',event)" aria-hidden="true"></i>';
		}else if(likeCookie == 'true'){
			likeStr='<i class="fa fa-heart like" onclick="clickLike(this,'+data[i].infoId+',event)" aria-hidden="true"></i>'
		}
		$(".info_div").last().after('<div  class="info_div">'+
				'<form action="info/detailInfo" method="post">'+
				'<input type="hidden" name="infoId" value="'+data[i].infoId+'">'+
				'<input type="hidden" name="user.headimgurl" value="'+data[i].user.headimgurl+'">'+
				'<input type="hidden" name="user.nickname" value="'+data[i].user.nickname+'">'+
				'<input type="hidden" name="user.sex" value="'+data[i].user.sex+'">'+
				'<input type="hidden" name="publishTime" value="'+FormatDate(data[i].publishTime)+'">'+
				'<input type="hidden" name="infoContent" value="'+data[i].infoContent+'">'+
				imgsInputStr+
				'<div class="user-heading">'+
				'<div class="headImg">'+
				'<img style="width:100%;height:100%;" class="headimgurl" src="'+data[i].user.headimgurl+'">'+
				'</div>'+
				'<div class="otherUserInfo">'+
				'<p><span class="nickname">'+data[i].user.nickname+'</span> &nbsp;'+
				sexStr+
				'</p>'+
				'<p class="publishTime">'+FormatDate(data[i].publishTime)+'</p>'+
				'</div>	'+
				'</div>'+
				'<div class="info_body">'+
				'<p class="info_content">'+data[i].infoContent+'</p>'+
				'<div class="imgList" id="imgList'+data[i].infoId+'" >'
				+imgStr+
				'</div>'+
				'<div style="clear:both"></div>'+
				'</div>'+
				'<div class="x-info" style="clear:both;">'+
				'<div class="x_left" style="line-height: 40px;">'+
				'<span><span class="likeSpan">'+data[i].likeinfo.length+'</span>喜欢</span>&nbsp;'+
				'<span><span class="commentCount">'+data[i].commentCount+'</span>评论</span>'+
				'</div>'+
				'<div class="x_right">'+
				likeStr+
				'<i class="fa fa-commenting-o comment" aria-hidden="true"></i>'+
				'</div>'+
				'<div class="_clear"></div>'+
				'</div>'+
				'</form>'+
				'</div>');
		// 初始化查看器
		initLightGallery("imgList"+data[i].infoId)
		
	}
	//解析表情
	$(".info_content").parseEmotion();
	//响应图片格式
	initImg();
}

function displayGoods(data){
	for(var i=0 ; i<data.length ; i++){
		$("#goodsList").append('<div class="goods_div" onclick="lookGoods(this)">'+
			   '<form action="goods/detailGoods" method="post">'+
			   '<input type="hidden" name="mainImage.imgId" value="'+data[i].mainImage.imgId +'" />'+
			   '<input type="hidden" name="mainImage.imgPath" value='+data[i].mainImage.imgPath +'" />'+
			   '<input type="hidden" name="goodsId"  value="'+data[i].goodsId+'"/>'+
			   '<input type="hidden" name="goodsTitle"  value="'+data[i].goodsTitle+'"/>'+
			   '<input type="hidden" name="tips"  value="'+data[i].tips+'"/>'+
			   '<input type="hidden" name="price" value="'+data[i].price+'" />'+
			   '<input type="hidden" name="qq" value="'+data[i].qq+'" />'+
			   '<input type="hidden" name="publishTime" value="'+FormatDate(data[i].publishTime)+'">'+
			   '<input type="hidden" name="goodsIntroduction" value="'+data[i].goodsIntroduction+'">'+
			   '<div class="goods_img" style="background-image:url('+data[i].mainImage.imgPath+')" ></div>'+
			   '<div class="goods_info">'+
			   '<p class="title" >'+data[i].goodsTitle+'</p>'+
			   '<p class="tipss">'+data[i].tips+'</p>'+
			   '<p class="price"><span>￥</span>'+data[i].price+'</p>'+
			   '</div>'+
			   '</form>'+
			   '</div>')
	}
	
}

function judgeIsBottom(data){
	if(data.length<10){
		refresher.isBottom = true;
		setTimeout(function(){
			pullUpEl.querySelector('.pullUpLabel').innerHTML =  refresher.info.atBottom;
		}, 1000)
	}
}
function setBottom(){
	refresher.isBottom = true;
	setTimeout(function(){
		pullUpEl.querySelector('.pullUpLabel').innerHTML =  refresher.info.atBottom;
	}, 1200)
}