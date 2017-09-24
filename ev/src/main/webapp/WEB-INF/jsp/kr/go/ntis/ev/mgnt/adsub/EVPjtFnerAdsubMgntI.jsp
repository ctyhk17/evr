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

				// 등록처리
				$("#btnCreate").click(function() {	
					fncCreate();
				});
				
				// 취소
				$("#btnGoList").click(function() {	
					fncGoList();
				});
				
				// 행추가
				$("#btnAddRow").click(function() {	
					fncAddRow();
				});
				
				// 길이제한
				$("#adsubItem").checkbyte({ limit:4, title : "항목" });
				$("#adsubDes").checkbyte({ limit:100, title : "내용" });
				$("#adsubGrantDes").checkbyte({ limit:50, title : "가감점 부여 내용" });
				$("#adsubApplProdDes").checkbyte({ limit:10, title : "적용기간" });
				$("#adsubExamDes").checkbyte({ limit:100, title : "적용기간" });
				$("#note").checkbyte({ limit:1000, title : "적용기간" });
				
				
			});
			
			
			// 목록으로 이동
			function fncGoList(){
				$("#pageIndex").val("1");
				
				$("#pjtFnerAdsubMgntVO").attr("action", "<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntL.do'/>");
				$("#pjtFnerAdsubMgntVO").submit();
			}
			
			
			// 등록처리
			function fncCreate(){
			
				var adsubSlctCd             = $("#adsubSlctCd").val();
				var adsubItem               = $("#adsubItem").val();
				var adsubDes                = $("#adsubDes").val();
				
				var adsubApplOrgSlctCd      = $("#adsubApplOrgSlctCd").val();
				var adsubGrantDes           = $("#adsubGrantDes").val();
				var adsubApplStanDtSlctCd   = $("#adsubApplStanDtSlctCd").val();
				var adsubApplProdDes        = $("#adsubApplProdDes").val();
				var adsubExamDes            = $("#adsubExamDes").val();
				var note                    = $("#note").val();
				
				var adsubTrgtCdArr = new Array();
				$("select[name=adsubTrgtCd]").each(function(i){
					adsubTrgtCdArr.push($(this).val());
				});
				
				
				// 입력값 체크
				if(adsubSlctCd == null || adsubSlctCd.length == 0){
					alert("구분을 선택하세요.");
					$("#adsubSlctCd").focus();
					return;
				}
				
				if(adsubItem == null || adsubItem.length == 0){
					alert("항목을 입력하세요.");
					$("#adsubItem").focus();
					return;
				}
				
				if(adsubDes == null || adsubDes.length == 0){
					alert("내용을 입력하세요.");
					$("#adsubDes").focus();
					return;
				}
				
				if(!fncIsValid())
				{
					return;
				}
				
				if(adsubApplOrgSlctCd == null || adsubApplOrgSlctCd.length == 0){
					alert("적용기관을 선택하세요.");
					$("#adsubApplOrgSlctCd").focus();
					return;
				}
				
				if(adsubGrantDes == null || adsubGrantDes.length == 0){
					alert("가감점 부여 내용을 입력하세요.");
					$("#adsubGrantDes").focus();
					return;
				}
				
				if(adsubApplStanDtSlctCd == null || adsubApplStanDtSlctCd.length == 0){
					alert("적용기준일자를 선택하세요.");
					$("#adsubApplStanDtSlctCd").focus();
					return;
				}
				
				if(adsubApplProdDes == null || adsubApplProdDes.length == 0){
					alert("적용기간을 입력하세요.");
					$("#adsubApplProdDes").focus();
					return;
				}
				
				


				
				
				
				/*
				alert('adsubSlctCd : ' + adsubSlctCd);
				alert('adsubItem : ' + adsubItem);
				alert('adsubDes : ' + adsubDes);
				
				alert('adsubApplOrgSlctCd : ' + adsubApplOrgSlctCd);
				alert('adsubGrantDes : ' + adsubGrantDes);
				alert('adsubApplStanDtSlctCd : ' + adsubApplStanDtSlctCd);
				alert('adsubApplProdDes : ' + adsubApplProdDes);
				alert('adsubExamDes : ' + adsubExamDes);
				alert('note : ' + note);
				
				return;
				*/
				
				
				
				jQuery.ajaxSettings.traditional = true;


				$.post(
						"<c:url value='/mgnt/adsub/EVPjtFnerAdsubMgntIProc.do'/>", 
						{ 
							  "adsubSlctCd"           : adsubSlctCd           
							, "adsubItem"             : adsubItem            
							, "adsubDes"              : adsubDes                
							, "adsubApplOrgSlctCd"    : adsubApplOrgSlctCd    
							, "adsubGrantDes"         : adsubGrantDes           
							, "adsubApplStanDtSlctCd" : adsubApplStanDtSlctCd 
							, "adsubApplProdDes"      : adsubApplProdDes        
							, "adsubExamDes"          : adsubExamDes            
							, "note"                  : note     
							, "adsubTrgtCdArr"        : adsubTrgtCdArr
						}, 
						function(responseText)
						{
							var rtnMsg = responseText.rtnMsg;
							alert("데이터가 정상적으로 등록되었습니다.") 
							
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
			
			
			// 행추가
			function fncAddRow(){
				
				var cnt      = $("select[name=adsubTrgtCd]").length;
				var limitCnt = parseInt('<c:out value="${ adsubTrgtCdListCnt }" />');
				
				if(limitCnt <= cnt){
					alert("대상 구분은 최대 "+limitCnt+"건 입니다.");
					return;
				}
				
				
				var innerHtml = "<tr>";
				innerHtml +=    "    <td style=\"border: 0px; margin-left: 0; margin-top: 0; margin-bottom: 0; padding: 0 0 0 0;  line-height: 33px;\">";
				innerHtml +=    "        <select name=\"adsubTrgtCd\" id=\"adsubTrgtCd\" style=\"width:200px;\" onchange=\"fncDupChkeck(this);\" >";
				innerHtml +=                 $("#adsubTrgtCd").html();
				innerHtml +=    "        </select>";
				innerHtml +=    "        &nbsp;<input type=\"button\" value=\"-\" class=\"btn_gray\" onClick=\"fncDeleteRow(this)\">";
				innerHtml +=    "    </td>";
				innerHtml +=    "</tr>";
				
				$("#tdAdsubTrgtArea").append(innerHtml);
			}
			
			// 행삭제
			function fncDeleteRow(obj){
				
				
				$(obj).parent().remove();
			}
			
			
			function fncIsValid()
			{
				var flag = true;
				
				$("select[name=adsubTrgtCd]").each(function(i){
					if($(this).val() == null || $(this).val().length == 0){
						alert("대상을 선택하세요.");
						$(this).focus();
						flag = false;
					}
					return;
				});
				
				return flag;
				
			}
			
			// 중복 검사
			function fncDupChkeck(obj)
			{
				
				var param = $(obj).val();
				var cnt = 0;
				
				$("select[name=adsubTrgtCd]").each(function(i){
					if($(this).val() == param){
						cnt++;
					}
				});
				
				if(cnt > 1){
					alert("이미 선택한 대상입니다.");
					$(obj).val("");	
				}
				
			}
			
		</script>	
		
		<script type="text/javascript">
    		history.go(1);
		</script> 

	</head>

	<body id="temp" style="background:url(<c:url value='/images/th/2016/subtopbg.png' />) repeat-x;">
	
    <form:form commandName="pjtFnerAdsubMgntVO" name="pjtFnerAdsubMgntVO" method="post">
		<form:hidden path="pageIndex" /> <!-- 페이지 인덱스    : -->
		<form:hidden path="recordCountPerPage" />



        
	        
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
			    			<td>
			    				<form:select path="adsubSlctCd" style="width:150px">
									<form:option value="">선택하세요</form:option>											
										<c:forEach var="adsubSlctCdMap" items="${adsubSlctCdList}" varStatus="status">
											<form:option value="${ adsubSlctCdMap.cd }">${ adsubSlctCdMap.cdNm }</form:option>
										</c:forEach>
						         </form:select>
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>항목</th>
			    			<td>
			    				<form:input path="adsubItem" style="width:100px;"/>
			    				
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>내용</th>
			    			<td>
			    				<form:input path="adsubDes" style="width:99%;"/>
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>대상</th>
			    			<td id="tdAdsubTrgtArea">
			    				<table>
			    					<tr>
			    						<td style="border: 0px; margin-left: 0; margin-top: 0; margin-bottom: 0; padding: 0 0 0 0; line-height: 30px;">
						    				<select name="adsubTrgtCd" id="adsubTrgtCd" style="width:200px;"  onchange="fncDupChkeck(this);">
												<option value="">선택하세요</option>											
													<c:forEach var="adsubTrgtCdMap" items="${adsubTrgtCdList}" varStatus="status">
														<option value="${ adsubTrgtCdMap.cd }">${ adsubTrgtCdMap.cdNm }</option>
													</c:forEach>
									         </select>	
									         <input type="button" value="+" class="btn_gray" id="btnAddRow">
									     </td>
			    					</tr>
			    				</table>				        
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기관</th>
			    			<td>
    							<form:select path="adsubApplOrgSlctCd" style="width:200px;">
									<form:option value="">선택하세요</form:option>											
										<c:forEach var="adsubApplOrgSlctCdMap" items="${adsubApplOrgSlctCdList}" varStatus="status">
											<form:option value="${ adsubApplOrgSlctCdMap.cd }">${ adsubApplOrgSlctCdMap.cdNm }</form:option>
										</c:forEach>
						         </form:select>
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>가감점 부여내용</th>
			    			<td>
			    				<form:input path="adsubGrantDes" style="width:99%;"/>
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기준일자</th>
			    			<td>
			    				<form:select path="adsubApplStanDtSlctCd" style="width:300px;">
									<form:option value="">선택하세요</form:option>											
										<c:forEach var="adsubApplStanDtSlctCdMap" items="${adsubApplStanDtSlctCdList}" varStatus="status">
											<form:option value="${ adsubApplStanDtSlctCdMap.cd }">${ adsubApplStanDtSlctCdMap.cdNm }</form:option>
										</c:forEach>
						         </form:select>
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>적용기간</th>
			    			<td>
			    				<form:input path="adsubApplProdDes" style="width:100px;" />
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>검토</th>
			    			<td>
			    				<form:input path="adsubExamDes" style="width:99%;" />
			    			</td>    			
			    		</tr>
			    		<tr>
			    			<th>비고</th>
			    			<td>
			    				<form:textarea path="note" style="width:96%;height:50px;"/>
			    			</td>    			
			    		</tr>
			    		
			    		
			    		
			    	</table>
			      </div>
			      
			      
			      <%-- 하단 버튼 시작 --%>
					<div class="tr">
						<input type="button" value="저장" class="btn_blue" id="btnCreate">
						<input type="button" value="취소" class="btn_blue" id="btnGoList">
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
					