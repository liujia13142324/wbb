function getValFromSheet(value,obj){
	if(typeof window.getComputedStyle!='undefined'){  //w3c
		value=window.getComputedStyle(obj,null)["height"];
	}else if(typeof this.elements[obj].currentStyle!='undefined'){  //IE
		value=this.elements[obj].currentStyle["height"];		
	}
	
	return removePx(value);	
}
function removePx(value){	
	return parseInt(value);
}
var refresher = {
	lock : 1,
	result:false,
	isBottom:false,
	srollEnd:false,
	/*scollDistance:0,*/
	info : {
		"pullUpLable" : "上拉加载更多...",
		"pullingUpLable" : "温柔的太阳君和他的小伙伴们 微信：a524294514",
		"loadingLable" : "Loading...",
		"atBottom":"没了"
	},
	init : function(parameter) {
		
		var inner_obj=document.getElementById("inner_div");
		var out_obj = document.getElementById("out_div");
		if($(inner_obj).height()>$(out_obj).height()){
			var out_height=0;
			var inner_height=0;	
			
			//创建上拉块
			var pullUp = document.createElement("div");
			pullUp.id = "pullUp";
			var loader = document.createElement("div");
			loader.className = "loader";
			for (var i = 0; i < 4; i++) {
				var span = document.createElement("span");
				loader.appendChild(span);
			}
			pullUp.appendChild(loader);
			
	
			var pullUpLabel = document.createElement("div");
			$(pullUpLabel).css("margin-bottom","10px")
			pullUpLabel.className = "pullUpLabel";
			var content = document.createTextNode(refresher.info.pullUpLable);
			pullUpLabel.appendChild(content);
			pullUp.appendChild(pullUpLabel);
			inner_obj.appendChild(pullUp);
			
			var pullUpEl = document.getElementById('pullUp');
			var pullUpOffset = pullUpEl.offsetHeight;
			
				this.scrollIt(parameter, pullUpEl,
						pullUpOffset,inner_height,out_height,inner_obj,out_obj);
		}
	},

	scrollIt : function(parameter,  pullUpEl,
			pullUpOffset,inner_height,out_height,inner_obj,out_obj) {
		
	var lastScoll 	//上次滚动的位置
	var scollLock = recordStart = 1; //滚动计时器锁
	var scollCount = 0 //位置相同的次数  
	var scollStartP = 0; //开始滚动的位置  ， 结束滚动的位置
	var isTouch,isTouchStart = false; //手指是否在屏幕上，   用户是否曾经把手指放到屏幕上
	document.onscroll=function(){
		if (!refresher.isBottom) {
			refresher.srollEnd = false;
			/*if(recordStart==1){ //记录开开始滚动
				recordStart--
				scollStartP = scrollY;
			}
			//console.info("lastScoll:"+lastScoll+"  scrollY:"+scrollY)
			 */
			/**
			 * 判断惯性滑动是否停止
			 * 1.第一种情况， 当用户手指已经不在屏幕上面，且之前已经确定触摸了屏幕， 计时器只能跑一次，所以加锁。
			 * 2.还有第二种情况，从滑动开始到结束，用户都是触摸着屏幕（用户的手一直在屏幕上面）
			 */
			/*if(! isTouch && isTouchStart && scollLock==1){
				scollLock--;
				var detectScollEnd = setInterval(function(){
					if(typeof(lastScoll)=="undefined" ||! refresher.srollEnd ){
						if(lastScoll == scrollY && scollCount>=1){
							//alert("scollEnd  lastScoll:"+lastScoll+"  minus:"+(lastScoll-scollStartP));
							//refresher.scollDistance = lastScoll-scollStartP
							clearInterval(detectScollEnd);
							refresher.srollEnd =  true; //已经滚动结束
						//	alert(refresher.srollEnd)
							scollCount=0;
							isTouchStart = false; //切记，这个要在这里还原 isTouch在touchend中还原
							scollLock=1;
							//recordStart=1;
						}else if(lastScoll == scrollY && !refresher.srollEnd){
							scollCount++;
							//console.info(scollCount)
						}else{
							lastScoll = scrollY;
						}
					}
				},50)
			}*/
			refresher.onScrolling(pullUpEl, pullUpOffset, inner_height,
					out_height, inner_obj, out_obj);// element
			}
		}
	
	addEventListener("touchstart", function(e){
		var touch = e.targetTouches[0];
		isTouch=true;
		isTouchStart = true;
		//scollStartP = scrollY;
	})
	
		
	addEventListener("touchend",function(e){
		
			isTouch = false;
			refresher.onPulling(pullUpEl, parameter.pullUpAction);
			if (pullUpEl.className.match('loading')) {
				refresher.lock = 0;
				var timer = setInterval(function() {
					if (refresher.result || refresher.isBottom) {
						refresher.onRelease(pullUpEl);
						clearInterval(timer)
						refresher.result = false;
					}

				}, 1000);

			} else {
				refresher.onRelease(pullUpEl);
			}
	})
		
	},

	onScrolling : function( pullUpEl, pullUpOffset,inner_height,out_height,inner_obj,out_obj) {
			
			inner_height=getValFromSheet(inner_height,inner_obj);
			out_height = getValFromSheet(out_height,out_obj);
			/*console.info("(inner_height):"+(inner_height));
			console.info("scrolly:"+scrollY);
			console.info("scrollY+out_height:"+(scrollY+out_height));*/
			if(refresher.lock == 1){
				
				if(scrollY+out_height<inner_height){
					pullUpEl.className = '';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullUpLable;
				}	
				
				if (scrollY+out_height>=inner_height) {
					//e.y < (e.maxScrollY - pullUpOffset)
					document.getElementById("pullUp").style.display = "block";
					pullUpEl.className = 'flip';
				//	console.info("pulling up");
					pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullingUpLable;
				}
			}	
	},

	// things loader css on pulling,you can wirte it yourself
	onPulling : function(pullUpEl, pullUpAction) {
				if (pullUpEl.className.match('flip')) {
					pullUpEl.className = 'loading';
					pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.loadingLable;
					pullUpEl.querySelector('.loader').style.display = "block"
					pullUpEl.style.lineHeight = "20px";
					if (pullUpAction)
						pullUpAction(); // Execute custom function (ajax call?)
				}
	},

	// things loader css on release,you can wirte it yourself
	//恢复下拉或者上拉标签的
	onRelease : function(pullUpEl) {
		if (pullUpEl.className.match('loading')) {
			pullUpEl.className = '';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullUpLable;
			pullUpEl.querySelector('.loader').style.display = "none"
				// 44 底部导航的高度
			pullUpEl.style.lineHeight = pullUpEl.offsetHeight - 44 + "px";
		}
		refresher.lock = 1;
	}
}
