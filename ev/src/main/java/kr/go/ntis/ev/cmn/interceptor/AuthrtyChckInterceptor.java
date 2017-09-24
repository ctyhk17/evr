package kr.go.ntis.ev.cmn.interceptor;

import java.io.PrintWriter;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.LoginService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.sso.api.SSOApiManager;

import org.springframework.stereotype.Service;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;


@Service
public class AuthrtyChckInterceptor extends HandlerInterceptorAdapter{

	@Resource(name = "loginService")
	protected LoginService loginService;
	
	@Override
	public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
		
		
		HttpSession session =  request.getSession ();
		
		// Session
		LoginVO loginVO = (LoginVO) session.getAttribute("loginVO");

		String reqUrl      = (String)request.getRequestURI();
		request.setAttribute("reqUrl", reqUrl);
		
		// 제외할 URL 추가
		//if(
				  //reqUrl.matches(".*/login.*")					// 로그인
				//|| reqUrl.matches(".*/adm/dnt/mng/AdmDntMng001P01.*")			
		//)
		//{
			//return true; 
		//}
		
		
	    SSOApiManager ssoApi = new SSOApiManager();
		String ssoId = ssoApi.getSsoId( request );
		
		
		// 1.SSO 없음 : SSO 아이디가 없으면 NTIS 홈페이지로 이동
		if(ssoId == null){
			
		    session.invalidate();
			
			response.setContentType("text/html; charset=UTF-8");
	        PrintWriter out = response.getWriter();
	        out.println("<script>alert('로그인이 필요한 서비스 입니다.\\nNTIS 홈페이지로 이동합니다.\\n로그인 후 이용하십시오.');location.href='http://www.ntis.go.kr';</script>");	        
	        out.flush(); 
	        
	        
	        return false;
		}
		
		
	    // 2. SSO_ID 있음, 업무세션 없음 : 로그인 로직으로 이동
		if(ssoId != null && loginVO == null) {
			
			// 로그인 세션 생성
			loginService.setLoginInfo(request);  
			
			//  세션 VO Reload
			loginVO = (LoginVO) session.getAttribute("loginVO");
		}
		
		
		// 3. SSOID와 업무 세션 아이디가 일치 하지 않는 경우
		// 홈페이지 로그아웃인 경우 이런상황이 발생함
		if(ssoId != null && loginVO != null) {
			
			if(!loginVO.getUserId().equals(ssoId))
			{
				// 로그인 세션 생성
				loginService.setLoginInfo(request);  
				
				//  세션 VO Reload
				loginVO = (LoginVO) session.getAttribute("loginVO");
			}
			
			
		}

		
		// 4. 평가간사 권한 체크
		if(ssoId != null && loginVO != null) {
			
			
			// 권한 코드 생성 후 주석 제거
			String ruleCd = loginVO.getRuleCd();
			
			
			
			if( !(ruleCd != null && ruleCd.matches(".*EV.*")) ){
				response.setContentType("text/html; charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<script>alert('과제평가 참여위원정보 서비스에 권한이 없습니다.');history.go(-1);</script>");	        
		        out.flush(); 
//				response.sendRedirect("/html/authError.html");
		        return false;
			}
		}
		
		
		return true;
		
	}
	
}
