package kr.go.ntis.ev.cmn.service.impl;

import java.net.URLEncoder;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Iterator;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.LoginService;
import kr.go.ntis.ev.cmn.service.LoginVO;
import kr.go.ntis.sso.api.SSOApiCrypt;
import kr.go.ntis.sso.api.SSOApiHttp;
import kr.go.ntis.sso.api.SSOApiManager;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import com.initech.eam.smartenforcer.SECode;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;
import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : TmpTempTemplate.java
 * @Description : TmpTempTemplate Controller Class
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 개발팀
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

@Service("loginService")
public class LoginServiceImpl extends EgovAbstractServiceImpl implements LoginService {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 기본 프로퍼티 */
	@Resource(name = "propertiesService")
	protected EgovPropertyService propertiesService;
	
    
	public void setLoginInfo(HttpServletRequest request) throws Exception {
		
		
		HttpSession session =  request.getSession ();
		  
		SSOApiManager ssoApi = new SSOApiManager();
	    
		LoginVO loginVO = null;
		
		String userId     = null;
		String psnNm      = null;
		String email      = null;
		String blngOrgCd  = null;
		String ruleCd     = null;
	      
		String ssoId = ssoApi.getSsoId( request );
	      
	      
		if(ssoId != null){
	        
			userId    = getUserTHInfo(ssoId, "USER_ID");
	    	psnNm     = getUserTHInfo(ssoId, "PSN_NM");
	    	email     = getUserTHInfo(ssoId, "EMAIL");
	    	blngOrgCd = getUserTHInfo(ssoId, "BLNG_ORG_CD");
	    	ruleCd    = getUserRoleCD(ssoId, "EV");
	    	
	    	
	    	  
	        
	    	// 로그인 정보 세션에 담기
	    	loginVO = new LoginVO();
	    	loginVO.setUserId(userId);
	    	loginVO.setPsnNm(psnNm);
	    	loginVO.setEmail(email);
	    	loginVO.setBlngOrgCd(blngOrgCd);
	    	loginVO.setRuleCd(ruleCd);
	    	
	    	session.setAttribute("loginVO", loginVO);
	        
	      }
	}
    
    public void setLogoutInfo() throws Exception {
    	
    	LOGGER.info("==========================>" + this.getClass().getName() + " : " + "setLogoutInfo()");
    	
    }
    
    
    
    /**
     * 
     */
    public String getUserTHInfo(String ssoId, String column) {
 			String returnVal = "";
 			try {
 				SSOApiHttp ssoah = new SSOApiHttp();
 				SSOApiCrypt ssoac = new SSOApiCrypt();
 				
 				String authHost = propertiesService.getString("authHost");
 				int authPort = 80;
 				String authURL = "/sso/userInfoApi.jsp";
 				String reqStr = "user_id=" + ssoId + "&user_col=" + column;	
 				
 				String returnString = ssoah.querySSO(authHost, authPort, authURL, reqStr);		
 				String eamSalt = ssoac.NTIS_KEY;
 				
 				returnVal = ssoac.decryptData(returnString, eamSalt);
 			}catch(Exception e) {
 				LOGGER.debug("getUserTHInfo Exception");
 			}
 			return returnVal;
 		}
 	  
 	  
 	// 사용자권한 가져오기
 	  public String getUserRoleCD(String ssoId, String rolecd){
 	    String returnVal = "";
 	    try{
 	      SSOApiHttp ssoah = new SSOApiHttp();
 	      SSOApiCrypt ssoac = new SSOApiCrypt();

 	     String authHost = propertiesService.getString("authHost");
 	      int authPort = 80;
 	      String authURL = "/sso/userInfoApi_role.jsp";
 	      String reqStr = "user_id=" + ssoId + "&user_role_cd=" + rolecd;

 	      String returnString = ssoah.querySSO(authHost, authPort, authURL, reqStr);
 	      String eamSalt = ssoac.NTIS_KEY;

 	      returnVal = ssoac.decryptData(returnString, eamSalt);
 	    }catch(Exception e){
 	    	LOGGER.debug("getUserTHInfo Exception");
 	    }
 	    return returnVal;
 	  }
 	  
    
    
}
