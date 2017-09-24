<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form"    uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="ui"      uri="http://egovframework.gov/ctl/ui"%>
<%@ taglib prefix="spring"  uri="http://www.springframework.org/tags"%>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="fmt"     uri="http://java.sun.com/jsp/jstl/fmt"%>

<%
    pageContext.setAttribute("cn", "\n");     //Enter
    pageContext.setAttribute("br", "<br/>");  //br 태그
%> 

		<meta charset="utf-8">
		<meta name="viewport" content="width=device-width, initial-scale=1">
		
		<title>과제평가이력정보</title>
		
		<%-- 스타일 시트 --%>
		<%-- NTIS 표준 CSS --%>
		<link href="<c:url value='/css/th/2014/reset2014.css' />" rel="stylesheet" type="text/css">
		<link href="<c:url value='/css/th/2014/layout2015.css' />" rel="stylesheet" type="text/css">
		<link href="<c:url value='/css/th/2014/combo2015.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/btn2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/pagination2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/tab2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/table2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/globalsearch2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/search2014.css' />" rel="stylesheet" type="text/css" />
		<link href="<c:url value='/css/th/2014/temp2014.css' />" rel="stylesheet" type="text/css" />
		
		<%-- jquery-ui css --%>
		<link href="<c:url value='/css/jquery/ui/jquery-ui.css' />" rel="stylesheet" type="text/css" />
		
		<style type="text/css">
			.highlight { background-color: yellow }
		</style>
		

		
		
		
		
		
		
		<%-- 스크립트 --%>
		<%-- jquery --%>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery-1.10.2.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.maskedinput.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.blockUI.js' />"></script> 
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery-ui-1.12.0.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.popupoverlay.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.bpopup.min.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.highlight-4.js' />"></script>
		
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.checkbyte.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.textchange.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/jquery/jquery.uamatch.js' />"></script>
		
		
		<%-- flash --%>
		<script type="text/javascript" src="<c:url value='/js/kr/go/ntis/ev/swfobject_modified.js' />"></script>
		<script type="text/javascript" src="<c:url value='/js/kr/go/ntis/ev/flashObj.js' />"></script>
				
		<%-- ntis 글로발 공통 스크립트 --%>
		<script type="text/javascript" src="<c:url value='/js/kr/go/ntis/ev/ntisGlobalCommon.js' />"></script>
		
		<%-- 과제평가이력정보 공통 스크립트 --%>
		<script type="text/javascript" src="<c:url value='/js/kr/go/ntis/ev/evCommon.js' />"></script>
		

		