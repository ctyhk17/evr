/*
var option = {
		showOn: "both", 
		buttonImage: "/images/th/2016/icon_calendar.gif", 
		buttonImageOnly: true,
		changeMonth: true, 
		changeYear: true,
		nextText: '다음 달',
		prevText: '이전 달',
		dateFormat: "yy-mm-dd",
		changeMonth: true, 
		dayNames: ['월요일', '화요일', '수요일', '목요일', '금요일', '토요일', '일요일'],
		dayNamesMin: ['월', '화', '수', '목', '금', '토', '일'], 
		monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
		monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월']
};
*/


$.datepicker.regional['ko'] = {
		showOn: "both", 
		buttonImage: "/images/th/2016/icon_calendar.gif", 
		buttonImageOnly: true,
		changeMonth: true, 
		changeYear: true,
		prevText: '이전달',
        nextText: '다음달',
        dateFormat: "yy-mm-dd",
        currentText: '오늘',
        monthNames: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        monthNamesShort: ['1월','2월','3월','4월','5월','6월','7월','8월','9월','10월','11월','12월'],
        dayNames: ['일','월','화','수','목','금','토'],
        dayNamesShort: ['일','월','화','수','목','금','토'],
        dayNamesMin: ['일','월','화','수','목','금','토'],
        weekHeader: 'Wk',
        dateFormat: 'yy-mm-dd',
        firstDay: 0,
        isRTL: false,
        showMonthAfterYear: true,
        yearSuffix: '년'
};
$.datepicker.setDefaults($.datepicker.regional['ko']);






