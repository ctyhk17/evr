package kr.go.ntis.ev.hist.pjt.service.impl;

import java.util.List;
import java.util.Map;

import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PjtFnerHistDAO.java
 * @Description : PjtFnerHistDAO DAO 
 *                과제최종평가이력  DAO
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

@Repository("pjtFnerHistDAO")
public class PjtFnerHistDAO extends EgovAbstractDAO {

	/**
	 * 과제최종평가이력 목록을 검색한다.
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectPjtFnerHistList(PjtFnerHistVO pjtFnerHistVO)
			throws Exception {
		// TODO Auto-generated method stub
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectPjtFnerHistList", pjtFnerHistVO);
	}
	
	

	/**
	 * 과제최종평가이력 목록 갯수를 조회한다. 
	 * @param pjtFnerHistVO
	 * @return
	 */
	public int selectPjtFnerHistListTotCnt(PjtFnerHistVO pjtFnerHistVO) {
		// TODO Auto-generated method stub
		return (Integer) select("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectPjtFnerHistListTotCnt", pjtFnerHistVO);
	}

	/**
	 * 과제최종평가이력 상세내용을 조회한다.
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public Map<?, ?> selectPjtFnerHistInfo(PjtFnerHistVO pjtFnerHistVO)
			throws Exception {
		// TODO Auto-generated method stub
		return (Map<?, ?>) select("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectPjtFnerHistInfo", pjtFnerHistVO);
	}
	
	
	/**
	 * 과제최종평가 평가위원 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAsesorList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectAsesorList", pjtFnerHistVO);
	}

	
	/**
	 * 기관별 평가등급 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectOrgAssmtGrdList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectOrgAssmtGrdList", pjtFnerHistVO);
	}
	
	
	/**
	 * 기관별 중단유형,사유 목록 조회 (트리구조)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStopTypeRsonCdList(String srcOrgId) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectStopTypeRsonCdList", srcOrgId);
	}
	
	/**
	 * 기관별 중단유형 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStopTypeCdList(String  srcOrgId) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectStopTypeCdList", srcOrgId);
	}
	
	/**
	 * 기관별 중단사유 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectStopRsonCdList(String srcOrgId) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectStopRsonCdList", srcOrgId);
	}
	
	
	
	public List<?> selectAdsubCdList(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectAdsubCdList", pjtFnerHistVO);
	}
	
	
	
	/**
	 * 과제최종평가이력 목록을 검색한다.(Excel다운로드 용)
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 * 2016.11.08 엑셀다운로드 추가
	 */
	public List<?> selectPjtFnerHistListForExcel(PjtFnerHistVO pjtFnerHistVO) throws Exception{
		return list("kr.go.ntis.ev.hist.pjt.PjtFnerHist.selectPjtFnerHistListForExcel", pjtFnerHistVO);
	}
}
