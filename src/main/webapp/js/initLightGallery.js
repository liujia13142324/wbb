document.write('<script src="lightGallery/js/picturefill.min.js"></script>');
document.write('<script src="lightGallery/js/lightgallery.js"></script>');
document.write('<script src="lightGallery/js/lg-fullscreen.js"></script>');
document.write('<script src="lightGallery/js/lg-zoom.js"></script>');
document.write('<script src="lightGallery/js/lg-hash.js"></script>');
document.write('<script src="lightGallery/js/lg-pager.js"></script>');

function initLightGallery(id) {
	var document_imgList = document.getElementById(id)
	//这里有点古怪，为什么是undefined
	if (window.lgData[document_imgList.getAttribute('lg-uid')] == 'undefined') {
		window.lgData[document_imgList.getAttribute('lg-uid')].destroy(true);
	}
	lightGallery(document_imgList, {
		download : false,
	    counter:false
	});
}