package kr.go.ntis.ev.hist.asesor.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.go.ntis.ev.hist.asesor.service.AsesorAssmtPrtcpHistService;
import kr.go.ntis.ev.hist.asesor.service.AsesorAssmtPrtcpHistVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : AsesorAssmtPrtcpHistServiceImpl.java
 * @Description : AsesorAssmtPrtcpHist Service Implements Class
 *                평가위원 평가참여이력 인터페이스 구현 클래스
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

@Service("asesorAssmtPrtcpHistService")
public class AsesorAssmtPrtcpHistServiceImpl extends EgovAbstractServiceImpl implements AsesorAssmtPrtcpHistService {

	/** DAO 선언 */
	@Resource(name = "asesorAssmtPrtcpHistDAO")
	private AsesorAssmtPrtcpHistDAO asesorAssmtPrtcpHistDAO;

	
	
	public List<?> selectAsesorAssmtPrtcpHistList(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception {
		// TODO Auto-generated method stub
		return asesorAssmtPrtcpHistDAO.selectAsesorAssmtPrtcpHistList(asesorAssmtPrtcpHistVO);
	}
	
	

	public int selectAsesorAssmtPrtcpHistListTotCnt(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) {
		// TODO Auto-generated method stub
		return asesorAssmtPrtcpHistDAO.selectAsesorAssmtPrtcpHistListTotCnt(asesorAssmtPrtcpHistVO);
	}

	public Map<?, ?> selectAsesorAssmtPrtcpHistInfo(
			AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception {
		// TODO Auto-generated method stub
		return asesorAssmtPrtcpHistDAO.selectAsesorAssmtPrtcpHistInfo(asesorAssmtPrtcpHistVO);
	}
	
	/**
	 * 평가위원의 평가단계별 평가참여이력 목록 조회
	 * @param asesorAssmtPrtcpHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStepByAsesorAssmtPrtcpHistList(AsesorAssmtPrtcpHistVO asesorAssmtPrtcpHistVO) throws Exception{
		return asesorAssmtPrtcpHistDAO.selectStepByAsesorAssmtPrtcpHistList(asesorAssmtPrtcpHistVO);
	}


	

}
