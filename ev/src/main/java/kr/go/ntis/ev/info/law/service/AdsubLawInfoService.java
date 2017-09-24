package kr.go.ntis.ev.info.law.service;

import java.util.List;
import java.util.Map;

/**
 * @Class Name : AdsubLawInfoService.java
 * @Description : AdsubLawInfo Service Interface
 *                가감점법령정보  서비스 인터페이스
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

public interface AdsubLawInfoService {
	
	/**
	 * 가감점코드 목록 조회
	 * @param pjtFnerHistVO
	 * @return
	 * @throws Exception
	 */
	List<?> selectAdsubCdList() throws Exception;
	
}
