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
		
				// 검색
				$("#btnGoList").click(function() {	
					fncGoList();
				});
				
				// 평가결과등급내용 (팝업)
				$("#btnPopGrade").click(function(e) {	
					// Prevents the default action to be triggered. 
	                e.preventDefault();

	            	$('#divGrade').bPopup({
	                    modalClose: true,
	                    opacity: 0,
	                    positionStyle: 'fixed' 
	                });

				});
				
				// 평가결과등급내용 (팝업) 닫기
				$("#btnCloseGrade").click(function() {	
					var bPopup = $("#divGrade").bPopup();
		       		bPopup.close();
				});
				
				
				// 과제중단유형 (팝업)
				$("#btnPopStopType").click(function(e) {	
					// Prevents the default action to be triggered. 
	                e.preventDefault();

	            	$('#divStopType').bPopup({
	                    modalClose: true,
	                    opacity: 0,
	                    positionStyle: 'fixed' 
	                });

				});
				
				// 과제중단유형 (팝업) 닫기
				$("#btnCloseStopType").click(function() {	
					var bPopup = $("#divStopType").bPopup();
		       		bPopup.close();
				});
				
				
				<%--
				// 과제중단사유 (팝업)
				$("#btnPopStopRson").click(function(e) {	
					// Prevents the default action to be triggered. 
	                e.preventDefault();

	            	$('#divStopRson').bPopup({
	                    modalClose: true,
	                    opacity: 0,
	                    positionStyle: 'fixed' 
	                });

				});
				
				// 과제중단사유 (팝업) 닫기
				$("#btnCloseStopRson").click(function() {	
					var bPopup = $("#divStopRson").bPopup();
		       		bPopup.close();
				});
				
				--%>
				
				
				
				<%--
				// 가감점 내용 조회 (팝업)
				$("#btnPopAdsub").click(function(e) {	
					// Prevents the default action to be triggered. 
	                e.preventDefault();

	                // Triggering bPopup when click event is fired
					$('#divAdsub').bPopup({
	                    modalClose: true,
	                    opacity: 0,
	                    positionStyle: 'fixed' 
	                });
				});
				
				
				// 가감점 내용조회  (팝업) 닫기
				$("#btnCloseAdsub").click(function() {	
					var bPopup = $("#divAdsub").bPopup();
		       		bPopup.close();
				});
				--%>
				
				
					
				// 파일다운로드
				<%--
				$("#btnFileDownload").click(function() {	
					
					$("#orgFileNm").val("attach_file.hwp");
					$("#fileNm").val("국가연구개발사업의관리등에관한규정(제7조10항관련).hwp");
					
					
					$("#pjtFnerHistVO").attr("action", "<c:url value='/FileDownload.do'/>");
					$("#pjtFnerHistVO").submit();
				});
				--%>
				
				
						
				// 평가위원 목록에 상세조회 이벤트 설정
// 				fncView( $("[name=resultList]") );
				
				// 평가위원 목록 정렬 이벤트 설정
				orderEventSetting( $("[name=ordCol]") );
				
				
				
				// 검색어 하이라이트
				var searchWord = "<c:out value='${resultInfo.stopRsonCdNm}' />";
				
				 if(searchWord != null && searchWord.length > 0){
					
					 $("[name=resultCol]").highlight(searchWord); 

				 }
			});
			
		    
		    function fncGoSims(pjtId){
				var winWidth = 1024	; // 새창 너비
				var winHeight = 768; // 새창 높이
				var winPosLeft = (screen.width - winWidth) / 2; // 새창 Y 좌표
				var winPosTop = (screen.height - winHeight) / 2; // 새창 X 좌표
				var winOpt = "width=" + winWidth + ",scrollbars=yes, resizable=yes, height=" + winHeight + ",top="+winPosTop+",left="+winPosLeft;
				window.open("https://sims.ntis.go.kr/pjtinfo/pjtMainInfo.do?pjtInfoVo.pjtId="+pjtId, "simsDetailView");
				
			}
		    
			
			// 목록으로 이동
			function fncGoList(){
				
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
				$("#pjtFnerHistVO").submit();
			}
			
			
			//  평가위원 상세조회
			function fncView(obj){
				obj.css("cursor", "pointer").click( function() {
					
					$("#rrno").val($(this).attr("rrno"));
					
					$("#orderItem").val("PJT_PRFRM_ORG_NM");
					$("#orderDivCd").val("ASC");
					
					// 평가위원 상세로 이동
					$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
					$("#pjtFnerHistVO").submit();  
					
		         	   
				});
			}
			
			function fncView_Link(rrno){
				$("#rrno").val(rrno);	
				
				$("#orderItem").val("PJT_PRFRM_ORG_NM");
				$("#orderDivCd").val("ASC");
				
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
				$("#pjtFnerHistVO").submit();	
            	
			}
			
			
			// 평가위원 목록 정렬
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
			
			// 새로고침
			function fncReload(){
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistR.do'/>");
				$("#pjtFnerHistVO").submit();
			}
			
		</script>			
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">

    <form:form commandName="pjtFnerHistVO" name="pjtFnerHistVO" method="post">
    	<form:hidden path="searchFlag" />
    	<form:hidden path="pageIndex" />
    	<form:hidden path="recordCountPerPage" />
    	
    	
    	<form:hidden path="pjtId" />
    	<form:hidden path="rrno" />
		        
		        
		<form:hidden path="searchStanYrFrom" />
		<form:hidden path="searchStanYrTo" />
		<form:hidden path="searchPjtStopYn" />
		
		<form:hidden path="searchDeptDivCd" />
		<form:hidden path="searchDeptCd" />
		<form:hidden path="searchPjtMgntOrgNm" />
		<form:hidden path="searchBzNm" />
		<form:hidden path="searchKorPjtNm" />
		<form:hidden path="searchMngrHmNm" />
		<form:hidden path="searchPjtPrfrmOrgNm" />
		
		<form:hidden path="orderItem" />
		<form:hidden path="orderDivCd" />
		
		<input type="hidden" name="fileNm" id="fileNm" />
		<input type="hidden" name="orgFileNm" id="orgFileNm" />
         
         
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

		    <jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include>




			<!-- pageBox -->
			<div class="pageBox">
				<div class="section1">
                	<div class="page_header">
						<h2>최종평가결과 검색 </h2>
					</div>  



					<%-- 컨텐츠 영역 시작 --%>
					
					
					<%-- 과제정보 --%>
					<h3 class="t_head">과제정보</h3>
					
					<div class="tabler">
            			<table width="100%" border="0" cellspacing="0" cellpadding="0">
		            		<colgroup>
								<col style="width:20%;">
								<col style="width:30%;">
								<col style="width:20%;">
		                        <col style="width:*;">
							</colgroup>
							 <tr>
				    			<th>과제고유번호</th>
				    			<td>${ resultInfo.pjtId }</td>
				    			<th>당해년도 연구기간</th>
				    			<td>${ resultInfo.tsyrRschStartDt} ~ ${ resultInfo.tsyrRschEndDt}</td>
				    		</tr>
				    		<tr>
				    			<th>(기관)세부과제번호</th>
				    			<td>${ resultInfo.pjtNo }</td>
				    			<th>총 연구기간</th>
				    			<td>${ resultInfo.totRschStartDt} ~ ${ resultInfo.totRschEndDt}</td>
				    		</tr>
				    		<tr>
				    			<th>사업명</th>
				    			<td colspan="3">${ resultInfo.bzNm }</td>
				    		</tr>
				    		<tr>
				    			<th>과제명</th>
				    			<td colspan="3">${ resultInfo.korPjtNm }</td>
				    		</tr>				    		
				    		<tr>
				    			<th>과제수행기관</th>
				    			<td>${ resultInfo.pjtPrfrmOrgNm }</td>
				    			<th>연구책임자명</th>
				    			<td>${ resultInfo.mngrHmNm }</td>
				    		</tr>
				    		<tr>
				    			<th>과제관리(전문)기관</th>
				    			<td colspan="3">${ resultInfo.pjtMgntOrgNm }</td>
				    		</tr>
							</table>
					</div>	
					
					<!-- 하단버튼 -->
					<div class="tr">
						<a href="javascript:fncGoSims('<c:out value="${ resultInfo.pjtId}" />');" role="button" class="btn_blue" title="상세보기팝업을 생성합니다.">더보기</a>
					</div>				
					
					
					
	      			<%-- 타이틀 --%>
					<h3 class="t_head">최종평가결과</h3>
	        	
	        		<div class="tabler">
						<table width="100%" border="0" cellspacing="0" cellpadding="0">
		            		<colgroup>
								<col style="width:20%;">
								<col style="width:30%;">
								<col style="width:20%;">
		                        <col style="width:*;">
							</colgroup>
							 <tr>
				    			<th>과제최종평가일자</th>
				    			<td>${ resultInfo.pjtFnerAssmtDt }</td>
				    			<th>과제중단여부</th>
				    			<td>${ resultInfo.pjtStopYnNm }</td>
				    		</tr>
				    		<tr>
				    			<th>평가구분</th>
				    			<td>${ resultInfo.pjtFinalAssmtSlctCdNm }</td>
				    			<th>과제중단유형</th>
				    			<td>${ resultInfo.stopTypeCdNm }&nbsp;
				    				<c:if test="${ not empty resultInfo.stopTypeCdNm }">
				    					<a href="#;" id="btnPopStopType"><img src="<c:url value='/images/th/2016/searchicon.png' />"></a>
				    				</c:if>
				    				
				    			</td>
				    			
				    		</tr>
				    		<tr>
				    			<th>평가결과점수</th>
				    			<td>${ resultInfo.pjtFinalAssmtPts }</td>
				    			<th>과제중단사유</th>
				    			<td>${ resultInfo.stopRsonCdNm }&nbsp;
				    				<%--
				    				<c:if test="${ not empty resultInfo.stopRsonCdNm }">
				    					<a href="#;" id="btnPopStopRson"><img src="<c:url value='/images/th/2016/searchicon.png' />"></a>
				    				</c:if>
				    				 --%>
				    			</td>
				    		</tr>
				    		<tr>
				    			<th>평가결과등급내용</th>
				    			<td>${ resultInfo.pjtFinalAssmtGrdDes }&nbsp;<a href="#;" id="btnPopGrade"><img src="<c:url value='/images/th/2016/searchicon.png' />"></a></td>
				    			
				    			<th>가·감점 후보추천</th>
				    			<td>${resultInfo.abevRecommend }</td>
				    			 
				    		</tr>
						</table>
					</div>	
					<c:if test="${ 'Y' eq resultInfo.clgtPjtAssmtYn }">
						<p style="line-height:1.7em;">※ 본 최종평가결과는 총괄과제 평가 기준의 결과이므로, 최총연차과제의 제1세부과제로 매핑 한 결과 입니다.</p>
					</c:if>
					
					
	        		
	        		<%-- 평가등급 --%>
					<div id="divGrade" class="popuplayerbox" style="display: none;">
						
						<h3 class="t_head">평가등급 (평가에 적용된 해당 평가기준)</h3>
						
						<table class="table1">
							<colgroup>
								<COL width="100">
								<COL width="100">
								<COL width="100">
							</colgroup>
							<thead>
								<tr>
					      				<th class="title" scope="col">등급</th>
					      				<th class="title" scope="col">상대평가</th>
					      				<th class="title" scope="col">절대평가</th>
					      			</tr>
							</thead> 
							<tbody>
								
								<c:forEach var="orgAssmtGrd" items="${orgAssmtGrdList}" varStatus="status">
									
									<c:if test="${ resultInfo.pjtFinalAssmtGrdDes eq orgAssmtGrd.pjtFinalAssmtGrdNm }" >
										<TR>
											<TD class="no"><span style="background-color: yellow;"><c:out value="${orgAssmtGrd.pjtFinalAssmtGrdNm}"/></span></td>
											<TD class="num"><span style="background-color: yellow;"><c:out value="${not empty orgAssmtGrd.rlevStanVal ? orgAssmtGrd.rlevStanVal : '해당없음' }"/></span></td>						
											<TD class="last"><span style="background-color: yellow;"><c:out value="${not empty orgAssmtGrd.abevStanVal ? orgAssmtGrd.abevStanVal : '해당없음' }"/></span></td>						
										</TR>
									</c:if>
									<c:if test="${ resultInfo.pjtFinalAssmtGrdDes ne orgAssmtGrd.pjtFinalAssmtGrdNm }" >
										<TR>
											<TD class="no"><c:out value="${orgAssmtGrd.pjtFinalAssmtGrdNm}"/></td>
											<TD class="num"><c:out value="${not empty orgAssmtGrd.rlevStanVal ? orgAssmtGrd.rlevStanVal : '해당없음' }"/></td>						
											<TD class="last"><c:out value="${not empty orgAssmtGrd.abevStanVal ? orgAssmtGrd.abevStanVal : '해당없음' }"/>&nbsp;</td>						
										</TR>
									</c:if>
								</c:forEach>
					      			
								<c:if test="${ empty orgAssmtGrdList }">
									<tr>
										<td class="last" colspan="3">조회결과가 없습니다.</td>
									</tr>
								</c:if>  
							</tbody>  
						</table>
						
						<div class="tc">
							<input type="button" value="닫기" class="btn_gray" id="btnCloseGrade">
						</div>
						
						
						
						
					</div>
					
					
					
					<%-- 중단유형 --%>
					<div id="divStopType" class="popuplayerbox" style="display: none;">
						
						<h3 class="t_head">중단유형 및 중단사유</h3>
						
						<table class="table1">
							<colgroup>
								<COL width="150">
								<COL width="400">
							</colgroup>
							<thead>
								<tr>
					      				<th class="title" scope="col">중단유형</th>
					      				<th class="title" scope="col">중단사유</th>
					      			</tr>
							</thead> 
							<tbody>
								
								
								
								
								
								
								
								<c:forEach var="stopTypeRsonCd" items="${stopTypeRsonCdList}" varStatus="status">
									<TR>
										<TD class="no">
											<c:if test="${ resultInfo.stopTypeCdNm eq stopTypeRsonCd.cdNm }" >
												<span style="background-color: yellow;">${ stopTypeRsonCd.cdNm }</span>
											</c:if>
											<c:if test="${ resultInfo.stopTypeCdNm ne stopTypeRsonCd.cdNm }" >
												${ stopTypeRsonCd.cdNm }
											</c:if>
										</td>						
										<TD name="resultCol" class="last" style="text-align: left;">
											${ stopTypeRsonCd.stopRsonNm }																						
										</td>						
									</TR>
								</c:forEach>
					      			
								<c:if test="${ empty stopTypeRsonCdList }">
									<tr>
										<td class="last" colspan="2">조회결과가 없습니다.</td>
									</tr>
								</c:if>  
							</tbody>  
						</table>
						
						<div class="tc">
							<input type="button" value="닫기" class="btn_gray" id="btnCloseStopType">
						</div>
						
						
						
						
					</div>
					
					
					<%-- 중단사유 --%>
					<%--
					<div id="divStopRson" class="popuplayerbox" style="display: none;">
						
						<h3 class="t_head">과제중단사유</h3>
						
						<table class="table1">
							<colgroup>
								<COL width="80">
								<COL width="250">
							</colgroup>
							<thead>
								<tr>
					      				<th class="title" scope="col">코드</th>
					      				<th class="title" scope="col">코드명</th>
					      			</tr>
							</thead> 
							<tbody>
								
								<c:forEach var="stopRsonCd" items="${stopRsonCdList}" varStatus="status">
									<c:if test="${ resultInfo.stopRsonCd eq stopRsonCd.cd }" >
										<TR>
											<TD class="no"><span style="background-color: yellow;"><c:out value="${not empty stopRsonCd.cd ? stopRsonCd.cd : '해당없음' }"/></span></td>						
											<TD class="last" style="text-align: left;"><span style="background-color: yellow;"><c:out value="${not empty stopRsonCd.cdNm ? stopRsonCd.cdNm : '해당없음' }"/></span></td>						
										</TR>
									</c:if>
									<c:if test="${ resultInfo.stopRsonCd ne stopRsonCd.cd }" >
										<TR>
											<TD class="no"><c:out value="${not empty stopRsonCd.cd ? stopRsonCd.cd : '해당없음' }"/></td>						
											<TD class="last" style="text-align: left;"><c:out value="${not empty stopRsonCd.cdNm ? stopRsonCd.cdNm : '해당없음' }"/>&nbsp;</td>						
										</TR>
									</c:if>
									
								</c:forEach>
					      			
								<c:if test="${ empty stopRsonCdList }">
									<tr>
										<td class="last" colspan="2">조회결과가 없습니다.</td>
									</tr>
								</c:if>  
							</tbody>  
						</table>
						
						<div class="tc">
							<input type="button" value="닫기" class="btn_gray" id="btnCloseStopRson">
						</div>
						
						
						
						
					</div>
					--%>
					
					
					
					
					<%-- 연구개발과제 선정의 우대가점의 기준 및 방법 --%>
					<%--
					<div id="divAdsub" class="popuplayerbox" style="display: none;">
						
						<h3 class="t_head">연구개발과제 선정의 우대·감점의 기준 및 방법</h3>
						
						<table class="table1">
							<colgroup>
								<COL width="70">
								<COL width="70">
								<COL width="200">
								<COL width="100">
								<COL width="170">
								<COL width="100">
								<COL width="120">
								<COL width="90">
							</colgroup>
							<thead>
								<tr>
					      				<th scope="col" class="no">구분</th>	
										<th scope="col" class="title">항목</th>
										<th scope="col" class="title">내용</th>
										<th scope="col" class="title">대상</th>
										<th scope="col" class="title">적용기관</th>
										<th scope="col" class="title">가감점<br/>부여내용</th>
										<th scope="col" class="title">적용기준일자</th>
										<th scope="col" class="last">적용기간</th>
					      			</tr>
							</thead> 
							<tbody>
								
								<c:forEach var="adsubCd" items="${adsubCdList}" varStatus="status">
		            			<tr>
		            				<td class="no"><c:out value="${adsubCd.adsubSlctCdNm}"/></td>
		            				<td class="num"><c:out value="${adsubCd.adsubItem}"/></td>
		            				<td class="num"><c:out value="${adsubCd.adsubDes}"/></td>
		            				<td class="num"><c:out value="${fn:replace(adsubCd.adsubTrgtCdNm, ',', ',<br />')}" escapeXml="false"/></td>
		            				<td class="num"><c:out value="${adsubCd.adsubApplOrgSlctCdNm}"/></td>
		            				<td class="num"><c:out value="${adsubCd.adsubGrantDes}"/></td>
		            				<td class="num"><c:out value="${adsubCd.adsubApplStanDtSlctCdNm}"/></td>
		            				<td class="last"><c:out value="${adsubCd.adsubApplProdDes}"/></td>
		            				
		            			</tr>
		        			</c:forEach>
		        			
		        			<c:if test="${ empty adsubCdList }">
								<tr>
									<td colspan="8">조회결과가 없습니다.</td>
								</tr>
							</c:if>  
							
							</tbody>  
						</table>
						
						<p style="line-height:1.7em;">※ 국가연구개발 사업의 관리 등에 관한 규정 (제 7조 10항 관련)&nbsp; <a href="#;" id="btnFileDownload" style="text-decoration: underline;">☞ 첨부파일 다운로드</a></p> 
						
						<div class="tc">
							<input type="button" value="닫기" class="btn_gray" id="btnCloseAdsub">
						</div>
					</div>	
					 --%>				
	      
	      
	      
	      
	      
	      			<%-- 평가위원정보 --%>
					<h3 class="t_head">평가위원정보</h3>
					
					<table class="table1">
						<COLGROUP>
								<col width="8%"/>
		        				<col width="12%"/>
		        				<col width="18%"/>
		        				<col width="30%"/>
		        				<col width="*"/>
							</COLGROUP>
							
						<thead>
							<tr>
								<th align="center">순번</th>
		        				<th name="ordCol" orderItem="ASESOR_HM_NM"   orderDivCd="ASC" align="center">평가위원명 <c:if test="${ pjtFnerHistVO.orderItem eq 'ASESOR_HM_NM'}"><c:if test="${ pjtFnerHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ pjtFnerHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
		        				<th name="ordCol" orderItem="RRNO"           orderDivCd="ASC" align="center">과학기술인등록번호 <c:if test="${ pjtFnerHistVO.orderItem eq 'RRNO'}"><c:if test="${ pjtFnerHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ pjtFnerHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
		        				<th name="ordCol" orderItem="ORG_NM"         orderDivCd="ASC" align="center">소속기관 <c:if test="${ pjtFnerHistVO.orderItem eq 'ORG_NM'}"><c:if test="${ pjtFnerHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ pjtFnerHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
		        				<th name="ordCol" orderItem="ORG_CLS"        orderDivCd="ASC" align="center">부처별 분야분류 <c:if test="${ pjtFnerHistVO.orderItem eq 'ORG_CLS'}"><c:if test="${ pjtFnerHistVO.orderDivCd eq 'ASC'}">▲</c:if><c:if test="${ pjtFnerHistVO.orderDivCd eq 'DESC'}">▼</c:if></c:if></th>
							</tr>
						</thead>
						 
						<tbody>
						
							<c:forEach var="result" items="${resultList}" varStatus="status">
		            			<tr name="resultList" rrno="${result.rrno}" >
		            				<td class="no"><c:out value="${result.rn}"/></td>
		            				<td class="num"><c:out value="${result.asesorHmNm}"/></td>
		            				<td name="resultCol" class="num">
										<a href="javascript:fncView_Link('<c:out value="${result.rrno}"/>');" style="color: #0000ff"><c:out value="${result.rrno}"/></a>		            				
		            				</td>
		            				<td class="num"><c:out value="${result.orgNm}"/></td>
		            				<td class="last"><c:out value="${fn:replace(result.orgCls, '|', ',')}" escapeXml="false"/></td>
		            			</tr>
		        			</c:forEach>
		        			
		        			<c:if test="${ empty resultList }">
								<tr>
									<td class="last" colspan="6" >조회결과가 없습니다.</td>
								</tr>
							</c:if>  
							
							
						</tbody>  
		        
		               </table>
		               
		               
		               
					
	        	
	        	
	      
					<!-- 하단버튼 -->
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


