
document.write('<script src="lightGallery/js/picturefill.min.js"></script>');
document.write('<script src="lightGallery/js/lightgallery.js"></script>');
document.write('<script src="lightGallery/js/lg-fullscreen.js"></script>');
document.write('<script src="lightGallery/js/lg-zoom.js"></script>');
document.write('<script src="lightGallery/js/lg-hash.js"></script>');
document.write('<script src="lightGallery/js/lg-pager.js"></script>');


function initLightGalleryWithoutCheck(id){
var document_imgList = document.getElementById(id)
	
	//这里有点古怪，为什么是undefined
	if (window.lgData[document_imgList.getAttribute('lg-uid')] == 'undefined') {
		window.lgData[document_imgList.getAttribute('lg-uid')].destroy(true);
	}
	lightGallery(document_imgList, {
		download : false,
	    counter:false,
	    hideBarsDelay:3000,
	    controls:false
	});
}

function initLightGallery(id) {
	var document_imgList = document.getElementById(id)
	
	judgeIfTwoImg(document_imgList)
	
	//这里有点古怪，为什么是undefined
	if (window.lgData[document_imgList.getAttribute('lg-uid')] == 'undefined') {
		window.lgData[document_imgList.getAttribute('lg-uid')].destroy(true);
	}
	lightGallery(document_imgList, {
		download : false,
	    counter:false,
	    hideBarsDelay:3000,
	    controls:false
	});
}

function judgeIfTwoImg(document_imgList){
	if($(document_imgList).children().length == 2){
		for(var i=0 ; i<2 ;i++){
			var div = $($(document_imgList).children()[i]).clone(true);
			$(div).css("display","none");
			$(document_imgList).append(div);
		}
		
	}
}

function initLightGallerys(document_imgList) {
	judgeIfTwoImg(document_imgList)
	//这里有点古怪，为什么是undefined
	if (window.lgData[document_imgList.getAttribute('lg-uid')] == 'undefined') {
		window.lgData[document_imgList.getAttribute('lg-uid')].destroy(true);
	}
	lightGallery(document_imgList, {
		download : false,
	    counter:false,
	    hideBarsDelay:3000,
	    controls:false
	});
}
