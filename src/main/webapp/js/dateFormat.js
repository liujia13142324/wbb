function getDayOfweek(day){
	switch(day){
		case 0:
			return "星期天";
			break;
		case 1:
			return "星期一";
			break;
		case 2:
			return "星期二";
			break;
		case 3:
			return "星期三";
			break;
		case 4:
			return "星期四";
			break;
		case 5:
			return "星期五";
			break;
		case 6:
			return "星期六";
			break;
	}
}

function formatTime(int){
	return int>10?int:"0"+int
}

function FormatDate(strTime){
	var date = new Date(strTime);
	return date.getFullYear()+"-"+formatTime(date.getMonth()+1)+"-"+formatTime(date.getDate())+" "+formatTime(date.getHours())+":"+formatTime(date.getMinutes())+":"+formatTime(date.getSeconds())+" "+getDayOfweek(date.getDay());
}