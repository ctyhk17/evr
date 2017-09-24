package kr.go.ntis.ev.mgnt.log.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogService;
import kr.go.ntis.ev.mgnt.log.service.PjtAssmtHistInfoLogVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

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

@Service("pjtAssmtHistInfoLogService")
public class PjtAssmtHistInfoLogServiceImpl extends EgovAbstractServiceImpl implements PjtAssmtHistInfoLogService {

	/** DAO 선언 */
	@Resource(name = "pjtAssmtHistInfoLogDAO")
	private PjtAssmtHistInfoLogDAO pjtAssmtHistInfoLogDAO;

	
	
	/**
	 * 과제평가이력정보 로그 목록을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	public List<?> selectPjtAssmtHistInfoLogList(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception{
		return pjtAssmtHistInfoLogDAO.selectPjtAssmtHistInfoLogList(pjtAssmtHistInfoLogVO);
	}

	/**
	 * 과제평가이력정보 로그 목록 갯수를 조회한다. 
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	public int selectPjtAssmtHistInfoLogListTotCnt(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO){
		return pjtAssmtHistInfoLogDAO.selectPjtAssmtHistInfoLogListTotCnt(pjtAssmtHistInfoLogVO);
	}
	

	/**
	 * 과제평가이력정보 로그 상세내용을 조회한다.
	 * @param pjtAssmtHistInfoLogVO - 조회할 정보가 담긴 pjtAssmtHistInfoLogVO
	 * @return  상세정보
	 * @exception Exception
	 */
	public Map<?, ?> selectPjtAssmtHistInfoLogInfo(PjtAssmtHistInfoLogVO pjtAssmtHistInfoLogVO) throws Exception{
		return pjtAssmtHistInfoLogDAO.selectPjtAssmtHistInfoLogInfo(pjtAssmtHistInfoLogVO);
	}
	 
	
	public void insertPjtAssmtHistInfoLogInfoProc(String userId, String userNm, String connIp, String connSlct, String userDfn1) throws Exception{
		Map paramMap = new HashMap();
		paramMap.put("userId", userId);
		paramMap.put("userNm", userNm);
		paramMap.put("connIp", connIp);
		paramMap.put("connSlct", connSlct);
		paramMap.put("userDfn1", userDfn1);
		
		
		pjtAssmtHistInfoLogDAO.insertPjtAssmtHistInfoLogInfoProc(paramMap);
	}

}
