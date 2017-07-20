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
<style>
body {
    background-color: #EAEAEA;
    color: #333;
}
div{
	width:100%;
	background:#fff;
}
.tool_div{
	height:30px;
}
.tool_div span{
	float:left;
	display:inline-block;
	height:30px;
	line-height:30px;
}
select{
    -webkit-appearance: none;
    margin-left: 5px;
    appearance: none;
    width: 60%;
    font-size: 12px;
    border: none;
    -webkit-box-sizing: border-box;
    box-sizing: border-box;
    background-color: #FFFFFF;
    color: #333333;
    border-radius: 4px;
    color: #999;
  }
.search_span{
	  width: 80%;
}

.search_span input{
    box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
    -webkit-appearance: none;
    border-radius: 5px;
    border-width:1px;
    border-color:#fff;
    background:#eaeaea;
    width: 88%;
    height:90%;
    font-size: 15px;
    padding: 0;
    padding-left: 5px;
}

.search_span i{
    height:90%;
    font-size: 15px;
}

.select_span{
	width:20%;
}

</style>
<body>

<div class="tool_div">
	<span class="select_span">
		<select>
			<option>全部</option>
		</select>
		<i class="fa fa-angle-down" style="color:#999;" aria-hidden="true"></i>
	</span>
	<span class="search_span">
		<input />
		<i class="fa fa-search" aria-hidden="true"></i>
	</span>
</div>
</body>
</html>