$("#sinaEmotion").remove();

function changeTheme(obj){
	var themeId = $(obj).attr("id");
//	alert(themeId);
	if(typeof(themeId) != "undefined" ){
		themeId = themeId.substr(themeId.indexOf("_")+1);
		if(parseInt(themeId)>0)
			location.href="info/infoCenter?themeId="+themeId
		else
			enterCenter();	
	}else{
		enterCenter();	
	}
}

