package kr.go.ntis.ev.hist.asesor.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : AsesorAssmtPrtcpHistService.java
 * @Description : AsesorAssmtPrtcpHist Service Interface
 *                평가위원 평가참여이력 서비스 인터페이스
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

public interface AsesorAssmtPrtcpHistService {
	
	/**
	 * 평가위원 평가참여이력 목록을 검색한다.
	 * @param pjtFnerHistVO - 조회할 정보가 담긴 VO
	 * @return 목록
	 * @exception Exception
	 */
	List<?> selectAsesorAssmtPrtcpHistList(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception;
	
	/**
	 * 평가위원 평가참여이력 목록 갯수를 조회한다. 
	 * @param AsesorAssmtPrtcpHistVO - 조회할 정보가 담긴 VO
	 * @return 목록 총 갯수
	 * @exception
	 */
	int selectAsesorAssmtPrtcpHistListTotCnt(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO);
	

	/**
	 * 평가위원 평가참여이력 상세내용을 조회한다.
	 * @param asesorAssmtPrtcpHistVO - 조회할 정보가 담긴 VO
	 * @return 평가참여이력 상세내용
	 * @exception Exception
	 */
	Map<?, ?> selectAsesorAssmtPrtcpHistInfo(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception;


	/**
	 * 평가위원의 평가단계별 평가참여이력 목록 조회
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectStepByAsesorAssmtPrtcpHistList(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception;
	
	
	
	

	

}
