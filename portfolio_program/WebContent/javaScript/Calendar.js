/**
 *
 */


const week = ["日","月","火","水","木","金","土"];
const today = new Date();

var shoDate = new Date(today.getFullYear(), today.getMonth(), 1);

//初期表示
window.onload = function(){
	showProcess(today, calendar);
};

//昨年のカレンダー表示
function lastYear(){
	showDate.setFullYear(showDate.getFullYear() -1);
	showProcess(showDate);
}

//来年のカレンダー表示
function nextYear(){
	showDate.setFullYear(showDate.getFullYear() +1);
	showProcess(showDate);
}

//先月のカレンダー表示
function lastMonth(){
	showDate.setMonth(showDate.getMonth() -1);
	showProcess(showDate);
}

//来月のカレンダー表示
function nextMonth(){
	showDate.setMonth(showDate.getMonth() +1);
	showProcess(showDate);
}

//カレンダー表示
function showProcess(date){
	var year = date.getFullYear();
	var month = date.getMonth();
	document.querySelector("#year").innerHTML = year;
	document.querySelector("#month").innerHTML = month;

	var calendar = createProcess(year, month);
	document.querySelector("#calendar").innerHTML = calendar;
}

//カレンダー作成






