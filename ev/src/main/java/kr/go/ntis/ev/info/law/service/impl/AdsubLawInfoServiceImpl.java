package kr.go.ntis.ev.info.law.service.impl;

import java.util.List;

import javax.annotation.Resource;

import kr.go.ntis.ev.info.law.service.AdsubLawInfoService;

import org.springframework.stereotype.Service;

import egovframework.rte.fdl.cmmn.EgovAbstractServiceImpl;

/**
 * @Class Name : AdsubLawInfoServiceImpl.java
 * @Description : AdsubLawInfoService Service implements
 *                가감점법령정보  서비스 인터페이스 구현
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

@Service("adsubLawInfoService")
public class AdsubLawInfoServiceImpl extends EgovAbstractServiceImpl implements AdsubLawInfoService {

	/** DAO 선언 */
	@Resource(name = "adsubLawInfoDAO")
	private AdsubLawInfoDAO adsubLawInfoDAO;

	

	
	/**
	 * 가감점코드 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	public List<?> selectAdsubCdList() throws Exception{
		return adsubLawInfoDAO.selectAdsubCdList();
	}
}
