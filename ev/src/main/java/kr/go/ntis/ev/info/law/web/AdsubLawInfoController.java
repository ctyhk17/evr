package kr.go.ntis.ev.info.law.web;

import java.util.List;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import kr.go.ntis.ev.cmn.service.CommonService;
import kr.go.ntis.ev.hist.search.service.PjtFnerSearchService;
import kr.go.ntis.ev.info.law.service.AdsubLawInfoService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;

import egovframework.rte.fdl.property.EgovPropertyService;

/**
 * @Class Name : AdsubLawInfoController.java
 * @Description : AdsubLawInfo Controller Class
 * 				가감점법령정보 컨트롤러
 * @Modification Information
 * @
 * @  수정일      수정자              수정내용
 * @ ---------   ---------   -------------------------------
 * @ 2016.07.12           최초생성
 *
 * @author 태장혁
 * @since 2016.11.08
 * @version 1.0
 * @see
 *  
 */

@Controller
public class AdsubLawInfoController {

	// 로그
	private Logger LOGGER = LoggerFactory.getLogger(this.getClass());
	
	/** 공통 서비스 선언 */
	@Resource(name = "commonService")
	protected CommonService commonService;
		
	
	/** 법령정보 서비스 */
	@Resource(name = "adsubLawInfoService")
	private AdsubLawInfoService adsubLawInfoService;
	


	/**
	 * 가감점 법령 정보를 조회한다.
	 * @param model
	 * @exception Exception
	 */
	@RequestMapping(value = "/info/law/EVAdsubLawInfoR.do")
	public String selectAdsubLawInfoInfo(
			ModelMap model,
			HttpServletRequest request,
			HttpSession session
			) throws Exception {

		// 통합로그 저장
		commonService.createTiberoTotlLog( session, request, "홈:법령정보:상세", "EV:06:0002");
		
		List<?> resultList = adsubLawInfoService.selectAdsubCdList();
		model.addAttribute("resultList", resultList);

		return "info/law/EVAdsubLawInfoR";  
	}

	
	
}
