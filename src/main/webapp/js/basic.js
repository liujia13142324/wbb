/*document.write("<script src='js/zepto.min.js'></script>")*/
//防止刷新停在原地
scrollTo(0, 1);
var t 
$(function(){
	if(typeof($("#menu_content").attr("class"))=="undefined" || $("#menu_content").attr("class")!="goods_menu"){
		$("#menu_content").append('<p class="menu_p" >写心情</p>'+
				'<p class="menu_p" >我的历史</p>'+
				'<p class="menu_p" >吐槽广场</p>'+
				'<p class="menu_p" >二手广场</p>')
	}else if($("#menu_content").attr("class")=="goods_menu"){
		$("#menu_content").append('<p class="menu_p" >发布二手信息</p>'+
				'<p class="menu_p" >我的发布历史</p>'+
				'<p class="menu_p" >二手广场</p>'+
				'<p class="menu_p" >吐槽广场</p>'
				)
	}
	// 初始化右下角菜单
	setTooltip("right_corner_menu","menu_content");
	setTooltip("menu_category","category_content"); 
})

function setTooltip(id,menuId){
	$('#'+id).tooltip({
		content: function(){
			return $('#'+menuId);
		},
		showEvent: 'click',
		onShow: function(){
			t = $(this);
			t.tooltip('tip').unbind().bind('mouseenter', function(){
				t.tooltip('show');
			}).bind('mouseleave', function(){
				t.tooltip('hide');
			});
			window.onscroll=function(){
				t.tooltip('hide');
			}
		}
	});
}

var starTime 
var startX = startY = endX = endY = 0; 
var sweep
addEventListener("touchend",function(e){
	e.stopPropagation();
	//alert("  class:"+$(e.target).attr("class")+"  "+ $(event.target).attr("class").indexOf("like"));
	//alert("startY:"+startY+"  endY："+endY+" Y:"+(endY-startY)+"  X:"+(endX-startX))
	var endTime = new Date().getTime();
	//alert($(e.target).attr("class").indexOf("theme_p"));
	sweep = endY-startY;//这个值不是很准
	// 点击时间过短,滑动距离过短，就按照点击事件处理 
	if((endY==0 || (endTime-starTime<150&&Math.abs(sweep)<20))&&typeof($(e.target).attr("class"))!="undefined" && $(e.target).attr("class").indexOf("like")<0 ){
		//alert("进来了。。");
		if($(e.target).attr("class").indexOf("menu_p")>=0 ){
			testClick(e.target);
		}else if($(e.target).attr("class").indexOf("theme_p")>=0){
			changeTheme(e.target)
		}else if($(e.target).attr("class").indexOf("publishTheme_p")>=0){
			changeThemeTitle(e.target)
		}
		else{
			//alert("else start");
			//放下面跑不下去？？ what fuck
			//alert("hide");
			hideComment(e);
			//alert($($(".tooltip")[1]).css("display") +"  display2")
			//alert(" e.target:"+$(e.target).attr("class")+$(e.target).attr("class").indexOf("info_div")+" parent:"+$($(e.target).parents(".info_div")).attr("class"))
			//如果菜单打开了先隐藏菜单
			if(typeof($(".tooltip").css("display"))!='undefined'&&($($(".tooltip")[0]).css("display")!="none"||$($(".tooltip")[1]).css("display")!="none")){
				//alert($(".tooltip").css("display") +"  display2")
				//alert(1);
				hideMenu();
				//$(e.target).attr("class").indexOf("info_div")>=0||
				
			}else if(typeof($($(e.target).parents(".info_div")).attr("class"))!='undefined'&&$($(e.target).parents(".info_div")).attr("class").indexOf("info_div")>=0){
				//alert($(e.target).parents(".info_div"))
				//alert(2);
				lookInfo($(e.target).parents(".info_div"), e)
			}
			//alert("else end ");
		}
		//alert("hide");
		hideComment(e);
	}
	startX = startY = endX = endY = 0; 
});

addEventListener("touchstart",function(e){
	starTime = new Date().getTime();
	var touch = e.targetTouches[0];
	startX = touch.pageX;
    startY = touch.pageY;
});

addEventListener("touchmove",function(e){
	 var touch = e.targetTouches[0];
     endX = touch.pageX;
     endY = touch.pageY;
});


function hideMenu(){
	if(t!=null && t!="undefined"){
		t.tooltip('hide');
	}
}

function checkMenuIsHide(){
	if(t!=null && t!="undefined"){
		return false;
	}
	return true;
}
function hideComment(e) {
	//alert($(e.target).attr("id") );
	//e.stopPropagation();
	//console.info($(e.target).attr("id"));
	if(  $(e.target).attr("id") !="comment_text" 
			&& $(e.target).attr("id") !="comment"
				&& $(e.target).attr("id") !="face-icon"
					&& $(e.target).parent().parent().parent().attr("id") !="emotions"
						&& $(e.target).parent().parent().attr("id") !="emotions"
							&& $(e.target).parent().attr("id") !="emotions"
								&& $(e.target).attr("id") !="emotions"){
		$("#emotions").css("display","none");
		//$("#publishComment_div").css("display","none");
		$("#comment_text").blur();
	}
						
}
function sendAsynRequest(requestType,url,RequestData,successHandler){
$.ajax({
	   type: requestType,
	   url: url,
	   data:RequestData,
	   success: successHandler
	});
}

function getCookie(name) {
	var arr, reg = new RegExp("(^| )" + name + "=([^;]*)(;|$)");
	if (arr = document.cookie.match(reg))
		return unescape(arr[2]);
	else
		return null;
}
function delCookie(name) {
	var exp = new Date();
	exp.setTime(exp.getTime() - 1);
	var cval = getCookie(name);
	if (cval != null)
		document.cookie = name + "=" + cval + ";expires=" + exp.toGMTString();
}
function enterCenter(){
	location.href="info/infoCenter"
}

function enterUserHistory(){
	location.href="info/userHistory"
}
function enterPublishInfo(){
	location.href="info/enterPublish"
}
function enterSecondMarket(){
	location.href="goods/goodsCenter"
}

function enterPublishGoods(){
	location.href="goods/enterPublishGoods"
}
function enterUserGoodsHistory(){
	location.href="goods/userHistory"
}

		

function testClick(obj){
	//alert($(obj).text());
	switch($(obj).text()){
	case "写心情": enterPublishInfo(); break;
	case "我的历史": enterUserHistory(); break;
	case "吐槽广场": enterCenter(); break;
	case "发布二手信息": enterPublishGoods(); break;
	case "我的发布历史": enterUserGoodsHistory(); break;
	case "二手广场": enterSecondMarket(); break;
	}
}

function changeTheme(obj){
	var themeId = $(obj).attr("id");
	if(typeof(themeId) != "undefined"){
		themeId = themeId.substr(themeId.indexOf("_")+1);
		$("#menu_category").attr("themeId",themeId);
		location.href="info/infoCenter?themeId="+themeId
	}
}


/**
 * 应该放到publishInfo.js里面，但是，由于basic都写到一起了，na
 * @param obj
 */
function changeThemeTitle(obj){
	var themeId = $(obj).attr("id");
	if(typeof(themeId) != "undefined"){
		themeId = themeId.substr(themeId.indexOf("_")+1);
		$("#menu_category").attr("themeId",themeId);
		//location.href="info/infoCenter?themeId="+themeId
	}
	$("#menu_category").text($(obj).text());
	$($(".tooltip-bottom")[0]).css("display","none");
}

/**
 * 应该放到info里面去，但是需要写在上面，就单独出来一个
 * @param infoId
 * @param index
 */
function setIsLike(infoId,index){
	var islike = getCookie("likeInfo_"+infoId);
	if(typeof(index)!='undefined'){
		if(islike=='true'){
		//	console.info($(".comment").eq(index))
			$(".comment").eq(index).before('<i class="fa fa-heart like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
		}else{
			$(".comment").eq(index).before('<i class="fa fa-heart-o like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
		}
	}else{
		if(islike=='true'){
			$(".comment").eq(0).before('<i class="fa fa-heart like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
			$("#likeMenu").find(".nav_tit").before('<i class="fa fa-heart like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
		}else{
			$(".comment").eq(0).before('<i class="fa fa-heart-o like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
			$("#likeMenu").find(".nav_tit").before('<i class="fa fa-heart-o like" onclick="clickLike(this,'+infoId+',event)" aria-hidden="true"></i>');
		}
	}
}
