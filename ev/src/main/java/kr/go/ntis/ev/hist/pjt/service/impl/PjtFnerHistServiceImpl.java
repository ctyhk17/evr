package kr.go.ntis.ev.hist.pjt.service.impl;

import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistService;
import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : PjtFnerHistServiceImpl.java
 * @Description : PjtFnerHistService Service implements
 *                과제최종평가이력  서비스 인터페이스 구현
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

@Service("pjtFnerHistService")
public class PjtFnerHistServiceImpl extends EgovAbstractServiceImpl implements PjtFnerHistService {

	/** DAO 선언 */
	@Resource(name = "pjtFnerHistDAO")
	private PjtFnerHistDAO pjtFnerHistDAO;

	

	public List<?> selectPjtFnerHistList(PjtFnerHistVO pjtFnerHistVO)
			throws Exception {
		// TODO Auto-generated method stub
		return pjtFnerHistDAO.selectPjtFnerHistList(pjtFnerHistVO);
	}
	
	

	public int selectPjtFnerHistListTotCnt(PjtFnerHistVO pjtFnerHistVO) {
		// TODO Auto-generated method stub
		return pjtFnerHistDAO.selectPjtFnerHistListTotCnt(pjtFnerHistVO);
	}

	public Map<?, ?> selectPjtFnerHistInfo(PjtFnerHistVO pjtFnerHistVO)
			throws Exception {
		// TODO Auto-generated method stub
		return pjtFnerHistDAO.selectPjtFnerHistInfo(pjtFnerHistVO);
	}
	
	
	/**
	 * 과제최종평가 평가위원 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAsesorList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return pjtFnerHistDAO.selectAsesorList(pjtFnerHistVO);
	}

	/**
	 * 기관별 평가등록 목록 조회
	 */
	public List<?> selectOrgAssmtGrdList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return pjtFnerHistDAO.selectOrgAssmtGrdList(pjtFnerHistVO);
	}
	
	
	/**
	 * 기관별 중단유형,사유 목록 조회 (트리구조)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStopTypeRsonCdList(String srcOrgId) throws Exception{
		return pjtFnerHistDAO.selectStopTypeRsonCdList(srcOrgId);
	}
	/**
	 * 기관별 중단유형 목록 조회
	 */
	public List<?> selectStopTypeCdList(String srcOrgId) throws Exception{
		return pjtFnerHistDAO.selectStopTypeCdList(srcOrgId);
	}
	
	/**
	 * 기관별 중단사유 목록 조회
	 */
	public List<?> selectStopRsonCdList(String srcOrgId) throws Exception{
		return pjtFnerHistDAO.selectStopRsonCdList(srcOrgId);
	}
	
	/**
	 * 가감점코드 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAdsubCdList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return pjtFnerHistDAO.selectAdsubCdList(pjtFnerHistVO);
	}
	
	
	/**
	 * 과제최종평가이력 목록을 검색한다.(Excel다운로드 용)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 * 2016.11.08 엑셀 다운로드 추가
	 */
	public List<?> selectPjtFnerHistListForExcel(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return pjtFnerHistDAO.selectPjtFnerHistListForExcel(pjtFnerHistVO);
	}
}
