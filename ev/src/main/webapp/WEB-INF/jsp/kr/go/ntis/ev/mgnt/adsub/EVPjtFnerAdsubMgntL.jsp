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
				$("#btnRetrieve").click(function() {	
					fncRetrieve();
				});
				
				// 초기화
				$("#btnClear").click(function() {	
					
					$("[searchItem=true]").each(
						function(){
							
							if($(this).attr('type') == "radio")
							{
								$(this).filter(":radio[value='']").prop("checked", true);
							
							}else if($(this).attr('type') == "checkbox")
							{
								$(this).prop("checked", true);
							}else{
								$(this).val("");
							}
						}
					);
					
					// 조회
					fncRetrieve();
					
				});
				
				// 엔터키 이벤트
				$("[searchItem=true]").keydown(function(e) {
			        if (e.keyCode == 13) {
			        	fncRetrieve();
			        }
			    }); 
				
				// 페이지수 변경
				$("#recordCountPerPage").change(function() {
					fncRetrieve();
				});

				// 등록
				$("#btnCreate").click(function() {	
					fncCreate();
				});
				
				
				fncView( $("[name=resultList]") );

			});
			
			
			// 조회
			function fncRetrieve(){
				$("#pageIndex").val("1");
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
			// 등록
			function fncCreate(){
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntI.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
			
			function fncView(obj){
				obj.css("cursor", "pointer").click( function() {

					$("#adsubMgntNo").val($(this).attr("adsubMgntNo"));
					
					$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntR.do'/>");
					$("#pjtFnerAdsubMgntVO").submit();  
					
	             	   
				});
			}
			
			
			
			
			
			// 페이지 이동
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
				
			}
			
		</script>
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
    
    <form:form commandName="pjtFnerAdsubMgntVO" name="pjtFnerAdsubMgntVO" method="post">
        <input type="hidden" name="adsubMgntNo" id="adsubMgntNo" />
	 
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include> 
			

			<!-- pageBox -->
			<div class="pageBox">
				<div class="section1">
	                <div class="page_header">
	                   <h2>가감점관리 </h2>
					</div>  
		              
	              
					<%-- 컨텐츠 시작 --%>	              
	              
					
					<div class="tabler">
			            <table width="100%" border="0" cellspacing="0" cellpadding="0">
							<colgroup>
								<COL width="15%">
								<COL width="*">		
							</colgroup>
							<tr>
								<th>가감점구분</th>
								<td>
									<form:select path="searchAdsubSlctCd" style="width:100px;" searchItem="true">
										<form:option value="">전체</form:option>
										<c:forEach var="adsubSlctCd" items="${adsubSlctCdList}" varStatus="status">
											<form:option value="${adsubSlctCd.cd}">${adsubSlctCd.cdNm}</form:option>
										</c:forEach>
									</form:select>
								</td>
							</tr>
							<TR>
								<TH>가감점대상</TH>
								<TD>
									
									<c:forEach var="adsubTrgtCd" items="${adsubTrgtCdList}" varStatus="status">
										<form:checkbox path="searchAdsubTrgtCd" label="${ adsubTrgtCd.cdNm }" value="${adsubTrgtCd.cd}" searchItem="true" />
									</c:forEach>
										
										
									<%--
									<form:select path="searchAdsubTrgtCd" style="width:100px;" searchItem="true">
										<form:option value="">전체</form:option>
										<c:forEach var="adsubTrgtCd" items="${adsubTrgtCdList}" varStatus="status">
											<form:option value="${adsubTrgtCd.cd}">${adsubTrgtCd.cdNm}</form:option>
										</c:forEach>
									</form:select>
									 --%>		
								</TD>
							</TR>   
							<TR>
								<TH>가감점내용</TH>
								<TD>
									<form:input path="searchAdsubDes" style="width:99%"  searchItem="true" maxlength="50" />		
								</TD>
							</TR>
						</table>
					</div>
					<%-- 검색 조건 박스 끝 --%>

					<div class="tr">
						<a href="#;" class="btn_blue" id="btnRetrieve"><img src="<c:url value='/images/th/2014/spacer.gif' />" alt="검색" class="search">검색</a>
						<input type="button" value="초기화" class="btn_gray" id="btnClear">
					</div>
					
					<!-- ================================= -->
					<!-- 검색조건  끝 -->
					<!-- ================================= -->
					






					<h3 class="t_head">
						결과  <span>| 검색결과 : ${paginationInfo.totalRecordCount }건</span>
						<form:select path="recordCountPerPage" style="width:80px;float: right;height:32px;" searchItem="true">
								<form:option value="10">10</form:option>
								<form:option value="30">30</form:option>
								<form:option value="50">50</form:option>
							</form:select>
					</h3>

	                <table class="table1">
						<COLGROUP>
						  <COL width="6%">
						  <COL width="6%">
						  <COL width="6%">
						  <COL width="*">
						  <COL width="10%">
						  <COL width="16%">
						  <COL width="10%">
						  <COL width="12%">
						  <COL width="10%">
						</COLGROUP> 
						
						<thead>
						
						<tr>
						<th scope="col" class="no">순번</th>
						<th scope="col" class="title">구분</th>	
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
							<c:forEach var="result" items="${resultList}" varStatus="status">
	            			<tr name="resultList" adsubMgntNo="${result.adsubMgntNo}" >
	            				<td class="no"><c:out value="${result.rn}"/></td>
	            				<td class="num"><c:out value="${result.adsubSlctCdNm}"/></td>
	            				<td class="num"><c:out value="${result.adsubItem}"/></td>
	            				<td class="title"><c:out value="${result.adsubDes}"/></td>
	            				<td class="num"><c:out value="${fn:replace(result.adsubTrgtCdNm, ',', ',<br />')}" escapeXml="false"/></td>
	            				<td class="num"><c:out value="${result.adsubApplOrgSlctCdNm}"/></td>
	            				<td class="num"><c:out value="${result.adsubGrantDes}"/></td>
	            				<td class="num"><c:out value="${result.adsubApplStanDtSlctCdNm}"/></td>
	            				<td class="last"><c:out value="${result.adsubApplProdDes}"/></td>
	            			</tr>
	        			</c:forEach>
	        			
	        			<c:if test="${ empty resultList }">
							<tr>
								<td colspan="9" class="num">조회결과가 없습니다.</td>
							</tr>
						</c:if>  
							
							
						</tbody>  
	         
	                </table>
                	              
	              
        	
        	
        	
	        		<%-- 페이지 네비게이션 --%>
		        	<div style="margin:10px 0; display:block">
	                    <div id="pagination">
			        		<ui:pagination paginationInfo = "${paginationInfo}" type="image" jsFunction="fncLinkPage" />
			        		<form:hidden path="pageIndex" />
		        		</div>
		        	</div>
					<%-- //페이지 네비게이션 --%>


	

					<%-- 하단 버튼 시작 --%>
					<div class="tr">
						<input type="button" value="등록" class="btn_blue" id="btnCreate">
					</div>
					<%-- 하단 버튼 시작 --%>
						


					<%-- 컨텐츠 끝 --%>

				</div> 
			</div>
			<!-- // pageBox -->



		</div>

		<!--  copy right -->
		<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVCopyright.jsp"></jsp:include>      
		
		
		
		
    </form:form>
    
	</body>
</html>
