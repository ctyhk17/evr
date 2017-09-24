<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD XHTML 1.0 Transitional//EN" "http://www.w3.org/TR/xhtml1/DTD/xhtml1-transitional.dtd">
<html xmlns="http://www.w3.org/1999/xhtml" lang="ko" xml:lang="ko">
	<head>
		<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
		<title>국가과학기술지식정보서비스 오류화면</title>
		<link href="<c:url value='/css/th/2014/reset2014.css' />" rel="stylesheet" type="text/css" />
		<style type="text/css">
		* {
			margin:0;
			padding:0;
		
			font-family: 'Apple SD Gothic Neo', 'Malgun Gothic', dotum, Verdana;
		}
		
		a {color:#00a0e9; text-decoration: underline;}
		a:hover {color:orange;}
		
		
		
		.access_wrap1 {margin:100px auto; width:680px; height: 480px; border:2px solid #dedede; background:url(<c:url value='/images/th/2016/access_check1.png' />) no-repeat center;position:relative;}
		
		.check1 {position:absolute; left:250px; top:120px; font-size:14px; line-height:24px;} 
		</style> 
	
	</head>
	
	<body>
	    <%-- <spring:message code='fail.common.sql' /> --%>
	    
	    <div class="access_wrap1">
		
			<div class="check1">
				<p style="margin-bottom:24px;">내부 서버 오류로 인하여 불편을 드려 죄송합니다. <br/>
					NTIS 메인페이지로 이동하시거나, <br/>
					콜센터로 문의 주시기 바랍니다.
				</p>
		
				<p style="color:#00a0e9;">NTIS Help Desk : 042-869-1115 (<a href="mailto:ntis@kisti.re.kr">ntis@kisti.re.kr</a> )</p>
		
			</div>
		</div>

	</body>
</html>