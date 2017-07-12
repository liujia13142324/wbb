<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">

<%-- <jsp:forward page="user/getCode"/> --%>

<script>
	<!-- 这里获得调用微信接口，获得参数 写在一个新的js里面 -->
	var appid ="";
	var redirect_uri=encodeURI("/center/enter");
	// 尤其注意：跳转回调redirect_uri，应当使用https链接来确保授权code的安全性。
	var codeRequestUrl="https://open.weixin.qq.com/connect/oauth2/authorize?appid="+appid
			+"&redirect_uri="+redirect_uri
			+"&response_type=code&scope=snsapi_userinfo&state=STATE#wechat_redirect"
	
	window.location.href = codeRequestUrl;		
			
</script>