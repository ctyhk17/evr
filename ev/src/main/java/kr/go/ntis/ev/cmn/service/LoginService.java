package kr.go.ntis.ev.cmn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import egovframework.rte.ptl.mvc.tags.ui.pagination.PaginationInfo;


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

public interface LoginService {
	
	// 로그인 설정
    void setLoginInfo(HttpServletRequest request) throws Exception;
    
    // 로그아웃 설정
    void setLogoutInfo() throws Exception;
    
    // 사용자 정보 조회
    String getUserTHInfo(String ssoId, String column) throws Exception;
    
    // 사용자 권한 조회
    String getUserRoleCD(String ssoId, String rolecd) throws Exception;
    
    
}