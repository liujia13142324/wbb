<%@ page language="java" contentType="text/html; charset=utf-8"
    pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<base href="/wbb/">
<title>二手市场</title>
</head>
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/goodsCenter.css">
<body>
<div class="header">二手市场</div>
<div class="tool_div">
	<span class="select_span">
		<select>
			<option>全部</option>
		</select><i class="fa fa-angle-down" style="color:#999;" aria-hidden="true"></i>
	</span>
	<span class="search_span">
		<input /><i class="fa fa-search" aria-hidden="true"></i>
	</span>
</div>

<div id="goodsList">
	<div class="goods_div">
		
	</div>
</div>

</body>
<script>
	window.jQuery
			|| document.write('<script src="js/jquery.min.js"><\/script>')
</script>
<script type="text/javascript">
	$($(".fa-search")[0]).css("line-height",$($(".fa-search")[0]).css("height"))
</script>
</html>