var ntisCalendar = {
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



//메뉴이동에 대한 히스토리 저장(.do를 포함한 경로, 메뉴명)
/*
function doMenuHist(value,value2){
	$('form').eq(1).append('<input type="hidden" name="menuFrom" id="menuFrom" value="" />');
	$('form').eq(1).append('<input type="hidden" name="menuNm" id="menuNm" value="" />');
	
	var obj = document.forms[1];
	
	obj.menuFrom.value = value;
	obj.menuNm.value = value2;
	
	obj.action = "/menuHist.do";
	obj.submit();
}
*/

//글로벌 메뉴 열기    
function doGlobalMenu(){
	// 헤더 메뉴
	var $ojbGlobalMenuLayer = $('#globalMenuLayer');
	if ($.trim($ojbGlobalMenuLayer.html()) == '') {		
	//if ($ojbGlobalMenuLayer.html().trim() == '') {
		$.ajax({
			type : "GET",
			url : '/globalMenu.do',
			dataType : "html",
			success : function(data){
				$ojbGlobalMenuLayer.html(data);
			},        
			error: function(data,status,error){
				alert('서버에 오류가 발생하였습니다.');
			}
		});
	}
	      
	$ojbGlobalMenuLayer.popup({
		type: 'overlay',
		scrolllock: true,
		blur: false
	});
	
	$ojbGlobalMenuLayer.popup('show');
}

// 글로벌 메뉴 닫기
$(document).on('click', '#globalMenuClose', function(e){
	e.preventDefault();
	
	$('#globalMenuLayer').popup('hide');
});






//글로벌 사용자 메뉴 열기
function doGlobalUserMenu(){
	// 헤더 메뉴
	var $ojbGlobalUserMenuLayer = $('#globalUserMenuLayer');

	if ($.trim($ojbGlobalUserMenuLayer.html()) == '') {	
	//if ($ojbGlobalUserMenuLayer.html().trim() == '') {
		$.ajax({
			type : "GET",
			url : '/globalUserMenu.do',
			dataType : "html",
			success : function(data){
				$ojbGlobalUserMenuLayer.html(data);
			},
			error: function(data,status,error){
				alert('서버에 오류가 발생하였습니다.');
			}
		});
	}
	
	$ojbGlobalUserMenuLayer.popup({
		type: 'overlay',
		scrolllock: true,
		blur: false
	});
	
	$ojbGlobalUserMenuLayer.popup('show');
}

// 글로벌 사용자 메뉴 닫기
$(document).on('click', '#globalUserMenuClose', function(e){
	e.preventDefault();
	
	$('#globalUserMenuLayer').popup('hide');
});







//통합 검색 화면 토글
function doFastSearchToggle(){
	$('#n_searchwrap').slideToggle('slow');
}

//검색 (과제평가이력정보 내부 검색)
function doFastSearch(){
	
	var frmObj = $("form");
	
	var searchWord = $("#searchWord").val();
	
	if(searchWord.length == 0){			
		alert("검색어를 입력하세요.");
		return;
		
	}else{
		frmObj.attr("action", "/hist/search/EVPjtFnerSearchL.do");
		frmObj.submit();
	}
	
	
	
}

$(document).on('keydown', '#searchWord', function(e){
	
	if (e.keyCode == 13) {
		doFastSearch();
    }
});


// 과제상세검색 (
function doAdvanceSearch(){
	$(location).attr("href", "http://www.ntis.go.kr/ThFastSearchTotalList.do");
}
