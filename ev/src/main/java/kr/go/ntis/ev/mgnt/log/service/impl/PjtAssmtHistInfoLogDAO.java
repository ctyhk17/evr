package kr.go.ntis.ev.mgnt.log.service.impl;

import java.util.List;
import java.util.Map;

import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PjtAssmtHistInfoLogDAO.java
 * @Description : PjtAssmtHistInfoLog DAO Class
 *                과제평가이력정보 로그 DAO 클래스
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

@Repository("pjtAssmtHistInfoLogDAO")
public class PjtAssmtHistInfoLogDAO extends EgovAbstractDAO {

	
	/**
	 * 과제평가이력정보 로그 목록을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectPjtAssmtHistInfoLogList(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception{
		return list("kr.go.ntis.ev.mgnt.log.PjtAssmtHistInfoLog.selectPjtAssmtHistInfoLogList", pjtAssmtHistInfoLogVO);
	}

	/**
	 * 과제평가이력정보 로그 목록 갯수를 조회한다. 
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectPjtAssmtHistInfoLogListTotCnt(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO){
		return (Integer)select("kr.go.ntis.ev.mgnt.log.PjtAssmtHistInfoLog.selectPjtAssmtHistInfoLogListTotCnt", pjtAssmtHistInfoLogVO);
	}
	

	/**
	 * 과제평가이력정보 로그 상세내용을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 pjtAssmtHistInfoLogVO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectPjtAssmtHistInfoLogInfo(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception{
		return (Map<?, ?>)select("kr.go.ntis.ev.mgnt.log.PjtAssmtHistInfoLog.selectPjtAssmtHistInfoLogInfo", pjtAssmtHistInfoLogVO);
	}
	
	
	public void insertPjtAssmtHistInfoLogInfoProc(Map paramMap) throws Exception{
		insert("kr.go.ntis.ev.mgnt.log.PjtAssmtHistInfoLog.insertPjtAssmtHistInfoLogInfoProc", paramMap);
	}

}
