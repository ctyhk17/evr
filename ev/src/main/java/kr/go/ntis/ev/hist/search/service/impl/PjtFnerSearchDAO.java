package kr.go.ntis.ev.hist.search.service.impl;

import java.util.List;

import kr.go.ntis.ev.hist.search.service.PjtFnerSearchVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : PjtFnerSearchDAO.java
 * @Description : PjtFnerSearchDAO DAO 
 *                과제최종평가결과 검색  DAO
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

@Repository("pjtFnerSearchDAO")
public class PjtFnerSearchDAO extends EgovAbstractDAO {

	/**
	 * 과제최종평가결과 검색 목록을 조회한다.
	 * @param pjtFnerSearchVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectPjtFnerSearchList(PjtFnerSearchVO pjtFnerSearchVO)
			throws Exception {
		return list("kr.go.ntis.ev.hist.search.PjtFnerSearch.selectPjtFnerSearchList", pjtFnerSearchVO);
	}

	/**
	 * 과제최종평가결과 검색 목록 갯수을 조회한다. 
	 * @param pjtFnerSearchVO
	 * @return
	 */
	public int selectPjtFnerSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO) {
		return (Integer) select("kr.go.ntis.ev.hist.search.PjtFnerSearch.selectPjtFnerSearchListTotCnt", pjtFnerSearchVO);
	}

	
	public List<?> selectAsesorAssmtPrtcpSearchList(PjtFnerSearchVO pjtFnerSearchVO) throws Exception{
		return list("kr.go.ntis.ev.hist.search.PjtFnerSearch.selectAsesorAssmtPrtcpSearchList", pjtFnerSearchVO);
	}
	
	public int selectAsesorAssmtPrtcpSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO) throws Exception{
		return (Integer) select("kr.go.ntis.ev.hist.search.PjtFnerSearch.selectAsesorAssmtPrtcpSearchListTotCnt", pjtFnerSearchVO);
	}

}
