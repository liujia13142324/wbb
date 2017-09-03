<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<base href="/wbb/">
<title>Insert title here</title>
</head>
<body>
	<div style="width:100px;height:100px;background:#ccc" onclick="testChoose()"></div>
</body>
<script type="text/javascript" src="js/jquery-2.1.4.min.js"></script>
<script type="text/javascript" src="js/weixin-1.2.0.js"></script>
<script type="text/javascript">
function sendAsynRequest(requestType,url,successHandler){
	$.ajax({
		   type: requestType,
		   url: url,
		   success: successHandler
		});
	}
</script>
<script type="text/javascript">

sendAsynRequest("get", "center/initJs", function(data){

	//通过config接口注入权限验证配置
	wx.config({
	    debug: true, // 开启调试模式,调用的所有api的返回值会在客户端alert出来，若要查看传入的参数，可以在pc端打开，参数信息会通过log打出，仅在pc端时才会打印。
	    appId: data.appId, // 必填，公众号的唯一标识
	    timestamp:data.timestamp , // 必填，生成签名的时间戳
	    nonceStr: data.nonceStr, // 必填，生成签名的随机串
	    signature: data.signature,// 必填，签名，见附录1
	    jsApiList: ["chooseImage","previewImage","uploadImage","downloadImage"] // 必填，需要使用的JS接口列表，所有JS接口列表见附录2
	});
	
})


//config信息验证后会执行ready方法，所有接口调用都必须在config接口获得结果之后，config是一个客户端的异步操作，所以如果需要在页面加载时就调用相关接口，则须把相关接口放在ready函数中调用来确保正确执行。对于用户触发时才调用的接口，则可以直接调用，不需要放在ready函数中。
wx.ready(function(){
	console.info('ready');
	// 判断当前客户端版本是否支持指定JS接口
	wx.checkJsApi({
	    jsApiList: ['chooseImage'], // 需要检测的JS接口列表，所有JS接口列表见附录2,
	    success: function(res) {
	        // 以键值对的形式返回，可用的api值true，不可用为false
	        // 如：{"checkResult":{"chooseImage":true},"errMsg":"checkJsApi:ok"}
	        console.info(res);
	    }
	});
	
});

wx.error(function(res){
	alert("error");
	console.info(res)
});


function testChoose(){
	wx.chooseImage({
	    count: 4, // 默认9
	    sizeType: ['original', 'compressed'], // 可以指定是原图还是压缩图，默认二者都有
	    sourceType: ['album', 'camera'], // 可以指定来源是相册还是相机，默认二者都有
	    success: function (res) {
	        var localIds = res.localIds; // 返回选定照片的本地ID列表，localId可以作为img标签的src属性显示图片
	    	for(var i=0 ; i<localIds.length ; i++){
	    		 $("body").append("<img src='"+localIds[i]+"' />")
	    	}
	    }
	});
}

</script>
</html>