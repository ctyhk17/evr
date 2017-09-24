<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
  /**
  * @Class Name : ERAsesorAssmtPrtcpHistL.jsp
  * @Description : 평가참여이력검색 화면
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

				$( "#searchPjtAssmtPrtcpYrFrom" ).datepicker().mask("9999-99-99");
				$( "#searchPjtAssmtPrtcpYrTo" ).datepicker().mask("9999-99-99");
				
				

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
							}else{
								$(this).val("");
							}
						}
					);
					
					
					$("#searchFlag").val("N");
					
					$("#pageIndex").val("1");
					
					// 조회
					$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
					$("#asesorAssmtPrtcpHistVO").submit();
					
				});
				
				// 엑셀 다운로드
				$("#btnExcel").click(function() {	
					fncExcelDown();
				});
				
				// 엔터키 이벤트
				//$("form input").keydown(function(e) {
				$("[searchItem=true]").keydown(function(e) {
			        if (e.keyCode == 13) {
			        	fncRetrieve();
			        }
			    }); 
				
				// 페이지수 변경
				$("#recordCountPerPage").change(function() {
					fncRetrieve();
				});
				
				//fncView( $("[name=resultCol]") );

			});
			
			
			// 조회
			function fncRetrieve(){
				
				// 평가참여기간 체크				
				var searchPjtAssmtPrtcpYrFrom = $("#searchPjtAssmtPrtcpYrFrom").val().replace(/-/gi, "");
				var searchPjtAssmtPrtcpYrTo   = $("#searchPjtAssmtPrtcpYrTo").val().replace(/-/gi, "");
				
				var searchAsesorHmNm           = $("#searchAsesorHmNm").val();
				var searchGenderDivCd          = $("input:radio[name='searchGenderDivCd']:checked").val();
				var searchBlngOrgNm            = $("#searchBlngOrgNm").val();
				var searchRrno                 = $("#searchRrno").val();
				
				
				if(searchPjtAssmtPrtcpYrFrom.length > 0 && searchPjtAssmtPrtcpYrTo.length > 0)
				{
					if(parseInt(searchPjtAssmtPrtcpYrTo)-parseInt(searchPjtAssmtPrtcpYrFrom) <0)
					{
						alert('평가참여기간을 올바르게 지정하여 주십시오.');
						return;
					}
					
				}
				
				
				// 검색어 입력 체크 (검색조건이 하나라도 있어야 함)
				if(
					  searchPjtAssmtPrtcpYrFrom.length    
					+ searchPjtAssmtPrtcpYrTo.length      
					+ searchAsesorHmNm.length     
					+ searchGenderDivCd.length        
					+ searchBlngOrgNm.length  
					+ searchRrno.length == 0
				){
					alert("검색조건을 입력하세요.");
					return;
				} 
				
				
				
				$("#pageIndex").val("1");
				
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();
			}
			
			// 엑셀 다운로드
			function fncExcelDown(){
				
				alert("최대 50건까지만 다운로드 됩니다.");
				
				
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistE.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();
			}
			
			
			function fncView(obj){
				obj.css("cursor", "pointer").click( function() {
					
					
					$("#rrno").val($(this).parent().attr("rrno"));
					
					$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
					$("#asesorAssmtPrtcpHistVO").submit();  
					
	             	   
				});
			}
			
			function fncView_Link(rrno){
				$("#rrno").val(rrno);	
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistR.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();	
            	
			}
			
			
			
			// 페이지 이동
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#asesorAssmtPrtcpHistVO").attr("action", "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
				$("#asesorAssmtPrtcpHistVO").submit();
				
			}
		</script>			
	</head>

	
	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
    
    <form:form commandName="asesorAssmtPrtcpHistVO" name="asesorAssmtPrtcpHistVO" method="post">
        <input type="hidden" name="searchFlag" id="searchFlag" value="Y" />
        <input type="hidden" name="rrno" id="rrno" />
        
		
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

					
					<%-- 검색 조건 박스 시작 --%>
					<div class="tabler">
			            <table width="100%" border="0" cellspacing="0" cellpadding="0">
							<colgroup>
								<col style="width:17%;">
								<col style="width:33%;">
								<col style="width:17%;">
								<col style="width:33%;">
							</colgroup>
							<tr>
								<th>평가위원명</th>
								<td>
									<form:input path="searchAsesorHmNm" style="width:98%"  searchItem="true" maxlength="22" />
								</td>
								<th>성별</th>
								<td>
									      <form:radiobutton path="searchGenderDivCd" label="전체"  value=""  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchGenderDivCd" label="남자"  value="1"  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchGenderDivCd" label="여자"  value="2"  searchItem="true"/>
								</td>
							</tr>
							<TR>
								<TH>소속기관</TH>
								<TD>
									<form:input path="searchBlngOrgNm" style="width:98%"  searchItem="true" maxlength="22" />											
								</TD>
								<TH>평가참여기간</TH>
								<TD >
									<form:input path="searchPjtAssmtPrtcpYrFrom" style="width:100px;"  searchItem="true"/>
									&nbsp;~&nbsp;
									<form:input path="searchPjtAssmtPrtcpYrTo" style="width:100px;"  searchItem="true"/>
								</TD>
							</TR>   
							<TR>
								<TH>과학기술인등록번호</TH>
								<TD colspan="3">	
									<form:input path="searchRrno" style="width:38%"  searchItem="true" maxlength="22" />		
								</TD>
							</TR>
						</table>
					</div>
					<%-- 검색 조건 박스 끝 --%>

					<div class="tr">
						<a href="#;" class="btn_blue" id="btnRetrieve"><img src="<c:url value='/images/th/2014/spacer.gif' />" alt="검색" class="search">검색</a>
						<input type="button" value="초기화" class="btn_gray" id="btnClear">
					</div>
					




					<%-- <c:if test="${ 'Y' eq asesorAssmtPrtcpHistVO.searchFlag }"> --%>

						<%-- 목록 시작 --%>
						<h3 class="t_head">
							결과  <span>| 검색결과 : ${paginationInfo.totalRecordCount }건</span>
							<form:select path="recordCountPerPage" style="width:80px;float: right;height:32px;" searchItem="true">
								<form:option value="10">10 개</form:option>
								<form:option value="30">30 개</form:option>
								<form:option value="50">50 개</form:option>
							</form:select>
							<%-- <a href="#;" class="btn_gray" id="btnExcel" style="float: right;"><img src="<c:url value='/images/th/2014/spacer.gif' />" alt="엑셀" class="excel">엑셀 다운로드</a> --%>
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
								
							<c:forEach var="result" items="${resultList}" varStatus="status">
		            			<tr name="resultList" rrno="${result.rrno}" >
		            				<td class="no"><c:out value="${result.rn}"/></td>
		            				<td name="resultCol" class="num"><c:out value="${result.asesorHmNm}"/></td>
		            				<td name="resultCol" class="num">
										<a href="javascript:fncView_Link('<c:out value="${result.rrno}"/>');" style="color: #0000ff"><c:out value="${result.rrno}"/></a>		            				
<%-- 		            				<c:out value="${result.rrno}"/> --%>
		            				</td>
		            				<td class="num"><c:out value="${result.orgNm}"/></td>
		            				<td class="last"><c:out value="${result.orgCls }"/></td>
		            			</tr>
		        			</c:forEach>
		        			
		        			<c:if test="${ empty resultList }">
								<tr>
									<td colspan="5" class="last">조회결과가 없습니다.</td>
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

					<%-- </c:if> --%>
	

          	


               
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
