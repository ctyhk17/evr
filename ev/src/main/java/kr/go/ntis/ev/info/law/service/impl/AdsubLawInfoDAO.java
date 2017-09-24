package kr.go.ntis.ev.info.law.service.impl;

import java.util.List;
import java.util.Map;

import kr.go.ntis.ev.hist.pjt.service.PjtFnerHistVO;

import org.springframework.stereotype.Repository;

import egovframework.rte.psl.dataaccess.EgovAbstractDAO;

/**
 * @Class Name : AdsubLawInfoDAO.java
 * @Description : AdsubLawInfoDAO DAO 
 *                가감점 법령정보  DAO
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

@Repository("adsubLawInfoDAO")
public class AdsubLawInfoDAO extends EgovAbstractDAO {

	
	public List<?> selectAdsubCdList() throws Exception{
		return list("kr.go.ntis.ev.info.law.AdsubLawInfo.selectAdsubCdList", null);
	}
}
