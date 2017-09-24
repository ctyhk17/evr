package kr.go.ntis.ev.cmn.service;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

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

public interface CommonService {
	
	
    String getStDt(int interval) throws Exception;
    
    //List getCommCd(String value) throws Exception;
    
    // 페이징 정보 설정
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex) throws Exception;
    
    void getPageInfo(PaginationInfo paginationInfo, int pageIndex, int recordCountPerPage) throws Exception;
    
    // 과제평가이력정보 코드 조회
    List getPjtFnerCdList(String grpCd) throws Exception;
    
    // 기준년도 조회
    List getStanYrList() throws Exception;
    
    // 공통코드 조회
    List getCmnCdList(String grpCd) throws Exception;
    
    
    // 신부처 코드 조회
    List getNewDeptCdList() throws Exception;
    
    
    // 구부처 코드 조회
    List getOldDeptCdList() throws Exception;
    
    // 통합로그 저장
    void createTiberoTotlLog( HttpSession session, HttpServletRequest request, String paramUrlKwd, String paramOptionPos ) throws Exception;
    
    // 통합로그 저장
    void createTiberoTotlLog( HttpSession session, HttpServletRequest request, String paramUrlKwd, String paramOptionPos, String paramSearchKwd ) throws Exception;

    void isAdminRuleCd(HttpSession session, HttpServletResponse response) throws Exception;
    
    // 이형부서목록 검색
    List getHeteromorphismDeptNm(String searchOrgNm, String opCode) throws Exception;
    
    
    
}