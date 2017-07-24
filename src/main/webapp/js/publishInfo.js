
initImg_div();

$('.face-icon').SinaEmotion($('.publish_content'), 1);

$(".fa-plus").css("line-height", $(".img_div").css("height"));

$("#wordCount").css("line-height", $("#wordCount").css("height"))

$("#plus_div").click(function() {
	$("#add_file").click();
})


var textArea = $("#publish_textarea")
var word = $("#wordCount");
//开启统计字数
statInputNum(textArea, word);

function initImg_div() {
	$(".img_div").css("height", $(".img_div").css("width"));
}

var add_files = new Array();
var file_values = new Array();

$("#add_file").change(function() {
	if (this.value != '' && this.value != 'undefined' && this.value != null) {
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
	var li = document.createElement('li');
	
	$(li).css({
		"display" : "inline-block",
		"background" : "url('" + uriStr + "') no-repeat center"
	})
	$(li).css({
		"background-size" : "cover",
		"position" : "relative"
	})
	$(li).addClass("img_div close_li");
	//$(li).backstretch(uriStr)
	$(li).attr("data-src", uriStr)
	$(li).attr("imgIndex", add_files.length)

	setRotateAndDisplay(fileObj, li);
	add_files[add_files.length] = fileObj;

}
function deleteImg(obj, e) {

	e.stopPropagation()
	var imgLi = $(obj).parent()
	var imgIndex = imgLi.attr("imgIndex");
	add_files.splice(imgIndex, 1);
	file_values.splice(imgIndex, 1)

	console.info(file_values);
	console.info(add_files);

	var nexts = imgLi.nextAll();

	for (var i = 0, j = nexts.length; i < j; i++) {
		$(nexts[i])
				.attr("imgIndex", parseInt($(nexts[i]).attr("imgIndex")) - 1);
	}

	imgLi.remove();

}
function setRotateAndDisplay(fileObj, li) {

	EXIF.getData(fileObj, function() {
		EXIF.getAllTags(this);
		var Orientation = EXIF.getTag(this, 'Orientation');

		//$.post("test/test",{"a":Orientation});
		var span = document.createElement("span");
		$(span).css({
			'width' : '15px',
			'height' : '15px',
			'position' : 'absolute',
			'background-color' : '#333',
			"color" : "white",
			'border-radius' : '50%'
		})
		$(span).addClass("fa fa-times");
		$(span).attr("onclick", "deleteImg(this,event)")

		if (Orientation == 6) {
			//顺时针90
			doRotate(li, "90deg")
			$(span).css({
				"left" : "0px",
				"top" : "0px"
			});
		} else if (Orientation == 8) {
			//逆时针90
			doRotate(li, "-90deg")
			$(span).css({
				"right" : "0px",
				"top" : "0px"
			});
		} else if (Orientation == 3) {
			// 180
			doRotate(li, "180deg")
			$(span).css({
				"left" : "0px",
				"bottom" : "0px"
			});
		} else {
			$(span).css({
				"right" : "0px",
				"top" : "0px"
			});
		}
		li.append(span);

		var imgIndex = $(li).attr("imgIndex")
		var lis = $("#imgList .close_li")
		var isMax = true;
		for (var i = 0; i < lis.length; i++) {
			if (parseInt(imgIndex) < parseInt($(lis[i]).attr("imgIndex"))) {
				lis[i].before(li);
				isMax = false;
				// 一定要break，只要记录第一次比它大的，插在它之前，
				//若无比它大的，则查到最后，即可按照顺序插入
				break;
			}
		}
		console.info(isMax)
		if (isMax) {
			$("#imgList").append(li);
		}

		initImg_div();
		// 初始化图片查看器
		initLightGallery('imgList');

	});
}

function doRotate(element, value) {
	element.style.webkitTransform = "rotate(" + value + ")"
	element.style.MozTransform = "rotate(" + value + ")"
	element.style.msTransform = "rotate(" + value + ")"
	element.style.OTransform = "rotate(" + value + ")"
	element.style.transform = "rotate(" + value + ")";
}


function statInputNum(textArea, numItem) {

	var max = numItem.text(),

	curLength;

	//这个属性有猫腻
	textArea[0].setAttribute("maxlength", max);

	curLength = textArea.val().length;

	numItem.text(max - curLength);

	textArea.on('input propertychange', function() {
		numItem.text(max - $(this).val().length);
	});

}
