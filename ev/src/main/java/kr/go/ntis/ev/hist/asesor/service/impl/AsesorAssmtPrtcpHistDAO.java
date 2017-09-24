package kr.go.ntis.ev.hist.asesor.service.impl;

import java.util.List;
import java.util.Map;

import kr.go.ntis.ev.hist.asesor.service.AsesorAssmtPrtcpHistVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : AsesorAssmtPrtcpHistDAO.java
 * @Description : AsesorAssmtPrtcpHist DAO Class
 *                평가위원 평가참여이력 DAO Class
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

@Repository("asesorAssmtPrtcpHistDAO")
public class AsesorAssmtPrtcpHistDAO extends EgovAbstractDAO {

	
	/**
	 * 평가위원 평가참여이력 목록을 검색한다.
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAsesorAssmtPrtcpHistList(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception {
		// TODO Auto-generated method stub
		return list("kr.go.ntis.ev.hist.asesor.AsesorAssmtPrtcpHist.selectAsesorAssmtPrtcpHistList", asesorAssmtPrtcpHistVO);
	}
	
	

	/**
	 * 평가위원 평가참여이력 목록 갯수를 조회한다. 
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 */
	public int selectAsesorAssmtPrtcpHistListTotCnt(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) {
		// TODO Auto-generated method stub
		return (Integer) select("kr.go.ntis.ev.hist.asesor.AsesorAssmtPrtcpHist.selectAsesorAssmtPrtcpHistListTotCnt", asesorAssmtPrtcpHistVO);
	}

	/**
	 * 평가위원 평가참여이력 상세내용을 조회한다.
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 * @throws Exception
	 */
	public Map<?, ?> selectAsesorAssmtPrtcpHistInfo(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>) select("kr.go.ntis.ev.hist.asesor.AsesorAssmtPrtcpHist.selectAsesorAssmtPrtcpHistInfo", asesorAssmtPrtcpHistVO);
	}
	
	/**
	 * 평가위원의 평가단계별 평가참여이력 목록 조회
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStepByAsesorAssmtPrtcpHistList(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception{
		return list("kr.go.ntis.ev.hist.asesor.AsesorAssmtPrtcpHist.selectStepByAsesorAssmtPrtcpHistList", asesorAssmtPrtcpHistVO);
	}
	
	
	
	
	

}
