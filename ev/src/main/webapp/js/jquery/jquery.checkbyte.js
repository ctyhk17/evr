/*
 * Check Byte - jQuery plugin for checking byte v1.1 (2011-11-11)
 * jquery.checkbyte.js
 * code by francis lee depend on jquery.textchange.js with jQuery v1.6.4
 */
(function($) {

	/**
	 * name checkbyte 
	 * param options{} 
	 
	 *         limit : number, 체크할 바이트수 
	 *         twice : boolean, 2건 체크 여부 예제
	 
	 */
	$.fn.checkbyte = function(options) {
		// 기본값 정의
		var settings = {			
		};
		// options 존재하면 options를 setting에 merge
		if (options) {
			$.extend(settings, options);
		}
		;
		
		// chainability 유지
		return this.each(function() {
			// 객체자신
			var $this = $(this);
			
			// firefox, opera는 한글입력시 keyup, keypress 같은 event 감지가 안됨
			if ($.browser.mozilla || $.browser.opera) {
				$this.bind("textchange", function(event, previousText) {
					$.check($this, parseInt(settings.limit), settings.title);
				});
			} else {
				$this.bind("keyup", function(event) {
					$.check($this, parseInt(settings.limit), settings.title);
				});
			}
		});
	};


	// 문자열을 해당하는 길이만큼 자르는 함수
	$.limitString = function(str, limit) {
		var tempStr = new String(str);
		var len = 0;
		for ( var i = 0; i < str.length; i++) {
			var c = escape(str.charAt(i));
			if (c.length == 1)
				len++;
			else if (c.indexOf("%u") != -1)
				len += 2;
			else if (c.indexOf("%") != -1)
				len += c.length / 3;
			if (len > limit) {
				tempStr = tempStr.substring(0, i);
				break;
			}
		}
		return tempStr;
	};

	// 문자열의 바이트수를 계산하는 함수
	$.byteString = function(str) {
		var len = 0;
		for ( var i = 0; i < str.length; i++) {
			var c = escape(str.charAt(i));
			if (c.length == 1)
				len++;
			else if (c.indexOf("%u") != -1)
				len += 2;
			else if (c.indexOf("%") != -1)
				len += c.length / 3;
		}
		return len;
	};

	// check(입력object 표시 object, 제한건수, 2건여부)
	$.check = function(input, limit, title) {
		// 문자열의 길이를 구함
		var len = $.byteString(input.val());
		// 두건보내기가 true라면
		
			if (len > limit) {
				alert("[" + title + "] 내용은 " + limit + "byte를 넘을수 없습니다. 초과된 부분은 자동으로 삭제됩니다.");
				
				// limit까지 짤라서 대상 객체에 넣기
				input.val($.limitString(input.val(), limit));
			}
		
	};

})(jQuery);

