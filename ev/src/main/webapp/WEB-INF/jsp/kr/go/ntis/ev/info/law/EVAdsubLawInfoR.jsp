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
		
				// 파일다운로드
				$("#btnFileDownload").click(function() {	
					
					$("#orgFileNm").val("ERAdsubLawInfoR.pdf");
					$("#fileNm").val("국가연구개발사업의관리등에관한규정.pdf");
					
					
					$("#adsubLawInfoVO").attr("action", "<c:url value='/FileDownload.do'/>");
					$("#adsubLawInfoVO").submit();
				});
		
			});
			
		</script>			
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">

    <form:form commandName="adsubLawInfoVO" name="adsubLawInfoVO" method="post">
    	<input type="text" name="dummy" style="display: none;">
		
		<input type="hidden" name="fileNm" id="fileNm" />
		<input type="hidden" name="orgFileNm" id="orgFileNm" />
         
         
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

		    <jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include>




			<!-- pageBox -->
			<div class="pageBox">
				<div class="section1">
                	<div class="page_header">
						<h2>법령정보</h2>
					</div>  



					<%-- 컨텐츠 영역 시작 --%>
					
					
					<%-- 과제정보 --%>
					
					
					<div class="page_header1">
                  		 <h3> 연구개발과제 선정의 우대·감점의 기준 및 방법 (제7조 제10항 관련)</h3>
                  		<p style="line-height:1.7em;float: right;">             
		                	<a href="#;" id="btnFileDownload" style="text-decoration: underline;"><img src="<c:url value='/images/th/2016/p_pdf_s.gif' />" border="0" style="vertical-align: middle;" alt="pdf파일" />국가연구개발사업의 관리 등에 관한 규정.pdf</a>
		                </p>
              		</div>  


<p style="line-height:1.7em;">

<strong>1. 가점 부여항목</strong><br />
가. 최종평가 결과가 최우수등급인 연구개발과제의 연구책임자가 해당 평가를 실시한 중앙행정기관의 장에게 새로운 연구개발과제를 신청하는 경우, 최종평가 후 2년간 선정 평가점수의 5％ 이내 가점 부여<br /> 
나. 최근 3년 이내에 국내외 과학기술논문색인지수(Science Citation Index) 논문에 기고한 실적이 있는 연구책임자가 연구개발과제를 신청하는 경우, 선정 평가점수의 3％ 이내 가점 부여 <br />
다. 최근 3년 이내에 협약한 연구개발과제로서 협약 시 보안과제로 분류된 연구개발과제의 연구책임자가 새로운 연구개발과제를 신청하는 경우, 선정 평가점수의 3％ 이내 가점 부여 <br />
라. 최근 3년 이내에 기술실시계약을 체결하여 징수한 기술료 총액이 2천만원  이상이거나, 같은 기간 내에 2건 이상의 기술이전 실적이 있는 연구책임자가 새로운 연구개발과제를 신청하는 경우, 선정 평가점수의 3% 이내 가점 부여<br />
마. 최근 3년 이내에 제17조제9항에 따라 포상을 받은 연구자가 새로운 연구개발과제를 신청하는 경우 선정 평가점수의 3퍼센트 이내 가점 부여<br />
바. 최근 3년 이내에 과학기술 분야의 훈장, 포장, 대통령 표창 또는 대통령상을 수상한 연구자가 새로운 연구개발과제를 신청하는 경우, 선정 평가점수의 3퍼센트 이내 가점 부여<br />

<br />

<strong>2. 감점 부여항목</strong><br /> 
가. 최근 3년 이내에 제31조제3항에 따라 연구부정행위로 판단되어 협약이 해약된 연구개발과제의 연구책임자가 새로운 연구개발과제를 신청하는 경우, 선정 평가점수의 10％ 이내 감점 부여<br />  
나. 최종평가 결과가 최하위등급(상대평가 시 하위 10％ 등급, 절대평가 시 만점의 50％ 이하)인 연구개발과제의 연구책임자가 해당 평가를 실시한 중앙행정기관의 장에게 새로운 연구개발과제를 신청하는 경우, 최종평가 후 2년간 선정 평가점수의 5％ 이내 감점 부여<br /> 
다. 연구개발과제 선정 후 정당한 사유 없이 협약을 포기한 경력이 있는 연구책임자나 기업의 경우에는 협약 포기 후 3년간 선정 평가점수의 5％ 이내의 감점 부여<br />
라. 연구개발과제의 연구수행 중 연구를 포기한 경력이 있는 연구책임자나 기업의 경우에는 연구 포기 후 3년간 선정 평가점수의 5％ 이내의 감점 부여 <br />
마. 최종평가 결과가 하위등급(상대평가 시 하위 30％등급, 절대평가 시 만점의 60％ 이하)인 연구개발과제의 연구책임자가 해당 평가를 실시한 중앙행정기관의 장에게 새로운 연구개발과제를 신청하는 경우, 최종평가 후 2년간 선정 평가점수의 3％ 이내 감점 부여<br /> 
바. 「하도급거래 공정화에 관한 법률」을 최근 3년 이내에 상습적으로 위반한 기업이 연구개발과제를 신청한 경우에 그러한 위반 사실이 같은 법 제26조에 따른 공정거래위원회로부터 관계 행정기관의 장에의 통보 등을 통하여 확인될 경우, 선정 평가점수의 5% 이내 감점 부여<br />
사. 그 밖에 중앙행정기관의 장이 정하는 경우<br /> 


</p>
 
<hr />						
					
	      
					<h3 class="t_head">요약정리</h3>
						
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
								
								<c:forEach var="result" items="${resultList}" varStatus="status">
		            			<tr>
		            				<td class="no"><c:out value="${result.adsubSlctCdNm}"/></td>
		            				<td class="num"><c:out value="${result.adsubItem}"/></td>
		            				<td class="num"><c:out value="${result.adsubDes}"/></td>
		            				<td class="num"><c:out value="${fn:replace(result.adsubTrgtCdNm, ',', ',<br />')}" escapeXml="false"/></td>		            				
		            				<td class="num"><c:out value="${result.adsubApplOrgSlctCdNm}"/></td>
		            				<td class="num"><c:out value="${result.adsubGrantDes}"/></td>
		            				<td class="num"><c:out value="${result.adsubApplStanDtSlctCdNm}"/></td>
		            				<td class="last"><c:out value="${result.adsubApplProdDes}"/></td>
		            				
		            			</tr>
		        			</c:forEach>
		        			
		        			<c:if test="${ empty resultList }">
								<tr>
									<td class="last" colspan="8">조회결과가 없습니다.</td>
								</tr>
							</c:if>  
							
							</tbody>  
						</table>
						
						<!-- <p style="line-height:1.7em;">※ 국가연구개발 사업의 관리 등에 관한 규정 (제 7조 10항 관련)&nbsp; <a href="#;" id="btnFileDownload" style="text-decoration: underline;">☞ 첨부파일 다운로드</a></p> -->
		               
		               
		               


          	
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


