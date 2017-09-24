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
				
				// 수정화면으로 이동
				$("#btnGoUpdate").click(function() {	
					fncGoUpdate();
				});
				
				// 삭제
				$("#btnDelete").click(function() {	
					fncDelete();
				});
				
				
				

				
				fncView( $("[name=resultList]") );

			});
			
			
			// 목록으로 이동
			function fncGoList(){
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
			// 수정화면으로 이동
			function fncGoUpdate(){
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntU.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
			// 삭제처리
			function fncDelete(){
			
				if(confirm("해당 가감점 항목을 삭제하시겠습니까?"))
				{
					var adsubMgntNo = $("#adsubMgntNo").val();
					
					$.post(
							"<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntDProc.do'/>", 
							{ "adsubMgntNo": adsubMgntNo }, 
							function(responseText)
							{
								var rtnMsg = responseText.rtnMsg;
								alert("데이터가 정상적으로 삭제되었습니다.") 
								
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

				}
			}
			
		</script>	
		
		<script type="text/javascript">
    		history.go(1);
		</script> 
    
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
	
    <form:form commandName="pjtFnerAdsubMgntVO" name="pjtFnerAdsubMgntVO" method="post">
    	<form:hidden path="adsubMgntNo" />  
		<form:hidden path="pageIndex" /> 
		<form:hidden path="recordCountPerPage" />
        
		<form:hidden path="searchAdsubSlctCd" />    		           
		<form:hidden path="searchAdsubDes" />    
		
		<spring:bind path="searchAdsubTrgtCd">
			<c:forEach var="searchAdsubTrgtCd" items="${ status.value }">
				<input type="hidden" name="searchAdsubTrgtCd" value="${ searchAdsubTrgtCd }" />
			</c:forEach>
		</spring:bind>
	        
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
					
	
        	
			        <%-- 과제정보 --%>
					<h3 class="t_head">가감점항목 정보</h3>
					
					<div class="tabler">
            			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			    		<colgroup>
			    			<col width="20%"/>
			    			<col width="*"/>
			    		</colgroup>
			    		
			    		
			    		<tr>
			    			<th>구분</th>
			    			<td>${ resultInfo.adsubSlctCdNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>항목</th>
			    			<td>${ resultInfo.adsubItem }</td>    			
			    		</tr>
			    		<tr>
			    			<th>내용</th>
			    			<td>${ resultInfo.adsubDes }</td>    			
			    		</tr>
			    		<tr>
			    			<th>대상</th>
			    			<td>${ resultInfo.adsubTrgtCdNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기관</th>
			    			<td>${ resultInfo.adsubApplOrgSlctCdNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>가감점 부여내용</th>
			    			<td>${ resultInfo.adsubGrantDes }</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기준일자</th>
			    			<td>${ resultInfo.adsubApplStanDtSlctCdNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기간</th>
			    			<td>${ resultInfo.adsubApplProdDes }</td>    			
			    		</tr>
			    		<tr>
			    			<th>검토</th>
			    			<td>${ resultInfo.adsubExamDes }</td>    			
			    		</tr>
			    		<tr>
			    			<th>비고</th>
			    			<td><c:out value="${fn:replace(resultInfo.note, cn, br)}" escapeXml="false"/></td>    			
			    		</tr>
			    		
			    		
			    		
			    	</table>
			      </div>
      
      
      
      				<%-- 하단 버튼 시작 --%>
					<div class="tr">
						<input type="button" value="수정" class="btn_blue" id="btnGoUpdate">
						<input type="button" value="삭제" class="btn_blue" id="btnDelete">
						<input type="button" value="목록" class="btn_blue" id="btnGoList">
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
