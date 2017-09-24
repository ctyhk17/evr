package kr.go.ntis.ev.hist.search.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : PjtFnerSearchService.java
 * @Description : PjtFnerSearchService Service Interface
 *                과제최종평가결과 검색  서비스 인터페이스
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

public interface PjtFnerSearchService {
	
	/**
	 * 과제최종평가결과 검색결과 목록 조회
	 * @param pjtFnerSearchVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectPjtFnerSearchList(PjtFnerSearchVO pjtFnerSearchVO) throws Exception;

	/**
	 * 과제최종평가결과 검색결과 목록 갯수 조회 
	 * @param pjtFnerSearchVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectPjtFnerSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO);
	

	List<?> selectAsesorAssmtPrtcpSearchList(PjtFnerSearchVO pjtFnerSearchVO) throws Exception;
	
	int selectAsesorAssmtPrtcpSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO) throws Exception;
	
	
}
