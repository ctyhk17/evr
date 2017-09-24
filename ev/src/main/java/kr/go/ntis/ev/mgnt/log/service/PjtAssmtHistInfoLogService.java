package kr.go.ntis.ev.mgnt.log.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : PjtAssmtHistInfoLogService.java
 * @Description : PjtAssmtHistInfoLog Service Interface
 *                과제평가이력정보 로그 서비스 인터페이스
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.11.02           최초생성
 *
 * @author 태장혁
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

public interface PjtAssmtHistInfoLogService {
	
	/**
	 * 과제평가이력정보 로그 목록을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectPjtAssmtHistInfoLogList(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception;

	/**
	 * 과제평가이력정보 로그 목록 갯수를 조회한다. 
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectPjtAssmtHistInfoLogListTotCnt(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO);
	

	/**
	 * 과제평가이력정보 로그 상세내용을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 pjtAssmtHistInfoLogVO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectPjtAssmtHistInfoLogInfo(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception;
	
	/**
	 * 과제평가이력정보 로그 내용을 저장한다.
	 * @param paramMap
	 * @throws Exception
	 */
	void insertPjtAssmtHistInfoLogInfoProc(String userId, String userNm, String connIp, String connSlct, String userDfn1) throws Exception;

	
	

}
