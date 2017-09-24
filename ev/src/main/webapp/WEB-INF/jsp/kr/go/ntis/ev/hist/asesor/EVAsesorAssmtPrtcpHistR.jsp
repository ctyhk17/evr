<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
  /**
  * @Class Name : ERPjtFnerHistL.jsp
  * @Description : 최종평가결과검색 화면
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2016.07.12            최초 생성
  *
  * author 태장혁
  * since 2016.07.12
  *
  */
%>

<!doctype html>
<html>
	<head>

    
	    <%@ include file="/WEB-INF/jsp/kr/go/ntis/ev/include/EVInclude.jsp" %>
    
    
    	<script type="text/javascript">
		
			$(document).ready(function () {  

				// 검색화면으로 이동
				$("#btnGoList").click(function() {	
					fncGoList();
				});
				
				
				// 탭버튼 클릭 이벤트
				$("#btnTab00").click(function() {	
					$("#searchAssmtPhaseCd").val("");
					fncReload();
				});
				
				$("#btnTab01").click(function() {	
					$("#searchAssmtPhaseCd").val("01");
					fncReload();
				});
				
				$("#btnTab02").click(function() {	
					$("#searchAssmtPhaseCd").val("02");
					fncReload();
				});
				
				$("#btnTab03").click(function() {	
					$("#searchAssmtPhaseCd").val("03");
					fncReload();
				});
				
				$("#btnTab04").click(function() {	
					$("#searchAssmtPhaseCd").val("04");
					fncReload();
				});
				
				$("#btnTab05").click(function() {	
					$("#searchAssmtPhaseCd").val("05");
					fncReload();
				});
				
				
				orderEventSetting( $("[name=ordCol]") );
				
			});
			
			
			// 목록으로 이동
			function fncGoList(){
				
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();
			}
			
			function fncGoHurims(hrstKOI){
				var winWidth = 1024	; // 새창 너비
				var winHeight = 768; // 새창 높이
				var winPosLeft = (screen.width - winWidth) / 2; // 새창 Y 좌표
				var winPosTop = (screen.height - winHeight) / 2; // 새창 X 좌표
				var winOpt = "width=" + winWidth + ",scrollbars=yes, resizable=yes, height=" + winHeight + ",top="+winPosTop+",left="+winPosLeft;
				window.open("https://hurims.ntis.go.kr/detail/selectDetailInfo.do?hrstKOI="+hrstKOI, "hurimsDetailView");
				
			}
			
			
			function fncReload(){
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();
			}
			
			
			function orderEventSetting( tdObj ) {
				tdObj.css("cursor", "pointer").click( function() {
	                	
					var tmpOrderItem  = $("#orderItem").val();
		            var tmpOrderDivCd = $("#orderDivCd").val();
		                	
		            var orderItem  = $(this).attr("orderItem");
		                	
		            if(tmpOrderItem == orderItem)
	                {
		            	if(tmpOrderDivCd == "ASC")
		                	$("#orderDivCd").val("DESC");
		                else
		                	$("#orderDivCd").val("ASC");
	                }else{
	                	$("#orderItem").val(orderItem);
						$("#orderDivCd").val("ASC");
	                }
					
		            fncReload()
	                	
				});
			}
			
			
			
		</script>			
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">

    <form:form commandName="asesorAssmtPrtcpHistVO" name="asesorAssmtPrtcpHistVO" method="post">
    	<form:hidden path="searchFlag" />
    	<form:hidden path="pageIndex" /> 			<%-- 페이지 인덱스    :  --%>
    	<form:hidden path="recordCountPerPage" />
    	
    	<form:hidden path="rrno" /> 				<%-- 과학기술인번호 :  --%>
    	<form:hidden path="searchAssmtPhaseCd" /> 	<%-- 검색 단계코드 :  --%>
    	
		
		<form:hidden path="searchAsesorHmNm" />
		<form:hidden path="searchGenderDivCd" />
		<form:hidden path="searchBlngOrgNm" />
		<form:hidden path="searchPjtAssmtPrtcpYrFrom" />
		<form:hidden path="searchPjtAssmtPrtcpYrTo" />
		<form:hidden path="searchRrno" />  
		
		<form:hidden path="orderItem" />
		<form:hidden path="orderDivCd" />
		
	        
        <div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

		    <jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include>




			<!-- pageBox -->
			<div class="pageBox">
				<div class="section1">
					
					<div class="page_header">
						<h2>평가참여이력 검색 </h2>
					</div>  
					
					
					<%-- 컨텐츠 영역 시작 --%>	
        	
        	
        			<%-- 과제정보 --%>
					<h3 class="t_head">평가위원 정보</h3>
					
					<div class="tabler">
            			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		            		<colgroup>
								<col style="width:20%;">
								<col style="width:30%;">
								<col style="width:20%;">
		                        <col style="width:*;">
							</colgroup>
							 <tr>
				    			<th>성명</th>
				    			<td><c:out value="${ resultInfo.asesorHmNm }" /></td>
				    			<th>과학기술인등록번호</th>
				    			<td><c:out value="${ resultInfo.rrno }" /></td>
				    		</tr>
				    		<%--
				    		<tr>
				    			<th>성별</th>
				    			<td><c:out value="${ resultInfo.sexGbNm }" /></td>
				    			<th>생년월일</th>
				    			<td><c:out value="${ resultInfo.birthYmd}" /></td>
				    		</tr>
				    		<tr>
				    			<th>핸드폰번호</th>
				    			<td><c:out value="${ resultInfo.cp }" /></td>
				    			<th>E-mail</th>
				    			<td><c:out value="${ resultInfo.email}" /></td>
				    		</tr>
				    		 --%>
				    		<tr>
				    			<th>부처별 분야분류</th>
				    			<td colspan="3"><c:out value="${fn:replace(resultInfo.orgCls, '|', ',')}" escapeXml="false"/></td>
				    		</tr>
							</table>
					</div>		
					
      
					<!-- 하단버튼 -->
					<div class="tr">
						<a href="javascript:fncGoHurims('<c:out value="${ resultInfo.koiNo}" />');" role="button" class="btn_blue" title="상세보기팝업을 생성합니다.">더보기</a>
					</div>
					
      
      
      
      
					<%-- 타이틀  --%>
					<h3 class="t_head">과거평가이력</h3>
		        	
		        	
					<div class="tab">
		                <ul>
			                <li <c:if test="${ empty asesorAssmtPrtcpHistVO.searchAssmtPhaseCd }"   >class="tab_on"</c:if> ><a href="#;" id="btnTab00">전체</a></li>
			                <li <c:if test="${ asesorAssmtPrtcpHistVO.searchAssmtPhaseCd eq '01' }" >class="tab_on"</c:if> ><a href="#;" id="btnTab01">선정평가</a></li>
			                <li <c:if test="${ asesorAssmtPrtcpHistVO.searchAssmtPhaseCd eq '02' }" >class="tab_on"</c:if> ><a href="#;" id="btnTab02">중간평가</a></li>
			                <li <c:if test="${ asesorAssmtPrtcpHistVO.searchAssmtPhaseCd eq '03' }" >class="tab_on"</c:if> ><a href="#;" id="btnTab03">단계평가</a></li>
			                <li <c:if test="${ asesorAssmtPrtcpHistVO.searchAssmtPhaseCd eq '04' }" >class="tab_on"</c:if> ><a href="#;" id="btnTab04">최종평가</a></li>
			                <li <c:if test="${ asesorAssmtPrtcpHistVO.searchAssmtPhaseCd eq '05' }" >class="tab_on"</c:if> ><a href="#;" id="btnTab05">추적평가</a></li>
		                </ul>
					</div>
					
					
					
					<table class="table1">
						<COLGROUP>
							  <COL width="8%">
							  <COL width="20%">					  
							  <COL width="*">	
							  <COL width="14%">
							  <COL width="15%">				  
							  <COL width="11%">
							</COLGROUP> 
						<thead>
							<tr>
								<th scope="col" class="no">순번</th>	
								<th name="ordCol" orderItem="PJT_PRFRM_ORG_NM"   orderDivCd="ASC" scope="col" class="title">과제수행기관 <c:if test="${ asesorAssmtPrtcpHistVO.orderItem eq 'PJT_PRFRM_ORG_NM'}"><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
								<th name="ordCol" orderItem="KOR_PJT_NM" 		 orderDivCd="ASC" scope="col" class="title">과제명 <c:if test="${ asesorAssmtPrtcpHistVO.orderItem eq 'KOR_PJT_NM'}"><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
								<th name="ordCol" orderItem="MNGR_HM_NM" 		 orderDivCd="ASC" scope="col" class="title">연구책임자명 <c:if test="${ asesorAssmtPrtcpHistVO.orderItem eq 'MNGR_HM_NM'}"><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
								<th name="ordCol" orderItem="PJT_ASSMT_PRTCP_YM" orderDivCd="ASC" scope="col" class="title">평가참여년월 <c:if test="${ asesorAssmtPrtcpHistVO.orderItem eq 'PJT_ASSMT_PRTCP_YM'}"><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
								<th name="ordCol" orderItem="ASSMT_PHASE_CD_NM"  orderDivCd="ASC" scope="col" class="last">평가단계 <c:if test="${ asesorAssmtPrtcpHistVO.orderItem eq 'ASSMT_PHASE_CD_NM'}"><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ asesorAssmtPrtcpHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
							</tr>
							</thead> 
					 
							<tbody>
							
								<c:forEach var="result" items="${resultList}" varStatus="status">
				            			<tr name="resultList" rrno="${result.rrno}" >
				            				<td class="no"><c:out value="${result.rn}"/></td>
				            				<td class="num"><c:out value="${result.pjtPrfrmOrgNm}"/></td>
				            				<td class="num"><c:out value="${result.korPjtNm}"/></td>
				            				<td class="num"><c:out value="${result.mngrHmNm}"/></td>
				            				<td class="num"><c:out value="${result.pjtAssmtPrtcpYm}"/></td>
				            				<td class="last"><c:out value="${result.assmtPhaseCdNm}"/></td>
				            			</tr>
				        			</c:forEach>
				        			
				        			<c:if test="${ empty resultList }">
										<tr>
											<td class="last" colspan="6">조회결과가 없습니다.</td>
										</tr>
									</c:if>  
								
								
							</tbody>  
	        
					</table>
	             
      		
		      		
        	
      
					<%-- 하단버튼  --%>
					<div class="tr">
						<input type="button" value="목록" class="btn_blue" id="btnGoList">
					</div>
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	
			    	<%-- 컨텐츠 영역 끝 --%>
				
				</div> 
			</div>
			<!-- // pageBox -->

		</div>

		<!--  copy right -->
		<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVCopyright.jsp"></jsp:include>      
		
		
        	
    </form:form>
    
	</body>
</html>