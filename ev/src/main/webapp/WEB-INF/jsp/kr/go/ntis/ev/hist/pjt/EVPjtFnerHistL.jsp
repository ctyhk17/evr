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
							}else{
								$(this).val("");
							}
						}
					);
					
					$("#searchFlag").val("N");
					
					// 조회
					$("#pageIndex").val("1");
					
					
					$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
					$("#pjtFnerHistVO").submit();
					
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
				
				// 부처구분 변경
				$("#searchDeptDivCd").change(function() {
					$("#searchDeptCd").val("");
					$("#searchDeptCdList").val("");
					fncLoadDeptCd();
				});
				
				
				$("#_chkAll").click(function(){
					
					
					if($("#_chkAll").is(":checked") == true)	
					{
						$("input[name='chk']").prop("checked", true); 
					}else{
						$("input[name='chk']").prop("checked", false);
					}
					
				}); 
				
				
				// 부처명 로드
				fncLoadDeptCd();
				
				// 상세보기 이벤트 바인딩
				//fncView( $("[name=resultCol]") );  

			});
			
			
			// 조회
			function fncRetrieve(){
				
				// 부처코드 
				$("#searchDeptCd").val($("#searchDeptCdList").val());
				
				
				// 기준년도 체크
				var searchStanYrFrom    = $("#searchStanYrFrom").val();
				var searchStanYrTo      = $("#searchStanYrTo").val();
				
				var searchPjtStopYn     = $("input:radio[name='searchPjtStopYn']:checked").val(); 
				var searchDeptCd        = $("#searchDeptCd").val();
				var searchPjtMgntOrgNm  = $("#searchPjtMgntOrgNm").val();
				var searchBzNm          = $("#searchBzNm").val();
				var searchKorPjtNm      = $("#searchKorPjtNm").val();
				var searchMngrHmNm      = $("#searchMngrHmNm").val();
				var searchPjtPrfrmOrgNm = $("#searchPjtPrfrmOrgNm").val();
				var searchRrno = $("#searchRrno").val();
				
				
				
				if(searchStanYrFrom.length > 0 && searchStanYrTo.length > 0)
				{
					if(parseInt(searchStanYrTo)-parseInt(searchStanYrFrom) <0)
					{
						alert('기준년도를 올바르게 지정하여 주십시오.');
						return;
					}
					
				}
				
				// 검색어 입력 체크 (검색조건이 하나라도 있어야 함)
				if(
					  searchStanYrFrom.length    
					+ searchStanYrTo.length      
					+ searchPjtStopYn.length     
					+ searchDeptCd.length        
					+ searchPjtMgntOrgNm.length  
					+ searchBzNm.length          
					+ searchKorPjtNm.length      
					+ searchMngrHmNm.length      
					+ searchPjtPrfrmOrgNm.length
					+ searchRrno.length == 0
				){
					alert("검색조건을 입력하세요.");
					return;
				} 
				
				
				$("#pageIndex").val("1");
				
				
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
				$("#pjtFnerHistVO").submit();
			}
			
			
			
			// 엑셀 다운로드
			function fncExcelDown(){
				
				
				// 체크항목
				if($("input[name='chk']:checked").length < 1){
					alert("엑셀로 다운로드할 결과를 선택해 주십시오.");
					return;
				}
				
				
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistE.do'/>");
				$("#pjtFnerHistVO").submit();
			}
			
			
			function fncView(obj){
				obj.css("cursor", "pointer").click( function() {
					
					if( $(this).attr("id") != "resultColChk" )
            		{
						$("#pjtId").val($(this).parent().attr("pjtId"));
            			
    					$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistR.do'/>");
    					$("#pjtFnerHistVO").submit();	
            		}
	             	   
				});
			}
			
			function fncView_Link(pjtId){
				$("#pjtId").val(pjtId);
          			
 				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistR.do'/>");
 				$("#pjtFnerHistVO").submit();	
            	
			}
			
			
			// 페이지 이동
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#pjtFnerHistVO").attr("action", "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
				$("#pjtFnerHistVO").submit();
				
			}
			
			// 부처콤보박스 로드
			function fncLoadDeptCd()
			{
				var searchDeptDivCd = $("#searchDeptDivCd").val();
				
				
				if(searchDeptDivCd != null && searchDeptDivCd.length > 0)
				{
					
					
					
					$.post(
							"<c:url value='/hist/pjt/EVDeptCdL.do'/>", 
							{ 
								  "searchDeptDivCd"           : searchDeptDivCd           
							}, 
							function(responseText)
							{
								
								var deptCdList = responseText.deptCdList;
								
								var innerBodyHtml = "";
								innerBodyHtml += "<option value=''>전체</option>";
								
								$("#searchDeptCdList").empty();
								 //Body
								 for(var i = 0 ; i < deptCdList.length; i++)
				                 {
									innerBodyHtml += "<option value='" + deptCdList[i].cd + "'>" + deptCdList[i].cdNm + "</option>";
				                 }
								 
								 $("#searchDeptCdList").append(innerBodyHtml);
								
								 $("#searchDeptCdList").val($("#searchDeptCd").val());
								 
							}, 
							"json"
					)
					.done(function() {
						fncGoList();
	 				})
					.fail(function() {
						alert( "처리 도중 에러가 발생하였습니다." );
					})
					;
					
					$("#searchDeptCdList").show();
				}else{
					$("#searchDeptCdList").hide();
				}
			}
			
		</script>			
    
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">

    <form:form commandName="pjtFnerHistVO" name="pjtFnerHistVO" method="post">
    	<input type="hidden" name="searchFlag" id="searchFlag" value="Y" />
    	<input type="hidden" name="pjtId" id="pjtId" />
    	
    	
    	<form:hidden path="searchDeptCd" searchItem="true" />
        
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

	    	<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include>


			<%-- pageBox --%>
		    <div class="pageBox">
				<div class="section1">
		        	
		        	<div class="page_header">
		            	<h2>최종평가결과 검색 </h2>
	              	</div>  



					<%-- 검색 조건 박스 시작 --%>
					<div class="tabler">
			            <table width="100%" border="0" cellspacing="0" cellpadding="0">
							<colgroup>
								<col style="width:20%;">
								<col style="width:30%;">
								<col style="width:20%;">
								<col style="width:30%;">
							</colgroup>
							<tr>
								<th>기준년도</th>
								<td>
									<form:select path="searchStanYrFrom" style="width:100px;" searchItem="true">
										<form:option value="">전체</form:option>
										<c:forEach var="stanYrFrom" items="${stanYrFromList}" varStatus="status">
											<form:option value="${stanYrFrom.stanYr}">${stanYrFrom.stanYr}</form:option>
										</c:forEach>
									</form:select>
									&nbsp; ~ &nbsp;	                  
									<form:select path="searchStanYrTo" style="width:100px;" searchItem="true">
										<form:option value="">전체</form:option>
										<c:forEach var="stanYrTo" items="${stanYrToList}" varStatus="status">
											<form:option value="${stanYrTo.stanYr}">${stanYrTo.stanYr}</form:option>
										</c:forEach>
									</form:select>
								</td>
								<th>과제중단여부</th>
								<td>
									<form:radiobutton path="searchPjtStopYn" label="전체"  value=""  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchPjtStopYn" label="예"  value="Y"  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchPjtStopYn" label="아니오"  value="N"  searchItem="true"/>
								</td>
							</tr>
							<TR>
								<TH>부처명</TH>
								<TD>
									<form:select path="searchDeptDivCd" style="width:100px"  searchItem="true">
										<form:option value="">전체</form:option>
										<form:option value="NEW">신부처</form:option>
										<form:option value="OLD">구부처</form:option>
									</form:select>
									<select name="searchDeptCdList" id="searchDeptCdList" style="width:68%;display:none"  searchItem="true">
									</select>			
								</TD>
								<TH>수행기관명</TH>
								<TD >		
									<form:input path="searchPjtPrfrmOrgNm" style="width:98%"  searchItem="true" maxlength="22"  />
								</TD>
							</TR>   
							<TR>
								<TH>과제관리(전문)기관</TH>
									<TD colspan="3">
									<form:input path="searchPjtMgntOrgNm" style="width:99%"  searchItem="true" maxlength="22" />
								</TD>
							</TR>
							<TR>
								<TH>사업명</TH>
								<TD colspan="3">	
									<form:input path="searchBzNm" style="width:99%"  searchItem="true"  maxlength="50" />		
								</TD>
							</TR>
						
							<TR>
								<TH>과제명</TH>
								<TD colspan="3">	
									<form:input path="searchKorPjtNm" style="width:99%"  searchItem="true"  maxlength="50" />		
								</TD>
							</TR>
						
							<TR>
								<TH>연구책임자명</TH>
								<TD>		
									<form:input path="searchMngrHmNm" style="width:98%"  searchItem="true" maxlength="22"  />	
								</TD>
								<TH>과학기술인등록번호</TH>
								<TD>			
									<form:input path="searchRrno" style="width:98%"  searchItem="true" maxlength="22"  />	
								</TD>
							</TR>
							
						</table>
					</div>
					<%-- 검색 조건 박스 끝 --%>

					<div class="tr">
						<a href="#;" class="btn_blue" id="btnRetrieve"><img src="<c:url value='/images/th/2014/spacer.gif' />" alt="검색" class="search">검색</a>
						<input type="button" value="초기화" class="btn_gray" id="btnClear">
					</div>
					
					
					
					<%-- <c:if test="${ 'Y' eq pjtFnerHistVO.searchFlag }"> --%>
						
						<%-- 목록 시작 --%>
						<h3 class="t_head">
							결과  <span>| 검색결과 : ${paginationInfo.totalRecordCount }건</span>
							<form:select path="recordCountPerPage" style="width:80px;float: right;height:32px;" searchItem="true">
								<form:option value="10">10 개</form:option>
								<form:option value="30">30 개</form:option>
								<form:option value="50">50 개</form:option>
							</form:select>
							<a href="#;" class="btn_gray" id="btnExcel" style="float: right;"><img src="<c:url value='/images/th/2014/spacer.gif' />" alt="엑셀" class="excel">엑셀 다운로드</a>
						</h3>
						
						
	
						<table class="table1">
							<thead>
								<COLGROUP>
									<COL width="1%">
									<COL width="4%">
									<COL width="6%">
									<COL width="10%">
									<COL width="10%">
									<COL width="*">
									<COL width="9%">  
									<COL width="7%">
									<COL width="7%">
									<COL width="6%">
									<COL width="11%">
								</COLGROUP>
								<tr>
									<th rowspan="2" scope="col" class="no"><input type="checkbox" name="_chkAll" id="_chkAll" value="" /></th>
									<th rowspan="2" scope="col" class="no">순번</th>	
									<th rowspan="2" scope="col" class="title">기준<br/>년도</th>
									<th rowspan="2" scope="col" class="title">부처명</th>
									<th rowspan="2" scope="col" class="title">수행<br/>기관명</th>
									<th rowspan="2" scope="col" class="title">과제명</th>
									<th rowspan="2" scope="col" class="last">연구<br/>책임자명</th>
									<th colspan="2" scope="col" class="last">평가결과</th>					
									<th rowspan="2" scope="col" class="last">과제<br />중단<br />여부</th>
									<th rowspan="2" scope="col" class="last">가·감점<br /> 후보추천</th>
								</tr>
								<tr>
									<th scope="col" class="last">점수</th>
									<th scope="col" class="last">등급</th>
								</tr>
							</thead>
							 
							<tbody>
							
								<c:forEach var="result" items="${resultList}" varStatus="status">
			            			<tr name="resultList" pjtId="${result.pjtId}" >
			            				<td class="no"    name="resultCol" id="resultColChk"><input type="checkbox" name="chk" value="${ result.pjtId }" /></td>
			            				<td class="no"    name="resultCol"><c:out value="${result.rn}"/></td>
			            				<td class="num"   name="resultCol"><c:out value="${result.stanYr}"/></td>
			            				<td class="num"   name="resultCol"><c:out value="${result.progMstrNm}"/></td>
			            				<td class="num"   name="resultCol"><c:out value="${result.pjtPrfrmOrgNm}"/></td>
			            				<td class="title" name="resultCol">
<%-- 			            				<c:out value="${result.korPjtNm}"/> --%>
			            					<a href="javascript:fncView_Link('<c:out value="${result.pjtId}"/>');" style="color: #0000ff"><c:out value="${result.korPjtNm}"/></a>
			            				</td>
			            				<td class="num"   name="resultCol">
 			            					<c:out value="${result.mngrHmNm}"/> 
			            				</td>
			            				<td class="num"   name="resultCol"><c:out value="${result.pjtFinalAssmtPts}"/></td>
			            				<td class="num"   name="resultCol"><c:out value="${result.pjtFinalAssmtGrdDes}"/></td>
			            				<td class="num"  name="resultCol"><c:out value="${result.pjtStopYn}"/></td>
			            				<td class="last"  name="resultCol"><c:out value="${result.abevRecommend}"/></td>
			            			</tr>
			        			</c:forEach>
			        			
			    
			        			<c:if test="${ empty resultList }">
									<tr>
										<td class="last" colspan="11" >조회결과가 없습니다.</td>
									</tr>
								</c:if>  
								
								
							</tbody>  
			        
			               </table>
			               
			               <%-- 목록 끝 --%>
							<div><span style="font-size: 12px; color:#666 "><b>※ 부처·청별로 가·감점 등급기준이 달라 최상위 등급을 가점 후보 추천과제로 최하위 등급을 감점 후보 추천과제로 구분하였음.</b></span></div>
							
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
						
					<%-- </c:if> --%>
				 
				</div>
			</div>
			<%-- // pageBox --%>

		</div>

		<%--  copy right --%>
		<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVCopyright.jsp"></jsp:include>      
  
    </form:form>
    
	</body>
</html>
