package kr.go.ntis.ev.mgnt.adsub.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : PjtFnerAdsubMgntService.java
 * @Description : PjtFnerAdsubMgnt Service Interface
 *                과제평가 가감점관리 서비스 인터페이스
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 태장혁
 * @since 2016.07.12
 * @version 1.0
 * @see
 *  
 */

public interface PjtFnerAdsubMgntService {
	
	/**
	 * 과제평가 가감점 목록을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectPjtFnerAdsubMgntList(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception;

	/**
	 * 과제평가 가감점 목록 갯수를 조회한다. 
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectPjtFnerAdsubMgntListTotCnt(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO);
	

	/**
	 * 과제평가 가감점 상세내용을 조회한다.
	 * @param pjtFnerAdsubMgntVO - 조회할 정보가 담긴 pjtFnerAdsubMgntVO
	 * @return  상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectPjtFnerAdsubMgntInfo(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception;

	
	/**
	 * 과제평가 가감점 정보을 등록한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	String insertPjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception;
	
	
	/**
	 * 과제평가 가감점 정보를 수정한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	void updatePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception;
	
	/**
	 * 과제평가 가감점 정보를 삭제한다.
	 * @param pjtFnerAdsubMgntVO
	 * @return
	 * @throws Exception
	 */
	int deletePjtFnerAdsubMgntInfoProc(PjtFnerAdsubMgntVO pjtFnerAdsubMgntVO) throws Exception;
	

	
	
	/**
	 * 가감점 대상 정보 조회
	 * @param adsubMgntNo
	 * @param getAdsubTrgtCdArr
	 * @return
	 * @throws Exception
	 */
	List selectPjtFnerAdsubTrgtProc(Map paramMap) throws Exception;
	
	/**
	 * 가감점 대상 등록
	 * @param adsubMgntNo
	 * @param getAdsubTrgtCdArr
	 * @return
	 */
	void insertPjtFnerAdsubTrgtProc(String adsubMgntNo, String[] getAdsubTrgtCdArr) throws Exception;
	
	/**
	 * 가감점 대상 삭제
	 * @param param
	 * @throws Exception
	 */
	void deletePjtFnerAdsubTrgtProc(String value) throws Exception;

}
