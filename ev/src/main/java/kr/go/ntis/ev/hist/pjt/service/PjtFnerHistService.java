package kr.go.ntis.ev.hist.pjt.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : PjtFnerHistService.java
 * @Description : PjtFnerHistService Service Interface
 *                과제최종평가이력  서비스 인터페이스
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

public interface PjtFnerHistService {
	
	/**
	 * 과제최종평가이력 목록을 검색한다.
	 * @param pjtFnerHistVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectPjtFnerHistList(PjtFnerHistVO pjtFnerHistVO) throws Exception;
	
	

	/**
	 * 과제최종평가이력 목록 갯수를 조회한다. 
	 * @param pjtFnerHistVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectPjtFnerHistListTotCnt(PjtFnerHistVO pjtFnerHistVO);
	

	/**
	 * 과제최종평가이력 상세내용을 조회한다.
	 * @param vo - 조회할 정보가 담긴 pjtFnerHistVO
	 * @return 과제최종평가이력 상세정보
	 * @exception Exception
	 */
	Map<?, ?> selectPjtFnerHistInfo(PjtFnerHistVO pjtFnerHistVO) throws Exception;

	
	/**
	 * 과제최종평가 평가위원 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectAsesorList(PjtFnerHistVO pjtFnerHistVO) throws Exception;
	

	
	/**
	 * 기관별 평가등급 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectOrgAssmtGrdList(PjtFnerHistVO pjtFnerHistVO) throws Exception;
	
	
	/**
	 * 기관별 중단유형,사유 목록 조회 (트리구조)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectStopTypeRsonCdList(String srcOrgId) throws Exception;
	
	
	/**
	 * 기관별 중단유형 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectStopTypeCdList(String srcOrgId) throws Exception;
	
	/**
	 * 기관별 중단사유 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectStopRsonCdList(String srcOrgId) throws Exception;
	

	/**
	 * 가감점코드 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectAdsubCdList(PjtFnerHistVO pjtFnerHistVO) throws Exception;
	
	/**
	 * 과제최종평가이력 목록을 검색한다.(Excel다운로드 용)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 * 2016.11.08 엑셀 다운로드 추가
	 */
	List<?> selectPjtFnerHistListForExcel(PjtFnerHistVO pjtFnerHistVO) throws Exception;
	
}
