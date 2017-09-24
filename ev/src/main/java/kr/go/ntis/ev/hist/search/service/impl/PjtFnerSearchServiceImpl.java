package kr.go.ntis.ev.hist.search.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.go.ntis.ev.hist.search.service.PjtFnerSearchService;
import kr.go.ntis.ev.hist.search.service.PjtFnerSearchVO;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : PjtFnerSearchServiceImpl.java
 * @Description : PjtFnerSearchService Service implements
 *                과제최종평가결과 검색  서비스 인터페이스 구현
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

@Service("pjtFnerSearchService")
public class PjtFnerSearchServiceImpl extends EgovAbstractServiceImpl implements PjtFnerSearchService {

	/** DAO 선언 */
	@Resource(name = "pjtFnerSearchDAO")
	private PjtFnerSearchDAO pjtFnerSearchDAO;

	

	public List<?> selectPjtFnerSearchList(PjtFnerSearchVO pjtFnerSearchVO) throws Exception {
		return pjtFnerSearchDAO.selectPjtFnerSearchList(pjtFnerSearchVO);
	}

	public int selectPjtFnerSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO) {
		return pjtFnerSearchDAO.selectPjtFnerSearchListTotCnt(pjtFnerSearchVO);
	}
	
	
	public List<?> selectAsesorAssmtPrtcpSearchList(PjtFnerSearchVO pjtFnerSearchVO) throws Exception{
		return pjtFnerSearchDAO.selectAsesorAssmtPrtcpSearchList(pjtFnerSearchVO);
	}
	
	public int selectAsesorAssmtPrtcpSearchListTotCnt(PjtFnerSearchVO pjtFnerSearchVO) throws Exception{
		return pjtFnerSearchDAO.selectAsesorAssmtPrtcpSearchListTotCnt(pjtFnerSearchVO);
	}

}
