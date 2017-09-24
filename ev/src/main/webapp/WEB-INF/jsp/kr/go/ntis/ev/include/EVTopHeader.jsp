<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%@ taglib prefix="c"       uri="http://java.sun.com/jsp/jstl/core" %>








		    <div class="globalHead">
		     <a href="http://www.ntis.go.kr" class="logo">NTIS 국가과학기술지식정보서비스</a>
		        
		        <div class="g_nav">      
		            <a href="javascript:doGlobalMenu();" id='headerGloblMenu' class="menu">메뉴</a>
		            <span class="search"><a href="javascript:doFastSearchToggle();">검색</a><img src="<c:url value='/images/th/2014/arrow_searchtab.png' />" alt="" id="search_tab"></span>
		            
		            <%-- 통합검색 --%> 
		            <div id="n_searchwrap">
						<div class="n_searchwrap_in">
							
								<input type="text" name="searchWord" id="searchWord" class="main_search" value="" title="NTIS 통합검색 검색어를 입력합니다." placeholder="검색어입력"  maxlength="22" onkeydown="beForeDoFastSearch();" />
								<input type="button" class="btn_search_main" value="검색" title="NTIS 통합검색을 합니다." onclick="doFastSearch();" />
								<a href="javascript:doAdvanceSearch();" id="btnGloblAdvancedSearch" class="ntis_global_search">통합검색</a>
								
						</div>  
					</div>
					
					
					
		            <c:if test="${ not empty loginVO.psnNm }">
		            	<a href="javascript:doGlobalUserMenu();" class="login">${ loginVO.psnNm }님</a>

						<%--		           		
		           		<c:if test="${ 'xowkdgur' eq loginVO.userId }">
		           			<a href="javascript:doGlobalUserMenu();" class="login">태장혁님</a>
		           		</c:if>
		           		<c:if test="${ 'haksadolee' eq loginVO.userId }">
		           			<a href="javascript:doGlobalUserMenu();" class="login">김준기님</a>
		           		</c:if>
		           		<c:if test="${ 'xowkdgur' ne loginVO.userId and 'haksadolee' eq loginVO.userId } ">
		           			<a href="javascript:doGlobalUserMenu();" class="login">${ loginVO.psnNm }님</a>
		           		</c:if>
		           		 --%>
		            </c:if>
		            <c:if test="${ empty loginVO.psnNm }">
		            	<a href="#;" class="login">로그인</a>
		            </c:if>
				</div>
		    </div> 
	 


			<!-- 글로벌 메뉴  -->       
			<div id="globalMenuLayer" style="display: none;"></div>
			
			<!-- 글로벌 사용자 메뉴  -->
			<div id="globalUserMenuLayer" style="display: none;"></div>
			
