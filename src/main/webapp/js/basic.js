
setTooltip("menu_a","menu_content");
var t 
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
