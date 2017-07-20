<%@ page language="java" contentType="text/html; charset=utf-8"
	pageEncoding="utf-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=utf-8">
<meta name="viewport"
	content="width=device-width, initial-scale=1 , user-scalable=no">
<title>发布信息</title>
<base href="/wbb/">
<link href="css/infoCenter.css" rel="stylesheet">
<link rel="stylesheet" href="font-awesome/css/font-awesome.min.css">
<link rel="stylesheet" href="css/sinaFaceAndEffec.css">
<link rel="stylesheet" type="text/css" href="easyui/themes/icon.css" >
<link  rel="stylesheet" href="easyui/css/easyui.css">
   <link href="lightGallery/css/lightgallery.css" rel="stylesheet">
</head>
<style>
body {
	margin: 0;
}

.header {
	margin-bottom: 0;
}

.header_left {
	float: left;
	margin-left: 10px;
	color: #50C5F5;
}

.header_title {
	clear: both;
}

.header_right {
	float: right;
	margin-right: 10px;
	color: #50C5F5;
}

.header_icon {
	height: 50px;
	line-height: 50px;
	display: inline-block;
}

.publish_div {
	background-color: white;
	width: 100%;
	height: 150px;
	padding-top:5px;
}

.publish_content {
	width: 98%;
	height: 67%;
	font-size: 15px;
	padding: 0;
	padding-left: 5px;
	padding-right: 2px;
	border: none;
	resize: none;
	box-shadow: 0px 0px 0px rgba(0, 0, 0, 0);
	-webkit-appearance: none;
}

.tool_bar {
	height: 33%;
}

.face-icon {
	height: 100%;
	font-size: 40px;
	vertical-align: middle;
	background: white;
	display: block;
	float: left;
}

.img_area {
	background-color: white;
	margin-top: 10px;
	width: 100%;
}

.fa-plus {
	height: 100%;
	font-size: 40px;
}

.img_area_inner {
	padding: 10px;
}


.title_div{
	width:100%;
	margin-bottom:10px;
	margin-top:10px;
	height:40px;
	line-height:40px;
	background:#fff;
}
.title_input,.detail_input{
	border:none;
	height:90%;
    width:98%;
    font-size: 15px;
    padding: 0;
    padding-left: 5px;
}
.detail_info .detail_input{
	height:40px;
}
hr{
    border-top: none;
    margin: 5px;
}
.detail_info{
	width:100%;
	margin-top:10px;
	background:#fff;
}
.detail_info span{
	height: 40px;
    display: inline-block;
    line-height: 40px;
    padding-left:5px;
    color: #999;
}
.detail_info select{
	height:40px;
	-webkit-appearance:none;
	appearance:none;
	width:50%;
	font-size: 15px;
	border:none;
	padding:0px 10px;
	-webkit-box-sizing:border-box;
	box-sizing:border-box;
	background-color: #FFFFFF;
	color:#333333;
	border-radius:4px;
	color: #999;
}
</style>
<body>
	<div class="header">
		<span class="header_left"><span class="fa fa-times header_icon"
			aria-hidden="true"></span></span> <span class="header_title">二手市场</span> <span
			class="header_right">发送</span>
	</div>

	<div class="title_div">
		<input class="title_input" placeholder="标 题：" type="text" >
	</div>

	<div class="publish_div">
		<textarea class="publish_content" placeholder="简 介：" ></textarea>
		<div class="tool_bar">
			<span class="face-icon" id="face-icon">☺</span>
		</div>
	</div>

	<div class="img_area">
		<div class="img_area_inner">
			<div class="imgList" id="imgList"></div>
			<div class="img_div" id="plus_div">
				<i class="fa fa-plus" aria-hidden="true"></i>
			</div>
			<div style="clear: both"></div>
		</div>
	</div>
	<input id="add_file" type="file" multiple name="add_file"
		style="display: none">
		
	<div class="detail_info" >
		<input placeholder="价 格（元）：" class="detail_input">
		<hr>
		<span>分 类：</span>
		<select>
			<option>请选择分类 ></option>
			<option>1</option>
		</select>
		<hr>
		<input placeholder="Q Q(选填)：" class="detail_input">
	</div>	
	
</body>

<script>
	window.jQuery
			|| document.write('<script src="js/jquery.min.js"><\/script>')
</script>
<script type="text/javascript" src="js/sinaFaceAndEffec.js"></script>
<script src="js/exif.js"></script>

<script src="lightGallery/js/picturefill.min.js"></script>
<script src="lightGallery/js/lightgallery.js"></script>
<script src="lightGallery/js/lg-pager.js"></script>
<script src="lightGallery/js/lg-fullscreen.js"></script>
<script src="lightGallery/js/lg-zoom.js"></script>
<script src="lightGallery/js/lg-hash.js"></script>


<script type="text/javascript">
	
	
	$('.face-icon').SinaEmotion($('.publish_content'), 1);
	initImg_div();
	$(".fa-plus").css("line-height", $(".img_div").css("height"));

	$("#plus_div").click(function() {
		$("#add_file").click();
	})

	function initImg() {
		$(".imgList img").attr("height", $(".imgList img")[0].width)
	}

	function initImg_div() {
		$(".img_div").css("height", $(".img_div").css("width"));
	}
	var add_files = new Array();
	var file_values = new Array();
	$("#add_file").change(
			function() {
				if (this.value != '' && this.value != 'undefined'
						&& this.value != null) {
					var files = this.files;
					for (var i = 0, j = files.length; i < j; i++) {
						var add_values = true;

						for (var q = 0, w = file_values.length; q < w; q++) {
							if (files[i].name == file_values[q]) {
								add_values = false;
								break;
							}
						}
						if (add_values) {
							file_values[file_values.length] = files[i].name;
							console.info(file_values); 

							if (file_values.length > 9) {
								alert("上传图片不能大于9张！")
								file_values.pop();
							} else {
								openImgFile(files[i]);
							}
						}
					}
					
				}
			})
			
			
	function openImgFile(fileObj) {

		var uriStr = window.URL.createObjectURL(fileObj);
		 var li =  document.createElement('li');
		
		$(li).css({"display":"inline-block","background":"url('"+ uriStr+ "') no-repeat center"})
		$(li).css({"background-size" :"cover","position":"relative"})
		$(li).addClass("img_div close_li");
		$(li).attr("data-src",uriStr) 
		$(li).attr("imgIndex",add_files.length) 
		
		setRotateAndDisplay(fileObj,li); 
		add_files[add_files.length] = fileObj;
		
	}
	function deleteImg(obj , e){
		
		e.stopPropagation()
		var imgLi = $(obj).parent()
		var imgIndex = imgLi.attr("imgIndex");
		add_files.splice(imgIndex,1);
		file_values.splice(imgIndex,1)
		
		console.info(file_values);
		console.info(add_files);
		
		var nexts = imgLi.nextAll();
		
		for( var i=0,j=nexts.length; i<j ; i++ ){
			$(nexts[i]).attr("imgIndex",parseInt($(nexts[i]).attr("imgIndex"))-1);
		}
		
		imgLi.remove();
		
	}
	function setRotateAndDisplay(fileObj,li) {
		
		EXIF.getData(fileObj, function() {
			EXIF.getAllTags(this);
			var Orientation = EXIF.getTag(this, 'Orientation');
			
			//$.post("test/test",{"a":Orientation});
			var span = document.createElement("span");
			$(span).css({'width':'15px','height':'15px','position':'absolute',
						  'background-color':'#333',"color":"white",
						  'border-radius':'50%'})
			$(span).addClass("fa fa-times");
			$(span).attr( "onclick","deleteImg(this,event)" )
			
			
			if(Orientation == 6){
				//顺时针90
				doRotate(li,"90deg")
				$(span).css({"left":"0px","top":"0px"});
			}else if(Orientation == 8){
				//逆时针90
				doRotate(li,"-90deg")
				$(span).css({"right":"0px","top":"0px"});
			}else if(Orientation == 3){
				// 180
				doRotate(li,"180deg")
				$(span).css({"left":"0px","bottom":"0px"});
			}else{
				$(span).css({"right":"0px","top":"0px"});
			}
			li.append(span);
			
			var imgIndex = $(li).attr("imgIndex")
			var lis = $("#imgList .close_li")
			var isMax = true;			
			for(var i=0;i<lis.length;i++){
				if(parseInt(imgIndex) < parseInt($(lis[i]).attr("imgIndex"))){
					lis[i].before(li);
					isMax=false;
					// 一定要break，只要记录第一次比它大的，插在它之前，
									//若无比它大的，则查到最后，即可按照顺序插入
					break;
				}
			}
			console.info(isMax)
			if(isMax){
				$("#imgList").append(li);
			} 
			
			initImg_div();
			// 初始化图片查看器
			initLightGallery();	

		});
	}
	
	function initLightGallery(){
		var document_imgList = document.getElementById('imgList')
		//这里有点古怪，为什么是undefined
		if(window.lgData[document_imgList.getAttribute('lg-uid')] == 'undefined'){
			window.lgData[document_imgList.getAttribute('lg-uid')].destroy(true);
		}
		lightGallery(document_imgList,{
			download:false
		});
	}
	function doRotate(element,value){
		element.style.webkitTransform="rotate("+value+")"
		element.style.MozTransform="rotate("+value+")"
		element.style.msTransform="rotate("+value+")"
		element.style.OTransform="rotate("+value+")"
		element.style.transform="rotate("+value+")";
	}
	
</script>
</html>