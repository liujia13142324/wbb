$(".imgList img").attr("height",$(".imgList img")[0].width)
$(".x_left").css("line-height",$(".x_right").css("height"))

// 旋转自适应
/*function orientationChange(){
		$(".imgList img").attr("height",$(".imgList img")[0].width)
}
addEventListener('load', function(){
    orientationChange();
    window.onorientationchange = orientationChange;
    $("comment_text").keyup(function(){
    	
    })
});
var bottom_obj;
var inner_obj;
var data;
window.onload=function(){
	var out_obj=document;
	inner_obj=document.getElementById("inner_div");
	bottom_obj=document.getElementById("bottom_div");
	data=document.getElementById("data");
	
	out_obj.onscroll=function(){  
		if($(document).height() == $(window).height() + $(window).scrollTop()){
			bottom_obj.style.display="block";
			window.setTimeout("addData()",1000);
		}			
	}		
}
//定时器的方法要写在 onload 外面 
function addData(){
	var str=inner_obj.innerHTML+=data.innerHTML;
	inner_obj.innerHTML=str;
	bottom_obj.style.display="none";	
}
*/
function clickLike(obj){
	if($(obj).attr("class").indexOf("fa-heart-o")>0){
		$(obj).removeClass("fa-heart-o").addClass("fa-heart");
	}else if($(obj).attr("class").indexOf("fa-heart")>0){
		$(obj).removeClass("fa-heart").addClass("fa-heart-o");
	}
}