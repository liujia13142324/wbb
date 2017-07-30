
/**
* @author 夏の寒风
 * @time 2012-12-14
 */

//自定义hashtable
function Hashtable() {
    this._hash = new Object();
    this.put = function(key, value) {
        if (typeof (key) != "undefined") {
            if (this.containsKey(key) == false) {
                this._hash[key] = typeof (value) == "undefined" ? null : value;
                return true;
            } else {
                return false;
            }
        } else {
            return false;
        }
    }
    this.remove = function(key) { delete this._hash[key]; }
    this.size = function() { var i = 0; for (var k in this._hash) { i++; } return i; }
    this.get = function(key) { return this._hash[key]; }
    this.containsKey = function(key) { return typeof (this._hash[key]) != "undefined"; }
    this.clear = function() { for (var k in this._hash) { delete this._hash[k]; } }
}


var emotions = new Array();
var categorys = new Array();// 分组
var uSinaEmotionsHt = new Hashtable();

// 初始化缓存，页面仅仅加载一次就可以了
$(function() {
	var app_id = '1362404091';
	$.ajax( {
		dataType : 'jsonp',
		url : 'https://api.weibo.com/2/emotions.json?source=' + app_id,
		success : function(response) {
			var data = response.data;
			for ( var i in data) {
				if (data[i].category == '') {
					data[i].category = '默认';
				}
				if (emotions[data[i].category] == undefined) {
					emotions[data[i].category] = new Array();
					categorys.push(data[i].category);
				}
				emotions[data[i].category].push( {
					name : data[i].phrase,
					icon : data[i].icon
				});
				uSinaEmotionsHt.put(data[i].phrase, data[i].icon);
			}
		}
	});
});

//替换
function AnalyticEmotion(s) {
	if(typeof (s) != "undefined") {
		var sArr = s.match(/\[.*?\]/g);
		if(null!=sArr && '' != sArr){
			for(var i = 0; i < sArr.length; i++){
				if(uSinaEmotionsHt.containsKey(sArr[i])) {
					var reStr = "<img src=\"" + uSinaEmotionsHt.get(sArr[i]) + "\" height=\"22\" width=\"22\" />";
					s = s.replace(sArr[i], reStr);
				}
			}
		}
		
	}
	return s;
}
//如果想上打开表情框，需要重新定位
function setPositonUp(target,position){
	if(position == 0){
		var topPx =  target.offset().top - target.height() ;
		var newTop = topPx -$('#emotions').height();
		$('#emotions').css("top",newTop) ;
	}
	return newTop;
}

(function($){
	$.fn.SinaEmotion = function(target,position){
		var cat_current;
		var cat_page;
		$(this).click(function(event){
			event.stopPropagation();
			//写死，防止失去焦点
			$("#comment_text").focus();
			var eTop 
			var newTop
			if(position ==1 ){
				eTop = target.offset().top + target.height() + 15;
			}else if(position == 0){
				eTop = target.offset().top - target.height() ;
				if($('#emotions').height()!=null){
					eTop = newTop;
				}
			}
			var eLeft = target.offset().left - 1;
			
			if($('#emotions .categorys')[0]){
				$('#emotions').css({top: eTop, left: eLeft});
				$('#emotions').toggle();
				return;
			}
			$('body').append('<div id="emotions"></div>');
			
			$('#emotions').css({top: eTop, left: eLeft});
			
			$('#emotions').html('<div>正在加载，请稍候...</div>');
			$('#emotions').click(function(event){
				event.stopPropagation();
				$("#comment_text").focus();
			});
			$('#emotions').html('<div style="float:right"><a href="javascript:void(0);" id="prev">&laquo;</a><a href="javascript:void(0);" id="next">&raquo;</a></div><div class="categorys"></div><div class="container"></div>');
			$('#emotions #prev').click(function(){
				showCategorys(cat_page - 1);
				
			});
			$('#emotions #next').click(function(){
				showCategorys(cat_page + 1);
			});
			
			
			// 下面是让表情框正常滑动的代码, 缺点：--》每滑倒两端的时候要额外滑动一次才能恢复正常滑动
			var container = document.getElementsByClassName("container")[0];
			var startx, starty;
			var direct;
		    //获得角度
		    function getAngle(angx, angy) {
		        return Math.atan2(angy, angx) * 180 / Math.PI;
		    };

		    //根据起点终点返回方向 1向上 2向下 3向左 4向右 0未滑动
		    function getDirection(startx, starty, endx, endy) {
		        var angx = endx - startx;
		        var angy = endy - starty;
		        var result = 0;

		        //如果滑动距离太短
		        if (Math.abs(angx) < 2 && Math.abs(angy) < 2) {
		            return result;
		        }

		        var angle = getAngle(angx, angy);
		        if (angle >= -135 && angle <= -45) {
		            result = 1;
		        } else if (angle > 45 && angle < 135) {
		            result = 2;
		        } else if ((angle >= 135 && angle <= 180) || (angle >= -180 && angle < -135)) {
		            result = 3;
		        } else if (angle >= -45 && angle <= 45) {
		            result = 4;
		        }

		        return result;
		    }
		    
		    function printDirectionInfo(direction){
		    	switch (direction) {
	            case 0:
	                console.info("未滑动！");
	                break;
	            case 1:
	            	 console.info("向上！")
	                break;
	            case 2:
	            	 console.info("向下！")
	                break;
	            case 3:
	            	 console.info("向左！")
	                break;
	            case 4:
	            	 console.info("向右！")
	                break;
	        }
		    }
		    
		    //手指接触屏幕
		    container.addEventListener("touchstart", function(e) {
		        startx = e.touches[0].pageX;
		        starty = e.touches[0].pageY;
		    }, false);
		    //手指离开屏幕
		    container.addEventListener("touchend", function(e) {
		        var endx, endy;
		        endx = e.changedTouches[0].pageX;
		        endy = e.changedTouches[0].pageY;
		        var direction = getDirection(startx, starty, endx, endy);
		        direct=direction;
		        printDirectionInfo(direction);
		    }, false);
			
			
		    container.addEventListener("touchmove",function(e){
				e.stopPropagation();
				if(this.scrollTop >= this.scrollHeight-this.offsetHeight){
					console.info("到底了");
					if(direct == 1){
						 e.preventDefault()
					}
				}
				if(this.scrollTop<=0 ){
					console.info("到顶了");
					if(direct == 2){
						 e.preventDefault()
					}
				}
			})
			
			showCategorys();
			showEmotions();
			
			//如果想上打开表情框，需要重新定位
			newTop = setPositonUp(target,position)
			
		});
		$('body').click(function(){
			$('#emotions').remove();
		});
		$.fn.insertText = function(text){
			this.each(function() {
				if(this.tagName !== 'INPUT' && this.tagName !== 'TEXTAREA') {return;}
				if (document.selection) {
					this.focus();
					var cr = document.selection.createRange();
					cr.text = text;
					cr.collapse();
					cr.select();
				}else if (this.selectionStart || this.selectionStart == '0') {
					var 
					start = this.selectionStart,
					end = this.selectionEnd;
					this.value = this.value.substring(0, start)+ text+ this.value.substring(end, this.value.length);
					this.selectionStart = this.selectionEnd = start+text.length;
				}else {
					this.value += text;
				}
			});        
			return this;
		}
		function showCategorys(){
			// 写死
			var pageSize = 3;
			var page = arguments[0]?arguments[0]:0;
			if(page < 0 || page >= categorys.length / pageSize){
				return;
			}
			$('#emotions .categorys').html('');
			cat_page = page;
			for(var i = page * pageSize; i < (page + 1) * pageSize && i < categorys.length; ++i){
				$('#emotions .categorys').append($('<a href="javascript:void(0);">' + categorys[i] + '</a>'));
			}
			$('#emotions .categorys a').click(function(){
				showEmotions($(this).text());
				setPositonUp(target,position)
			});
			$('#emotions .categorys a').each(function(){
				if($(this).text() == cat_current){
					$(this).addClass('current');
					setPositonUp(target,position)
				}
			});
		}
		function showEmotions(){
			var category = arguments[0]?arguments[0]:'默认';
			var page = arguments[1]?arguments[1] - 1:0;
			$('#emotions .container').html('');
			cat_current = category;
			for(var i = 0;  i < emotions[category].length; ++i){
				$('#emotions .container').append($('<a href="javascript:void(0);" title="' + emotions[category][i].name + '"><img src="' + emotions[category][i].icon + '" alt="' + emotions[category][i].name + '" width="22" height="22" /></a>'));
			}
			$('#emotions .container a').click(function(){
				target.insertText($(this).attr('title'));
				$('#emotions').remove();
			});
			 
			$('#emotions .categorys a.current').removeClass('current');
			$('#emotions .categorys a').each(function(){
				if($(this).text() == category){
					$(this).addClass('current');
				}
			});
		}
	}
})(jQuery);


//点击文本框，focus后软键盘不会遮住文本框 ---> 适用于安卓
if (/Android [4-6]/.test(navigator.appVersion)) {
	   window.addEventListener('resize', function () {
		   alert("resize");
	     if (document.activeElement.tagName === 'INPUT' || document.activeElement.tagName === 'TEXTAREA') {
	        window.setTimeout(function () {
	          document.activeElement.scrollIntoViewIfNeeded()
	        }, 0)
	      }
	   })
	}

/*let u = navigator.userAgent, app = navigator.appVersion;  
let isiOS = !!u.match(/\(i[^;]+;( U;)? CPU.+Mac OS X/); //ios终端  
if (isiOS) {  
    window.setTimeout(function(){  
    	alert("IOS");
        window.scrollTo(0,document.body.clientHeight);  
    }, 500);  
}  */
/*//resize ， 横屏后resize会触发
window.onresize = function(){
	alert("resize")
}*/
