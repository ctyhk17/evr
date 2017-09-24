<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
/**
* @Class Name : ERPjtAssmtHistInfoLogR.jsp.jsp
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

				// 검색화면으로 이동
				$("#btnGoList").click(function() {	
					fncGoList();
				});

			});
			
			
			// 목록으로 이동
			function fncGoList(){
				
				$("#pjtAssmtHistInfoLogVO").attr("action", "<c:url value='/mgnt/log/EVPjtAssmtHistInfoLogL.do'/>");
				$("#pjtAssmtHistInfoLogVO").submit();
			}
			
			
		</script>	
		
	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
	
    <form:form commandName="pjtAssmtHistInfoLogVO" name="pjtAssmtHistInfoLogVO" method="post">
    	<form:hidden path="seq" />  
		<form:hidden path="pageIndex" /> 
		<form:hidden path="recordCountPerPage" />
        
	        
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
					
	
        	
			        <%-- 과제정보 --%>
					<h3 class="t_head">접속이력 정보</h3>
					
					<div class="tabler">
            			<table width="100%" border="0" cellspacing="0" cellpadding="0">
			    		<colgroup>
			    			<col width="20%"/>
			    			<col width="*"/>
			    		</colgroup>
			    		
			    		
			    		<tr>
			    			<th>아이디</th>
			    			<td>${ resultInfo.userId }</td>    			
			    		</tr>
			    		<tr>
			    			<th>사용자명</th>
			    			<td>${ resultInfo.userNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>접속일자</th>
			    			<td>${ resultInfo.connDtMask }</td>    			
			    		</tr>
			    		<tr>
			    			<th>접속아이피</th>
			    			<td>${ resultInfo.connIp }</td>    			
			    		</tr>
			    		<tr>
			    			<th>접속대상</th>
			    			<td>${ resultInfo.connSlctNm }</td>    			
			    		</tr>
			    		<tr>
			    			<th>
			    				<c:if test="${ '1' eq resultInfo.connSlct  }">과제관리번호</c:if>
			    				<c:if test="${ '2' eq resultInfo.connSlct  }">과학기술인등록번호</c:if>
							</th>
			    			<td>${ resultInfo.userDfn1 }</td>    			
			    		</tr>			    			    
			    		<tr>
			    			<th>
			    				<c:if test="${ '1' eq resultInfo.connSlct  }">과제명</c:if>
			    				<c:if test="${ '2' eq resultInfo.connSlct  }">평가위원명</c:if>
							</th>
			    			<td>${ resultInfo.userDfn1Des }</td>    			
			    		</tr>
			    		
			    	</table>
			      </div>
      
      
      
      				<%-- 하단 버튼 시작 --%>
					<div class="tr">
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
