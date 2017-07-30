

$(".comment").click(function(){
	$("#publishComment_div").css("display","block");
})
$("#comment_text").attr("placeholder","输入你的评论...")

$(function () {
    $('#comment_text').flexText();
});

document.onclick = function(e){
	hideComment(e);
}
