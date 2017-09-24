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

				// 최종평가결과 더보기
				$("#btnGoList").click(function() {	
					$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
					$("#pjtFnerSearchVO").submit();  
				});
				
				// 평가참여이력 더보기
				$("#btnGoList1").click(function() {	
					$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
					$("#pjtFnerSearchVO").submit();  
				});
				
				// 상세보기 이벤트 바인딩
				fncPjtFnerView( $("[name=resultList]") );
				
				fncAsesorView( $("[name=resultList1]") );
				

				
				
				// 검색어 하이라이트
				var searchWord = "<c:out value='${pjtFnerSearchVO.searchWord}' />";
				
				 if(searchWord != null && searchWord.length > 0){
					
					 $("[name=resultList]").highlight(searchWord); 
					 $("[name=resultList1]").highlight(searchWord);

				 }

				
			});
			
			
			
			// 최종평가결과 상세보기
			function fncPjtFnerView(obj){
				obj.css("cursor", "pointer").click( function() {
					
					
					$("#pjtId").val($(this).attr("pjtId"));
					
					$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistR.do'/>");
					$("#pjtFnerSearchVO").submit();  
					
	             	   
				});
			}
			
			// 평가참여이력 상세보기
			function fncAsesorView(obj){
				obj.css("cursor", "pointer").click( function() {
					
					
					$("#rrno").val($(this).attr("rrno"));
					
					$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
					$("#pjtFnerSearchVO").submit();  
					
	             	   
				});
			}
			
			
			
			
			
			// 최종평가결과 페이지 이동
			function fncLinkPage(pageNo){
				$("#searchWord").val($("#tmpSearchWord").val());
				$("#pageIndex").val(pageNo);
				
				$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/search/EVPjtFnerSearchL.do'/>");
				$("#pjtFnerSearchVO").submit();
				
			}
			
			// 평가참여이력 페이지 이동
			function fncLinkPage1(pageNo){
				$("#searchWord").val($("#tmpSearchWord").val());
				$("#pageIndex1").val(pageNo);
				 
				
				$("#pjtFnerSearchVO").attr("action", "<c:url value='/hist/search/EVPjtFnerSearchL.do'/>");
				$("#pjtFnerSearchVO").submit();
				
			}
			
		</script>			
    
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">

    <form:form commandName="pjtFnerSearchVO" name="pjtFnerSearchVO" method="post">
    	<input type="hidden" name="pjtId" id="pjtId" />
    	<input type="hidden" name="rrno" id="rrno" />
    	<input type="hidden" name="tmpSearchWord" id="tmpSearchWord" value="${ pjtFnerSearchVO.searchWord }"/>
    	
        
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

	    	<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include>


			<%-- pageBox --%>
		    <div class="pageBox">
				<div class="section1">
		        	
		        	<div class="page_header">
		            	<h2>검색</h2>
	              	</div>  




					

					<%-- 목록 시작 --%>
					<h3 class="t_head">최종평가결과  <span>| 검색결과 : ${paginationInfo.totalRecordCount }건</span>
						<span style="float: right">
						<!-- <input type="button" value="더보기" class="btn_blue" id="btnGoList"> -->
					</span>
					</h3>

					<table class="table1">
						<thead>
							<COLGROUP>
								<COL width="7%">
								<COL width="9%">
								<COL width="13%">
								<COL width="17%">
								<COL width="*">
								<COL width="12%">  
								<COL width="7%">
								<COL width="7%">
								<COL width="9%">
							</COLGROUP>
							<tr>
								<th rowspan="2" scope="col" class="no">순번</th>	
								<th rowspan="2" scope="col" class="title">기준년도</th>
								<th rowspan="2" scope="col" class="title">부처명</th>
								<th rowspan="2" scope="col" class="title">수행기관명</th>
								<th rowspan="2" scope="col" class="title">과제명</th>
								<th rowspan="2" scope="col" class="last">연구책임자명</th>
								<th colspan="2" scope="col" class="last">평가결과</th>					
								<th rowspan="2" scope="col" class="last">과제<br />중단여부</th>
							</tr>
							<tr>
								<th scope="col" class="last">점수</th>
								<th scope="col" class="last">등급</th>
							</tr>
						</thead>
						 
						<tbody>
						
							<c:forEach var="result" items="${pjtFnerResultList}" varStatus="status">
		            			<tr name="resultList" pjtId="${result.pjtId}" >
		            				<td class="no"><c:out value="${result.rn}"/></td>
		            				<td class="num"><c:out value="${result.stanYr}"/></td>
		            				<td class="num"><c:out value="${result.progMstrNm}"/></td>
		            				<td class="num"><c:out value="${result.pjtPrfrmOrgNm}"/></td>
		            				<td class="title"><c:out value="${result.korPjtNm}"/></td>
		            				<td class="num"><c:out value="${result.mngrHmNm}"/></td>
		            				<td class="num"><c:out value="${result.pjtFinalAssmtPts}"/></td>
		            				<td class="num"><c:out value="${result.pjtFinalAssmtGrdDes}"/></td>
		            				<td class="last"><c:out value="${result.pjtStopYn}"/></td>
		            			</tr>
		        			</c:forEach>
		        			
		    
		        			<c:if test="${ empty pjtFnerResultList }">
								<tr>
									<td class="last" colspan="9" >조회결과가 없습니다.</td>
								</tr>
							</c:if>  
							
							
						</tbody>  
		        
		               </table>
		               
		               <%-- 목록 끝 --%>

						
						<%-- 페이지 네비게이션 --%>
			        	<div style="margin:10px 0; display:block">
		                    <div id="pagination">
				        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fncLinkPage" />
				        		<form:hidden path="pageIndex" />
			        		</div>
			        	</div>
						<%-- //페이지 네비게이션 --%>
						
						
						<%-- 하단 버튼 시작 --%>
						<%--
						<div class="tr">
							<input type="button" value="등록" class="btn_blue">
						</div>
						 --%>
						<%-- 하단 버튼 시작 --%>
						
						
						<%-- 목록 시작 --%>
					<h3 class="t_head">평가참여이력  <span>| 검색결과 : ${paginationInfo1.totalRecordCount }건</span>
					<span style="float: right">
						<!-- <input type="button" value="더보기" class="btn_blue" id="btnGoList1"> -->
					</span>											
					</h3>

					<table class="table1">
	
						<thead>
						<COLGROUP>
						  <COL width="8%">
						  <COL width="15%">
						  <COL width="17%">
						  <COL width="25%">
						  <COL width="*">					  
						</COLGROUP> 
						<tr>
						<th scope="col" class="no">순번</th>	
						<th scope="col" class="title">평가위원명</th>
						<th scope="col" class="title">과학기술인등록번호</th>
						<th scope="col" class="title">소속기관</th>
						<th scope="col" class="last">부처별 분야분류</th>
						</tr>
						</thead> 
					 
					<tbody>
							
						<c:forEach var="result" items="${asesorAssmtPrtcpResultList}" varStatus="status">
	            			<tr name="resultList1" rrno="${result.rrno}" >
	            				<td class="no"><c:out value="${result.rn}"/></td>
	            				<td class="num"><c:out value="${result.asesorHmNm}"/></td>
	            				<td class="num"><c:out value="${result.rrno}"/></td>
	            				<td class="num"><c:out value="${result.orgNm}"/></td>
	            				<td class="last"><c:out value="${result.orgCls }"/></td>
	            			</tr>
	        			</c:forEach>
	        			
	        			<c:if test="${ empty asesorAssmtPrtcpResultList }">
							<tr>
								<td class="last" colspan="5" >조회결과가 없습니다.</td>
							</tr>
						</c:if>  
						
						
					</tbody>  
	        
	               </table>
		               
		               <%-- 목록 끝 --%>

						
						<%-- 페이지 네비게이션 --%>
			        	<div style="margin:10px 0; display:block">
		                    <div id="pagination">
				        		<ui:pagination paginationInfo = "${paginationInfo1}" type="image" jsFunction="fncLinkPage1" />
				        		<form:hidden path="pageIndex1" />
			        		</div>
			        	</div>
						<%-- //페이지 네비게이션 --%>
						
						
						<%-- 하단 버튼 시작 --%>
						<%--
						<div class="tr">
							<input type="button" value="등록" class="btn_blue">
						</div>
						 --%>
						<%-- 하단 버튼 시작 --%>

               

				</div> 
			</div>
			<%-- // pageBox --%>

		</div>

		<%--  copy right --%>
		<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVCopyright.jsp"></jsp:include>      
  
    </form:form>
    
	</body>
</html>
