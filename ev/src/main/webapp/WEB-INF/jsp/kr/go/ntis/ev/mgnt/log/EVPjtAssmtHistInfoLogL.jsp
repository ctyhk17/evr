<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>


<%
  /**
  * @Class Name : ERPjtAssmtHistInfoLogL.jsp.jsp
  * @Description : 접속이력과관리
  * @Modification Information
  *
  *   수정일         수정자                   수정내용
  *  -------    --------    ---------------------------
  *  2016.11.02            최초 생성
  *
  * author 태장혁
  * since 2016.11.02
  *
  */
%>

<!doctype html>
<html>
	<head>

    
	    <%@ include file="/WEB-INF/jsp/kr/go/ntis/ev/include/EVInclude.jsp" %>
	    
	    
	    <script type="text/javascript">
		
			$(document).ready(function () {
				
				$( "#searchConnDtFrom" ).datepicker().mask("9999-99-99");
				$( "#searchConnDtTo" ).datepicker().mask("9999-99-99");

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

				
				fncView( $("[name=resultList]") );

			});
			
			
			// 조회
			function fncRetrieve(){
				$("#pageIndex").val("1");
				
				$("#pjtAssmtHistInfoLogVO").attr("action", "<c:url value='/mgnt/log/EVPjtAssmtHistInfoLogL.do'/>");
				$("#pjtAssmtHistInfoLogVO").submit();
			}
			
			
			function fncView(obj){
				obj.css("cursor", "pointer").click( function() {

					$("#seq").val($(this).attr("seq"));
					
					$("#pjtAssmtHistInfoLogVO").attr("action", "<c:url value='/mgnt/log/EVPjtAssmtHistInfoLogR.do'/>");
					$("#pjtAssmtHistInfoLogVO").submit();  
					
	             	   
				});
			}
			
			
			
			
			
			// 페이지 이동
			function fncLinkPage(pageNo){
				$("#pageIndex").val(pageNo);
				
				$("#pjtAssmtHistInfoLogVO").attr("action", "<c:url value='/mgnt/log/EVPjtAssmtHistInfoLogL.do'/>");
				$("#pjtAssmtHistInfoLogVO").submit();
				
			}
			
		</script>
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
    
    <form:form commandName="pjtAssmtHistInfoLogVO" name="pjtAssmtHistInfoLogVO" method="post">
        <input type="hidden" name="seq" id="seq" />
	 
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">

			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
			<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopMenu.jsp"></jsp:include> 
			

			<!-- pageBox -->
			<div class="pageBox">
				<div class="section1">
	                <div class="page_header">
	                   <h2>접속이력관리</h2>
					</div>  
		              
	              
					<%-- 컨텐츠 시작 --%>	              
	              
					
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
								<th>아이디</th>
								<td>
									<form:input path="searchUserId" style="width:98%"  searchItem="true" maxlength="22" />
								</td>
								<TH>사용자명</TH>
								<TD>
									<form:input path="searchUserNm" style="width:98%"  searchItem="true" maxlength="22" />											
								</TD>
							</tr>
							<TR>
								<TH>접속일자</TH>
								<TD >
									<form:input path="searchConnDtFrom" style="width:100px;"  searchItem="true"/>
									&nbsp;~&nbsp;
									<form:input path="searchConnDtTo" style="width:100px;"  searchItem="true"/>
								</TD>
								<TH>접속아이피</TH>
								<TD>	
									<form:input path="searchConnIp" style="width:98%"  searchItem="true" maxlength="22" />		
								</TD>
								
							</TR>   
							<TR>
								
								<th>접속대상</th>
								<td colspan="3">
									      <form:radiobutton path="searchConnSlct" label="전체"  value=""  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchConnSlct" label="과제"  value="1"  searchItem="true"/>
									&nbsp;<form:radiobutton path="searchConnSlct" label="평가위원"  value="2"  searchItem="true"/>
								</td>
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
						  <COL width="10%">
						  <COL width="15%">
						  <COL width="15%">
						  <COL width="25%">
						  <COL width="auto;">
						  <COL width="10%">
						</COLGROUP> 
						
						<thead>
						
						<tr>
						<th scope="col" class="no">순번</th>
						<th scope="col" class="title">아이디</th>
						<th scope="col" class="title">사용자명</th>
						<th scope="col" class="title">접속일자</th>
						<th scope="col" class="title">접속아이피</th>
						<th scope="col" class="last">접속대상</th>
						
						</tr>
						</thead> 
						<tbody>
							<c:forEach var="result" items="${resultList}" varStatus="status">
	            			<tr name="resultList" seq="${result.seq}" >
	            				<td class="no"><c:out value="${result.seq}"/></td>
	            				<td class="num"><c:out value="${result.userId}"/></td>
	            				<td class="num"><c:out value="${result.userNm}"/></td>
	            				<td class="num"><c:out value="${result.connDtMask}"/></td>
	            				<td class="num"><c:out value="${result.connIp}"/></td>
	            				<td class="last"><c:out value="${result.connSlctNm}"/></td>
	            			</tr>
	        			</c:forEach>
	        			
	        			<c:if test="${ empty resultList }">
							<tr>
								<td colspan="6" class="last">조회결과가 없습니다.</td>
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
