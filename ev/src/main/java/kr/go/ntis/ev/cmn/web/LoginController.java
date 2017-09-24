package kr.go.ntis.ev.cmn.web;

import java.io.PrintWriter;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.cmn.service.LoginService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistService;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;
import kr.go.ntis.sso.api.SSOApiManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.initech.eam.smartenforcer.SECode;

import egovframework.rte.fdl.property.EgovPropertyService;
import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;

/**
 * @Class Name : LoginController.java
 * @Description : LoginController Controller Class
 *                로그인 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.27           최초생성
 *
 * @author 태장혁
 * @since 2016.07.27
 * @version 1.0
 * @see
 *  
 */

@Controller
public class LoginController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	@Resource(name = "loginService")
	protected LoginService loginService;
		
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	

		
	
	
	/**
	 * SSO 로그아웃
	 * @param pjtFnerHistVO
	 * @param model
	 * @param session
	 * @return
	 * @throws Exception
	 */
	
	@RequestMapping(value = "/logout.do")
	public void logout(
			ModelMap model,
			HttpSession session,
			HttpServletRequest request,
			HttpServletResponse response
			) 
			throws Exception {
		
				// 업무시스템 로그아웃
				session.removeAttribute("loginVO");
		
				// SSO 로그아웃
				String NLS_DOMAIN = propertiesService.getString("NLS_DOMAIN");
				com.initech.eam.nls.CookieManager.removeNexessCookie(NLS_DOMAIN, response);
				com.initech.eam.nls.CookieManager.removeCookie(SECode.USER_URL, NLS_DOMAIN, response);
				com.initech.eam.nls.CookieManager.removeCookie(SECode.R_TOA, NLS_DOMAIN, response);

				response.setContentType("text/html; charset=UTF-8");
		        PrintWriter out = response.getWriter();
		        out.println("<script>alert('정상적으로 로그아웃 되었습니다.');location.href='http://www.ntis.go.kr';</script>");	        
		        out.flush();
	}
	
	
	
	
	

}
