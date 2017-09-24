<%@ page contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>

<%
  /**
  * @Class Name : ERPjtFnerHistItrR.jsp
  * @Description : 과제평가이력정보 인트로 화면
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
				
				// 최종평가결과 검색 페이지로 이동
				$("#btnPjt").click(function() {	
					$(location).attr('href', "<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>");
				});
				
				// 평가참여이력 검색
				$("#btnAsesor").click(function() {	
					$(location).attr('href', "<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>");
				});
				
				// 이용안내 (팝업)
				$("#btnHelp").click(function(e) {
					var popupHelp = window.open("<c:url value='/html/onlineHelp.html'/>","popupHelp", "width=1100, height=750,scrollbars=no,resizable=yes");
					popupHelp.focus();
					
				});
				
				
			});
			
		</script>
    
	</head>

	<body id="temp">
		<form name="frm" method="post">
		
			<input type="text" name="dummy" style="display: none;">
		
		<div  style="margin: 0 auto;max-width:100%;min-width: 980px;clear: none;float: none;">
		
			<%-- 탑헤더 인클루드 --%>
		    <jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVTopHeader.jsp"></jsp:include>
		 
		    <div class="tempHead main">
		    
		    	<h1><img src="<c:url value='/images/th/2016/logo.png' />"></h1>
		        
		        <div class="maintoptxt"><img src="<c:url value='/images/th/2016/visualtxt.png' />"></div>
		        
		        <div class="maintopimage"><img src="<c:url value='/images/th/2016/visualimage.png' />"></div>
		        
		    </div>
		
		</div>

		<!--main body wrap-->
		<div class="mainbodywrap">
			<!--main body-->
			<div class="mainbody">

				<!--box01-->
				<div class=" mbox01"><img src="<c:url value='/images/th/2016/mainconimg.png' />">
					<div class="mbox01txt">과제평가이력정보 이용안내입니다.<br>시스템의 이용을 효율적으로 활용하도록 도와 드립니다.</div>				  
				  	<div class="mbox01btn"><a href="#;" id="btnHelp">이용안내</a></div>
				</div>

				<!--box03-->
				<div class="mbox03">
				
					<ul>
						<li id="btnAsesor">
						  <object id="FlashID2" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="114" height="80">
						    <param name="movie" value="<c:url value='/swf/icon.swf' />">
						    <param name="quality" value="high">
						    <param name="wmode" value="opaque">
						    <param name="swfversion" value="9.0.45.0">
						    <!-- This param tag prompts users with Flash Player 6.0 r65 and higher to download the latest version of Flash Player. Delete it if you don’t want users to see the prompt. -->
						    <param name="expressinstall" value="Scripts/expressInstall.swf">
						    <!-- Next object tag is for non-IE browsers. So hide it from IE using IECC. -->
						    <!--[if !IE]>-->
						    <object type="application/x-shockwave-flash" data="<c:url value='/swf/icon.swf' />" width="114" height="80">
						      <!--<![endif]-->
						      <param name="quality" value="high">
						      <param name="wmode" value="opaque">
						      <param name="swfversion" value="9.0.45.0">
						      <param name="expressinstall" value="Scripts/expressInstall.swf">
						      <!-- The browser displays the following alternative content for users with Flash Player 6.0 and older. -->
						      <div>
						        <h4>Content on this page requires a newer version of Adobe Flash Player.</h4>
						        <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
						      </div>
						      <!--[if !IE]>-->
						    </object>
						    <!--<![endif]-->
						  </object>
						</li>
						<li class="title">평가참여이력 검색</li>
						<li class="txt">과제평가(선정, 중간, 최종, 추적)<br>에 참여한 평가위원 평가이력정보를<br>검색하여 활용 할 수 있습니다. </li>
					</ul>
				
					<div class="mboxbtn box3"><a href="<c:url value='/hist/asesor/EVAsesorAssmtPrtcpHistL.do'/>">바로가기</a></div>
				
				</div>


				<!--box02-->
				<div class="mbox02">
				
					<ul style=" margin-top:38px; margin-left:65px;">
						<li id="btnPjt">
						              <object id="FlashID" classid="clsid:D27CDB6E-AE6D-11cf-96B8-444553540000" width="84" height="100">
						                <param name="movie" value="<c:url value='/swf/icon01.swf' />">
						                <param name="quality" value="high">
						                <param name="wmode" value="opaque">
						                <param name="swfversion" value="9.0.45.0">
						                <!-- This param tag prompts users with Flash Player 6.0 r65 and higher to download the latest version of Flash Player. Delete it if you don’t want users to see the prompt. -->
						                <param name="expressinstall" value="Scripts/expressInstall.swf">
						                <!-- Next object tag is for non-IE browsers. So hide it from IE using IECC. -->
						                <!--[if !IE]>-->
						                <object type="application/x-shockwave-flash" data="<c:url value='/swf/icon01.swf' />" width="84" height="100">
						                  <!--<![endif]-->
						                  <param name="quality" value="high">
						                  <param name="wmode" value="opaque">
						                  <param name="swfversion" value="9.0.45.0">
						                  <param name="expressinstall" value="Scripts/expressInstall.swf">
						                  <!-- The browser displays the following alternative content for users with Flash Player 6.0 and older. -->
						                  <div>
						                    <h4>Content on this page requires a newer version of Adobe Flash Player.</h4>
						                    <p><a href="http://www.adobe.com/go/getflashplayer"><img src="http://www.adobe.com/images/shared/download_buttons/get_flash_player.gif" alt="Get Adobe Flash player" /></a></p>
						                  </div>
						                  <!--[if !IE]>-->
						                </object>
						                <!--<![endif]-->
						              </object>
						</li>
						<li class="title">최종평가결과 검색</li>
						<li class="txt">국가R&D사업 관련 과제의<br>최종평가결과 정보를 검색하여<br>활용할 수 있습니다.</li>
					</ul>
				
					<div class="mboxbtn"><a href="<c:url value='/hist/pjt/EVPjtFnerHistL.do'/>">바로가기</a></div>
				
				</div>


			</div><!--e main body-->
		</div><!--e main body wrap-->
		
		
		
		
					
					
					
					

		<%-- 탑헤더 인클루드 --%>
		<jsp:include page="/WEB-INF/jsp/kr/go/ntis/ev/include/EVCopyright.jsp"></jsp:include>
		
		<script type="text/javascript">
			swfobject.registerObject("FlashID");
			swfobject.registerObject("FlashID2");
		</script>
    	
		</form>    	
	</body>
</html>









    	
    	
    	

