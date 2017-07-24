//author wallace 华dee
//2015 7 3 
//qq447363121陈国华
var refresher = {
	info : {
		"pullDownLable" : "Pull down to refresh...",
		"pullingDownLable" : "Release to refresh...",
		"pullUpLable" : "上拉加载更多...",
		"pullingUpLable" : "温柔的太阳君和他的小伙伴们 微信：a524294514",
		"loadingLable" : "Loading..."
	},
	init : function(parameter) {
		var wrapper = document.getElementById(parameter.id);
		console.info(document.getElementById("scroller"))
		
		if(document.getElementById("scroller") == null){
			var div = document.createElement("div");
			div.id = "scroller";
			wrapper.appendChild(div);
			var scroller = document.getElementById("scroller");
			var list = document.querySelector("#" + parameter.id + " ul")
			scroller.insertBefore(list, scroller.childNodes[0]);
			
			var pullDown = document.createElement("div");
			pullDown.id = "pullDown";
			var loader = document.createElement("div");
			loader.className = "loader";
			for (var i = 0; i < 4; i++) {
				var span = document.createElement("span");
				loader.appendChild(span);
			}
			pullDown.appendChild(loader);

			var pullDownLabel = document.createElement("div");
			pullDownLabel.className = "pullDownLabel";
			pullDown.appendChild(pullDownLabel);

			scroller.insertBefore(pullDown, scroller.childNodes[0]);

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
			pullUpLabel.className = "pullUpLabel";
			var content = document.createTextNode(refresher.info.pullUpLable);
			pullUpLabel.appendChild(content);
			pullUp.appendChild(pullUpLabel);

			scroller.appendChild(pullUp);
			// create dom above
			// create dom ,you can wirte it yourself
		}
		
		var pullDownEl = document.getElementById('pullDown');
		var pullDownOffset = pullDownEl.offsetHeight;
		var pullUpEl = document.getElementById('pullUp');
		var pullUpOffset = pullUpEl.offsetHeight;
		// parameter
		this.scrollIt(parameter, pullDownEl, pullDownOffset, pullUpEl,
				pullUpOffset);
		
	},

	scrollIt : function(parameter, pullDownEl, pullDownOffset, pullUpEl,
			pullUpOffset) {
		
		myScroll = new iScroll(parameter.id,
				{
					useTransition : true,
					vScrollbar : false, // hide the iscroll v bar
					topOffset : pullDownOffset,
					onRefresh : function() {
						refresher.onRelease(pullDownEl, pullUpEl);
					},
					onScrollMove : function() {
						refresher.onScrolling(this, pullDownEl, pullUpEl,
								pullUpOffset);// element
					},
					onScrollEnd : function() {
						refresher.onPulling(pullDownEl,
								parameter.pullDownAction, pullUpEl,
								parameter.pullUpAction);
					},
				});
		
		console.info(myScroll.maxScrollY)
		//alert(myScroll.maxScrollY)
		
		setTimeout(
				function() {
					pullDownEl.querySelector('.pullDownLabel').innerHTML = refresher.info.pullDownLable
				}, 300);
		document.addEventListener('touchmove', function(e) {
			e.preventDefault();
		}, false);
	},

	// things loader css on scrolling,you can wirte it yourself
	onScrolling : function(e, pullDownEl, pullUpEl, pullUpOffset) {
		/* console.info("e.scrollerH:"+e.scrollerH +" e.wrapperH:" +
		 e.wrapperH+" e.minScrollY:"+e.minScrollY +" pullUpOffset:" +
		 pullUpOffset+" e.maxScrollY:" + e.maxScrollY);*/
		if (e.y > -(pullUpOffset)) {
			pullDownEl.className = '';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = refresher.info.pullDownLable;
			e.minScrollY = -pullUpOffset;
		}
		if (e.y > 0) {
			pullDownEl.className = 'flip';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = refresher.info.pullingDownLable;
			e.minScrollY = 0;
		}
		if (e.scrollerH < e.wrapperH && e.y < (e.minScrollY - pullUpOffset)
				|| e.scrollerH > e.wrapperH
				&& e.y < (e.maxScrollY - pullUpOffset)) {
			document.getElementById("pullUp").style.display = "block";
			pullUpEl.className = 'flip';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullingUpLable;
		}
		if (e.scrollerH < e.wrapperH && e.y > (e.minScrollY - pullUpOffset)
				&& pullUpEl.className.match('flip') || e.scrollerH > e.wrapperH
				&& e.y > (e.maxScrollY - pullUpOffset)
				&& pullUpEl.className.match('flip')) {
			document.getElementById("pullUp").style.display = "none";
			pullUpEl.className = '';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullUpLable;
		}
	},

	// things loader css on release,you can wirte it yourself
	onRelease : function(pullDownEl, pullUpEl) {
		if (pullDownEl.className.match('loading')) {
			pullDownEl.className = '';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = refresher.info.pullDownLable;
			pullDownEl.querySelector('.loader').style.display = "none"
			pullDownEl.style.lineHeight = pullDownEl.offsetHeight + "px";
		}
		if (pullUpEl.className.match('loading')) {
			pullUpEl.className = '';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.pullUpLable;
			pullUpEl.querySelector('.loader').style.display = "none"
			pullUpEl.style.lineHeight = pullDownEl.offsetHeight + "px";
		}
	},
	// things loader css on pulling,you can wirte it yourself
	onPulling : function(pullDownEl, pullDownAction, pullUpEl, pullUpAction) {
		if (pullDownEl.className.match('flip')) {
			pullDownEl.className = 'loading';
			pullDownEl.querySelector('.pullDownLabel').innerHTML = refresher.info.loadingLable;
			pullDownEl.querySelector('.loader').style.display = "block"
			pullDownEl.style.lineHeight = "20px";
			if (pullDownAction)
				pullDownAction(); // Execute custom function (ajax call?)
		}
		if (pullUpEl.className.match('flip')) {
			pullUpEl.className = 'loading';
			pullUpEl.querySelector('.pullUpLabel').innerHTML = refresher.info.loadingLable;
			pullUpEl.querySelector('.loader').style.display = "block"
			pullUpEl.style.lineHeight = "20px";
			if (pullDownAction)
				pullUpAction(); // Execute custom function (ajax call?)
		}
	}
}

// 防止iscroll 阻止了input等组件的正常使用
function allowFormsInIscroll() {
	[].slice.call(document.querySelectorAll('input, select, button')).forEach(
			function(el) {
				el.addEventListener(('ontouchstart' in window) ? 'touchstart'
						: 'mousedown', function(e) {
					e.stopPropagation();

				})
			})
}
document.addEventListener('DOMContentLoaded', allowFormsInIscroll, false);


