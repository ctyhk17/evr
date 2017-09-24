<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn"      uri="http://java.sun.com/jsp/jstl/functions" %>




		    <div class="tempHead">
		    
		    	<h1><a href="<c:url value='/itr/idx/EVPjtFnerHistItrR.do' />"><img src="<c:url value='/images/th/2016/sublogo.png' />"></a></h1>
		        
		        <div class="nav">
		        	
		            <a href="<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>"              <c:if test="${ fn:startsWith(reqUrl, '/hist/pjt/EVPjtFnerHist') }">class="navOn"</c:if> >최종평가결과검색</a>
		            <a href="<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>"  <c:if test="${ fn:startsWith(reqUrl, '/hist/asesor/EVAsesorAssmtPrtcpHist') }">class="navOn"</c:if> >평가참여이력검색</a>
		            <a href="<c:url value='/info/law/EVAdsubLawInfoR.do'/>"              <c:if test="${ fn:startsWith(reqUrl, '/info/law/EVAdsubLawInfo') }">class="navOn"</c:if> >법령정보</a>
		            <c:if test="${ 'EV9999' eq loginVO.ruleCd }">
		            	<a href="<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do' />"      <c:if test="${ fn:startsWith(reqUrl, '/mgnt/adsub/EVPjtFnerAdsubMgnt') }">class="navOn"</c:if>>가감점관리</a>
		            	<a href="<c:url value='/mgnt/log/EVPjtAssmtHistInfoLogL.do' />"      <c:if test="${ fn:startsWith(reqUrl, '/mgnt/log/EVPjtAssmtHistInfoLog') }">class="navOn"</c:if>>접속이력관리</a>
		            </c:if>
		        </div>
		        
		    </div>
